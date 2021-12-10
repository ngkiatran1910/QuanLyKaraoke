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
        String sql = "Select MaDV, TenDV, SoLuong, DonViTinh.MaDVT, GiaDV, LoaiDichVu.MaLDV, IDTTDichVu\n"
                + "from LoaiDichVu join DichVu on LoaiDichVu.MaLDV=DichVu.MaLDV join DonViTinh on DichVu.MaDVT=DonViTinh.MaDVT";
        return selectBySql_Table(sql);
    }

    public List selectTop5() {
        String sql = "";
        return selectBySql(sql);
    }

    @Override
    public void them(DichVu model) {
        String sql = "INSERT INTO DichVu (MaDV,TenDV,GiaDV,SoLuong,IDTTDichVu,MaLDV,MaDVT) VALUES (?,?,?,?,?,?,?)";
        jdbcUtilities.update(sql,
                model.getMaDV(),
                model.getTenDV(),
                model.getGiaDV(),
                model.getSoLuong(),
                model.getTrangThai(),
                model.getMaLDV(),
                model.getDonViTinh()
        );
    }

    @Override
    public void sua(DichVu model) {
        String sql = "UPDATE DichVu SET TenDV=?,GiaDV=?,SoLuong=?,IDTTDichVu=?,MaLDV=?,MaDVT=? WHERE MaDV=?";
        jdbcUtilities.update(sql,
                model.getTenDV(),
                model.getGiaDV(),
                model.getSoLuong(),
                model.getTrangThai(),
                model.getMaLDV(),
                model.getDonViTinh(),
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
                model.setTrangThai(rs.getInt("IDTTDichVu"));
                model.setMaLDV(rs.getInt("MaLDV"));
                model.setDonViTinh(rs.getInt("MaDVT"));
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
                model.setGiaDV(rs.getFloat("GiaDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setTrangThai(rs.getInt("IDTTDichVu"));
                model.setMaLDV(rs.getInt("MaLDV"));
                model.setDonViTinh(rs.getInt("MaDVT"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DichVu> selectByLoaiDV(int MaLDV) {
        String sql = "SELECT * FROM DichVu WHERE MaLDV = ?";
        return this.selectBySql(sql, MaLDV);
    }

    public List selectDVCS() {
        String sql = "Select MaDV,TenDV,SoLuong from DichVu";
        return selectBySql1(sql);
    }

    protected List<DichVu> selectBySql1(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                DichVu model = new DichVu();
                model.setMaDV(rs.getString("MaDV"));
                model.setTenDV(rs.getString("TenDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<DichVu> selectMaDV(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                DichVu model = new DichVu();
                model.setMaDV(rs.getString("MaDV"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DichVu> selectByTenDV(String key) {
        String sql = "SELECT MaDV FROM DichVu WHERE TenDV = ?";
        return selectMaDV(sql, key);
    }

    public List<DichVu> updateDV(int Madv) {
        String sql = "update DichVu\n"
                + "set SoLuong = SoLuong - (Select SUM(Soluong) FROM CTDICHVU WHERE MaDV = ?)\n"
                + "where MaDV = ?";
        return selectMaDV(sql, Madv, Madv);
    }

}
