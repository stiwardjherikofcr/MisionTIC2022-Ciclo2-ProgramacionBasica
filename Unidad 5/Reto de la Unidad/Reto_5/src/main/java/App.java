
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.view.ReportesGUI;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase App
 *
 * Clase Principal
 *
 * @author Stiward
 * @version 1.0
 */
public class App {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new ReportesGUI();
            } catch (Exception err) {
            }
        });
    }
}
