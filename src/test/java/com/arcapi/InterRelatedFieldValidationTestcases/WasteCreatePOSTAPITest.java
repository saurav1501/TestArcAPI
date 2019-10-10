package com.arcapi.InterRelatedFieldValidationTestcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

import net.minidev.json.JSONObject;

public class WasteCreatePOSTAPITest extends BaseClass {

	@Test(groups="CheckMeter")
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void WasteCreatePOSTAPI(String SheetName,String ProjectTypeColumn, int rownumber) throws IOException {

		
		for (String str : FuelTypeValue) {
		
		JSONObject jsonAsMap = new JSONObject();
		jsonAsMap.put("name", "Test Energy Meter");
		jsonAsMap.put("native_unit", str);
		jsonAsMap.put("type", "267");

		url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/meters/";

		CommonMethod.res = MethodCall.POSTRequest(url, jsonAsMap);

		String Actvalue = "US tons";
		if(Actvalue.contains(str)) {
		Assertion.verifyStatusCode(	CommonMethod.res, 201);
		
		}
		
		else {
			
			Assertion.verifyStatusCode(CommonMethod.res, 400);
					
		}
		
		

	}
	}


}