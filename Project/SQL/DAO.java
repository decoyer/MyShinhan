package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class DAO {
    public static DTO make(ResultSet rs) throws SQLException {
        DTO dto = new DTO();

        dto.setId(rs.getInt("식별번호"));
        dto.setName(rs.getString("식당 이름"));
        dto.setClassInt(rs.getInt("분류"));
        dto.setTime(rs.getInt("도보시간 (분)"));

        return dto;
    }

    public static DTO make2(ResultSet rs) throws SQLException {
        DTO dto = new DTO();

        dto.setId(rs.getInt("식별번호"));
        dto.setName(rs.getString("식당 이름"));
        dto.setClassString(rs.getString("분류"));

        return dto;
    }

    public static DTO make3(ResultSet rs) throws SQLException {
        DTO dto = new DTO();

        dto.setName(rs.getString("식당 이름"));
        dto.setMenu(rs.getString("메뉴"));
        dto.setPrice(rs.getInt("가격"));
        dto.setTime(rs.getInt("도보시간 (분)"));

        return dto;
    }

    public void init() {
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;

        String sql = """
                DECLARE
                    max_id NUMBER;
                BEGIN
                    SELECT NVL(MAX("식별번호"), 0) INTO max_id FROM RES_INFO;
                
                    BEGIN
                        EXECUTE IMMEDIATE 'DROP SEQUENCE id_seq';
                    EXCEPTION
                        WHEN OTHERS THEN
                            IF SQLCODE != -2289 THEN
                                RAISE;
                            END IF;
                    END;

                    EXECUTE IMMEDIATE 'CREATE SEQUENCE id_seq
                                        START WITH ' || (max_id + 1) || '
                                        INCREMENT BY 1
                                        NOCACHE';
                END;
                """;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, rs);
        }
    }

    public int selectRandom() {
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM RES_INFO";

        int result = 0;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
                result++;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, rs);
        }

        return result;
    }

    public void selectSearch(int[] arr) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = """
                SELECT *
                FROM RES_INFO JOIN RES_MENU ON(RES_INFO."식별번호" = RES_MENU."식별번호")
                WHERE "분류"=?
                AND RES_MENU."가격"<=?
                AND "도보시간 (분)"<=?
                """;

        int category = arr[0];
        int price = arr[1];
        int time = arr[2];

        List<DTO> list = new ArrayList<DTO>();

        StringBuilder sb = new StringBuilder();

        try {
            st = conn.prepareStatement(sql);

            st.setInt(1, category);
            st.setInt(2, price);
            st.setInt(3, time);

            rs = st.executeQuery();
            while (rs.next()) {
                DTO dto = DAO.make3(rs);
                list.add(dto);
            }

            if (list.size() == 0)
                sb.append("조회 결과 없음");

            else {
                sb.append("[ 식당 이름 - 메뉴 - 가격 - 예상 소요시간 ]\n");
                sb.append("=============================================\n");

                for (int i = 0; i < list.size(); i++)
                    sb.append(list.get(i).getName()).append(" - ").append(list.get(i).getMenu()).append(" - ")
                            .append(list.get(i).getPrice()).append("원 - ").append(list.get(i).getTime()).append("분 \n");
            }

            System.out.println(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, rs);
        }
    }

    public void selectAll() {
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;

        String sql = """
                SELECT RES_INFO."식별번호", "식당 이름", RES_CLASS."분류"
                FROM RES_INFO INNER JOIN RES_CLASS ON(RES_INFO."분류" = RES_CLASS."식별번호")
                ORDER BY 1
                """;
        List<DTO> list = new ArrayList<DTO>();

        StringBuilder sb = new StringBuilder();

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DTO dto = DAO.make2(rs);
                list.add(dto);
            }

            for (int i = 0; i < list.size(); i++)
                sb.append(list.get(i).getId()).append(". ").append(list.get(i).getName()).append(" (")
                        .append(list.get(i).getClassString()).append(")\n");

            System.out.println(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, rs);
        }
    }

    public DTO selectById(int id) {
        Connection conn = DBUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        DTO dto = null;

        String sql = """
                SELECT RES_INFO."식별번호", "식당 이름", RES_CLASS."분류"
                FROM RES_INFO INNER JOIN RES_CLASS ON(RES_INFO."분류" = RES_CLASS."식별번호")
                WHERE RES_INFO."식별번호"=
                """
                + id;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
                dto = make2(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, rs);
        }

        return dto;
    }

    public int insert(DTO dto) {
        int result = 0;
        String sql = "INSERT INTO RES_INFO VALUES(id_seq.nextval, ?, ?, ?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;

        try {
            init();
            st = conn.prepareStatement(sql);

            st.setString(1, dto.getName());
            st.setInt(2, dto.getClassInt());
            st.setInt(3, dto.getTime());

            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, null);
        }

        return result;
    }

    public int update(DTO dto) {
        int result = 0;
        String sql = """
                UPDATE RES_INFO SET
                "식당 이름"=?,
                "분류"=?,
                "도보시간 (분)"=?
                WHERE "식당 이름"=?
                """;
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, dto.getName());
            st.setInt(2, dto.getClassInt());
            st.setInt(3, dto.getTime());
            st.setString(4, dto.getName());

            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, null);
        }

        return result;
    }

    public int delete(String s) {
        int result = 0;
        String sql = """
                DELETE FROM RES_INFO WHERE "식당 이름"=?
                """;
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        try {
            init();
            conn.setAutoCommit(false);

            st = conn.prepareStatement(sql);
            st.setString(1, s);

            result = st.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, st, null);
        }

        return result;
    }
}