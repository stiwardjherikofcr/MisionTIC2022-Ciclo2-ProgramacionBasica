/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.vo;

/**
 *
 * @author Stiward
 */
public class ComprasDeLiderVo {

    private String lider;
    private Double valor;

    public ComprasDeLiderVo(String lider, Double valor) {
        this.lider = lider;
        this.valor = valor;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%-25s %,15.1f", lider, valor);
    }
}
