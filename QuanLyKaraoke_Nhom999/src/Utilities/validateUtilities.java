
package Utilities;

import javax.swing.JOptionPane;


public class validateUtilities {
    
    public static boolean checkRong(String ck, String ms) {
        
        if(ck.isEmpty()) {
            JOptionPane.showMessageDialog(null, ms);
            return true;
        }else {
            return false;
        }
        
    }
    public static boolean checkSDT(String ck, String ms) {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        Boolean a;
        if(a=ck.matches(reg)) {
            JOptionPane.showMessageDialog(null, ms);
            return true;
        }else {
            return false;
        }
        
    }
    
}
