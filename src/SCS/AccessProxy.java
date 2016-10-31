package SCS;
import java.sql.*;

public class AccessProxy {

	private AccessUserDB accUserDB = new AccessUserDB();
	private AccessHotelDB accHotelDB = new AccessHotelDB();
	private boolean authority;
	private AccessAirplaneSystem accAS = new RealAccessAirplaneSystem();
	private static AccessProxy accProxy;

	public static AccessProxy getInstance(){
		if(accProxy==null){
			accProxy = new AccessProxy();
		}
		return accProxy;
	}
	
	public boolean requestAuthority(String userID, char[] userPW){
		this.authority = this.accUserDB.requestAuthority(userID, userPW);
		return this.authority;
	}

	public String[][] checkNewHotel(){
		if(authority == true){
			return(accHotelDB.checkNewHotel());
		}
		return null;
	}
	
	public String[][] getRoomInfo(String hotelName){

		if(authority==true){
			return(accHotelDB.getRoomInfo(hotelName));	
		}
		return null;

	}

	public boolean reserveHotel(String[] reserve_info) {
		if(authority==true){
			return(accHotelDB.reserveHotel(reserve_info));
		}
		return false;
	}

	public String[][] searchAirplane(String search_info) {
		if(authority==true){
			String[][] airplaneList;
			airplaneList = accAS.searchAirplane(search_info);
			return airplaneList;
		}
		return null;

	}

	public String[][] recommendAirplane(String destination, String time) {
		if(authority == true){
			String[][] airplaneList;
			airplaneList = accAS.recommendAirplane(destination, time);
			return airplaneList;
		}
		return null;
	}

	public boolean reserveAirplane(String[] reserve_info) {
		if(authority == true){
			boolean success;
			success = accAS.reserveAirplane(reserve_info);
			return success;
		}
		return false;
	}


}
