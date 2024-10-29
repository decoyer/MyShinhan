package sql;

public class Viewer {
    public static void display() {
        System.out.println();
        System.out.println("[조회 결과]");
        System.out.println();
    }

    public static void display(DTO dto) {
        System.out.println();
        System.out.println("[조회 결과]");
        System.out.println(dto == null ? "실패" : dto.getName() + " (" + dto.getClassString() + ")");
        System.out.println();
    }

    public static void display(String msg) {
        System.out.println();
        System.out.println("[알림] " + msg);
        System.out.println();
    }
}