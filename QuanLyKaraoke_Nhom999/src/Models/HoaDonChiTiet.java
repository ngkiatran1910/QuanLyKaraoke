package Models;

import java.util.Date;

public class HoaDonChiTiet {

    public String MaP, TenDV;
    public Date NgayDat, NgayXuatHD, GioBD, GioKT;
    public int IDTTThanhToan, MaHD, MaTT, SoLuong;
    public float TienGio, TienDV, TongGio, DonGia, TongTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaP, String TenDV, Date NgayDat, Date NgayXuatHD, Date GioBD, Date GioKT, int IDTTThanhToan, int MaHD, int MaTT, int SoLuong, float TienGio, float TienDV, float TongGio, float DonGia, float TongTien) {
        this.MaP = MaP;
        this.TenDV = TenDV;
        this.NgayDat = NgayDat;
        this.NgayXuatHD = NgayXuatHD;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
        this.IDTTThanhToan = IDTTThanhToan;
        this.MaHD = MaHD;
        this.MaTT = MaTT;
        this.SoLuong = SoLuong;
        this.TienGio = TienGio;
        this.TienDV = TienDV;
        this.TongGio = TongGio;
        this.DonGia = DonGia;
        this.TongTien = TongTien;
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

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaP() {
        return MaP;
    }

    public void setMaP(String MaP) {
        this.MaP = MaP;
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

    public int getIDTTThanhToan() {
        return IDTTThanhToan;
    }

    public void setIDTTThanhToan(int IDTTThanhToan) {
        this.IDTTThanhToan = IDTTThanhToan;
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

    public float getTongGio() {
        return TongGio;
    }

    public void setTongGio(float TongGio) {
        this.TongGio = TongGio;
    }

    public Date getGioBD() {
        return GioBD;
    }

    public void setGioBD(Date GioBD) {
        this.GioBD = GioBD;
    }

    public Date getGioKT() {
        return GioKT;
    }

    public void setGioKT(Date GioKT) {
        this.GioKT = GioKT;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "MaHD=" + MaHD + ", MaP=" + MaP + ", NgayDat=" + NgayDat + ", NgayXuatHD=" + NgayXuatHD + ", IDTTThanhToan=" + IDTTThanhToan + ", MaTT=" + MaTT + ", TienGio=" + TienGio + ", TienDV=" + TienDV + ", TongGio=" + TongGio + ", GioBD=" + GioBD + ", GioKT=" + GioKT + '}';
    }
}
