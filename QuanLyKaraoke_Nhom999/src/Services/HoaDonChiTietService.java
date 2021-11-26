package Services;

import IServices.IServiceHoaDonChiTiet;
import Models.HoaDonChiTiet;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Utilities;

public class HoaDonChiTietService extends IServiceHoaDonChiTiet<HoaDonChiTiet, String> {

    @Override
    public void them(HoaDonChiTiet model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sua(HoaDonChiTiet model) {
        String sql = "update CTHoaDon\n"
                + "set MaP = ?, MaTT = ?, MaDV = ?,TienGio =?, TienDV = ?, NgayXuatHD = ?,IDTTThanhToan = ?,NgayDat = ? ,GioBD = ?,GioKT = ?,TongGio = ?\n"
                + "where MaHD = ?";
        jdbcUtilities.update(sql, 
                model.getMaP(),
                model.getMaTT(),
                model.getMaDV(),
                model.getTienGio(),
                model.getMaDV(),
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                model.setMaDV(rs.getString("MaDV"));
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

}
