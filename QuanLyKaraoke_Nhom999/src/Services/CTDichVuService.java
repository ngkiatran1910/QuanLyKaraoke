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
public class CTDichVuService extends IServices.IServiceCTDichVu<CTDichVu, String>{

    @Override
    public void them(CTDichVu model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sua(CTDichVu model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
