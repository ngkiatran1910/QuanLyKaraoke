package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtilities {

    static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYKARAOKE";
    static String username = "sa";
    static String password = "123";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static PreparedStatement getStmt(String sql, Object...args) throws SQLException {
        Connection con=DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstmt=null;
        if(sql.startsWith("{")){
            pstmt=con.prepareCall(sql);
        }    
        else {
            pstmt=con.prepareStatement(sql);
        }
        for(int i=0; i<args.length;i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    
    public static ResultSet query(String sql, Object...args) throws SQLException{
        PreparedStatement pstm = jdbcUtilities.getStmt(sql, args);
        return pstm.executeQuery();
    }
    
    public static Object value(String sql, Object...args) {
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            if(rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static int update(String sql, Object...args) {
        try {
            PreparedStatement pstm = jdbcUtilities.getStmt(sql, args);
            try {
                return pstm.executeUpdate();
            }
            finally {
                pstm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
