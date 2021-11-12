
package IServices;

import java.util.List;


abstract public class IServicePhong <Model, Key> {
    abstract public void them(Model model);
    abstract public void sua(Model model);
    abstract public Model selectByID(Key key);
    abstract public List<Model> selectAll();
}
