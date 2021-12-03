/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    public String MaHD,MaKH,MaNV;
    public int SLPhongDat,IDTTPhong;
    public float TongTien;
    public Date  NgayDat;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaKH, String MaNV, int SLPhongDat, int IDTTPhong, float TongTien, Date NgayDat) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.SLPhongDat = SLPhongDat;
        this.IDTTPhong = IDTTPhong;
        this.TongTien = TongTien;
        this.NgayDat = NgayDat;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getSLPhongDat() {
        return SLPhongDat;
    }

    public void setSLPhongDat(int SLPhongDat) {
        this.SLPhongDat = SLPhongDat;
    }

    public int getIDTTPhong() {
        return IDTTPhong;
    }

    public void setIDTTPhong(int IDTTPhong) {
        this.IDTTPhong = IDTTPhong;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "MaHD=" + MaHD + ", MaKH=" + MaKH + ", MaNV=" + MaNV + ", SLPhongDat=" + SLPhongDat + ", IDTTPhong=" + IDTTPhong + ", TongTien=" + TongTien + ", NgayDat=" + NgayDat + '}';
    }

    
    
    
}
