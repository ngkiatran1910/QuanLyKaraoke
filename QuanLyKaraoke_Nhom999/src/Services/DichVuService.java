package Services;

import Models.DichVu;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DichVuService extends IServices.IServiceDichVu<DichVu, String> {

    DichVu dv = new DichVu();

    private List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                DichVu model = new DichVu();
                model.setMaDV(rs.getString("MaDV"));
                model.setTenDV(rs.getString("TenDV"));
                model.setGiaDV(rs.getFloat("GiaDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setDonViTinh(rs.getString("DonViTinh"));
                model.setTrangThai(rs.getInt("TrangThai"));
                model.setMaLDV(rs.getString("MaLDV"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List selectAll() {
        String sql = "SELECT * FROM DichVu";
        return selectBySql(sql);
    }

    public List selectTop5() {
        String sql = "";
        return selectBySql(sql);
    }

    @Override
    public void them(DichVu model) {
        String sql = "INSERT INTO DichVu (MaDV,TenDV,GiaDV,SoLuong,DonViTinh,TrangThai,MaLDV) VALUES (?,?,?,?,?,?,?)";
        jdbcUtilities.update(sql,
                dv.getMaDV(),
                dv.getTenDV(),
                dv.getGiaDV(),
                dv.getSoLuong(),
                dv.getDonViTinh(),
                dv.getTrangThai(),
                dv.getMaLDV());
    }

    @Override
    public void sua(DichVu model) {
        String sql = "UPDATE DichVu SET TenDV=?,GiaDV=?,SoLuong=?,DonViTinh=?,TrangThai=?,MaLDV=? WHERE MaDV=?";
        jdbcUtilities.update(sql,
                dv.getTenDV(),
                dv.getGiaDV(),
                dv.getSoLuong(),
                dv.getDonViTinh(),
                dv.getTrangThai(),
                dv.getMaLDV(),
                dv.getMaDV());
    }

    @Override
    public DichVu selectByID(String key) {
        String sql = "SELECT * FROM DichVu WHERE MaDV = ?";
        List<DichVu> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

}
