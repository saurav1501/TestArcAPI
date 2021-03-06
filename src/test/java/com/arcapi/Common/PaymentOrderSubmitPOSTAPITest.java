package com.arcapi.Common;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utill.Controller.Assertion;
import com.Utill.Controller.MethodCall;
import com.Utill.Model.AddProjectPayload;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PaymentOrderSubmitPOSTAPITest extends BaseClass {

	@Test(groups="CheckPayment")
	@Parameters({ "SheetName", "ProjectTypeColumn", "rownumber", "PaymentType" })
	public void PaymentOrderSubmitPOSTAPI(String SheetName, String ProjectTypeColumn, int rownumber, String PaymentType) {	
		try {
			
			url ="/assets/LEED:"+data.getCellData(SheetName, ProjectTypeColumn, rownumber)+"/payments/order/";
			
			if (PaymentType.equalsIgnoreCase("CreditCardPayment"))
			{
				payload=AddProjectPayload.paymentCC();				
				CommonMethod.res= MethodCall.POSTRequest(url, payload);
			}
			else {		
				payload=AddProjectPayload.paymentCheck();
				CommonMethod.res= MethodCall.POSTRequest(url, payload);
			}
			Assertion.verifyStatusCode(CommonMethod.res, 403);
			Assertion.verifyStatusMessage(CommonMethod.res,statusMessage);
	
			CommonMethod.fetchedID = CommonMethod.res.path("ESalesdocument").toString();
			data.setCellData("DataInput","ESalesdocument",2,CommonMethod.fetchedID);
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
	
	
}