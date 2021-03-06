package com.arcapi.Buildingtestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.minidev.json.JSONObject;

public class WaterMeterCreateAPITest extends BaseClass {

	@Test(groups="CheckMeter")
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void WaterMeterCreateAPI(String SheetName,String ProjectTypeColumn, int rownumber){
		
		try {
			int row = 2;
			
			String[] Unit = {"gal","kGal", "MGal","cf","ccf","kcf","mcf","l","cu m","gal(UK)","kGal(UK)", "MGal(UK)","cGal (UK)","cGal (US)","Kcm"};
			String[] Type = {"47","54","57"};
			
			for (int i=0;i < Unit.length;i++) {
				for(int j=0;j<Type.length;j++) {

			JSONObject jsonAsMap = new JSONObject();
			jsonAsMap.put("name", "Test Water Meter");
			jsonAsMap.put("native_unit", Unit[i]);
			jsonAsMap.put("type", Type[j]);

			url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/meters/?recompute_score=false";

			CommonMethod.res = MethodCall.POSTRequest(url,jsonAsMap);

			CommonMethod.fetchedID = CommonMethod.res.path("id").toString();

			data.setCellData("DataInput", "WaterMeterID", row, CommonMethod.fetchedID);

			Assertion.verifyStatusCode(CommonMethod.res, 201);
			
			row++;
		}
}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
}