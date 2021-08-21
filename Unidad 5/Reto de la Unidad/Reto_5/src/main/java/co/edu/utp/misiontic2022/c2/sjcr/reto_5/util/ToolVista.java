/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_5.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * Clase ToolVista
 *
 * ToolVista
 *
 * @author Stiward
 * @version 1.0
 */
public class ToolVista {

    public static final GridBagLayout GBL = new GridBagLayout();
    private static final GridBagConstraints GBC = new GridBagConstraints();

    public static void insert(Container contenedor, Component componente, int gridx, int gridy, double weightx, double weighty, int gridwidth, int gridheight, int fill, int anchor, Insets insets, int ipadx, int ipady) throws Exception {
        if (!(contenedor.getLayout() instanceof GridBagLayout)) {
            throw new Exception("El contenerdor [" + contenedor.getClass() + "] no tiene establecido el layout aceptado [" + GridBagLayout.class + "]");
        }
        if (insets == null) {
            insets = new Insets(0, 0, 0, 0);
        }
        ToolVista.GBC.gridx = gridx;
        ToolVista.GBC.gridy = gridy;
        ToolVista.GBC.weightx = weightx;
        ToolVista.GBC.weighty = weighty;
        ToolVista.GBC.gridwidth = gridwidth;
        ToolVista.GBC.gridheight = gridheight;
        ToolVista.GBC.fill = fill;
        ToolVista.GBC.anchor = anchor;
        ToolVista.GBC.insets = insets;
        ToolVista.GBC.ipadx = ipadx;
        ToolVista.GBC.ipady = ipady;
        contenedor.add(componente, ToolVista.GBC);
        reset();
    }

    private static void reset() {
        ToolVista.GBC.anchor = GridBagConstraints.CENTER;
        ToolVista.GBC.fill = GridBagConstraints.NONE;
        ToolVista.GBC.gridheight = 1;
        ToolVista.GBC.gridwidth = 1;
        ToolVista.GBC.insets.bottom = 0;
        ToolVista.GBC.insets.top = 0;
        ToolVista.GBC.insets.left = 0;
        ToolVista.GBC.insets.right = 0;
        ToolVista.GBC.weightx = 0;
        ToolVista.GBC.weighty = 0;
        ToolVista.GBC.ipadx = 0;
    }
}
