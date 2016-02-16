/*
 * Kreiranje konfiguraciong file-a(Java-properties)
 * Morar<exdatis@gmail.com> 2016-02-15
 * Revizija:
    -------------------------------------------------------------------------------------------
        U stvari je vrlo jednostavno, samo sto sam jako lose dizajnirao klasu DbProperties,
        inace je nacin razmisljanja ok, samo je trebalo mnogo bolje dizajnirati klasu DbProperties,
        a onda je gui jednostavno koristi. Sve u svemu, nije lose!
    -------------------------------------------------------------------------------------------
 */
package bsproperties;

import java.io.FileNotFoundException;
import java.util.Properties;
import javax.swing.UIManager;

/**
 *
 * @author morar
 */
public class BsProperties {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        /******************************************************************************************
        // driver test
        DbProperties temp = new DbProperties("Pera", "Djura", "Djura.Host.Test");
        Properties tempProperties = temp.createJavaProperties();
        tempProperties = temp.encryptProperties(tempProperties);
        DbProperties.savePropertiesFile(tempProperties, "/home/morar/Documents/test.properties");
        * ****************************************************************************************/
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
