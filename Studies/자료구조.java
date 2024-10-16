// List 컬렉션
// 객체 저장 간 순서 유지
// ArrayList   : 배열 길이에 제한이 없는 배열
// Vector      : 멀티 스레드 지원 ArrayList
// LinkedList  : 인접 객체의 위치를 서로 연결

// Set 컬렉션
// 객체 저장 간 순서 유지 X
// HashSet     : 중복되는 객체 없이 저장(집합)
// TreeSet     : 객체를 저장할 때 값을 기준으로 정렬

// Map 컬렉션
// 키와 값으로 구성된 객체 저장
// HashMap     : 중복되는 키 없이 저장
// Hashtable   : 멀티 스레드 지원 HashMap
// TreeMap     : 객체를 저장할 때 키를 기준으로 정렬

private static void f() {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new Vector<>();
    List<Integer> l3 = new LinkedList<>();

    // add() get() contains() size() isEmpty()
  
    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new TreeSet<>();

    // add() contains() size() isEmpty()
  
    Map<Integer, String> m1 = new HashMap<>();
    Map<Integer, String> m2 = new Hashtable<>();
    Map<Integer, String> m3 = new TreeMap<>();

    // put() get() size() isEmpty()
}
