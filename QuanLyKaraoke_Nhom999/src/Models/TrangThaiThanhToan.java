
package Models;

public class TrangThaiThanhToan {
    private int IDTTThanhToan;
    private String TenTrangThai;

    public TrangThaiThanhToan() {
    }

    public TrangThaiThanhToan(int IDTTThanhToan, String TenTrangThai) {
        this.IDTTThanhToan = IDTTThanhToan;
        this.TenTrangThai = TenTrangThai;
    }

    public int getIDTTThanhToan() {
        return IDTTThanhToan;
    }

    public void setIDTTThanhToan(int IDTTThanhToan) {
        this.IDTTThanhToan = IDTTThanhToan;
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
