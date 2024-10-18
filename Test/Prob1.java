public class Prob1 {
    public static void main(String[] args) {
        String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
        printMaxScore(array);
    }

    private static void printMaxScore(String[] array) {
        String maxName = "";
        int maxScore = -1;

        for (String s : array) {
	    // 문자열 끝의 불필요한 요소 제외
            int idx = s.length() - 2;

	    // 문자 숫자 분리하기 위해 기준점 설정
            while (Character.isDigit(s.charAt(idx - 1)))
                idx--;

	    // 문자 숫자 분리
            String name = s.substring(0, idx);
            int score = Integer.parseInt(s.substring(idx, s.length() - 1));

	    // 최고점수 탐색
            if (score > maxScore) {
                maxScore = score;
                maxName = name;
            }
        }

        System.out.printf("최고점수는 %s님 %d점 입니다.", maxName, maxScore);
    }
}
