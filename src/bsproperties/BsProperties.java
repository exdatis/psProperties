/*
 * Kreiranje konfiguraciong file-a(Java-properties)
 * Morar<exdatis@gmail.com> 2016-02-15
 * Revizija:
 */
package bsproperties;

import javax.swing.UIManager;

/**
 *
 * @author morar
 */
public class BsProperties {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set theme(look and feel)
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception e) {
            System.out.println("Greska u inicijalizaciji teme...");
            System.out.println("Error: " + e.getMessage());
        }
        
        //kreiraj dialog
        JPropertiesDlg dlg = new JPropertiesDlg();
        dlg.setVisible(true);
    }
    
}
