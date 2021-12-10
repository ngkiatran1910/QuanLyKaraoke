/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeService {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object...args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = Utilities.jdbcUtilities.query(sql, args);
            while(rs.next()) {
                Object[] vals = new Object[cols.length];
                for(int i = 0; i< cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }   
    public List<Object[]> getHoaDonDaXuat() {
        String sql = "Exec SP_BANGHOADONDX ";
        String[] cols = {"MaHD", "MaP", "NgayXuatHD", "TongGio", "TienDV","TongTien"};
        return this.getListOfArray(sql, cols);
    } 
    public List<Object[]> getDV(int LHD) {
        String sql = "Exec SP_BANGTKDV ?";
        String[] cols = {"MaDV", "TenDV","KieuDVT","SoLanSD","TienDV"};
        return this.getListOfArray(sql, cols,LHD);
    }
}
