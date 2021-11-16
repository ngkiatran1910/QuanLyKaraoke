
package Services;

import Models.LoaiPhong;
import Models.Phong;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LoaiPhongService extends IServices.IServiceLoaiPhong<LoaiPhong, String>{

    String THEM_SQL = "INSERT INTO LoaiPhong (MaLP, TenLoaiP, GiaTheoGio) VALUES (?,?,?)";
    String SUA_SQL = "UPDATE LoaiPhong SET TenLoaiP=?, GiaTheoGio=? WHERE MaLP=?";
    String SELECT_ID = "SELECT * FROM LoaiPhong Where MaLP = ?";
    String SELECT_SQL = "SELECT * FROM LoaiPhong";
    
    @Override
    public void them(LoaiPhong model) {
        jdbcUtilities.update(THEM_SQL, model.getMaLP(),
                model.getTenLP(), model.getGiaTheoGio());
    }

    @Override
    public void sua(LoaiPhong model) {
        jdbcUtilities.update(SUA_SQL, model.getTenLP(),
                model.getGiaTheoGio(), model.getMaLP());
    }

    @Override
    public LoaiPhong selectByID(String key) {
        List<LoaiPhong> list = this.selectBySql(SELECT_ID, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiPhong> selectAll() {
        return this.selectBySql(SELECT_SQL);
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
