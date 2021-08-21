/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_4.view;

import co.edu.utp.misiontic2022.c2.sjcr.reto_4.controller.ReportesController;
import java.sql.SQLException;

/**
 *
 * @author Stiward
 */
public class ReportesView {

    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isEmpty()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
                    "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));

            // TODO Imprimir en pantalla la información del proyecto 
            ReportesController controller = new ReportesController();
            try {
                System.out.println(controller.proyectosFinanciadosPorBanco(banco));
            } catch (SQLException e) {
                System.out.println(String.format("¡Algo salio mal! %s", e.getMessage()));
            }
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR  "));
            System.out.println(repitaCaracter('-', 29));

            // TODO Imprimir en pantalla la información del total adeudado 
            ReportesController controller = new ReportesController();
            try {
                System.out.println(controller.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior));
            } catch (SQLException e) {
                System.out.println(String.format("¡Algo salio mal! %s", e.getMessage()));
            }
        }
    }

    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR  "));
        System.out.println(repitaCaracter('-', 41));

        // TODO Imprimir en pantalla la información de los líderes 
        ReportesController controller = new ReportesController();
        try {
            System.out.println(controller.lideresQueMasGastan());
        } catch (SQLException e) {
            System.out.println(String.format("¡Algo salio mal! %s", e.getMessage()));
        }
    }
}
