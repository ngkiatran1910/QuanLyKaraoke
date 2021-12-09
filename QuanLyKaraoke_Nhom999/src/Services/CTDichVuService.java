/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.CTDichVu;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class CTDichVuService extends IServices.IServiceCTDichVu<CTDichVu, String> {

    @Override
    public void them(CTDichVu model) {
        String sql = "Insert into CTDICHVU (MaP,MaDV,TenDV,SoLuong,DonGia,MaHD)values (?,?,?,?,?,?)";
        jdbcUtilities.update(sql,
                model.getMaP(),
                model.getMaDV(),
                model.getTenDV(),
                model.getSoLuong(),
                model.getDonGia(),
                model.getMaHD());
    }

    @Override
    public void sua(CTDichVu model) {
        String sql = "update CTDICHVU\n"
                + "set SoLuong = ?\n"
                + "where TenDV = ? and MaHD = ?";
        jdbcUtilities.update(sql,
                model.getSoLuong(),
                model.getTenDV(),
                model.getMaHD());
    }

    @Override
    public CTDichVu selectByID(String key) {
        String sql = "SELECT * FROM CTDichVu WHERE MaP = ?";
        List<CTDichVu> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<CTDichVu> selectAll() {
        String sql = "SELECT * FROM CTDichVu";
        return selectBySql(sql);
    }

    @Override
    protected List<CTDichVu> selectBySql(String sql, Object... args) {
        List<CTDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                CTDichVu model = new CTDichVu();
                model.setMaP(rs.getString("MaP"));
                model.setMaDV(rs.getString("MaDV"));
                model.setTenDV(rs.getString("TenDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setDonGia(rs.getFloat("DonGia"));
                model.setMaHD(rs.getInt("MaHD"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CTDichVu> selectTongTien(int mahd) {
        String sql = "Select SUM(SoLuong*DonGia) AS TongTienDV From CTDichVu WHERE MaHD=?";
        return this.selectByTongTien(sql, mahd);
    }

    protected List<CTDichVu> selectByTongTien(String sql, Object... args) {
        List<CTDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                CTDichVu model = new CTDichVu();
                model.setTongTien(rs.getFloat("TongTienDV"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<CTDichVu> selectDVHD(String sql, Object... args) {
        List<CTDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                CTDichVu model = new CTDichVu();
                model.setTenDV(rs.getString("TenDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setDonGia(rs.getFloat("DonGia"));
                model.setTongTien(rs.getFloat("TongTien"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CTDichVu> selectByMaHD(int MaHD) {
        String sql = "SELECT TenDV,SoLuong,DonGia,DonGia*SoLuong as TongTien FROM CTDichVu WHERE MaHD = ?";
        return selectDVHD(sql, MaHD);
    }

    public CTDichVu selectByMaHDUP(int MaHD) {
        String sql = "SELECT TenDV,SoLuong,DonGia,DonGia*SoLuong as TongTien FROM CTDichVu WHERE MaHD = ?";
        List<CTDichVu> list = selectDVHD(sql, MaHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<CTDichVu> selectByTenDV(String TenDV) {
        String sql = "SELECT TenDV,SoLuong,DonGia,DonGia*SoLuong as TongTien FROM CTDichVu WHERE TenDV = ?";
        return selectDVHD(sql, TenDV);
    }

    public CTDichVu selectByTenDV1(String TenDV, int MaHD) {
        String sql = "SELECT TenDV,SoLuong,DonGia,DonGia*SoLuong as TongTien FROM CTDichVu WHERE TenDV = ? and MaHD = ?";
        List<CTDichVu> list = selectDVHD(sql, TenDV, MaHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    public void xoaDichVuDangDung(String TenDV, int MaHD) {
        String sql = "delete CTDICHVU\n"
                + "where TenDV = ? AND MaHD = ?";
        jdbcUtilities.update(sql,TenDV,MaHD);
    }
}
