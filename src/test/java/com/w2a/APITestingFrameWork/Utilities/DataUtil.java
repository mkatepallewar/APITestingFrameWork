package com.w2a.APITestingFrameWork.Utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.w2a.APITestingFrameWork.setUp.BaseTest;

public class DataUtil extends BaseTest{
	
	@DataProvider(name = "data" , parallel = true)
	public Object [][] getData(Method m) {
		
		int rows=excel.getRowCount(config.getProperty("testDataSheetName"));
		System.out.println("Total Rows are: " + rows);
		
		String testName=m.getName();
		System.out.println("Test Name: "+ m.getName());
		
		//Find the test case start row
		int testCaseRowNum=1;
		for (testCaseRowNum=1; testCaseRowNum<=rows;testCaseRowNum++) {
			String testCaseName=excel.getCellData(config.getProperty("testDataSheetName"), 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test case starts from row num: " + testCaseRowNum);
		
		//Find ttotal eows in test case
		
		int dataStartRowNum=testCaseRowNum+2;
		int testRows=0;
		
		while(!excel.getCellData(config.getProperty("testDataSheetName"), 0, dataStartRowNum+testRows).equals("")) {
			testRows++;
		}
		System.out.println("Total Rows of data : " + testRows);
		
		// find total cols in test case
		
		int colStartColNum=testCaseRowNum+1;
		int testCols=0;
		
		while(!excel.getCellData(config.getProperty("testDataSheetName"),testCols, colStartColNum).equals("")) {
			testCols++;
		}
		
		System.out.println("Total Cols : " + testCols);
		
		Object[][] data=new Object[testRows][1];
		int i=0;
		
		for (int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++) {
			Hashtable<String, String> table=new Hashtable<String, String>();
			
			for(int cNum=0;cNum<testCols;cNum++) {
				String testData=excel.getCellData(config.getProperty("testDataSheetName"), cNum, rNum);
				String colName=excel.getCellData(config.getProperty("testDataSheetName"), cNum, colStartColNum);
				
				table.put(colName, testData);
			}
			data[i][0]=table;
			i++;
		}
		

		return data;
		
	}

}
