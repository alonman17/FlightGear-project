package com.flightgearserver.Utils;



import com.flightgearserver.Http.Entiteis.Flightsdatum;
import com.opencsv.CSVParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TimeSeries {

	List<String> colName;
	ArrayList<ArrayList<Float>> data ;
//	public TimeSeries(String colNames) {
//		colName = new ArrayList<>();
//		data = new ArrayList<>();
//		String[] curRow = colNames.split(",");
//		for (int i = 0; i < curRow.length; i++) {
//			colName.add(curRow[i]);
//		}
//		//initializing each column in the data
//			for (int i = 0; i < curRow.length; i++) {
//				data.add(new ArrayList<Float>());
//			}
//	}
	public TimeSeries(String FilePath){
		colName = new ArrayList<>();
		data = new ArrayList<>();
		try{
			 BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath));
			 String line = bufferedReader.readLine();
			 while(line!=null){
				 colName.add(line);
				 line = bufferedReader.readLine();
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//initializing each column in the data
		for (int i = 0; i < colName.size(); i++) {
			data.add(new ArrayList<Float>());
		}
	}
	//TODO do we need csvfile constructor?
//	public TimeSeries(String csvFileName) {
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(csvFileName));
//			String line;
//			line = br.readLine();
//			String[] curRow = line.split(",");
//			colName=new ArrayList<>();
//			data=new ArrayList<>();
//			//reading the col names into the colName list
//			for (int i = 0; i < curRow.length; i++) {
//				colName.add(curRow[i]);
//			}
//			//initializing each column in the data
//			for (int i = 0; i < curRow.length; i++) {
//				data.add(new ArrayList<Float>());
//			}
//			//adding the data to it's corresponding column
//			while ((line = br.readLine()) != null) {
//				int row = 0;
//				if(line.equals("done"))
//					break;
//				curRow = line.split(",");
//
//				for (int i = 0; i < curRow.length; i++) {
//						data.get(i).add(Float.parseFloat(curRow[i]));
//				}
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public ArrayList<Float> getColByName(String name) {
		int col = colName.indexOf(name);
		if (col != -1) {
			return data.get(col);
		}
		return null;

	}
	public void addRow(String row){
		String[] curRow = row.split(",");
		//TODO CHANGE BACK TO curRow.length!
		for (int i = 0; i < curRow.length; i++) {
			data.get(i).add(Float.parseFloat(curRow[i]));
		}
	}
	public int getNumberOfCols() {
		return colName.size();
	}

	public List<String> getColName() {
		return colName;
	}

	public void setColName(List<String> colName) {
		this.colName = colName;
	}

	public ArrayList<ArrayList<Float>> getData() {
		return data;
	}

	public void setData(ArrayList<ArrayList<Float>> data) {
		this.data = data;
	} //V1 OF TS
	//TODO TESTING
	public void exportToCsv(String FileName){
		File csv=new File("src/main/resources/"+FileName);
		PrintWriter writer=null;
		try {
			writer=new PrintWriter(csv);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder sb=new StringBuilder();
		colName.forEach((s)->sb.append(s+","));
		sb.deleteCharAt(sb.length()-1);
		writer.println(sb);
		sb.setLength(0);
		System.out.println(data.size()+ " " +data.get(0).size());
		for (int i = 0; i < data.get(0).size()-1; i++) {
			for (int j = 0; j < data.size(); j++) {
				sb.append(data.get(j).get(i)+",");
			}
			sb.deleteCharAt(sb.length()-1);
			writer.println(sb);
			sb.setLength(0);
		}
		writer.close();

	}

	public String exportToString() {

		StringBuilder sb=new StringBuilder();
		colName.forEach((s)->sb.append(s+","));
		sb.deleteCharAt(sb.length()-1);

		sb.setLength(0);
		for (int i = 0; i < data.get(0).size(); i++) {
			for (int j = 0; j < data.size(); j++) {
				sb.append(data.get(j).get(i)+",");
			}
			sb.deleteCharAt(sb.length()-1);

			sb.setLength(0);
		}

		return sb.toString();
	}


}