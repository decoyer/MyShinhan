public static void main(String[] args) {
	int[] tickets = { 10, 8, 20000 };
	int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } },
						  { { 1, 9 }, { 3, 6 }, { 2, 5 } },
						  { { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };

	for (int test = 0; test < tickets.length; test++) {
		System.out.println("\n----- " + (test + 1) + "번 테스트케이스 -----");
		System.out.println(solution(tickets[test], requests[test]));

		for (int[] arr : requests[test]) {
			System.out.println(Arrays.toString(arr));
		}
	}
}

private static int solution(int tickets, int[][] requests) {
	int sold = 0, grade = 1;

	// 회원 등급 증가
	while (grade <= 10) {
		// 배열 순회
		for (int i = 0; i < requests.length; i++) {
			// 낮은 등급부터 티켓 개수 확인 후 판매 가능 시 카운트
			if (grade == requests[i][0] && tickets >= requests[i][1]) {
				tickets -= requests[i][1];	// 보유 티켓 변수
				sold += requests[i][1];		// 판매 티켓 변수
			}
		}
        grade++;
	}

	return sold;
}
