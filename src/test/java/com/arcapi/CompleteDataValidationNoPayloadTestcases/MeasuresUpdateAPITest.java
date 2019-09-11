package com.arcapi.CompleteDataValidationNoPayloadTestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.jayway.restassured.http.ContentType;

public class MeasuresUpdateAPITest extends BaseClass {

	@Test(groups="Measures")
	@Parameters({ "SheetName", "ProjectTypeColumn", "rownumber" })
	public void MeasuresUpdateAPI(String SheetName, String ProjectTypeColumn, int rownumber) {

		url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/measures/"
				+ data.getCellData(SheetName, "MeasuresID", rownumber) + "/?points_pursued=";
		
		CommonMethod.res = MethodCall.PUTRequest(url);		
		Assertion.verifyStatusCode(CommonMethod.res, 400);
		CommonMethod.res.then().assertThat().contentType(ContentType.JSON);
	}

}