/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_5.view;

import co.edu.utp.misiontic2022.c2.sjcr.reto_5.controller.ReportesController;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.sjcr.reto_5.util.ToolVista;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase ReportesGUI
 *
 * GUI de Reportes
 *
 * @author Stiward
 * @version 1.0
 */
public class ReportesGUI {

    private final ReportesController reportesController;
    private final JFrame frame;
    private final JTabbedPane tabs;

    private final JTable tableQuery1;
    private final JTable tableQuery2;
    private final JTable tableQuery3;

    private final JLabel lblBank;
    private final JTextField txtBank;
    private final JButton btnQuery1;

    private final JLabel lblLowerLimit;
    private final JTextField txtLowerLimit;
    private final JButton btnQuery2;

    private final JButton btnQuery3;

    public ReportesGUI() throws Exception {
        this.reportesController = new ReportesController();
        this.frame = new JFrame("Reto 5 - Misión TIC 2022");
        this.tabs = new JTabbedPane();

        this.tableQuery1 = this.getCustomTable(
                new String[]{"ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"},
                new boolean[6],
                new int[]{20, 160, 160, 150, 60, 240}
        );
        this.tableQuery2 = this.getCustomTable(
                new String[]{"ID", "VALOR"},
                new boolean[2],
                new int[]{300, 300}
        );
        this.tableQuery3 = this.getCustomTable(
                new String[]{"LIDER", "VALOR"},
                new boolean[2],
                new int[]{400, 200}
        );

        this.lblBank = new JLabel("Bank");
        this.txtBank = new JTextField();
        this.btnQuery1 = new JButton("Search");

        this.lblLowerLimit = new JLabel("Lower Limit");
        this.txtLowerLimit = new JTextField();
        this.btnQuery2 = new JButton("Search");

        this.btnQuery3 = new JButton("Search");

        this.init();
    }

    private void init() throws Exception {
        Dimension minDim[] = {new Dimension(1000, 600), new Dimension(400, 600), new Dimension(400, 600)};
        this.frame.setPreferredSize(minDim[0]);
        this.frame.setMinimumSize(minDim[0]);
        this.frame.getContentPane().setLayout(ToolVista.GBL);

        //Tab Query #1
        JPanel panelQuery1 = new JPanel(ToolVista.GBL);
        JPanel panelSearchQ1 = new JPanel(ToolVista.GBL);

        panelQuery1.setBorder(this.getCustomBorder("Proyectos Financiados por un Banco"));

        this.btnQuery1.addActionListener(e -> {
            try {
                changeTableQuery1();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this.frame, "¡Algo salio mal! " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        ToolVista.insert(panelSearchQ1, this.lblBank, 0, 0, 0, 1, 1, 1, GridBagConstraints.VERTICAL, GridBagConstraints.FIRST_LINE_START, new Insets(5, 5, 5, 5), 10, 0);
        ToolVista.insert(panelSearchQ1, this.txtBank, 1, 0, 0, 1, 1, 1, GridBagConstraints.VERTICAL, GridBagConstraints.FIRST_LINE_START, new Insets(5, 0, 5, 0), 120, 0);
        ToolVista.insert(panelSearchQ1, this.btnQuery1, 2, 0, 0, 1, 1, 1, GridBagConstraints.VERTICAL, GridBagConstraints.FIRST_LINE_START, new Insets(5, 5, 5, 5), 20, 0);

        ToolVista.insert(panelQuery1, panelSearchQ1, 0, 0, 0, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.FIRST_LINE_START, new Insets(10, 10, 5, 10), 0, 0);
        ToolVista.insert(panelQuery1, new JScrollPane(this.tableQuery1), 0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.FIRST_LINE_START, new Insets(5, 10, 10, 10), 0, 0);
        //End Tab Query #1

        //Tab Query #2
        JPanel panelQuery2 = new JPanel(ToolVista.GBL);
        JPanel panelSearchQ2 = new JPanel(ToolVista.GBL);

        panelQuery2.setBorder(this.getCustomBorder("Total Adeudado por Proyecto Superior a un Limite"));

        this.btnQuery2.addActionListener(e -> {
            try {
                changeTableQuery2();
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(this.frame, "Solo se permiten numeros", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this.frame, "¡Algo salio mal! " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        ToolVista.insert(panelSearchQ2, this.lblLowerLimit, 0, 0, 0, 1, 1, 1, GridBagConstraints.VERTICAL, GridBagConstraints.FIRST_LINE_START, new Insets(5, 5, 5, 5), 10, 0);
        ToolVista.insert(panelSearchQ2, this.txtLowerLimit, 1, 0, 0, 1, 1, 1, GridBagConstraints.VERTICAL, GridBagConstraints.FIRST_LINE_START, new Insets(5, 0, 5, 0), 120, 0);
        ToolVista.insert(panelSearchQ2, this.btnQuery2, 2, 0, 0, 1, 1, 1, GridBagConstraints.VERTICAL, GridBagConstraints.FIRST_LINE_START, new Insets(5, 5, 5, 5), 20, 0);

        ToolVista.insert(panelQuery2, panelSearchQ2, 0, 0, 0, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.FIRST_LINE_START, new Insets(10, 10, 5, 10), 0, 0);
        ToolVista.insert(panelQuery2, new JScrollPane(this.tableQuery2), 0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.FIRST_LINE_START, new Insets(5, 10, 10, 10), 0, 0);
        //End Tab Query #3

        //Tab Query #3
        JPanel panelQuery3 = new JPanel(ToolVista.GBL);
        JPanel panelSearchQ3 = new JPanel(ToolVista.GBL);

        panelQuery3.setBorder(this.getCustomBorder("Lideres que mas Gastan"));

        this.btnQuery3.addActionListener(e -> {
            try {
                changeTableQuery3();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this.frame, "¡Algo salio mal! " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        ToolVista.insert(panelSearchQ3, this.btnQuery3, 0, 0, 0, 1, 1, 1, GridBagConstraints.VERTICAL, GridBagConstraints.FIRST_LINE_START, new Insets(5, 5, 5, 5), 20, 0);

        ToolVista.insert(panelQuery3, panelSearchQ3, 0, 0, 0, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.FIRST_LINE_START, new Insets(10, 10, 5, 10), 0, 0);
        ToolVista.insert(panelQuery3, new JScrollPane(this.tableQuery3), 0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.FIRST_LINE_START, new Insets(5, 10, 10, 10), 0, 0);
        //End Tab Query #3

        this.tabs.add("Query #1", panelQuery1);
        this.tabs.add("Query #2", panelQuery2);
        this.tabs.add("Query #3", panelQuery3);
        this.tabs.addChangeListener((e) -> {
            this.reset();
            this.frame.setPreferredSize(minDim[this.tabs.getSelectedIndex()]);
            this.frame.setMinimumSize(minDim[this.tabs.getSelectedIndex()]);
            this.frame.pack();
            this.frame.setLocationRelativeTo(null);
        });

        ToolVista.insert(this.frame.getContentPane(), this.tabs, 0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    private Border getCustomBorder(String title) {
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), title, TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
    }

    private JTable getCustomTable(String[] nameColumns, boolean[] editables, int[] sizeColumns) {
        JTable tbl = new JTable();
        ModelTable modelTable = new ModelTable(nameColumns, editables);
        tbl.setModel(modelTable);

        tbl.getTableHeader().setDefaultRenderer((JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) -> {
            JLabel lbl = new JLabel(value.toString());
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            lbl.setPreferredSize(new Dimension(lbl.getWidth(), 30));
            lbl.setBorder(BorderFactory.createLineBorder(new Color(Integer.parseInt("484848", 16))));
            lbl.setBackground(new Color(Integer.parseInt("aeaeae", 16)));
            lbl.setOpaque(true);
            lbl.setForeground(Color.BLACK);

            return lbl;
        });

        Color DEFAULT_COLOR = new Color(Integer.parseInt("FFFFFF", 16));
        Color SELECTED_COLOR = new Color(Integer.parseInt("aeaeae", 16));
        Color BG_COLOR = new Color(Integer.parseInt("e0e0e0", 16));

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Color backgroundColor = hasFocus ? SELECTED_COLOR : BG_COLOR;
                super.setText(value.toString());
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.setBackground(isSelected ? backgroundColor : DEFAULT_COLOR);
                super.setForeground(Color.BLACK);
                return this;
            }
        };

        for (int i = 0; i < tbl.getColumnCount(); i++) {
            tbl.getColumnModel().getColumn(i).setCellRenderer(cellRender);
            tbl.getColumnModel().getColumn(i).setPreferredWidth(sizeColumns[i]);
        }

        tbl.setRowHeight(25);
        tbl.setGridColor(Color.BLACK);
        tbl.setBackground(Color.WHITE);

        return tbl;
    }

    private void changeTableQuery1() throws SQLException {
        ModelTable mt = (ModelTable) this.tableQuery1.getModel();
        if (!this.txtBank.getText().replace(" +", "").isEmpty()) {
            List<ProyectoBancoVo> list = reportesController.proyectosFinanciadosPorBanco(this.txtBank.getText());
            Object data[][] = new Object[list.size()][6];
            int i = 0;
            for (ProyectoBancoVo pb : list) {
                data[i][0] = pb.getId();
                data[i][1] = pb.getConstructora();
                data[i][2] = pb.getCiudad();
                data[i][3] = pb.getClasificacion();
                data[i][4] = pb.getEstrato();
                data[i++][5] = pb.getLider();
            }
            mt.setData(data);
        } else {
            mt.clear();
        }
    }

    private void changeTableQuery2() throws SQLException {
        ModelTable mt = (ModelTable) this.tableQuery2.getModel();
        String val = this.txtLowerLimit.getText().replaceAll(" +", "");
        if (!val.isEmpty()) {
            Double valNum = Double.parseDouble(val);
            List<DeudasPorProyectoVo> list = this.reportesController.totalAdeudadoPorProyectosSuperioresALimite(valNum);
            Object data[][] = new Object[list.size()][2];
            int i = 0;
            for (DeudasPorProyectoVo dp : list) {
                data[i][0] = dp.getId();
                data[i++][1] = dp.getValor();
            }
            mt.setData(data);
        } else {
            mt.clear();
        }
    }

    private void changeTableQuery3() throws SQLException {
        ModelTable mt = (ModelTable) this.tableQuery3.getModel();
        List<ComprasDeLiderVo> list = this.reportesController.lideresQueMasGastan();
        Object data[][] = new Object[list.size()][2];
        int i = 0;
        for (ComprasDeLiderVo cd : list) {
            data[i][0] = cd.getLider();
            data[i++][1] = cd.getValor();
        }
        mt.setData(data);
    }

    private void reset() {
        ((ModelTable) this.tableQuery1.getModel()).clear();
        ((ModelTable) this.tableQuery2.getModel()).clear();
        ((ModelTable) this.tableQuery3.getModel()).clear();
        this.txtBank.setText("");
        this.txtLowerLimit.setText("");
    }
}
