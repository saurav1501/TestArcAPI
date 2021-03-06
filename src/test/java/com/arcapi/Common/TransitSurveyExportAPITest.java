package com.arcapi.Common;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class TransitSurveyExportAPITest extends BaseClass {

	@Test(groups="CheckSurveyExport")
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void TransitSurveyExportAPI(String SheetName,String ProjectTypeColumn, int rownumber){

		try {
			url ="/assets/LEED:" +  data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/survey/transit/export/";
			CommonMethod.res= MethodCall.GETRequest(url);
			Assertion.verifyStatusCode(	CommonMethod.res, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}