class Account {
    public int[] solution(String[] accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;

        for (String s : accounts) {
            // 규칙 유효성 확인
            if (!isValid(s))
                continue;
            // 정상 계좌번호, 계좌패턴 저장
            map.put(getBank(s), map.getOrDefault(getBank(s), 0) + 1);
            System.out.println(s);
        }

        int[] result = new int[map.size()];

        // 계좌패턴 값만 저장
        for (Integer val : map.values()) {
            result[index++] = val;
        }

        // 배열 정렬(오름차순)
        Arrays.sort(result);

        // 배열 정렬(내림차순)
        for (int i = 0; i < result.length / 2; i++) {
            int tmp = 0;

            tmp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = tmp;
        }

        return result;
    }

    private String getBank(String str) {
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split("-");

        for (String s : arr)
            sb.append(s.length() + "-");

        return sb.toString();
    }

    // 규칙 유효성 확인
    private boolean isValid(String str) {
        // 1번 규칙(숫자와 -로만 구성) 확인
        if (!str.matches("[0-9-]+"))
            return false;

        // 2번 규칙(숫자 11개 이상 14개 이하) 확인
        long cnt2 = str.chars().filter(c -> Character.isDigit(c)).count();
        if (cnt2 < 11 || cnt2 > 14)
            return false;

        // 3번 규칙(- 0개 이상 3개 이하) 확인
        long cnt3 = str.chars().filter(c -> c == '-').count();
        if (cnt3 < 0 || cnt3 > 3)
            return false;

        // 4번 규칙(- 연속 X / 처음이나 마지막 X) 확인
        if (str.contains("--") || str.startsWith("-") || str.endsWith("-"))
            return false;

        return true;
    }
}

public class MyClass {
    public static void main(String[] args) {
        Account e = new Account();
        // 1번 테스트케이스
        int[] result1 = e.solution(new String[] { "4514--234495-1", "305-44-291501", "1-2-34-495-8623", "492134545151",
                "623-421523-67-341", "-5439-59639921", "6235-7X3+47-7456", "98-76-543-210", "512-73-634901",
                "000-999999-22-555", "064-82-792561" });
        // 2번 테스트케이스
        int[] result2 = e.solution(new String[] { "1-2-3-456789012", "582845-385823", "48572-39485-89012",
                "4-5-2-593328484", "4958-39-2945123-", "49582039415423", "7-3-7-000000000", "485723-693812",
                "39482746582734", "1-1-1-111111111", "A4944-5095-4951", "4851293412223" });
        // 3번 테스트케이스
        int[] result3 = e.solution(new String[] { "592356=5345", "49-694-4495-64", "5923565345%" });

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }
}
