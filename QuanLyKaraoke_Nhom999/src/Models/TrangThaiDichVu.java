
package Models;

public class TrangThaiDichVu {
    private int IDTTDichVu;
    private String TenTrangThai;

    public TrangThaiDichVu() {
    }

    public TrangThaiDichVu(int IDTTDichVu, String TenTrangThai) {
        this.IDTTDichVu = IDTTDichVu;
        this.TenTrangThai = TenTrangThai;
    }

    public int getIDTTDichVu() {
        return IDTTDichVu;
    }

    public void setIDTTDichVu(int IDTTDichVu) {
        this.IDTTDichVu = IDTTDichVu;
    }

    public String getTenTrangThai() {
        return TenTrangThai;
    }

    public void setTenTrangThai(String TenTrangThai) {
        this.TenTrangThai = TenTrangThai;
    }

    @Override
    public String toString() {
        return TenTrangThai;
    }
    
}
