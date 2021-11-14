package Services;

import IServices.IServiceTaiKhoan;
import Models.TaiKhoan;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanService extends IServiceTaiKhoan<TaiKhoan, String> {

    String THEM_SQL = "Insert Into TaiKhoan \n"
            + "values (?, ?, ?, ?, ?)";
    String SUA_SQL = "Update TaiKhoan\n"
            + "Set TenNV = ?, ChucVu = ?, MatKhau = ?, TrangThai = ?\n"
            + "Where MaNV = ?";
    String SELECT_SQL = "Select * from TaiKhoan";

    @Override
    public void them(TaiKhoan model) {
        jdbcUtilities.update(THEM_SQL, model.getMaNV(), model.getTenNV(),
                model.isChucVu(), model.getMatKhau(), model.getTrangThai());
    }

    @Override
    public void sua(TaiKhoan model) {
        jdbcUtilities.update(SUA_SQL, model.getTenNV(), model.isChucVu(),
                model.getMatKhau(), model.getTrangThai(), model.getMaNV());
    }

    @Override
    public TaiKhoan selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return this.selectBySql(SELECT_SQL);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while(rs.next()) {
                TaiKhoan model = new TaiKhoan();
                model.setMaNV(rs.getString("MaNV"));
                model.setTenNV(rs.getString("TenNV"));
                model.setChucVu(rs.getBoolean("ChucVu"));
                model.setMatKhau(rs.getString("MatKhau"));
                model.setTrangThai(rs.getInt("TrangThai"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    


}
