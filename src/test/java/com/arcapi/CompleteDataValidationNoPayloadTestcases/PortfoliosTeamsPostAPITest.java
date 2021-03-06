package com.arcapi.CompleteDataValidationNoPayloadTestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.jayway.restassured.http.ContentType;

public class PortfoliosTeamsPostAPITest extends BaseClass {

	@Test(groups="Portfolios")
	@Parameters({ "SheetName", "ProjectTypeColumn", "rownumber" })
	public void PortfoliosTeamsPostAPI(String SheetName, String ProjectTypeColumn, int rownumber){

		try {
			url = "/portfolios/ID:" + data.getCellData(SheetName, "PortfolioID", rownumber) + "/teams/";
			CommonMethod.res = MethodCall.POSTRequest(url);
			Assertion.verifyStatusCode(CommonMethod.res, 400);
			CommonMethod.res.then().assertThat().contentType(ContentType.JSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}}