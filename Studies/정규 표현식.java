// [] : 선택
// () : 그룹
// - : 범위
// + : 1개 이상
// * : 0개 이상
// ? : 0, 1
// ^ : ~로 시작
// $ : ~로 끝
// . : 임의의 문자
// [0-9a-zA-Z] : \w
// [0-9] : \d
// [^]   : 제외
private static void m1() {
    String num = "010-1234-5678";
    String regExp1 = "([01]{3})-(\\d{3,4})-(\\d{4})";

    String email = "test1234@naver.com";
    String regExp2 = "(\\w+)@(\\w+\\.\\w+)";

    // 패턴 확인
    boolean result1 = Pattern.matches(regExp1, num);
    System.out.println(result1);
    boolean result2 = Pattern.matches(regExp2, email);
    System.out.println(result2);

    // 그룹 확인 시 컴파일 필수
    Pattern p1 = Pattern.compile(regExp1);
    Pattern p2 = Pattern.compile(regExp2);

    // 그룹 확인
    Matcher m1 = p1.matcher(num);
    Matcher m2 = p2.matcher(email);

    if (m1.find()) {
        System.out.println(m1.group(0));
        System.out.println(m1.group(1));
        System.out.println(m1.group(2));
        System.out.println(m1.group(3));
    }

    if (m2.find()) {
        System.out.println(m2.group(0));
        System.out.println(m2.group(1));
        System.out.println(m2.group(2));
    }
}
