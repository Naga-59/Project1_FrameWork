package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

	@DataProvider(name=" LogInDatas")
	public String [][] getData() throws IOException{
		String path=".\\testData\\logInData.xlsx";
		
		XLUtilities xl=new XLUtilities(path);
		
		int totalrows=xl.getRowCount("Sheet1");
		int totalcell=xl.getCellCount("Sheet1", 1);
		
		String logIndata[][]=new String[totalrows][totalcell];
		for(int r=1;r<=totalrows;r++) {
			for(int c=0;c<totalcell;c++) {
				logIndata[r-1][c]=xl.getCellData("Sheet1", r, c);
			}
		}
		
		return logIndata;
	}
}
