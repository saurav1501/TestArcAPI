package com.arcapi.InterRelatedFieldValidationTestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.minidev.json.JSONObject;

public class HumanCreatePOSTAPITest extends BaseClass {

	@Test(groups="CheckMeter")
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void HumanCreatePOSTAPI(String SheetName,String ProjectTypeColumn, int rownumber)  {
		try {
			for (String str : FuelTypeValue) {
			
			JSONObject jsonAsMap = new JSONObject();
			jsonAsMap.put("name", "Test Energy Meter");
			jsonAsMap.put("native_unit", str);
			jsonAsMap.put("type", "270");

			url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/meters/";

			CommonMethod.res = MethodCall.POSTRequest(url,jsonAsMap);

			
			
			if(str=="person"||str=="ppm"||str=="days"||str=="dollar") {
			
			Assertion.verifyStatusCode(CommonMethod.res, 201);	
			}
			
			else {
				
				Assertion.verifyStatusCode(CommonMethod.res, 400);	
			
			}
			
			
}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}