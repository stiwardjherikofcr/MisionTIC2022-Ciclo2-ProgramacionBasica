/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.dao;

import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DeudasPorProyectoDao
 *
 * Deudas por Proyecto DAO
 *
 * @author Stiward
 * @version 1.0
 */
public class DeudasPorProyectoDao {

    public List<DeudasPorProyectoVo> totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) throws SQLException {
        List<DeudasPorProyectoVo> res = new ArrayList<>();
        String sql = "SELECT p.ID_Proyecto, sum(mc.Precio_Unidad * c.Cantidad) FROM Proyecto p INNER JOIN Compra c ON c.ID_Proyecto=p.ID_Proyecto INNER JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion=c.ID_MaterialConstruccion WHERE c.Pagado='No' GROUP BY p.ID_Proyecto HAVING sum(mc.Precio_Unidad * c.Cantidad) > ? ORDER BY 2 DESC;";
        try (Connection con = JDBCUtilities.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, limiteInferior);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new DeudasPorProyectoVo(rs.getInt(1), rs.getDouble(2)));
            }
        }
        return res;
    }
}
