package com.gorest.api.tests;

import org.testng.annotations.DataProvider;
import com.gorest.api.utilities.ExcelUtil;


public class UserExcelDataProvider {
	
    @DataProvider(name = "excelUserData")
    public Object[][] getUserData() {
        return ExcelUtil.getExcelData(
                "UserData/users.xlsx",
                "users"
        );
    }

}
