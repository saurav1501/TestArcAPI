package com.arcapi.Citytestcases;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.jayway.restassured.http.ContentType;

public class CreateAssetCityOtherAPITest extends BaseClass {

	@Test(groups="CheckCreateProject")
	@Parameters({ "SheetName", "ProjectType","ProjectTypeColumn","rownumber","Country" })
	public void CreateAssetPOSTAPI(String SheetName, String ProjectType,String ProjectTypeColumn, int rownumber, String Country) throws IOException {
	
		String State = null;
		String Unit = null;
		String OwnerType  = null;
		String ZipCode = null;

        if(Country.equals("IN"))
			
		{
			String[] StateOptions  = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17",
					"18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","TG"};
			
			State = (StateOptions[new Random().nextInt(StateOptions.length)]);
			
			data.setCellData(SheetName, "Country", rownumber, Country);
			
			data.setCellData(SheetName, "State", rownumber, State);
			
			ZipCode = "122018";
			
			data.setCellData(SheetName, "ZipCode", rownumber, ZipCode);
		}
		
        else if(Country.equals("US"))
			
		{
			String[] StateOptions  = {"AL","AK","AS","AZ","AR","CA","CO","CT","DE","DC","FL","GA","GU","HI","ID","IL","IN","IA",
					"KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","MP",
					"OH","OK","OR","PA","PR","RI","SC","SD","TN","TX","UT","VT","VI","VA","WA","WV","WI","WY"};
			
			State = (StateOptions[new Random().nextInt(StateOptions.length)]);
			
			data.setCellData(SheetName, "Country", rownumber, Country);
			
			data.setCellData(SheetName, "State", rownumber, State);
			
            ZipCode = "20037";
			
			data.setCellData(SheetName, "ZipCode", rownumber, ZipCode);
		}
		
        else if(Country.equals("CN"))
			
		{
			String[] StateOptions  = {"110","010","320","150","260","190","200","210","220","060","090","180","160","170","100","140","080",
					"070","040","270","280","250","120","020","050","230","030","240","290","300","240","130"};
			
			State = (StateOptions[new Random().nextInt(StateOptions.length)]);
			
			data.setCellData(SheetName, "Country", rownumber, Country);
			
			data.setCellData(SheetName, "State", rownumber, State);
			
            ZipCode = "518000";
			
			data.setCellData(SheetName, "ZipCode", rownumber, ZipCode);
		}
		
		
		String[] UnitOptions  = {"SI","IP"};
		
		Unit = (UnitOptions[new Random().nextInt(UnitOptions.length)]);
		
		data.setCellData(SheetName, "Unit", rownumber, Unit);
		
		
		String[] OwnerTypeOptions  = {"Business Improvement District",
			    "Community Development Corporation or Non-profit Developer",
			    "Corporate: Privately Held",
			    "Corporate: Publicly Traded",
			    "Educational: College, Private",
			    "Educational: College, Public",
			    "Educational: Community College, Private",
			    "Educational: Community College, Public",
			    "Educational: Early Childhood Education/Daycare",
			    "Educational: K-12 School, Private",
			    "Educational: K-12 School, Public",
			    "Educational: University, Private",
			    "Educational: University, Public",
			    "Government Use: Federal",
			    "Government Use: Local, City",
			    "Government Use: Local, County",
			    "Government Use: Local, Public Housing Authority",
			    "Government Use: Other (utility, airport, etc.)",
			    "Government Use: State",
			    "Investor: Bank",
			    "Investor: Endowment",
			    "Investor: Equity Fund",
			    "Investor: Individual/Family",
			    "Investor: Insurance Company",
			    "Investor: Investment Manager",
			    "Investor: Pension Fund",
			    "Investor: REIT, Non-traded",
			    "Investor: REIT, Publicly traded",
			    "Investor: ROEC",
			    "Main Street Organization",
			    "Non-Profit (that do not fit into other categories)",
			    "Religious"
			    };
		
		OwnerType = (OwnerTypeOptions[new Random().nextInt(OwnerTypeOptions.length)]);
		
		data.setCellData(SheetName, "OwnerType", rownumber, OwnerType);
		
		String ProjectName = "MachineTestProject-City-Other-" + Country;
		
		data.setCellData(SheetName, "ProjectName", rownumber, ProjectName);
		
        data.setCellData(SheetName, "Address", rownumber, "312 Wilson Streets");
		
		data.setCellData(SheetName, "OwnerOrg", rownumber, "B & B Associates, Inc.");
		
		data.setCellData(SheetName, "OwnerCountry", rownumber, Country);
		
		CommonMethod.res = given().log().all()
				.parameters(
						    "name", ProjectName,
						    "unitType", Unit,
						    "project_type", ProjectType,
						    "rating_system","other", 
						    "ownerType",OwnerType,
						    "organization","B & B Associates, Inc.",
						    "owner_email",data.getCellData(SheetName, "OwnerEmail", rownumber),
						    "manageEntityCountry",Country,
						    "gross_area", GrossArea,
						    "confidential", false,
						    "occupancy", "50", 
						    "operating_hours", "30",
						    "street", "312 Wilson Streets", 
						    "city","Test City", 
						    "country", Country, 
						    "state", State,
						    "zip_code",ZipCode
						    )
				.header("Ocp-Apim-Subscription-Key", CommonMethod.SubscriptionKey)
				.header("Authorization", header).spec(reqSpec).when().post("/assets/").then()
				.extract().response();
		
		CommonMethod.res.then().assertThat().statusCode(201);
		
		CommonMethod.res.then().assertThat().contentType(ContentType.JSON);

		CommonMethod.testlog("Pass", "Verifies response from API" + "<br>" + CommonMethod.res.asString());

		CommonMethod.fetchedID = CommonMethod.res.path("leed_id").toString();

		data.setCellData(SheetName, ProjectTypeColumn, rownumber, CommonMethod.fetchedID);

	}

	
}