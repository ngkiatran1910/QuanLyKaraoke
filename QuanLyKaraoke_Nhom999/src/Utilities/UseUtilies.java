/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Models.TaiKhoan;

/**
 *
 * @author Admin
 */
public class UseUtilies {
    //    Đối tượng này chứa thông tin người sử dụng sau khi đăng nhnập

    public static TaiKhoan USER = null;

//    Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void logoff() {
          UseUtilies.USER  = null;
    }


    public static boolean authenticated() {
        return UseUtilies.USER != null;
    }
}
