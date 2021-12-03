package Models;

public class DichVu {

    public String MaDV, TenDV;
    public float GiaDV;
    public int TrangThai, SoLuong, MaLDV,DonViTinh;

    public DichVu() {
    }

    public DichVu(String MaDV, String TenDV, int DonViTinh, int MaLDV, float GiaDV, int TrangThai, int SoLuong) {
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

    public int getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(int DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public int getMaLDV() {
        return MaLDV;
    }

    public void setMaLDV(int MaLDV) {
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
