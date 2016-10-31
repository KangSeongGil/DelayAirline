package Model;

import java.util.Vector;

import SCS.AccessProxy;

public class HotelInfo {
	Vector <Hotel> hotel_list = new Vector<Hotel>();
	Hotel hotel = new Hotel();
	private String[] reserveInfo;//String 0�� ����̸� 1�� ��ȣ 2�� ȣ���̸� 3�� ���ȣ
	private AccessProxy acProxy;
	
	public HotelInfo(){
		acProxy = acProxy.getInstance();
	}
	
	public Vector<Hotel> getHotelList(){
		return this.hotel_list;	
	}
	
	public void addHotel(Hotel A){
		this.hotel_list.add(A);
	}
	
	public String[][] getRoomInfo(String hotelName){
//		int i=0;
//		while(this.hotel_list.elementAt(i).getName()!=hotelName&& i<=this.hotel_list.size()){
//			i++;
//		}
		//return(this.hotel_list.elementAt(i).getRoomInfo(hotelName));
		return(hotel.getRoomInfo(hotelName));
	}
	
	public void manageHotelInfo(){
		String[][] hotelList = acProxy.checkNewHotel();
		while(this.hotel_list.size()!=hotelList.length){
			if(this.hotel_list.size()>hotelList.length){//��񿡼� ȣ���� �پ���� ���
				this.hotel_list.remove(hotel_list.lastElement());
			}
			if(this.hotel_list.size()<hotelList.length){
				Hotel hotel = new Hotel("","","","","","");
				this.hotel_list.add(hotel);
			}
		}
		for(int i=0; i<hotelList.length; i++){
			if(!this.hotel_list.get(i).getFlag().equals(hotelList[i][5])){//�÷��װ� �ٸ���� ������Ʈ
				this.hotel_list.elementAt(i).setName(hotelList[i][0]);
				this.hotel_list.elementAt(i).setLocation(hotelList[i][1]);
				this.hotel_list.elementAt(i).setPhoneNumber(hotelList[i][2]);
				this.hotel_list.elementAt(i).setDistance(hotelList[i][3]);
				this.hotel_list.elementAt(i).setGrade(hotelList[i][4]);
				this.hotel_list.elementAt(i).setFlag(hotelList[i][5]);
				
			}
		}	
	}
	
	public boolean reserveHotel(String[] reserve_info){
		reserveInfo = reserve_info;
		return(hotel.reserveHotel(reserve_info));
	}

	public Vector<Hotel> recommendHotel(String seatGrade) {
		Vector<Hotel> recommendHotelList = new Vector<Hotel>();
		if(seatGrade.equals("Economy")){//�Է��¼��� Economy�� ���
			for(int i=0;i<this.hotel_list.size();i++){
				if(Integer.parseInt(this.hotel_list.elementAt(i).getGrade())<=3&&Integer.parseInt(this.hotel_list.elementAt(i).getGrade())>=1){
					recommendHotelList.add(this.hotel_list.elementAt(i));
				}
			}
		}else if(seatGrade.equals("Business")){//Business�� ���
			for(int i=0;i<this.hotel_list.size();i++){
				if(Integer.parseInt(this.hotel_list.elementAt(i).getGrade())<=4&&Integer.parseInt(this.hotel_list.elementAt(i).getGrade())>=3){
					recommendHotelList.add(this.hotel_list.elementAt(i));
				}
			}
		}else{//First�� ���
			for(int i=0;i<this.hotel_list.size();i++){
				if(Integer.parseInt(this.hotel_list.elementAt(i).getGrade())>=4){
					recommendHotelList.add(this.hotel_list.elementAt(i));
				}
			}
		}
		return recommendHotelList;
		
	}
	
	public String[] getReserveInfo(){
		return this.reserveInfo;//String 0�� ����̸� 1�� ��ȣ 2�� ȣ���̸� 3�� ���ȣ
	}
}
