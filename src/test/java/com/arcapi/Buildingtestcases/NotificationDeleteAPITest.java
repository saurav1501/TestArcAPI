package com.arcapi.Buildingtestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class NotificationDeleteAPITest extends BaseClass {

	@Test(groups="CheckNotification")
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void NotificationDeleteAPI(String SheetName,String ProjectTypeColumn, int rownumber){

		try {
			url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/notifications/?foreign_id=skipped_payment";
			CommonMethod.res = MethodCall.DELETERequest(url);
			Assertion.verifyStatusCode(CommonMethod.res, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}