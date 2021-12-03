/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class ThanhToan {

    public String HinhThucTT;
    public float TienTT, TienNhan, TienDu;
    public int TrangThai, MaTT;

    public ThanhToan() {
    }

    public ThanhToan(String HinhThucTT, float TienTT, float TienNhan, float TienDu, int TrangThai, int MaTT) {
        this.HinhThucTT = HinhThucTT;
        this.TienTT = TienTT;
        this.TienNhan = TienNhan;
        this.TienDu = TienDu;
        this.TrangThai = TrangThai;
        this.MaTT = MaTT;
    }

    public String getHinhThucTT() {
        return HinhThucTT;
    }

    public void setHinhThucTT(String HinhThucTT) {
        this.HinhThucTT = HinhThucTT;
    }

    public float getTienTT() {
        return TienTT;
    }

    public void setTienTT(float TienTT) {
        this.TienTT = TienTT;
    }

    public float getTienNhan() {
        return TienNhan;
    }

    public void setTienNhan(float TienNhan) {
        this.TienNhan = TienNhan;
    }

    public float getTienDu() {
        return TienDu;
    }

    public void setTienDu(float TienDu) {
        this.TienDu = TienDu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaTT() {
        return MaTT;
    }

    public void setMaTT(int MaTT) {
        this.MaTT = MaTT;
    }

    @Override
    public String toString() {      
        return HinhThucTT;
    }

}
