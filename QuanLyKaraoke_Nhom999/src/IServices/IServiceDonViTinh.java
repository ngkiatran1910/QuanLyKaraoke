package IServices;

import java.util.List;

abstract public class IServiceDonViTinh<Model, Key> {

    abstract public void them(Model model);

    abstract public List<Model> selectAll();
    
    abstract protected List<Model> selectBySql(String sql, Object... args);

}
