/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.dao;

import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ProyectoBancoDao
 *
 * Proyectos por Banco DAO
 *
 * @author Stiward
 * @version 1.0
 */
public class ProyectoBancoDao {

    public List<ProyectoBancoVo> proyectosFinanciadosPorBanco(String banco) throws SQLException {
        List<ProyectoBancoVo> res = new ArrayList<>();
        String sql = "SELECT p.ID_Proyecto, p.Constructora, p.Ciudad, p.Clasificacion, t.Estrato, l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER  FROM Proyecto p INNER JOIN Tipo t ON t.ID_Tipo=p.ID_Tipo INNER JOIN Lider l ON l.ID_Lider=p.ID_Lider WHERE p.Banco_Vinculado = ? ORDER BY p.Fecha_Inicio DESC, p.Ciudad ASC, p.Constructora ASC;";
        try (Connection con = JDBCUtilities.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, banco);         
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new ProyectoBancoVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
        }
        return res;
    }
}
