/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class LoaiDichVu {

    public String MaLDV, TenLDV;

    public LoaiDichVu() {
    }

    public LoaiDichVu(String MaLDV, String TenLDV) {
        this.MaLDV = MaLDV;
        this.TenLDV = TenLDV;
    }

    public String getMaLDV() {
        return MaLDV;
    }

    public void setMaLDV(String MaLDV) {
        this.MaLDV = MaLDV;
    }

    public String getTenLDV() {
        return TenLDV;
    }

    public void setTenLDV(String TenLDV) {
        this.TenLDV = TenLDV;
    }

    @Override
    public String toString() {
        return TenLDV;
    }

}
