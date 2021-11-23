/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IServices;

import java.util.List;

/**
 *
 * @author Admin
 */
abstract public class IServiceCTDichVu <Model, Key>{
    abstract public void them(Model model);

    abstract public void sua(Model model);

    abstract public Model selectByID(Key key);

    abstract public List<Model> selectAll();

    abstract protected List<Model> selectBySql(String sql, Object... args);
}
