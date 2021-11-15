package Models;

public class CTHoaDonTam {

    public String TenDV;
    public int SoLuong;
    public float GiaTien;

    public CTHoaDonTam() {
    }

    public CTHoaDonTam(String TenDV, int SoLuong, float GiaTien) {
        this.TenDV = TenDV;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
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

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    @Override
    public String toString() {
        return "CTHoaDonTam{" + "TenDV=" + TenDV + ", SoLuong=" + SoLuong + ", GiaTien=" + GiaTien + '}';
    }

    public float ThanhTien() {
        return SoLuong * GiaTien;
    }

}
