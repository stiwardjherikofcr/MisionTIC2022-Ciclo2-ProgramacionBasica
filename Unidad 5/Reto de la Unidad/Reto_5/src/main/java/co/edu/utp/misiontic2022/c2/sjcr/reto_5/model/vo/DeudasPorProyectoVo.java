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
 * Clase DeudasPorProyectoDao
 *
 * Deudas por Proyecto 
 *
 * @author Stiward
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class DeudasPorProyectoVo {
    private @Getter @Setter Integer id;
    private @Getter @Setter Double valor;
    
    @Override
    public String toString(){
        return String.format("%3d %,15.1f", id, valor);
    }
}
