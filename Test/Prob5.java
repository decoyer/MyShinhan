public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		// 배열 요소 값의 개수 체크하여 배열에 저장
		for (int i : answer) {
			switch (i) {
				case 1 -> counter[0]++;
				case 2 -> counter[1]++;
				case 3 -> counter[2]++;
				case 4 -> counter[3]++;
			}
		}

		for (int i = 0; i < counter.length; i++)
			System.out.printf("%d의 개수는 %d개 입니다.\n", i + 1, counter[i]);
	}
}
