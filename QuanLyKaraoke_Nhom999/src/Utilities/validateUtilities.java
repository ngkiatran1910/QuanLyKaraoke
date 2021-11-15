
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
    
}
