// List 컬렉션
// 객체 저장 간 순서(index) 있음
// 객체 간 중복 허용
// ArrayList   : 배열 길이에 제한이 없는 배열
// Vector      : 멀티 스레드 지원 ArrayList
// LinkedList  : 인접 객체의 위치를 서로 연결

// Set 컬렉션
// 객체 저장 간 순서(index) 없음
// 객체 간 중복 불가
// HashSet     : 중복되는 객체 없이 저장, 값이 같으면 저장 X
// TreeSet     : 객체를 저장할 때 값을 비교하여 정렬(compare 함수 구현)

// Map 컬렉션
// 키(Set)와 값의 쌍으로 구성된 객체 저장
// 객체 간 중복 불가
// HashMap     : 중복되는 키 없이 저장, 키 값이 같으면 덮어씀
// Hashtable   : 멀티 스레드 지원 HashMap
// TreeMap     : 객체를 저장할 때 키를 기준으로 정렬

// Stack       : 후입선출 클래스
// Queue       : 선입선출 인터페이스

public static void main(String[] args) {
    // E : 객체 타입
    // K : 키 타입
    // V : 값 타입
    List<E> list1 = new ArrayList<>();
    List<E> list2 = new Vector<>();
    List<E> list3 = new LinkedList<>();
  
    Set<E> set1 = new HashSet<>();
    TreeSet<E> set2 = new TreeSet<>();
  
    Map<K, V> map1 = new HashMap<>();
    Map<K, V> map2 = new Hashtable<>();
    TreeMap<K, V> map3 = new TreeMap<>();

    Stack<E> stack = new Stack<>();

    Queue<E> queue = new LinkedList<>();
}
