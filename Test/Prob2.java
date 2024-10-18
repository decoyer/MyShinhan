class IllegalSizeException extends Exception {
    public IllegalSizeException(String message) {
        super(message);
    }
}

public class Prob2 {
	public static void main(String[] args) throws IllegalSizeException {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));
	}

	public static String leftPad(String str, int size, char fillChar) throws IllegalSizeException {
		StringBuilder sb = new StringBuilder();

		if(size < str.length()) {
			throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
		}

		for (int i = 0; i < 10 - str.length(); i++) {
			sb.append(fillChar);
		}

		sb.append(str);

		return sb.toString();
	}
}
