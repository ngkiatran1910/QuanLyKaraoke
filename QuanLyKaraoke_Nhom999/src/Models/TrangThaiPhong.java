
package Models;


public class TrangThaiPhong {
    public int idTTPhong;
    public String tenTTPhong;

    public TrangThaiPhong() {
    }

    public TrangThaiPhong(int idTTPhong, String tenTTPhong) {
        this.idTTPhong = idTTPhong;
        this.tenTTPhong = tenTTPhong;
    }

    public int getIdTTPhong() {
        return idTTPhong;
    }

    public void setIdTTPhong(int idTTPhong) {
        this.idTTPhong = idTTPhong;
    }

    public String getTenTTPhong() {
        return tenTTPhong;
    }

    public void setTenTTPhong(String tenTTPhong) {
        this.tenTTPhong = tenTTPhong;
    }

    @Override
    public String toString() {
        return tenTTPhong ;
    }
    
    
}
