package Controller;

import java.util.Vector;

import View.*;
import SCS.*;
import Model.*;

public class Controller {
	LoginInterface loginInterface;
	FunctionInterface menu;
	LoginInfo LoginInfo;
	HotelInfo hotelInfo;
	AirplaneInfo apInfo;
	Printer printer;
	int isSelected;
	
	public Controller(){
		loginInterface = new LoginInterface(this);
		LoginInfo = new LoginInfo();
		hotelInfo = new HotelInfo();
		apInfo = new AirplaneInfo();
		printer = new Printer();
	}
	
	public void loginAction(){//�α����� �����ϴ� �Լ�
		String ID;
		char[] PW = new char[10];
		ID = loginInterface.getID();//�Է� ���̵� �޾ƿ�
		PW = loginInterface.getPW();//�Է� PW�� �޾ƿ�
		LoginInfo.setID(ID);
		LoginInfo.setPW(PW);
		if(LoginInfo.requestAuthority()){//�α��� �������� �α��� ����
			menu = new FunctionInterface(this);
			loginInterface.getFrame().setVisible(false);
		}else loginInterface.errorMessage();
	}
	
	public void actionHTSearch(){//ȣ�� ����Ʈ�� �޾ƿ�
		Vector <Hotel> hotelList;
		hotelList = hotelInfo.getHotelList();
		menu.displayHotelList(hotelList);
	}
	
	public void actionHTSearch(String hotelName){//hotelName�� �������� Search
		menu.selectedHotel = hotelName;
		String[][] roomInfo;
		roomInfo = this.hotelInfo.getRoomInfo(hotelName);
		menu.displaySearchHTList(roomInfo);
	}
	
	public void actionHTRecommend(){//Recommend ����
		String seatGrade;
		seatGrade = menu.displayInputGradeWindow();//���� �����ߴ� �¼� ����� �Է� �޴´�.
		if(seatGrade != null)
			menu.addHTRecommend(hotelInfo.recommendHotel(seatGrade));//�Է� ���� �¼� ������� ����
		
	}
	
	public void actionHTReserve(){
		menu.displayInputPersonInfo();
	}
	
	public boolean actionHTReserve(String[] reserve_info){//String 0�� ����̸� 1�� ��ȣ 2�� ȣ���̸� 3�� ���ȣ
		boolean success;
		isSelected = 1;//Print�Ҷ� �������� ����� �����߾�����
		success = hotelInfo.reserveHotel(reserve_info);//������ ������ �̿��� Reserve ����
		return(success);
	}
	
	public void actionHTMange(){
		hotelInfo.manageHotelInfo();
		
	}

	public void actionAPSearch() {//Airplane Search
		String search_info;
		String[][] airplaneList;
		search_info = menu.displayInputDestination();//�������� �޾ƿ�
		airplaneList =apInfo.searchAirplane(search_info);//�������� ���ϴ� �װ��⸦ Search
		menu.displaySearchAPList(airplaneList);
	}

	public void actionAPRecommend() {//�װ��� ��õ ����
		String[] arr;
		String[][] recommendInfo;
		arr = menu.displayPassengerInputWindow();//�������� ��߽ð��� �޾ƿ�
		if(arr!=null){
			recommendInfo = apInfo.recommendAirplane(arr[0], arr[1]);//�޾ƿ� ������ ���� ����
			menu.addAPRecommendInfo(recommendInfo);
		}
	}

	public void actionAPReserve() {
		menu.displayAPInputPersonInfo();
	}

	public boolean actionAPReserve(String[] reserve_info) {//Airplane Reserve �������� �װ���/�̸�/��ȭ��ȣ
		boolean success;
		isSelected = 2;//Print�Ҷ� �������� ����� �����߾�����
		success = apInfo.reserveAirplane(reserve_info);
		return success;
		
	}

	public void actionPrinter() {//������ ����
		String[] reserveInfo;//��������

		if(isSelected == 1){//ȣ�� ������ ���
			reserveInfo = hotelInfo.getReserveInfo();
			printer.insertReadyQueue(reserveInfo);
		}else if(isSelected == 2){//�װ��� ������ ���
			reserveInfo = apInfo.getReserveInfo();
			printer.insertReadyQueue(reserveInfo);
		}else System.out.println("������ ���� �����ϴ�.");
		
		
	}
}
