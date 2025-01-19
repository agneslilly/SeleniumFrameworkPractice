package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public static String [][] getData() throws IOException
	{
		ExcelUtility excelutil=new ExcelUtility("./testData/OpenCart_LoginData.xlsx");
		int total_no_of_rows=excelutil.getRowCount("Sheet1");
		int total_no_of_cols=excelutil.getCellCount("Sheet1",1);
		String loginData[][]=new String[total_no_of_rows][total_no_of_cols];
		for(int i=1;i<=total_no_of_rows;i++)
		{
			for(int j=0;j<total_no_of_cols;j++)
			{
			 loginData[i-1][j]=excelutil.getCellData("Sheet1",i,j);
			}
		}
		return loginData;
		
	}
			

}
