package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	public static ConfigDataProvider getConfig() {
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}

	public static ExcelDataProvider getExcelData() {
		ExcelDataProvider exceldata = new ExcelDataProvider();
		return exceldata;
	}
}
