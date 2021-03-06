package com.arcapi.Portfoliostestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

import net.minidev.json.JSONObject;

public class PortfoliosTeamsDELETEAPITest extends BaseClass {

	@Test(groups="CheckPortfolio")
	@Parameters({ "SheetName","rownumber" })
	public void PortfoliosTeamsDELETEAPI(String SheetName, int rownumber)  {

		
		try {
			JSONObject jsonAsMap = new JSONObject();
			jsonAsMap.put("username", "usgbcarcapi2@gmail.com");
			
			url = "/portfolios/ID:" + data.getCellData(SheetName, "PortfolioID", rownumber) + "/teams/";
			CommonMethod.res = MethodCall.DELETERequest(url,jsonAsMap);
			Assertion.verifyStatusCode(CommonMethod.res , 200);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}

	

}