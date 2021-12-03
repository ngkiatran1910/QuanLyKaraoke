package Models;

public class DonViTinh {

    public int MaDVT;
    public String KieuDVT;

    public DonViTinh() {
    }

    public DonViTinh(int MaDVT, String KieuDVT) {
        this.MaDVT = MaDVT;
        this.KieuDVT = KieuDVT;
    }

    public int getMaDVT() {
        return MaDVT;
    }

    public void setMaDVT(int MaDVT) {
        this.MaDVT = MaDVT;
    }

    public String getKieuDVT() {
        return KieuDVT;
    }

    public void setKieuDVT(String KieuDVT) {
        this.KieuDVT = KieuDVT;
    }

    @Override
    public String toString() {
        return  KieuDVT ;
    }
    

}
