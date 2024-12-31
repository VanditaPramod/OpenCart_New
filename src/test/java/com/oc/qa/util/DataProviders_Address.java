package com.oc.qa.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders_Address {

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
	
//	@DataProvider(name="AddressDelete")
//	public String [][] getAddressData_Delete() throws IOException
//	{
//		String path=".\\TestData\\OpenCart_AddressUpdate.xlsx";//taking xl file from testData
//		
//		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
//		
//		int totalrows=xlutil.getRowCount("AddressUpdate");	
//		int totalcols=xlutil.getCellCount("AddressUpdate",1);
//				
//		String AddressData[][]=new String [totalrows][totalcols];//created for two dimension array which can store the data user and password
//		
//		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
//		{	
//		
//			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
//			{
//				AddressData[i-1][j]= xlutil.getCellData("AddressUpdate",i, j);  //1,0
//			}
//		}
//	return AddressData;//returning two dimension array
//				
//	}
}
