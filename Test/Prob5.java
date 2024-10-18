public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		for (int i : answer) {
			switch (i) {
				case 1:
					counter[0]++;
					break;
				case 2:
					counter[1]++;
					break;
				case 3:
					counter[2]++;
					break;
				case 4:
					counter[3]++;
					break;
			}
		}

		for (int i = 0; i < counter.length; i++)
			System.out.printf("%d의 개수는 %d개 입니다.\n", i + 1, counter[i]);
	}
}