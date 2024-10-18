public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		String maxName = "";
        int maxScore = -1;

        for (String s : array) {
            int idx = s.length() - 2;

            while (Character.isDigit(s.charAt(idx - 1)))
                idx--;
			
            String name = s.substring(0, idx);
            int score = Integer.parseInt(s.substring(idx, s.length() - 1));

            if (score > maxScore) {
                maxScore = score;
                maxName = name;
            }
        }

        System.out.printf("최고점수는 %s님 %d점 입니다.", maxName, maxScore);
	}
}