/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class KhachHang {
    public String MaKH,TenKH,SDT;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String TenKH, String SDT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KhachHang{MaKH=").append(MaKH);
        sb.append(", TenKH=").append(TenKH);
        sb.append(", SDT=").append(SDT);
        sb.append('}');
        return sb.toString();
    }
    
}
