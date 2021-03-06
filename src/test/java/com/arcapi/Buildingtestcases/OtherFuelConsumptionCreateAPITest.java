package com.arcapi.Buildingtestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.Utill.Model.MeterPayload;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.fasterxml.jackson.core.JsonProcessingException;

public class OtherFuelConsumptionCreateAPITest extends BaseClass {

	@Test(groups="CheckMeter")
	@Parameters({ "SheetName","ProjectTypeColumn","rownumber" })
	public void OtherFuelConsumptionCreateAPI(String SheetName,String ProjectTypeColumn, int rownumber) {

			
		try {
			int RowNum = data.getRowCountbyColNum("DataInput", 0);
			
			for (int i =2; i<= RowNum;i++) {

			payload = MeterPayload.meterData3();

			url = "/assets/LEED:" + data.getCellData(SheetName, ProjectTypeColumn, rownumber) + "/meters/ID:"
					+ data.getCellData("DataInput", "OtherFuelMeterID", i) + "/consumption/";

			CommonMethod.res = MethodCall.POSTRequest(url,payload);
					
			Assertion.verifyStatusCode(CommonMethod.res, 201);

			CommonMethod.fetchedID = CommonMethod.res.path("id").toString();

			data.setCellData("DataInput", "OtherFuelPK", i, CommonMethod.fetchedID);

}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}