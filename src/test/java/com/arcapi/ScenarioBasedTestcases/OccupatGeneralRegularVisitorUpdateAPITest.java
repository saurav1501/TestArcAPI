package com.arcapi.ScenarioBasedTestcases;

import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.fasterxml.jackson.core.JsonProcessingException;

public class OccupatGeneralRegularVisitorUpdateAPITest extends BaseClass{
	
		@Test(groups="UpdateGeneralOccupancy")
		@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	
		public void OccupatGeneralRegularVisitorUpdateAPI(String SheetName,String ProjectTypeColumn, int rownumber) {

		try {
			url = "/assets/LEED:" +data.getCellData(SheetName, ProjectTypeColumn, rownumber)+"/occupant/general/";
			
			map = new HashMap<>();
			map.put("start_date","2011-01-01");
			map.put("total_occupant","3");
			map.put("regular_occupant","4");
			map.put("visitor_occupant","4");
			
			CommonMethod.res = MethodCall.POSTRequest(url, map);
			
			Assertion.verifyStatusCode(CommonMethod.res, 201);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		

}

}