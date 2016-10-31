package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Controller.Controller;

import java.util.Vector;

import Model.*;

public class FunctionInterface implements ActionListener {


	private JPanel change_pnl;
	private JFrame frame;
	private JButton Hotel_btn;
	private JButton Airplane_btn;
	private JPanel Hotel_pnl;
	private JPanel Airplane_pnl;
	private JLabel lblHotelPanel;
	private JLabel lblAirplane;
	private JPanel panel_2;
	private JButton Hotel_recommend_btn;
	private JButton Hotel_manage_btn;
	private JPanel Hotel_menu_pnl;
	private JButton Hotel_search_btn;
	private JButton Airplane_recommend_btn;
	private JButton Airplane_manage_btn;
	private JPanel Airplane_menu_pnl;
	private JButton Airplane_search_btn;
	private JButton Hotel_reserve_btn;
	private JButton Airplane_reserve_btn;
	private JTable table;
	private JScrollPane scroll;
	private JButton Confirm_btn;
	public String selectedHotel;

	public Controller controller;
	private JButton Print_btn;

	public FunctionInterface(Controller Controller) {
		Controller.actionHTMange();
		initialize();
		frame.setVisible(true);
		this.selectedHotel = "";
		this.controller = Controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 40, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Ȯ�ι�ư
		Confirm_btn = new JButton("Ȯ��");
		Confirm_btn.addActionListener(this);


		//���� ȣ��/�װ��� �ǳ�
		JPanel select_pnl = new JPanel();
		select_pnl.setBackground(new Color(128, 128, 128));
		select_pnl.setForeground(new Color(192, 192, 192));
		select_pnl.setBounds(0, 0, 143, 762);
		frame.getContentPane().add(select_pnl);
		select_pnl.setLayout(null);
		Hotel_btn = new JButton("Hotel");
		Hotel_btn.setForeground(Color.WHITE);
		Hotel_btn.setBackground(new Color(51, 102, 51));
		Hotel_btn.setFont(new Font("����", Font.PLAIN, 16));
		Hotel_btn.addActionListener(this);
		Hotel_btn.setBounds(12, 51, 119, 201);
		select_pnl.add(Hotel_btn);
		Airplane_btn = new JButton("Airplane");
		Airplane_btn.setForeground(Color.WHITE);
		Airplane_btn.setBackground(new Color(51, 102, 51));
		Airplane_btn.setFont(new Font("����", Font.PLAIN, 16));
		Airplane_btn.addActionListener(this);
		Airplane_btn.setBounds(12, 304, 119, 201);
		select_pnl.add(Airplane_btn);
		
		Print_btn = new JButton("Print");
		Print_btn.setForeground(Color.WHITE);
		Print_btn.setBackground(new Color(51, 102, 51));
		Print_btn.setFont(new Font("����", Font.PLAIN, 16));
		Print_btn.addActionListener(this);
		Print_btn.setBounds(12, 608, 119, 99);
		select_pnl.add(Print_btn);

		//ü���� �ǳ�
		change_pnl = new JPanel();
		change_pnl.setBounds(143, 0, 1041, 599);
		frame.getContentPane().add(change_pnl);
		change_pnl.setLayout(null);



		//�Ʒ��� ȣ�� �޴�
		Hotel_menu_pnl = new JPanel();
		Hotel_menu_pnl.setBackground(new Color(128, 128, 128));
		Hotel_menu_pnl.setBounds(143, 599, 1041, 163);
		Hotel_menu_pnl.setLayout(null);		
		Hotel_search_btn = new JButton("Search");
		Hotel_search_btn.setForeground(Color.WHITE);
		Hotel_search_btn.setBackground(new Color(51, 102, 51));
		Hotel_search_btn.setFont(new Font("����", Font.PLAIN, 16));
		Hotel_search_btn.addActionListener(this);
		Hotel_search_btn.setBounds(30, 30, 167, 93);
		Hotel_menu_pnl.add(Hotel_search_btn);		
		Hotel_recommend_btn = new JButton("Recommend");
		Hotel_recommend_btn.setForeground(Color.WHITE);
		Hotel_recommend_btn.setBackground(new Color(51, 102, 51));
		Hotel_recommend_btn.setFont(new Font("����", Font.PLAIN, 16));
		Hotel_recommend_btn.addActionListener(this);
		Hotel_recommend_btn.setBounds(278, 30, 167, 93);
		Hotel_menu_pnl.add(Hotel_recommend_btn);		
		Hotel_manage_btn = new JButton("Manage");
		Hotel_manage_btn.setForeground(Color.WHITE);
		Hotel_manage_btn.setBackground(new Color(51, 102, 51));
		Hotel_manage_btn.setFont(new Font("����", Font.PLAIN, 16));
		Hotel_manage_btn.addActionListener(this);
		Hotel_manage_btn.setBounds(774, 30, 167, 93);
		Hotel_menu_pnl.add(Hotel_manage_btn);
		Hotel_reserve_btn = new JButton("Reserve");
		Hotel_reserve_btn.setForeground(Color.WHITE);
		Hotel_reserve_btn.setBackground(new Color(51, 102, 51));
		Hotel_reserve_btn.setFont(new Font("����", Font.PLAIN, 16));
		Hotel_reserve_btn.addActionListener(this);
		Hotel_reserve_btn.setBounds(526, 30, 167, 93);
		Hotel_menu_pnl.add(Hotel_reserve_btn);

		//�Ʒ��� �װ��� �޴�
		Airplane_menu_pnl = new JPanel();
		Airplane_menu_pnl.setBackground(new Color(128, 128, 128));
		Airplane_menu_pnl.setBounds(143, 599, 1041, 163);
		Airplane_menu_pnl.setLayout(null);		
		Airplane_search_btn = new JButton("Search");
		Airplane_search_btn.setForeground(Color.WHITE);
		Airplane_search_btn.setBackground(new Color(51, 102, 51));
		Airplane_search_btn.setFont(new Font("����", Font.PLAIN, 16));
		Airplane_search_btn.addActionListener(this);
		Airplane_search_btn.setBounds(30, 30, 167, 93);
		Airplane_menu_pnl.add(Airplane_search_btn);		
		Airplane_recommend_btn = new JButton("Recommend");
		Airplane_recommend_btn.setForeground(Color.WHITE);
		Airplane_recommend_btn.setBackground(new Color(51, 102, 51));
		Airplane_recommend_btn.setFont(new Font("����", Font.PLAIN, 16));
		Airplane_recommend_btn.addActionListener(this);
		Airplane_recommend_btn.setBounds(278, 30, 167, 93);
		Airplane_menu_pnl.add(Airplane_recommend_btn);
		Airplane_reserve_btn = new JButton("Reserve");
		Airplane_reserve_btn.setForeground(Color.WHITE);
		Airplane_reserve_btn.setBackground(new Color(51, 102, 51));
		Airplane_reserve_btn.setFont(new Font("����", Font.PLAIN, 16));
		Airplane_reserve_btn.addActionListener(this);
		Airplane_reserve_btn.setBounds(526, 30, 167, 93);
		Airplane_menu_pnl.add(Airplane_reserve_btn);

		//ȣ�� �ǳ�
		Hotel_pnl = new JPanel();
		Hotel_pnl.setBounds(0, 0, 1041, 599);		
		Hotel_pnl.setLayout(null);

		//�װ��� �ǳ�
		Airplane_pnl = new JPanel();
		Airplane_pnl.setBounds(0, 0, 1041, 599);
		Airplane_pnl.setLayout(null);

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==Hotel_btn){
			change_pnl.removeAll();
			frame.remove(Airplane_menu_pnl);
			change_pnl.add(Hotel_pnl);
			frame.getContentPane().add(Hotel_menu_pnl);
			frame.revalidate();
			frame.repaint();
		}
		if(e.getSource()==Airplane_btn){
			change_pnl.removeAll();
			frame.remove(Hotel_menu_pnl);
			change_pnl.add(Airplane_pnl);
			frame.getContentPane().add(Airplane_menu_pnl);
			frame.revalidate();
			frame.repaint();
		}
		if(e.getSource()==Hotel_search_btn){
			Hotel_pnl.removeAll();
			controller.actionHTSearch();
			//			 Controller.actionHTSearch("a");
			frame.revalidate();
			frame.repaint();
		}
		if(e.getSource() == Airplane_search_btn){
			controller.actionAPSearch();
		}
		if(e.getSource()==Hotel_recommend_btn){
			Hotel_pnl.removeAll();
			controller.actionHTRecommend();
			//			 Controller.actionHTSearch("a");
			frame.revalidate();
			frame.repaint();
		}
		if(e.getSource() == Airplane_recommend_btn){
			controller.actionAPRecommend();
		}
		if(e.getSource()==Hotel_reserve_btn){
			controller.actionHTReserve();
		}
		if(e.getSource() == Airplane_reserve_btn){
			controller.actionAPReserve();
		}
		if(e.getSource()==Hotel_manage_btn){
			controller.actionHTMange();
			JOptionPane.showMessageDialog(Confirm_btn, "������ �Ϸ�Ǿ����ϴ�!");
		}
		if(e.getSource()==Confirm_btn){
			Hotel_pnl.removeAll();
			controller.actionHTSearch();
			frame.revalidate();
			frame.repaint();
		}
		if(e.getSource() == Print_btn){
			controller.actionPrinter();
		}

	}

	public void displayHotelList(Vector <Hotel> hotelList){
		this.Hotel_pnl.removeAll();
		int i=0;
		i = hotelList.size();
		String columnNames[] =
			{ "Name", "Location", "PhoneNumber", "Grade", "Distance" };
		Object rowData[][] = new Object[i][5];

		for(int j=0;j<i;j++){
			rowData[j][0] = hotelList.elementAt(j).getName();
			rowData[j][1] = hotelList.elementAt(j).getLocation();
			rowData[j][2] = hotelList.elementAt(j).getPhoneNumber();
			rowData[j][3] = hotelList.elementAt(j).getGrade();
			rowData[j][4] = hotelList.elementAt(j).getDistance();
		}

		//		Object rowData[][] =
		//			{
		//			{ hotelList.elementAt(0).getName(), hotelList.elementAt(0).getLocation(), hotelList.elementAt(0).getPhoneNumber(), hotelList.elementAt(0).getGrade(),hotelList.elementAt(0).getDistance()+"km" },
		//			{ hotelList.elementAt(1).getName(), hotelList.elementAt(1).getLocation(), hotelList.elementAt(1).getPhoneNumber(), hotelList.elementAt(1).getGrade(),hotelList.elementAt(1).getDistance()+"km" },
		//			{ hotelList.elementAt(2).getName(), hotelList.elementAt(2).getLocation(), hotelList.elementAt(2).getPhoneNumber(), hotelList.elementAt(2).getGrade(),hotelList.elementAt(2).getDistance()+"km" }};
		DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dm);	
		table.getColumn("Name").setCellRenderer(new ButtonRenderer());
		table.getColumn("Name").setCellEditor(new ButtonEditor(new JCheckBox(), controller));
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 1041, 599);
		this.Hotel_pnl.add(scroll);

	}

	public void displaySearchHTList(String[][] roomState){
		this.Hotel_pnl.removeAll();;
		String columnNames[] =
			{ "RoomNum", "State", "Clt_Name", "Clt_PH", "Grade", "Price" };

		Object rowData[][] = roomState;

		DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dm);	
		//		table.getColumn("Name").setCellRenderer(new ButtonRenderer());
		//	    table.getColumn("Name").setCellEditor(new ButtonEditor(new JCheckBox(), Controller));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 1041, 599);
		this.Hotel_pnl.add(scroll);

	}

	public void addHTRecommend(Vector <Hotel> recommendInfo){
		this.Hotel_pnl.removeAll();
		int i;
		i = recommendInfo.size();
		String columnNames[] =
			{ "Name", "Location", "PhoneNumber", "Grade", "Distance" };

		Object rowData[][] = new Object[i][5];

		for(int j=0;j<i;j++){
			rowData[j][0] = recommendInfo.elementAt(j).getName();
			rowData[j][1] = recommendInfo.elementAt(j).getLocation();
			rowData[j][2] = recommendInfo.elementAt(j).getPhoneNumber();
			rowData[j][3] = recommendInfo.elementAt(j).getGrade();
			rowData[j][4] = recommendInfo.elementAt(j).getDistance();
		}
		DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dm);	
		table.getColumn("Name").setCellRenderer(new ButtonRenderer());
		table.getColumn("Name").setCellEditor(new ButtonEditor(new JCheckBox(), controller));
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 1041, 599);
		this.Hotel_pnl.add(scroll);

	}

	public void displayInputPersonInfo() {
		String str;
		String[] arr;
		String[] reserve_info = new String[4];
		if(((String)table.getValueAt(table.getSelectedRow(), 1)).equals("empty")){
			str = JOptionPane.showInputDialog(null, "�̸�, ��ȭ��ȣ�� �Է����ּ���. (��. ��û��,01032204871)");
			if(str!= null){
				arr = str.split("\\,");
				reserve_info[0] = arr[0];
				reserve_info[1] = arr[1];
				reserve_info[2] = selectedHotel;
				reserve_info[3] = table.getValueAt(table.getSelectedRow(), 0).toString();

				if(controller.actionHTReserve(reserve_info)){//�迭 ���� �̸�/��ȣ/������ȣ��/�����ѹ�
					JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");
				}else JOptionPane.showMessageDialog(null, "���࿡ �����߽��ϴ�.");
			}
		}else JOptionPane.showMessageDialog(null, "�� ���� �������ּ���.");
	}

	public String displayInputGradeWindow() {
		String[] selection = {"First", "Business", "Economy"};
		return ((String)JOptionPane.showInputDialog(null, "�¼� ����� �����ϼ���.", "��� �Է�", JOptionPane.QUESTION_MESSAGE, null, selection, "Business"));
		
	}

	public String displayInputDestination() {
		String search_info;
		search_info = (String)JOptionPane.showInputDialog(null, "�������� �Է��ϼ���.");
		return search_info;
	}

	public void displaySearchAPList(String[][] airplaneList) {
		this.Airplane_pnl.removeAll();
		String columnNames[] =
			{ "AirplaneNumber", "Desination", "DepartTime", "ArriveTime", "Type" };
		Object rowData[][] = airplaneList;

		DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dm);	
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 1041, 599);
		this.Airplane_pnl.add(scroll);
	}

	public String[] displayPassengerInputWindow() {
		String str;
		String[] arr;
		str =JOptionPane.showInputDialog(null, "�������� ��߽ð��� �Է��ϼ���. (�� Hongkong,15:00");
		if(str != null){
			arr = str.split("\\,");
			return arr;
		}
		return null;
	}

	public void addAPRecommendInfo(String[][] recommendInfo) {
		this.Airplane_pnl.removeAll();
		String columnNames[] =
			{ "AirplaneNumber", "Desination", "DepartTime", "ArriveTime", "Type" };
		Object rowData[][] = recommendInfo;

		DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dm);	
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 1041, 599);
		this.Airplane_pnl.add(scroll);
		
	}

	public void displayAPInputPersonInfo() {
		String str;
		String[] reserve_info;
		boolean success;
		String[] selection = {"First", "Business", "Economy"};
		JOptionPane.showInputDialog(null, "�¼� ����� �����ϼ���.", "��� �Է�", JOptionPane.QUESTION_MESSAGE, null, selection, "Business");
		
		str =JOptionPane.showInputDialog(null, "�̸��� ��ȭ��ȣ�� �Է��ϼ���. (�� ��û��,01032204871");
		if(str!=null){
			reserve_info = str.split("\\,");
			success = controller.actionAPReserve(reserve_info);
			if(success){
				JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");
			}else JOptionPane.showMessageDialog(null, "���࿡ �����߽��ϴ�.");
		}
	}
}

class ButtonRenderer extends JButton implements TableCellRenderer {

	public ButtonRenderer() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText((value == null) ? "" : value.toString());
		return this;
	}
}


class ButtonEditor extends DefaultCellEditor {
	protected JButton button;

	private String label;
	private boolean isPushed;
	private Controller Controller;
	public ButtonEditor(JCheckBox checkBox,Controller Controller) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		this.Controller = Controller;
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) { //ȣ�� ��Ͽ��� ȣ���̸� ������ �׼� ������!
			// 
			// 
			//JOptionPane.showMessageDialog(button, label + ": Ouch!!!");
			Controller.actionHTSearch(label);
			// System.out.println(label + ": Ouch!");
		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}
