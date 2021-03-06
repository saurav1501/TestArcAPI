package com.arcapi.Common;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class SocreVersionUpdateQuerysetGetAPITest extends BaseClass{
	
	@Test(groups="CheckAsset")
	@Parameters({"SheetName","ProjectTypeColumn","rownumber" })
	public void SocreVersionUpdateQuerysetGetAPI(String SheetName,String ProjectTypeColumn, int rownumber)  {

		try {
			url="/assets/LEED:" +data.getCellData(SheetName, ProjectTypeColumn, rownumber)+ "/scores/version/update/";
			CommonMethod.res = MethodCall.GETRequest(url);
			Assertion.verifyStatusCode(CommonMethod.res, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}



}


