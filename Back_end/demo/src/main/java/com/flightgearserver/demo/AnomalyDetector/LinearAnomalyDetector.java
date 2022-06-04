
package com.flightgearserver.demo.AnomalyDetector;

import com.flightgearserver.demo.Utils.TimeSeries;

import java.util.ArrayList;
import java.util.List;



public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {
    List<CorrelatedFeatures> coRelatedFeat = new ArrayList<>();
    float highPearsonVal=0.9F;
    public void setHighPearsonVal(float highPearsonVal) {
        this.highPearsonVal = highPearsonVal;
    }

    @Override

    public void learnNormal(TimeSeries ts) {
        float m = 0; //max pearson value
        int currentMaxCol = -1;
        float p;
        for (int i = 0; i < ts.getNumberOfCols(); i++) {
            //transfering the MAIN col from Float obj to float

            ArrayList<Float> objMain = ts.getData().get(i);
            float[] x = new float[objMain.size()];
            float[] y = new float[objMain.size()];

            for (int k = 0; k < objMain.size(); k++)
                x[k] = objMain.get(k);

            for (int j = i + 1; j < ts.getNumberOfCols(); j++) {

                //transferring the SECONDARY col from Float obj to float

                ArrayList<Float> objSecond = ts.getData().get(j);
                for (int k = 0; k < objSecond.size(); k++)
                    y[k] = objSecond.get(k);
                p = StatLib.pearson(x, y);
                //
                if (Math.abs(p) > m && Math.abs(p) > this.highPearsonVal) {
                    m = p;
                    currentMaxCol = j;
                }
            }
            if (currentMaxCol != -1) {
                //we found the two correlated features, now we need to add them to our array
                Point[] points = new Point[x.length];
                for (int k = 0; k < x.length; k++) {
                    points[k] = new Point(x[k], ts.getData().get(currentMaxCol).get(k));
                }
                Line l = StatLib.linear_reg(points);
                float maxDev = 0;
                //finding the max deviation
                for (Point z : points) {

                    if (StatLib.dev(z, l) > maxDev)
                        maxDev = StatLib.dev(z, l);
                }
                CorrelatedFeatures foundRelated = new CorrelatedFeatures(ts.getColName().get(i), ts.getColName().get(currentMaxCol), m, l, maxDev*1.1F );
                coRelatedFeat.add(foundRelated);
            }
            currentMaxCol = -1;
            m = 0;

        }

    }


    @Override
    public List<AnomalyReport> detect(TimeSeries ts) {

        List<AnomalyReport> reports = new ArrayList<>();
        for(CorrelatedFeatures c:coRelatedFeat)
        {
            String col1=c.feature1;
            String col2=c.feature2;
            Line l=c.lin_reg;
            ArrayList<Float> feat1=ts.getColByName(col1);
            ArrayList<Float> feat2= ts.getColByName(col2);
            Point[] points=new Point[feat1.size()];
            for(int i=0;i< points.length;i++)
            {
                points[i]=new Point(feat1.get(i),feat2.get(i));
            }
            for(int i=0;i< points.length;i++)
            {
                if(StatLib.dev(points[i],l)>c.threshold)
                {
                    reports.add(new AnomalyReport(col1+"-"+col2,i+1));
                }
            }
        }

        return reports;
    }

    @Override
    public AnomalyReport detect(TimeSeries ts, int timestamp) {
        List<AnomalyReport> reports = new ArrayList<>();
        for(CorrelatedFeatures c:coRelatedFeat)
        {

            String col1=c.feature1;
            String col2=c.feature2;
            Line l=c.lin_reg;
            ArrayList<Float> feat1=ts.getColByName(col1);
            ArrayList<Float> feat2= ts.getColByName(col2);
            Point point=new Point(feat1.get(timestamp),feat2.get(timestamp));
            if(StatLib.dev(point,l)>c.threshold)
            {
                return new AnomalyReport(col1+"-"+col2,timestamp+1);
            }
        }
        return null;
    }

    public List<CorrelatedFeatures> getNormalModel() {
        return coRelatedFeat;
    }

}