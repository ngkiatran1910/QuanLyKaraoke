/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.HoaDon;
import Utilities.jdbcUtilities;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonService extends IServices.IServiceHoaDon<HoaDon, String> {

    String THEM_SQL = "Insert into HoaDon values (null,?,?,?,?,?)\n";

    @Override
    public void them(HoaDon model) {
        jdbcUtilities.update(THEM_SQL,
                model.getMaKH(), model.getNgayDat(), model.getSLPhongDat(),
                model.getIDTTPhong(), model.getMaNV());
    }

    public  java.sql.Date convertJavaUtilDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    @Override
    public void sua(HoaDon model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDon selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
