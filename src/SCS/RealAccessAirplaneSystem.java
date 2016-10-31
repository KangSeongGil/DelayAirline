package SCS;

public class RealAccessAirplaneSystem implements AccessAirplaneSystem {
	private String[][] AirplaneList;
	
	public RealAccessAirplaneSystem(){
		 this.AirplaneList=new String[][]{{"1","Hongkong","10:00","19:00","via Shanghai"},
					{"2","Hongkong","10:00","13:00","Direct"},
					{"3","Hongkong","12:30","22:00","via Tokyo"},
					{"4","Hongkong","15:00","18:00","Direct"},
					{"5","Hongkong","18:00","22:00","Direct"}};
	}
	
	public String[][] searchAirplane(String search_info){
		return AirplaneList;
	}

	public String[][] recommendAirplane(String destination, String time) {
		String[][] apList = new String[][]{
				{"3","Hongkong","12:30","22:00","via Tokyo"},
				{"4","Hongkong","15:00","18:00","Direct"},
				{"5","Hongkong","18:00","22:00","Direct"}};
		return apList;
	}

	public boolean reserveAirplane(String[] reserveInfo) {
		boolean success;
		success = true;
		return success;
	}
}
