
package Services;

import Models.DonViTinh;
import Utilities.jdbcUtilities;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DonViTinhService extends IServices.IServiceDonViTinh <DonViTinh, String> {

    String THEM_SQL = "Insert into DonViTinh values (?)";
    String SELECT_SQL = "SELECT * FROM DonViTinh";
    
    @Override
    public void them(DonViTinh model) {
        jdbcUtilities.update(THEM_SQL, model.getKieuDVT());
    }

    @Override
    public List<DonViTinh> selectAll() {
        return this.selectBySql(SELECT_SQL);
    }

    @Override
    protected List<DonViTinh> selectBySql(String sql, Object... args) {
        List<DonViTinh> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtilities.query(sql, args);
            while (rs.next()) {
                DonViTinh model = new DonViTinh();
                model.setKieuDVT(rs.getString("KieuDVT"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
