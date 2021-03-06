package com.arcapi.Portfoliostestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

import net.minidev.json.JSONObject;

public class PortfoliosTeamsPUTAPITest extends BaseClass {

	@Test(groups="CheckPortfolio")
	@Parameters({ "SheetName","rownumber" })
	public void PortfoliosTeamsPUTAPI(String SheetName, int rownumber){

			
		try {
			JSONObject jsonAsMap = new JSONObject();
			jsonAsMap.put("username", "usgbcarcapi2@gmail.com");
			jsonAsMap.put("permission", "can_read");
			
			url = "/portfolios/ID:"+data.getCellData(SheetName, "PortfolioID", rownumber)+"/teams/";

			CommonMethod.res = MethodCall.PUTRequest(url,jsonAsMap);
			
			Assertion.verifyStatusCode(CommonMethod.res, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}