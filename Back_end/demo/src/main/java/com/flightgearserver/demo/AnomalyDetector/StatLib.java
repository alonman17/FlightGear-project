package com.flightgearserver.demo.AnomalyDetector;

public class StatLib {
    // simple average
    public static float avg(float[] x)
    {
        float sum=0;
        for(float n: x)
        {
            sum+=n;
        }
        return sum/x.length;
    }

    // returns the variance of X and Y
    public static float var(float[] x) {
        float e;
        float res=0;
        e=avg(x);
        for(float n:x)
        {
            res+=Math.pow(n-e,2);
        }
        return res/x.length;
    }

    // returns the covariance of X and Y
    public static float cov(float[] x, float[] y){

        float sum=0;
        for(int i=0;i<x.length;i++)
        {
            sum+=(x[i]-avg(x))*(y[i]-avg(y));
        }
        return sum/x.length;
    }

    // returns the Pearson correlation coefficient of X and Y
    public static float pearson(float[] x, float[] y)
    {
        float divider= (float) Math.sqrt(var(x)*var(y));
        float res=cov(x,y)/divider;
        return res;
    }

    // performs a linear regression and returns the line equation
    public static Line linear_reg(Point[] points){
        float[] x=new float[points.length];
        float[] y=new float[points.length];
        for(int i=0;i<points.length;i++)
        {
            x[i]=points[i].x;
            y[i]=points[i].y;
        }
        float a=cov(x,y)/var(x);
        float b=avg(y)-(a*avg(x));
        Line l=new Line(a,b);
        return l;

    }

// returns the deviation between point p and the line equation of the
//    points
    public static float dev(Point p,Point[] points)
    {

        Line l=linear_reg(points);
        return dev(p,l);

    }
    // returns the deviation between point p and the line
    public static float dev(Point p,Line l){
        float res;

        float fx=l.f(p.x);
        res=fx-p.y;
       return Math.abs(res);
    }
}
