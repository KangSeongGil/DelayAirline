package SCS;
import java.sql.*;

public class AccessUserDB {
	private Connection con = null;
	
	public AccessUserDB(){
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("����̹� �˻� ����!");
		}
		String url = "jdbc:mysql://127.0.0.1:3306/scs";//"jdbc:mysql://127.0.0.1:3306/mysql57";
		String user = "root";
		String pass = "a789123";
		try{
			con = DriverManager.getConnection(url,user,pass);
		}catch(SQLException e){
			System.out.println("���� ����!");
		}
	}
	
	public boolean requestAuthority(String userID, char[] userPW){//�α����ؼ� ������ ����
		String PW = new String(userPW);
		try{
			java.sql.Statement stmt = this.con.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery("select * from userdb where ID ='"+userID+"' and PW = '"+PW+"'");//������
			rs.beforeFirst();
			if(rs.next()){//�ش��ϴ� ID/PW�� ������
				System.out.println("�α��ο� �����Ͽ����ϴ�.");
				return true;
			}else{
				System.out.println("�ش��ϴ� ID/PW�� �����ϴ�.");
				return false;
			}
		}catch(SQLException e){
			System.out.println("���� ����!");
			return false;
		}
	}
	
	
}
