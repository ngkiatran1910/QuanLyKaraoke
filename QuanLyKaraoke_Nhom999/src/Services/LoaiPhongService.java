package Services;

import Models.LoaiPhong;
import Models.Phong;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoaiPhongService extends IServices.IServiceLoaiPhong<LoaiPhong, String> {

    @Override
    public void them(LoaiPhong model) {
        String sql = "INSERT INTO LoaiPhong (TenLoaiP, GiaTheoGio) VALUES (?,?)";
        jdbcUtilities.update(sql,
                model.getTenLP(), model.getGiaTheoGio());
    }

    @Override
    public void sua(LoaiPhong model) {
        String sql = "UPDATE LoaiPhong SET TenLoaiP=?, GiaTheoGio=? WHERE MaLP=?";
        jdbcUtilities.update(sql, model.getTenLP(),
                model.getGiaTheoGio(), model.getMaLP());
    }

    @Override
    public LoaiPhong selectByID(String key) {
        String sql = "SELECT * FROM LoaiPhong Where MaLP = ?";
        List<LoaiPhong> list = this.selectBySql(sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiPhong> selectAll() {
        String sql = "SELECT * FROM LoaiPhong";
        return this.selectBySql(sql);
    }

    @Override
    protected List<LoaiPhong> selectBySql(String sql, Object... args) {
        List<LoaiPhong> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                LoaiPhong model = new LoaiPhong();
                model.setMaLP(rs.getString("MaLP"));
                model.setTenLP(rs.getString("TenLoaiP"));
                model.setGiaTheoGio(rs.getFloat("GiaTheoGio"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
