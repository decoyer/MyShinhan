// 클래스 생성하여 각종 연산 수행
class PhoneCharge {
	private String user;
	private int call;
	private int sms;
	private int data;
	private int total;

	public PhoneCharge(String user, int call, int sms, int data) {
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}

	public int calcCharge(int call, int sms, int data) {
		int callFee = 10;
		int smsFee = 20;
		int dataFee = 1000;

		if (call >= 200)
			callFee *= 2;
		if (sms >= 300)
			smsFee *= 4;
		if (data >= 7)
			dataFee *= 2;
		
		total = callFee * call + smsFee * sms + dataFee * data;

		return total;
	}

	public void printCharge() {
		System.out.printf("%s 사용자는 이번달에 사용하신 전화요금이 %d 원입니다.\n", user, calcCharge(call, sms, data));
	}
}

class Prob3 {
	public static void main(String args[]) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}
