/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_5.controller;

import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.dao.DeudasPorProyectoDao;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.ProyectoBancoVo;
import java.sql.SQLException;
import java.util.List;

/**
 * Clase ReportesController
 *
 * Controlador de Reportes
 *
 * @author Stiward
 * @version 1.0
 */
public class ReportesController {

    public List<ProyectoBancoVo> proyectosFinanciadosPorBanco(String banco) throws SQLException {
        return new ProyectoBancoDao().proyectosFinanciadosPorBanco(banco);
    }

    public List<DeudasPorProyectoVo> totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) throws SQLException {
        return new DeudasPorProyectoDao().totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
    }

    public List<ComprasDeLiderVo> lideresQueMasGastan() throws SQLException {
        return new ComprasDeLiderDao().lideresQueMasGastan();
    }
}
