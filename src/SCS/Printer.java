package SCS;

public class Printer implements IPrinter{
	private String[] reserveInfo;//String 0번 사람이름 1번 번호 2번 호텔이름 3번 방번호

	public boolean insertReadyQueue(String[] reserveInfo){
		this.reserveInfo = reserveInfo;
		print();
		return true;
	}
	@Override
	public boolean print() {
		System.out.println("예약자 명 : "+reserveInfo[0]);
		System.out.println("예약자 번호 : "+reserveInfo[1]);
		System.out.println("예약 내용 : "+reserveInfo[2]);
		System.out.println("예약 세부내용 : "+reserveInfo[3]);
		return true;
	}

}
