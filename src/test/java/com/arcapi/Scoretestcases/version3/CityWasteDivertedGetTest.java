package com.arcapi.Scoretestcases.version3;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class CityWasteDivertedGetTest extends BaseClass {

	@Test
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void CityWasteDivertedGet(String SheetName,String ProjectTypeColumn, int rownumber)  {

		try {
			url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber)
			+ "/waste_diversion_perc/list/";
			CommonMethod.res = MethodCall.GETRequest(url);
			
			Assertion.verifyStatusCode(	CommonMethod.res, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}