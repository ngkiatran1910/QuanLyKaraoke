package Services;

import IServices.IServiceHoaDonChiTiet;
import Models.HoaDonChiTiet;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietService extends IServiceHoaDonChiTiet<HoaDonChiTiet, String> {

    @Override
    public void them(HoaDonChiTiet model) {
        String sql = "insert into CTHoaDon (MaHD, MaP, MaTT, TienGio, TienDV, NgayXuatHD, IDTTThanhToan, NgayDat, GioBD, GioKT, TongGio) \n"
                + "values (?,?,null,null,null,null,null,?,?,null,null)";
        jdbcUtilities.update(sql,
                model.getMaHD(),
                model.getMaP(),
                model.getNgayDat(),
                model.getGioBD()
        );
    }

    @Override
    public void sua(HoaDonChiTiet model) {
        String sql = "update CTHoaDon\n"
                + "set MaP = ?, MaTT = ?, MaDV = ?,TienGio =?, TienDV = ?, NgayXuatHD = ?,IDTTThanhToan = ?,NgayDat = ? ,GioBD = ?,GioKT = ?,TongGio = ?\n"
                + "where MaHD = ?";
        jdbcUtilities.update(sql,
                model.getMaP(),
                model.getMaTT(),
                model.getTienGio(),
                model.getNgayXuatHD(),
                model.getIDTTThanhToan(),
                model.getNgayDat(),
                model.getGioBD(),
                model.getGioKT(),
                model.getTongGio(),
                model.getMaHD());
    }

    @Override
    public HoaDonChiTiet selectByID(String key) {
        String sql = "select MAX(HoaDon.MaHD) as cutancut, TenDV, DonGia, SoLuong, DonGia*SoLuong as TongTien\n"
                + "from HoaDon join CTHoaDon on HoaDon.MaHD = CTHoaDon.MaHD\n"
                + "join CTDICHVU on CTHoaDon.MaP = CTDICHVU.MaP where CTHoaDon.MaP = ?\n"
                + "group by TenDV, DonGia, SoLuong";
        List<HoaDonChiTiet> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setMaHD(rs.getInt("MaHD"));
                model.setMaP(rs.getString("MaP"));
                model.setMaTT(rs.getInt("MaTT"));
                model.setTienGio(rs.getFloat("TienGio"));
                model.setTienDV(rs.getFloat("TienDV"));
                model.setNgayXuatHD(rs.getDate("NgayXuatHD"));
                model.setIDTTThanhToan(rs.getInt("IDTTThanhToan"));
                model.setNgayDat(rs.getDate("NgayDat"));
                model.setGioBD(rs.getTime("GioBD"));
                model.setGioKT(rs.getTime("GioKT"));
                model.setTongGio(rs.getFloat("TongGio"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(HoaDonChiTiet model) {
        String sql = "update CTHoaDon\n"
                + "set GioBD = ?\n"
                + "where MaHD = ? and MaP=?";
        jdbcUtilities.update(sql, model.getGioBD(), model.getMaHD(), model.getMaP());
    }

    public void exitTime(HoaDonChiTiet model) {
        String sql = "update CTHoaDon\n"
                + "set GioKT = ?\n"
                + "where MaHD = ? and MaP=?";
        jdbcUtilities.update(sql, model.getGioBD(), model.getMaHD(), model.getMaP());
    }

    public List<HoaDonChiTiet> selectByMaKH(String makh) {
        String sql = "select MAX(MaHD) as cutancut from HoaDon where MaKH = ?";
        return this.selectBySq(sql, makh);
    }

    protected List<HoaDonChiTiet> selectByS(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setMaHD(rs.getInt("cutancut"));
                model.setTenDV(rs.getString("TenDV"));
                model.setSoLuong(rs.getInt("SoLuong"));
                model.setTongTien(rs.getFloat("TongTien"));
                model.setDonGia(rs.getFloat("DonGia"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<HoaDonChiTiet> selectBySq(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setMaHD(rs.getInt("cutancut"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
