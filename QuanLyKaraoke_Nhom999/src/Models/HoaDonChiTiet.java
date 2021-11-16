/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {

    public String MaHD, MaP, MaDV;
    public Date NgayDat, NgayXuatHD;
    public int TrangThai, MaTT;
    public float TienGio, TienDV;
    public LocalTime GioBD, GioKT;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHD, String MaP, String MaDV, Date NgayDat, Date NgayXuatHD, int TrangThai, int MaTT, float TienGio, float TienDV, LocalTime GioBD, LocalTime GioKT) {
        this.MaHD = MaHD;
        this.MaP = MaP;
        this.MaDV = MaDV;
        this.NgayDat = NgayDat;
        this.NgayXuatHD = NgayXuatHD;
        this.TrangThai = TrangThai;
        this.MaTT = MaTT;
        this.TienGio = TienGio;
        this.TienDV = TienDV;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

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

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public Date getNgayXuatHD() {
        return NgayXuatHD;
    }

    public void setNgayXuatHD(Date NgayXuatHD) {
        this.NgayXuatHD = NgayXuatHD;
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

    public float getTienGio() {
        return TienGio;
    }

    public void setTienGio(float TienGio) {
        this.TienGio = TienGio;
    }

    public float getTienDV() {
        return TienDV;
    }

    public void setTienDV(float TienDV) {
        this.TienDV = TienDV;
    }

    public LocalTime getGioBD() {
        return GioBD;
    }

    public void setGioBD(LocalTime GioBD) {
        this.GioBD = GioBD;
    }

    public LocalTime getGioKT() {
        return GioKT;
    }

    public void setGioKT(LocalTime GioKT) {
        this.GioKT = GioKT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HoaDonChiTiet{MaHD=").append(MaHD);
        sb.append(", MaP=").append(MaP);
        sb.append(", MaDV=").append(MaDV);
        sb.append(", NgayDat=").append(NgayDat);
        sb.append(", NgayXuatHD=").append(NgayXuatHD);
        sb.append(", TrangThai=").append(TrangThai);
        sb.append(", MaTT=").append(MaTT);
        sb.append(", TienGio=").append(TienGio);
        sb.append(", TienDV=").append(TienDV);
        sb.append(", GioBD=").append(GioBD);
        sb.append(", GioKT=").append(GioKT);
        sb.append('}');
        return sb.toString();
    }

}
