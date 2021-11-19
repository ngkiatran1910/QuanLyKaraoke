/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class LoaiPhong {
    public String MaLP,TenLP;
    public float  GiaTheoGio;

    public LoaiPhong() {
    }

    public LoaiPhong(String MaLP, String TenLP, float GiaTheoGio) {
        this.MaLP = MaLP;
        this.TenLP = TenLP;
        this.GiaTheoGio = GiaTheoGio;
    }

    public String getMaLP() {
        return MaLP;
    }

    public void setMaLP(String MaLP) {
        this.MaLP = MaLP;
    }

    public String getTenLP() {
        return TenLP;
    }

    public void setTenLP(String TenLP) {
        this.TenLP = TenLP;
    }

    public float getGiaTheoGio() {
        return GiaTheoGio;
    }

    public void setGiaTheoGio(float GiaTheoGio) {
        this.GiaTheoGio = GiaTheoGio;
    }

    @Override
    public String toString() {
        return TenLP ;
    }
    
}
