class Member {
    int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] result = new int[2];

        for (int i = 0; i < periods.length; i++) {
            int paid = 0;
            // 납부 금액 저장
            for (int j = 0; j < payments[i].length; j++) {
                paid += payments[i][j];
            }

            // 이번달 기준 VIP 확인
            if (check(paid, periods[i])) {
                paid = paid - payments[i][0] + estimates[i];
                if (!check(paid, periods[i] + 1))
                    result[1]++;
            }

            // 다음달 기준 VIP 확인
            else {
                paid = paid - payments[i][0] + estimates[i];
                if (check(paid, periods[i] + 1))
                    result[0]++;
            }
        }

        return result;
    }

    // VIP 조건
    private boolean check(int paid, int period) {
        // 5년 가입 시 60만원 납부 필요
        if (period >= 60 && paid >= 600000)
            return true;

        // 2년 가입 시 90만원 납부 필요
        else if (period >= 24 && paid >= 900000)
            return true;

        return false;
    }
}
