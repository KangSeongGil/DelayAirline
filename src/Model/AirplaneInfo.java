package Model;

import SCS.AccessProxy;

public class AirplaneInfo {
	private AccessProxy acProxy;
	private String[] reserveInfo;
	
	public AirplaneInfo(){
		acProxy = acProxy.getInstance();
	}

	public String[][] searchAirplane(String search_info) {
		String[][] airplaneList;
		airplaneList = acProxy.searchAirplane(search_info);
		return airplaneList;
	}

	public String[][] recommendAirplane(String destination, String time) {
		String[][] airplaneList;
		airplaneList = acProxy.recommendAirplane(destination, time);
		return airplaneList;
		
	}

	public boolean reserveAirplane(String[] reserve_info) {
		boolean success;
		this.reserveInfo = new String[4];
		this.reserveInfo[0] = reserve_info[0];
		this.reserveInfo[1] = reserve_info[1];
		this.reserveInfo[2] = "4";
		this.reserveInfo[3] = "First";
		success = acProxy.reserveAirplane(reserve_info);
		return success;
	}
	
	public String[] getReserveInfo(){
		return reserveInfo;
	}
}
