package Services;

import IServices.IServiceThanhToan;
import Models.ThanhToan;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThanhToanService extends IServiceThanhToan<ThanhToan, String> {

    @Override
    public void them(ThanhToan model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sua(ThanhToan model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ThanhToan selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ThanhToan> selectAll() {
        String sql = "Select * from ThanhToan";
         return this.selectBySql(sql);

    }

    @Override
    protected List<ThanhToan> selectBySql(String sql, Object... args) {
        List<ThanhToan> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                ThanhToan model = new ThanhToan();
                model.setMaTT(rs.getInt("MaTT"));
                model.setTienTT(rs.getFloat("TienTT"));
                model.setTienNhan(rs.getFloat("TienNhan"));
                model.setTienDu(rs.getFloat("TienDu"));
                model.setHinhThucTT(rs.getString("HinhThucTT"));
                model.setTrangThai(rs.getInt("IDTTThanhToan"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
