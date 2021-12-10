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

    protected List<HoaDonChiTiet> selectTG(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setTongGio(rs.getFloat("TongGio"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HoaDonChiTiet> selectTienGio(String mahd) {
        String sql = "Select ROUND(TongGio/60, 1)*GiaTheoGio as TienGio from CTHoaDon\n"
                + "join Phong on CTHoaDon.MaP = Phong.MaP\n"
                + "join LoaiPhong on Phong.MaLP = LoaiPhong.MaLP\n"
                + "where MaHD = ?";
        return this.selectByTienGio(sql, mahd);
    }
    
    protected List<HoaDonChiTiet> selectByTienGio(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setTienGio(rs.getFloat("TienGio"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HoaDonChiTiet> selectTongGio(String mahd) {
        String sql = "Select ROUND(TongGio/60, 1) AS TGio  From CTHoaDon where MaHD = ?";
        return this.selectByTongGio(sql, mahd);
    }

    protected List<HoaDonChiTiet> selectByTongGio(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setTongGio(rs.getFloat("TGio"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTimeKT(HoaDonChiTiet model) {
        String sql = "update CTHoaDon set GioKT = ? where MaHD = ?";
        jdbcUtilities.update(sql, model.getGioKT(), model.getMaHD());
    }

    public void updateTongGio(HoaDonChiTiet model) {
        String sql = "UPDATE CTHoaDon SET TongGio = DATEDIFF(MINUTE, GioBD, GioKT) WHERE MaHD = ?";
        jdbcUtilities.update(sql, model.getMaHD());
    }

    public void updateMaTT(HoaDonChiTiet model) {
        String sql = "UPDATE CTHoaDon SET MaTT = ?, NgayXuatHD = ?, IDTTThanhToan = 1 WHERE MaHD = ?";
        jdbcUtilities.update(sql, model.getMaTT(), model.getNgayXuatHD(), model.getMaHD());
    }

    public List<HoaDonChiTiet> selectGio(int maHD) {
        String sql = "Select TienGio, NgayDat, GioBD, GioKT from CTHoaDon where MaHD = ?";
        return this.selectByGio(sql, maHD);
    }

    protected List<HoaDonChiTiet> selectByGio(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setTienGio(rs.getFloat("TienGio"));
                model.setNgayDat(rs.getDate("NgayDat"));
                model.setGioBD(rs.getTime("GioBD"));
                model.setGioKT(rs.getTime("GioKT"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<HoaDonChiTiet> selectTienDV(String maHD) {
        String sql = "Select SUM(SoLuong*DonGia) AS TongTienDV From CTDichVu WHERE MaHD=?";
        return this.selectByTienDV(sql, maHD);
    }
    
    protected List<HoaDonChiTiet> selectByTienDV(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setTienDV(rs.getFloat("TongTienDV"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTien(HoaDonChiTiet model) {
        String sql = "UPDATE CTHoaDon SET TienGio = ?, TienDV = ? WHERE MaHD = ?";
        jdbcUtilities.update(sql, model.getTienGio(), model.getTienDV(), model.getMaHD());
    }
    protected List<HoaDonChiTiet> selectByMAP(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet model = new HoaDonChiTiet();
                model.setMaHD(rs.getInt("MaHDmax"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<HoaDonChiTiet> selectMaHD(String MaP) {
        String sql = "Select MAX(MaHD) AS MaHDmax from CTHoaDon where MaP = ?";
        return selectByMAP(sql, MaP);
    }
    public List<Integer> selectYears() {
        String sql = "SELECT year(NgayXuatHD) as Nam FROM CTHoaDon\n"
                + "	Group BY year(NgayXuatHD)\n"
                + "	ORDER BY year(NgayXuatHD) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Object[]> getBangTKTN(int nam ) {
        String sql = "Exec SP_BANGTKNAM ?";
        String[] cols = {"NgayXuatHD", "SoHoaDonXuat", "TienTT"};
        return this.getListOfArray(sql, cols,nam);
    }
}
