package com.oc.qa.util;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\TestData\\OpenCart_LoginTestdata.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
//	//DataProvider 2
	@DataProvider(name="AddressUpdate")
	public String [][] getAddressData() throws IOException
	{
		String path=".\\TestData\\OpenCart_AddressUpdate.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("AddressUpdate");	
		int totalcols=xlutil.getCellCount("AddressUpdate",1);
				
		String AddressData[][]=new String [totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{	
		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				AddressData[i-1][j]= xlutil.getCellData("AddressUpdate",i, j);  //1,0
			}
		}
	return AddressData;//returning two dimension array
				
	}


}
