package Services;

import Models.TrangThaiPhong;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class TrangThaiPhongService extends IServices.IServiceTrangThaiPhong<TrangThaiPhong, String> {

    @Override
    public void them(TrangThaiPhong model) {
        String sql = "Insert into  TrangThaiPhong (TenTrangThai) values(?)";
        jdbcUtilities.update(sql,
                model.getTenTTPhong());
    }

    @Override
    public void sua(TrangThaiPhong model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TrangThaiPhong selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrangThaiPhong> selectAll() {
        String sql = "Select * from TrangThaiPhong";
        return selectBySql(sql);
    }

    @Override
    protected List<TrangThaiPhong> selectBySql(String sql, Object... args) {
        List<TrangThaiPhong> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                TrangThaiPhong model = new TrangThaiPhong();
                model.setIdTTPhong(rs.getInt("IDTTPhong"));
                model.setTenTTPhong(rs.getString("TenTrangThai"));                
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
