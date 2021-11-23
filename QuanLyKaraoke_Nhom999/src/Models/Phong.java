
package Models;


public class Phong {
    public String MaP ,MaLP;
    public int Tang,TrangThai,Sosd;
    public float TongGio;

    public Phong() {
    }

    public Phong(String MaP, String MaLP, int Tang, int TrangThai, float TongGio) {
        this.MaP = MaP;
        this.MaLP = MaLP;
        this.Tang = Tang;
        this.TrangThai = TrangThai;
        this.TongGio = TongGio;
    }

    public String getMaP() {
        return MaP;
    }

    public void setMaP(String MaP) {
        this.MaP = MaP;
    }

    public String getMaLP() {
        return MaLP;
    }

    public void setMaLP(String MaLP) {
        this.MaLP = MaLP;
    }

    public int getTang() {
        return Tang;
    }

    public void setTang(int Tang) {
        this.Tang = Tang;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public float getTongGio() {
        return TongGio;
    }

    public void setTongGio(float TongGio) {
        this.TongGio = TongGio;
    }

    public int getSosd() {
        return Sosd;
    }

    public void setSosd(int Sosd) {
        this.Sosd = Sosd;
    }

    @Override
    public String toString() {
        return "" + TrangThai;
    }

    public String kh = null;
}
