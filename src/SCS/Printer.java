package SCS;

public class Printer implements IPrinter{
	private String[] reserveInfo;//String 0�� ����̸� 1�� ��ȣ 2�� ȣ���̸� 3�� ���ȣ

	public boolean insertReadyQueue(String[] reserveInfo){
		this.reserveInfo = reserveInfo;
		print();
		return true;
	}
	@Override
	public boolean print() {
		System.out.println("������ �� : "+reserveInfo[0]);
		System.out.println("������ ��ȣ : "+reserveInfo[1]);
		System.out.println("���� ���� : "+reserveInfo[2]);
		System.out.println("���� ���γ��� : "+reserveInfo[3]);
		return true;
	}

}
