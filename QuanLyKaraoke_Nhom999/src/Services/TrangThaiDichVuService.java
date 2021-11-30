
package Services;

import Models.TrangThaiDichVu;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class TrangThaiDichVuService extends IServices.IServiceTrangThaiDichVu<TrangThaiDichVu,String> {

    @Override
    public void them(TrangThaiDichVu model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sua(TrangThaiDichVu model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TrangThaiDichVu selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrangThaiDichVu> selectAll() {
        String sql = "SELECT * FROM TrangThaiDichVu";
        return this.selectBySql(sql);
    }

    @Override
    protected List<TrangThaiDichVu> selectBySql(String sql, Object... args) {
        List<TrangThaiDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                TrangThaiDichVu model = new TrangThaiDichVu();
                model.setIDTTDichVu(rs.getInt("IDTTDichVu"));
                model.setTenTrangThai(rs.getString("TenTrangThai"));                
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public TrangThaiDichVu selectByIDTTDichVu(int key) {
        String sql = "SELECT * FROM TrangThaiDichVu WHERE IDTTDichVu = ?";
        List<TrangThaiDichVu> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
}
