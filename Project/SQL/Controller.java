package sql;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
 
public class Controller {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        boolean isStop = false;
        while (!isStop) {
            mmenu();

            int select = sc.nextInt();

            switch (select) {
                case 1 -> f_random();
                case 2 -> f_search();
                case 3 -> {
                    boolean prev = false;

                    while (!prev) {
                        smenu();

                        select = sc.nextInt();

                        switch (select) {
                            case 1 -> f_selectAll();
                            case 2 -> f_selectById();
                            case 3 -> f_insert();
                            case 4 -> f_update();
                            case 5 -> f_delete();
                            case 0 -> {
                                System.out.println();
                                prev = true;
                            }
                            default -> System.out.println("잘못된 입력입니다.");
                        }
                    }
                }
                case 0 -> {
                    System.out.println();
                    isStop = true;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }

    private static void f_random() {
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());

        DTO dto = Service.selectById(r.nextInt(Service.selectRandom()) + 1);
        Viewer.display(dto);
    }

    private static void f_search() {
        int[] arr = new int[3];

        System.out.print("카테고리 선택(1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 기타) >> ");
        arr[0] = sc.nextInt();
        System.out.print("최대 금액 >> ");
        arr[1] = sc.nextInt();
        System.out.print("최대 시간(분) >> ");
        arr[2] = sc.nextInt();

        Viewer.display();
        Service.selectSearch(arr);
    }

    private static void f_selectAll() {
        Viewer.display();
        Service.selectAll();
    }

    private static void f_selectById() {
        System.out.print("식별번호 입력 >> ");
        int id = sc.nextInt();

        DTO dto = Service.selectById(id);
        Viewer.display(dto);
    }

    private static void f_insert() {
        int result = Service.insertService(f_make());
        if (result == 0)
            Viewer.display("입력 실패");
        else
            Viewer.display(result + "건 입력 완료");
    }

    private static void f_update() {
        int result = Service.updateService(f_make());
        if (result == 0)
            Viewer.display("수정 실패");
        else
            Viewer.display(result + "건 수정 완료");
    }

    private static void f_delete() {
        System.out.print("식당 이름 >> ");
        String s = sc.next();

        int result = Service.deleteService(s);
        if (result == 0)
            Viewer.display("삭제 실패");
        else
            Viewer.display(result + "건 삭제 완료");
    }

    private static DTO f_make() {
        System.out.print("식당 이름 >> ");
        String name = sc.next();

        System.out.print("카테고리 선택(1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 기타) >> ");
        int classInt = sc.nextInt();

        System.out.print("도보시간 (분) >> ");
        int time = sc.nextInt();

        DTO dto = new DTO();

        dto.setName(name);
        dto.setClassInt(classInt);
        dto.setTime(time);

        return dto;
    }

    private static void mmenu() {
        System.out.println("--------------------- Main ---------------------");
        System.out.println("1. 오늘은 뭐 먹지? 2. 상세 검색 3. CRUD 0. 종료");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.print("작업 선택 >> ");
    }

    private static void smenu() {
        System.out.println("------------------------- CRUD -------------------------");
        System.out.println("1. 전체 조회 2. 검색 3. 입력 4. 수정 5. 삭제 0. 돌아가기");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.print("작업 선택 >> ");
    }
}
