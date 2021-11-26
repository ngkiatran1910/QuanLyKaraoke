
package Models;

import java.util.Date;


public class HoaDonChiTiet {

    public String MaP, MaDV;
    public Date NgayDat, NgayXuatHD,GioBD, GioKT;
    public int IDTTThanhToan,MaHD, MaTT;
    public float TienGio, TienDV,TongGio;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int MaHD, String MaP, String MaDV, Date NgayDat, Date NgayXuatHD, int IDTTThanhToan, int MaTT, float TienGio, float TienDV, float TongGio, Date GioBD, Date GioKT) {
        this.MaHD = MaHD;
        this.MaP = MaP;
        this.MaDV = MaDV;
        this.NgayDat = NgayDat;
        this.NgayXuatHD = NgayXuatHD;
        this.IDTTThanhToan = IDTTThanhToan;
        this.MaTT = MaTT;
        this.TienGio = TienGio;
        this.TienDV = TienDV;
        this.TongGio = TongGio;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
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
        return "HoaDonChiTiet{" + "MaHD=" + MaHD + ", MaP=" + MaP + ", MaDV=" + MaDV + ", NgayDat=" + NgayDat + ", NgayXuatHD=" + NgayXuatHD + ", IDTTThanhToan=" + IDTTThanhToan + ", MaTT=" + MaTT + ", TienGio=" + TienGio + ", TienDV=" + TienDV + ", TongGio=" + TongGio + ", GioBD=" + GioBD + ", GioKT=" + GioKT + '}';
    }

    

}
