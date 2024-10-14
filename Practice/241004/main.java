class Member {
	int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] result = new int[2];

		for (int i = 0; i < periods.length; i++) {
            int paid = 0;
            for (int j = 0; j < payments[i].length; j++) {
                paid += payments[i][j];
            }

            if (check(paid, periods[i])) {
                paid = paid - payments[i][0] + estimates[i];
                if (!check(paid, periods[i] + 1))
                    result[1]++;
            }

            else {
                paid = paid - payments[i][0] + estimates[i];
                if (check(paid, periods[i] + 1))
                    result[0]++;
            }
        }

        return result;
    }

	private boolean check(int paid, int period) {
        if (period >= 60 && paid >= 600000)
                return true;
		
        else if (period >= 24 && paid >= 900000)
                return true;

        return false;
    }
}
