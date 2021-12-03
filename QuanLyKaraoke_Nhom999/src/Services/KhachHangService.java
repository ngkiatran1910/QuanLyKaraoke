package Services;

import Models.KhachHang;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangService extends IServices.IServiceKhachHang<KhachHang, String> {

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
    public KhachHang selectByTen(String key) {
        String sql = "SELECT * FROM KhachHang WHERE TenKH = ?";
        List<KhachHang> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
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
    public List<KhachHang> selectTop5() {
        String sql = "Select Top 5 KhachHang.MaKH,KhachHang.TenKH,KhachHang.SDT,COUNT(HoaDon.MaKH)"
                + " AS SOHD From KhachHang join HoaDon on KhachHang.MaKH = HoaDon.MaKH\n"
                + "GROUP BY KhachHang.MaKH,KhachHang.TenKH,KhachHang.SDT\n"
                + "ORDER BY COUNT(HoaDon.MaKH) DESC";
        return selectBySql(sql);
    }

}
