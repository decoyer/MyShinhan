	public static void main(String[] args) {
		// 1번 테케
		int[] tc1 = new int[] { 10000, -13000, -4000, -2000, 6500, -20000 };
		// 2번 테케
		int[] tc2 = new int[] { -34152, -40000, -50000 };

		System.out.println(p1(tc1, 5000));
		System.out.println(p1(tc2, 34151));
	}

	private static int p1(int[] ledger, int m) {
		int amount = 0;				// 잔고액 변수

		for (int i : ledger) {
			if (amount + i < -m)	// 한도액 > 출금액 확인
				i = 0;				// 요청 거절
			amount += i;			// 잔고액 계산
		}

		return amount;
	}
