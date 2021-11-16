
package Models;


public class DonViTinh {
    
    public String MaDVT, KieuDVT;

    public DonViTinh() {
    }

    public DonViTinh(String MaDVT, String KieuDVT) {
        this.MaDVT = MaDVT;
        this.KieuDVT = KieuDVT;
    }

    public String getMaDVT() {
        return MaDVT;
    }

    public void setMaDVT(String MaDVT) {
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
        return KieuDVT;
    }
    
    
    
}
