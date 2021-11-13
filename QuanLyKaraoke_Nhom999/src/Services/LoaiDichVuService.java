/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.LoaiDichVu;
import Utilities.jdbcUtilities;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class LoaiDichVuService extends IServices.IServiceLoaiDichVu{

    LoaiDichVu dv = new LoaiDichVu();

    private List<LoaiDichVu> selectBySql(String sql, Object... args) {
        List<LoaiDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                LoaiDichVu model = new LoaiDichVu();
                model.setMaLDV(rs.getString("MaLDV"));
                model.setTenLDV(rs.getString("TenLDV"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void them(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sua(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object selectByID(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List selectAll() {
        String sql = "SELECT * FROM LoaiDichVu";
        return selectBySql(sql);
    }
    
}
