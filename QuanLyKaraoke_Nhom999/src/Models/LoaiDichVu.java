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

    public String TenLDV;
    public int MaLDV;

    public LoaiDichVu() {
    }

    public LoaiDichVu(int MaLDV, String TenLDV) {
        this.MaLDV = MaLDV;
        this.TenLDV = TenLDV;
    }

    public int getMaLDV() {
        return MaLDV;
    }

    public void setMaLDV(int MaLDV) {
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
