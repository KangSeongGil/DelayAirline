package Model;

import SCS.AccessProxy;

public class Hotel {
	private String name;
	private String location;
	private String phoneNumber;
	private String distance;
	private String grade;
	private String flag;
	private AccessProxy accessProxy;
	
	public Hotel(){
		
	}
	public Hotel(String name, String location, String phoneNumber,  String grade, String distance, String flag){
		this.name = name;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.distance = distance;
		this.grade = grade;
		this.flag = flag;
		
	}
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public void setLocation(String location){
		this.location = location;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getDistance(){
		return this.distance;
	}
	
	public void setDistance(String distance){
		this.distance = distance;
	}
	
	public String getGrade(){
		return this.grade;
	}
	
	public void setGrade(String grade){
		this.grade = grade;
	}
	
	public String getFlag(){
		return this.flag;
	}
	
	public void setFlag(String flag){
		this.flag = flag;
	}
	public String[][] getRoomInfo(String hotelName) {
		accessProxy = accessProxy.getInstance();
		return(accessProxy.getRoomInfo(hotelName));
	}
	public boolean reserveHotel(String[] reserve_info) {
		accessProxy = accessProxy.getInstance();
		return(accessProxy.reserveHotel(reserve_info));
	}
}
