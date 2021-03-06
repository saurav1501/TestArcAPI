package com.arcapi.Transittestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class ExcelTemplateMetersTransitAboveAPITest extends BaseClass {

	@Test(groups="CheckMeter")
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void ExcelTemplateMetersTransitAbove(String SheetName,String ProjectTypeColumn, int rownumber){

			
		try {
			int row = 2;
			url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/meters/?page_size=20";
			CommonMethod.res = MethodCall.GETRequest(url);	
			Assertion.verifyStatusCode(CommonMethod.res, 200);
			
			for (int i=0;i<2;i++) {
				
			CommonMethod.fetchedID = CommonMethod.res.path("results.id["+i+"]").toString();
			data.setCellData("DataInput", "ExcelTemplateMeterID", row, CommonMethod.fetchedID);
			CommonMethod.fetchedID = CommonMethod.res.path("results.name["+i+"]").toString();
			data.setCellData("DataInput", "ExcelTemplateMeterName", row, CommonMethod.fetchedID);
			row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}