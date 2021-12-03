
package Models;


public class TaiKhoan {
    public String MaNV, TenNV, MatKhau;
    public boolean ChucVu;
    public int TrangThai;

    public TaiKhoan() {
    }

    public TaiKhoan(String MaNV, String TenNV, String MatKhau, boolean ChucVu, int TrangThai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.MatKhau = MatKhau;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isChucVu() {
        return ChucVu;
    }

    public void setChucVu(boolean ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return  MaNV ;
    }

    
    public String trangThai(int tt) {
        if(tt==0) {
            return "Hoạt Động";
        }else {
            return "Ngưng Hoạt Động";
        }
    }
    
    
}
