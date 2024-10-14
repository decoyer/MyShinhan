// 금액 비교를 위한 클래스 생성
class Person implements Comparable<Person> {
    int bal;
    int idx;

    Person(int bal, int idx) {
        this.bal = bal;
        this.idx = idx;
    }

    @Override
    public int compareTo(Person p) {
        return bal != p.bal ? p.bal - bal : idx - p.idx;
    }
}

public class main {
    public static void main(String[] args) {
        // 1번 테스트케이스
        int[] arr1 = { 1000000, 490000, 700000, 290000 };
        // 2번 테스트케이스
        int[] arr2 = { 30000, 70000, 10000 };
        
        System.out.println(Arrays.toString(solution(4, arr1)));
        System.out.println(Arrays.toString(solution(6, arr2)));
    }

    public static int[] solution(int n, int[] amounts) {
        int m = amounts.length;
        int[] result = new int[n];
        Person[] p = new Person[m];

        for (int i = 0; i < m; i++) {
            p[i] = new Person(amounts[i], i);
        }

        // 배열 정렬 및 자본 순서대로 낙찰 후 변동금액 저장
        for (int i = 0; i < n; i++) {
            Arrays.sort(p);
            if (p[1].bal == 0) {
                result[i] = p[0].bal;
                p[0].bal = 0;
            } else if (p[0].bal == p[1].bal) {
                result[i] = p[0].bal;
                p[0].bal = 0;
            } else {
                result[i] = p[1].bal + 10000;
                p[0].bal -= p[1].bal + 10000;
            }
        }

        return result;
    }
}
