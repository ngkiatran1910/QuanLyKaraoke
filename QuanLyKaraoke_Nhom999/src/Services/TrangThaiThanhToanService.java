package Services;

import IServices.IServiceTrangThaiThanhToan;
import Models.TrangThaiThanhToan;
import Utilities.jdbcUtilities;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TrangThaiThanhToanService extends IServiceTrangThaiThanhToan<TrangThaiThanhToan, String> {

    @Override
    public void them(TrangThaiThanhToan model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sua(TrangThaiThanhToan model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TrangThaiThanhToan selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrangThaiThanhToan> selectAll() {
        String sql = "Select * from TrangThaiThanhToan";
        return this.selectBySql(sql);
    }

    @Override
    protected List<TrangThaiThanhToan> selectBySql(String sql, Object... args) {
        List<TrangThaiThanhToan> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                TrangThaiThanhToan model = new TrangThaiThanhToan();
                model.setIDTTThanhToan(rs.getInt("IDTTThanhToan"));
                model.setTenTrangThai(rs.getString("TenTrangThai"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
