package sql;

public class Service {
    static DAO dao = new DAO();

    public static void selectAll() {
        dao.selectAll();
    }

    public static void selectSearch(int[] arr) {
        dao.selectSearch(arr);
    }

    public static int selectRandom() {
        return dao.selectRandom();
    }

    public static DTO selectById(int id) {
        return dao.selectById(id);
    }

    public static int insertService(DTO dto) {
        return dao.insert(dto);
    }

    public static int updateService(DTO dto) {
        return dao.update(dto);
    }

    public static int deleteService(String s) {
        return dao.delete(s);
    }
}