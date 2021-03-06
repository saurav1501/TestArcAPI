package com.Utill;

import java.io.Serializable;

public class  AddBuildingProject implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String rating_system; 
	private String gross_area;
	private String occupancy;
	private String street;
	private String city;
	private String country;
	private String state;
	private String project_type;
	private String unitType;
	private String spaceType;
	private String owner_email;
	private String ownerType;
	private boolean confidential;
	private boolean sign_agreement;
	private String organization;
	private String manageEntityCountry;
	private String zip_code;
	private String orgName;
	private String year_constructed;
	private String category;
	private String effective_at;
	private String station_type;
	private String annual_ridership;
	private String full_time_staff;
	private String time_spent_by_riders;
	private String noOfParkingSpace;
	private String noOfParkingLevels;

	
	public String getNoOfParkingSpace() {
		return noOfParkingSpace;
	}
	public void setNoOfParkingSpace(String noOfParkingSpace) {
		this.noOfParkingSpace = noOfParkingSpace;
	}
	public String getNoOfParkingLevels() {
		return noOfParkingLevels;
	}
	public void setNoOfParkingLevels(String noOfParkingLevels) {
		this.noOfParkingLevels = noOfParkingLevels;
	}
	public String getYear_constructed() {
		return year_constructed;
	}
	public void setYear_constructed(String year_constructed) {
		this.year_constructed = year_constructed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating_system() {
		return rating_system;
	}
	public void setRating_system(String rating_system) {
		this.rating_system = rating_system;
	}
	public String getGross_area() {
		return gross_area;
	}
	public void setGross_area(String gross_area) {
		this.gross_area = gross_area;
	}
	public String getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getSpaceType() {
		return spaceType;
	}
	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}
	public String getOwner_email() {
		return owner_email;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public boolean isConfidential() {
		return confidential;
	}
	public void setConfidential(boolean confidential) {
		this.confidential = confidential;
	}
	public boolean isSign_agreement() {
		return sign_agreement;
	}
	public void setSign_agreement(boolean sign_agreement) {
		this.sign_agreement = sign_agreement;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getManageEntityCountry() {
		return manageEntityCountry;
	}
	public void setManageEntityCountry(String manageEntityCountry) {
		this.manageEntityCountry = manageEntityCountry;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getOperating_hours() {
		return operating_hours;
	}
	public void setOperating_hours(String operating_hours) {
		this.operating_hours = operating_hours;
	}
	private String operating_hours;


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEffective_at() {
		return effective_at;
	}
	public void setEffective_at(String effective_at) {
		this.effective_at = effective_at;
	}
	public String getStation_type() {
		return station_type;
	}
	public void setStation_type(String station_type) {
		this.station_type = station_type;
	}
	public String getAnnual_ridership() {
		return annual_ridership;
	}
	public void setAnnual_ridership(String annual_ridership) {
		this.annual_ridership = annual_ridership;
	}
	public String getFull_time_staff() {
		return full_time_staff;
	}
	public void setFull_time_staff(String full_time_staff) {
		this.full_time_staff = full_time_staff;
	}
	public String getTime_spent_by_riders() {
		return time_spent_by_riders;
	}
	public void setTime_spent_by_riders(String time_spent_by_riders) {
		this.time_spent_by_riders = time_spent_by_riders;
	}
	
		
}
