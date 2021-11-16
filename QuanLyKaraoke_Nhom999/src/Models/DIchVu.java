package Models;

public class DichVu {

    public String MaDV, TenDV, DonViTinh, MaLDV;
    public float GiaDV;
    public int TrangThai, SoLuong;

    public DichVu() {
    }

    public DichVu(String MaDV, String TenDV, String DonViTinh, String MaLDV, float GiaDV, int TrangThai, int SoLuong) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.DonViTinh = DonViTinh;
        this.MaLDV = MaLDV;
        this.GiaDV = GiaDV;
        this.TrangThai = TrangThai;
        this.SoLuong = SoLuong;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getMaLDV() {
        return MaLDV;
    }

    public void setMaLDV(String MaLDV) {
        this.MaLDV = MaLDV;
    }

    public float getGiaDV() {
        return GiaDV;
    }

    public void setGiaDV(float GiaDV) {
        this.GiaDV = GiaDV;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return TenDV;
    }

}
