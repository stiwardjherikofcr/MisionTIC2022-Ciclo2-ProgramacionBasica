/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_4.controller;

import co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.dao.DeudasPorProyectoDao;
import co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.vo.ProyectoBancoVo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Stiward
 */
public class ReportesController {

    public String proyectosFinanciadosPorBanco(String banco) throws SQLException {
        String res = "";
        List<ProyectoBancoVo> list = new ProyectoBancoDao().proyectosFinanciadosPorBanco(banco);
        for (ProyectoBancoVo pb : list) {
            res += pb + "\n";
        }
        return res;
    }

    public String totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) throws SQLException {
        String res = "";
        List<DeudasPorProyectoVo> list = new DeudasPorProyectoDao().totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
        for (DeudasPorProyectoVo dp : list) {
            res += dp + "\n";
        }
        return res;
    }

    public String lideresQueMasGastan() throws SQLException {
        String res = "";
        List<ComprasDeLiderVo> list = new ComprasDeLiderDao().lideresQueMasGastan();
        for (ComprasDeLiderVo cl : list) {
            res += cl + "\n";
        }
        return res;
    }
}
