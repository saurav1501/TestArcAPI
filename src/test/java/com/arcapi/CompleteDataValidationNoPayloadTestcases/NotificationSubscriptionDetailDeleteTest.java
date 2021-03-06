package com.arcapi.CompleteDataValidationNoPayloadTestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.jayway.restassured.http.ContentType;

public class NotificationSubscriptionDetailDeleteTest extends BaseClass {

	@Test(groups="CheckNotifcaiton")
	@Parameters({ "SheetName", "ProjectTypeColumn", "rownumber" })
	public void NotificationSubscriptionDetailDelete(String SheetName, String ProjectTypeColumn, int rownumber)
		{

		try {
			url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/subscriptions/";

			CommonMethod.res = MethodCall.DELETERequest(url);
			Assertion.verifyStatusCode(CommonMethod.res, 404);
			CommonMethod.res.then().assertThat().contentType(ContentType.JSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}}