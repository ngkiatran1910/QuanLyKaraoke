/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class CTDichVu {
    public String  MaP,MaDV,TenDV;
    public int SoLuong,MaHD;
    public float DonGia, Tongtien;

    public String getMaP() {
        return MaP;
    }

    public void setMaP(String MaP) {
        this.MaP = MaP;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public float getTongtien() {
        return Tongtien;
    }

    public void setTongtien(float Tongtien) {
        this.Tongtien = Tongtien;
    }

    @Override
    public String toString() {
        return "CTDichVu{" + "MaP=" + MaP + ", MaDV=" + MaDV + ", MaHD=" + MaHD + ", TenDV=" + TenDV + ", SoLuong=" + SoLuong + ", DonGia=" + DonGia + '}';
    }
    
}
