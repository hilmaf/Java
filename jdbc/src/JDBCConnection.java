import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

    public static PreparedStatement preparedStatement;
    public static Connection conn;
    public static ResultSet rs;
    public static JDBCTemplate jdbcTemplate = new JDBCTemplate();

    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            conn = JDBCTemplate.getConnection();
            String SQLCode = br.readLine();

            if (SQLCode.equals("SELECT")) {
                System.out.println("<< SELECT >>");

                String sql = "SELECT * FROM ---";
                preparedStatement = conn.prepareStatement(sql);

                rs = preparedStatement.executeQuery();

                int cnt = 0;
                while (rs.next()) {
                    String callKey = rs.getString("callkey");
                    String cbDate = rs.getString("cb_date");
                    String ani = rs.getString("ani");
                    String cbNumber = rs.getString("cb_number");

                    StringBuilder sb = new StringBuilder();
                    sb.append("[callKey : ").append(callKey).append(" cb_date : ").append(cbDate).append(" ani : ").append(ani).append(" cb_number : ").append(cbNumber).append(" ]");

                    System.out.println(sb.toString());
                    cnt++;
                }

            } else if (SQLCode.equals("PROCEDURE")) {
                // execute() : 여러 개의 결과 반환할 때 사용, boolean 값 반환, 결과가 ResultSet이면 true, 아니면 false, getMoreResults()를 사용하여 추가 결과 처리 가능
                System.out.println("<< PROCEDURE >>");
                System.out.println("어떤 프로시저를 실행할 지 입력하기");
                System.out.print(">> ");

                String str = br.readLine();
                if (str.equals("insert")) {
                    String insertProcedure = "DECLARE @m1 VARCHAR(50), @m2 VARCHAR(50), @ph	VARCHAR(50)"
                    + "SET @m1 = ?;"
                    + "SET @m2 = ?;"
                    + "SET @ph = ?;"
                    + "EXEC InsertCallback @m1, @m2, @ph;";

                    preparedStatement = conn.prepareStatement(insertProcedure);
                    preparedStatement.setString(1, "11111111111");
                    preparedStatement.setString(2, "01000000000");
                    preparedStatement.setString(3, "01000000000");

                    int result = preparedStatement.executeUpdate();
                    System.out.println("result :: " + result);

                    if (result == 1) {
                        jdbcTemplate.commit(conn);
                    } else {
                        jdbcTemplate.rollback(conn);
                    }

                } else {
                    String selectProcedure = "EXEC SelectCallback;";
                    preparedStatement = conn.prepareStatement(selectProcedure);
                    rs = preparedStatement.executeQuery();
                    int cnt = 0;
                    while (rs.next()) {
                        String callKey = rs.getString("callkey");
                        String cbDate = rs.getString("cb_date");
                        String ani = rs.getString("ani");
                        String cbNumber = rs.getString("cb_number");

                        StringBuilder sb = new StringBuilder();
                        sb.append("[callKey : ").append(callKey).append(" cb_date : ").append(cbDate).append(" ani : ").append(ani).append(" cb_number : ").append(cbNumber).append(" ]");

                        System.out.println(sb.toString());
                        cnt++;
                    }

                    System.out.println("cnt = " + cnt);
                }

            } else {
                System.out.println("<< DML >>");

                String sql = "INSERT INTO ---(callkey, cb_date, ani, cb_number) VALUES(?, convert(CHAR(19), getdate(), 120), ?, ?);";

                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, "22222222222");
                preparedStatement.setString(2, "01000000000");
                preparedStatement.setString(3, "01000000000");

                int rowsUpdated = preparedStatement.executeUpdate();
                System.out.println("rowsUpdated :: " + rowsUpdated);

                if (rowsUpdated == 1) {
                    jdbcTemplate.commit(conn);
                } else {
                    jdbcTemplate.rollback(conn);
                }
            }

        } catch (IOException ioException) {
            System.out.println("::: IOException Occurred :::");
            ioException.printStackTrace();
        } catch (SQLException sqlException) {
            System.out.println("::: SQLException Occurred :::");
            sqlException.printStackTrace();
            jdbcTemplate.rollback(conn);
        } finally {
            jdbcTemplate.close(rs);
            jdbcTemplate.close(preparedStatement);
            jdbcTemplate.close(conn);
        }

    }
}