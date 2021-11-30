package Services;

import Models.LoaiDichVu;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class LoaiDichVuService extends IServices.IServiceLoaiDichVu<LoaiDichVu, String> {

    @Override
    protected List selectBySql(String sql, Object... args) {
        List<LoaiDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                LoaiDichVu model = new LoaiDichVu();
                model.setMaLDV(rs.getInt("MaLDV"));
                model.setTenLDV(rs.getString("TenLDV"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void them(LoaiDichVu model) {
        String sql = "INSERT INTO LoaiDichVu (TenLDV) VALUES (?)";
        jdbcUtilities.update(sql,model.getTenLDV());
    }

    @Override
    public void sua(LoaiDichVu model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoaiDichVu selectByID(String key) {
        String sql = "SELECT * FROM LoaiDichVu WHERE MaLDV = ?";
        List<LoaiDichVu> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiDichVu> selectAll() {
        String sql = "SELECT * FROM LoaiDichVu";
        return selectBySql(sql);
    }

    public LoaiDichVu selectByMaLDV(int key) {
        String sql = "SELECT * FROM LoaiDichVu WHERE MaLDV = ?";
        List<LoaiDichVu> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

}
