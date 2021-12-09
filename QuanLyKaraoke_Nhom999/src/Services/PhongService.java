package Services;

import Models.Phong;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class PhongService extends IServices.IServicePhong<Phong, String> {

    @Override
    public List selectAll() {
        String sql = "SELECT * FROM Phong";
        return selectBySql(sql);
    }

    @Override
    public void them(Phong p) {
        String sql = "INSERT INTO Phong (MaP, MaLP, IDTTPhong, Tang) VALUES (?,?,?,?)";
        jdbcUtilities.update(sql,
                p.getMaP(),
                p.getMaLP(),
                p.getTrangThai(),
                p.getTang());
    }

    @Override
    public void sua(Phong p) {
        String sql = "UPDATE Phong SET MaLP=?, IDTTPhong=?, Tang=? WHERE MaP=?";
        jdbcUtilities.update(sql,
                p.getMaLP(),
                p.getTrangThai(),
                p.getTang(),
                p.getMaP());
    }

    @Override
    public Phong selectByID(String key) {
        String sql = "SELECT * FROM Phong WHERE MaP=?";
        List<Phong> list = this.selectBySql(sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                Phong model = new Phong();
                model.setMaP(rs.getString("MaP"));
                model.setMaLP(rs.getString("MaLP"));
                model.setTrangThai(rs.getInt("IDTTPhong"));
                model.setTang(rs.getInt("Tang"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List selectTop5() {
        String sql = "Select Top 5 Phong.MaP,Tang,MaLP,Phong.IDTTPhong,COUNT(Phong.MaP) AS SOLANSD From Phong join CTHoaDon on Phong.MaP = CTHoaDon.MaP\n"
                + "GROUP BY Phong.MaP,Tang,MaLP,Phong.IDTTPhong\n"
                + "ORDER BY COUNT(Phong.MaP) DESC";
        return selectBySql(sql);
    }

    public List<Phong> selectByTang(int tang) {
        String sql = "Select * from Phong where Tang=?";
        return selectBySql(sql, tang); 
    }
    
    public void UDPhong(Phong p) {
        String sql = "UPDATE Phong SET IDTTPhong = ? WHERE MaP = ?";
        jdbcUtilities.update(sql,
                p.getTrangThai(),
                p.getMaP());
    }
}
