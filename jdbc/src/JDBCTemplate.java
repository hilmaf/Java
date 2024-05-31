import java.sql.*;

public class JDBCTemplate {

    // getConnection
    public static Connection getConnection() throws SQLException {

        String url = "";
        String username = "";
        String pwd = "";

        Connection conn = DriverManager.getConnection(url, username, pwd);
        conn.setAutoCommit(false);

        return conn;

    }

    // commit
    public static void commit(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.commit();
            }
        } catch (SQLException e) {
            //TODO : Exception Handling
        }
    }

    // rollback
    public static void rollback(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } catch (SQLException e) {
            //TODO : Exception Handling
        }
    }

    // close(conn)
    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            // TODO : Exception Handling
        }
    }

    // close(stmt)
    public static void close(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            // TODO : Exception Handling
        }
    }


    // close(prepStmt)
    public static void close(PreparedStatement prepStmt) {
        try {
            if (prepStmt != null && !prepStmt.isClosed()) {
                prepStmt.close();
            }
        } catch (SQLException e) {
            // TODO : Exception Handling
        }
    }

    // close(rs)
    public static void close(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO : Exception Handling
        }
    }


}
