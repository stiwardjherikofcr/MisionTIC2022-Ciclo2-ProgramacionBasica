/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase ProyectoBancoDao
 *
 * Proyectos por Banco 
 *
 * @author Stiward
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoBancoVo {
    private @Getter @Setter Integer id;
    private @Getter @Setter String constructora;
    private @Getter @Setter String ciudad;
    private @Getter @Setter String clasificacion;
    private @Getter @Setter Integer estrato;
    private @Getter @Setter String lider;
    
    @Override
    public String toString(){
        return String.format("%3d %-25s %-20s %-15s %7d %-30s", id, constructora, ciudad, clasificacion, estrato, lider);
    }
}
