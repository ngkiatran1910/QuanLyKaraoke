/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.KhachHang;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangService extends IServices.IServiceKhachHang<KhachHang ,String> {

    Models.KhachHang kh = new KhachHang();

    private List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                KhachHang model = new KhachHang();
                model.setMaKH(rs.getString("MaKH"));
                model.setTenKH(rs.getString("TenKH"));
                model.setSDT(rs.getString("SDT"));
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
        String sql = "SELECT * FROM KhachHang";
        return selectBySql(sql);
    }

    @Override
    public void them(KhachHang kh) {
     String sql = "INSERT INTO KhachHang(MaKH,TenKH,SDT) values (?,?,?)";
        jdbcUtilities.update(sql,
                kh.getMaKH(),
                kh.getTenKH(),
                kh.getSDT());
    }

    @Override
    public void sua(KhachHang kh) {
          String sql = "UPDATE KhachHang \n"
                + "SET TenKH = ?,SDT=?\n"
                + "WHERE MaKH= ?";
        jdbcUtilities.update(sql,
                kh.getTenKH(),
                kh.getSDT(),
                kh.getMaKH());
    }

    @Override
    public KhachHang selectByID(String key) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
        List<KhachHang> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

}
