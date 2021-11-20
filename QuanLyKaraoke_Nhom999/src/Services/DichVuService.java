package Services;

import Models.DichVu;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DichVuService extends IServices.IServiceDichVu<DichVu, String> {

    @Override
    public List selectAll() {
        String sql = "SELECT * FROM DichVu";
        return selectBySql(sql);
    }

    public List selectFillTable() {
        String sql = "Select MaDV, TenDV, SoLuong, KieuDVT, GiaDV, TenLDV, TrangThai\n"
                + "from LoaiDichVu join DichVu \n"
                + "on LoaiDichVu.MaLDV=DichVu.MaLDV join DonViTinh\n"
                + "on DichVu.MaDVT=DonViTinh.MaDVT";
        return selectBySql_Table(sql);
    }

    public List selectTop5() {
        String sql = "";
        return selectBySql(sql);
    }

    @Override
    public void them(DichVu model) {
        String sql = "INSERT INTO DichVu (MaDV,TenDV,GiaDV,SoLuong,DonViTinh,TrangThai,MaLDV) VALUES (?,?,?,?,?,?,?)";
        jdbcUtilities.update(sql,
                model.getMaDV(),
                model.getTenDV(),
                model.getGiaDV(),
                model.getSoLuong(),
                model.getDonViTinh(),
                model.getTrangThai(),
                model.getMaLDV());
    }

    @Override
    public void sua(DichVu model) {
        String sql = "UPDATE DichVu SET TenDV=?,GiaDV=?,SoLuong=?,DonViTinh=?,TrangThai=?,MaLDV=? WHERE MaDV=?";
        jdbcUtilities.update(sql,
                model.getTenDV(),
                model.getGiaDV(),
                model.getSoLuong(),
                model.getDonViTinh(),
                model.getTrangThai(),
                model.getMaLDV(),
                model.getMaDV());
    }

    @Override
    public DichVu selectByID(String key) {
        String sql = "SELECT * FROM DichVu WHERE MaDV = ?";
        List<DichVu> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                DichVu model = new DichVu();
                model.setMaDV(rs.getString("MaDV"));
                model.setTenDV(rs.getString("TenDV"));
                model.setGiaDV(rs.getFloat("GiaDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setTrangThai(rs.getInt("TrangThai"));
                model.setMaLDV(rs.getString("MaLDV"));
                model.setDonViTinh(rs.getString("MaDVT"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    protected List<DichVu> selectBySql_Table(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                DichVu model = new DichVu();
                model.setMaDV(rs.getString("MaDV"));
                model.setTenDV(rs.getString("TenDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setDonViTinh(rs.getString("KieuDVT"));
                model.setGiaDV(rs.getFloat("GiaDV"));
                model.setKieuLDV(rs.getString("TenLDV"));
                model.setTrangThai(rs.getInt("TrangThai"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DichVu> selectByLoaiDV(String MaLDV) {
        String sql = "SELECT * FROM DichVu WHERE MaLDV = ?";
        return this.selectBySql(sql, MaLDV);
    }

}
