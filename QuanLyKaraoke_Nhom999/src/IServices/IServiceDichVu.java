package IServices;

import java.util.List;

abstract public class IServiceDichVu<Model, Key> {

    abstract public void them(Model model);

    abstract public void sua(Model model);

    abstract public Model selectByID(Key key);

    abstract public List<Model> selectAll();

    abstract protected List<Model> selectBySql(String sql, Object... args);
}
