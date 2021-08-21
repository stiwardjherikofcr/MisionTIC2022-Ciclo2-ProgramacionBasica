/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.dao;

import co.edu.utp.misiontic2022.c2.sjcr.reto_4.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_4.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stiward
 */
public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> lideresQueMasGastan() throws SQLException {
        List<ComprasDeLiderVo> res = new ArrayList<>();
        String sql = "SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER, SUM(mc.Precio_Unidad * c.Cantidad) AS \"VALOR\" FROM Lider l INNER JOIN Proyecto p ON p.ID_Lider = l.ID_Lider INNER JOIN Compra c ON c.ID_Proyecto = p.ID_Proyecto INNER JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion GROUP BY l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido ORDER BY 2 DESC LIMIT 10;";
        Connection con = JDBCUtilities.getConnection();
        ResultSet rs = con.prepareStatement(sql).executeQuery();
        while (rs.next()) {
            res.add(new ComprasDeLiderVo(rs.getString(1), rs.getDouble(2)));
        }
        con.close();
        return res;
    }
}
