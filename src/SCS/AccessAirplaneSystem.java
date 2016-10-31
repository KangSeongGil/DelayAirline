package SCS;

public interface AccessAirplaneSystem {
	public String[][] searchAirplane(String search_info);
	public String[][] recommendAirplane(String destination, String time);
	public boolean reserveAirplane(String[] reserveInfo);
}
