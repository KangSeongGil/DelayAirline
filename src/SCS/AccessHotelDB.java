package SCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessHotelDB {
	private Connection con = null;
	
	
	public AccessHotelDB(){
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("����̹� �˻� ����!");
		}
		String url = "jdbc:mysql://127.0.0.1:3306/hoteldb";//"jdbc:mysql://127.0.0.1:3306/mysql57";
		String user = "root";
		String pass = "a789123";
		try{
			con = DriverManager.getConnection(url,user,pass);
		}catch(SQLException e){
			System.out.println("���� ����!");
		}
	}
	
	public String[][] getRoomInfo(String hotelName){//hotelName�� DB�� ������ ���� ������ �޾ƿ�
		String[][] roomState;
		try{
			java.sql.Statement stmt = this.con.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery("select * from currentroom_"+hotelName);//�ش� ȣ���� ������ �޾ƿ�
			rs.last();
			roomState =new String[rs.getRow()][6];
			rs = stmt.executeQuery("select RoomNum, State, Clt_name, Clt_PH, Grade, Price from currentroom_"+hotelName);
			rs.beforeFirst();
			
			int i=0;
			while(rs.next()){//�ϳ��ϳ� ����
				roomState[i][0] = rs.getString("RoomNum");
				roomState[i][1] = rs.getString("State");
				roomState[i][2] = rs.getString("Clt_name");
				roomState[i][3] = rs.getString("Clt_PH");
				roomState[i][4] = rs.getString("Grade");
				roomState[i][5] = rs.getString("Price");
				i++;
			}
			return roomState;
		}catch(SQLException e){
			System.out.println("���� ����!");
			return null;
		}
	}
	
	public String[][] checkNewHotel(){//ȣ�� ����Ʈ�� ���� ���� ������Ʈ
		String[][] HotelList;
		try{
			java.sql.Statement stmt = this.con.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery("select * from hotel_list");
			rs.last();
			HotelList =new String[rs.getRow()][6];
			rs = stmt.executeQuery("select Name, Location, PhoneNumber, Distance, Grade, Flag from hotel_list");
			rs.beforeFirst();
			
			int i=0;
			while(rs.next()){
				HotelList[i][0] = rs.getString("Name");
				HotelList[i][1] = rs.getString("Location");
				HotelList[i][2] = rs.getString("PhoneNumber");
				HotelList[i][3] = rs.getString("Distance");
				HotelList[i][4] = rs.getString("Grade");
				HotelList[i][5] = rs.getString("Flag");
				i++;
			}
			return HotelList;
		}catch(SQLException e){
			System.out.println("���� ����!");
			return null;
		}
	}

	public boolean reserveHotel(String[] reserve_info) {//�迭 ���� �̸�/��ȣ/������ȣ��/�����ѹ�
		String State;
		try{
			java.sql.Statement stmt = this.con.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery("select * from currentroom_"+reserve_info[2]+" where RoomNum = '"+reserve_info[3]+"'");//��������
			rs.next();
			if(rs.getString("State").equals("empty")){//������� Ȯ��
				//�� ����
				stmt.executeUpdate("update currentroom_"+reserve_info[2]+" set State='reserved', Clt_name ='"+reserve_info[0]+"', Clt_PH = '"+reserve_info[1]+"' where RoomNum = '"+reserve_info[3]+"'");
				return true;
			}else return false;
			
		}catch(SQLException e){
			System.out.println("���� ����!");
			return false;
		}
	}

}
