package com.alekseyld.ui.plotframe.helper;

import com.alekseyld.model.Coordinates;
import com.alekseyld.ui.base.view.AbstractViewPanel;
import com.alekseyld.ui.plotframe.helper.interfaces.ITablePanelPresenter;
import com.alekseyld.ui.plotframe.helper.interfaces.ITablePanelView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Map;

public class TablePanel extends AbstractViewPanel<ITablePanelPresenter> implements ITablePanelView {

    private Label headerLabel;

    private JTable table;

    private TableModel tableModel;

    public TablePanel(ITablePanelPresenter presenter, int x, int y, int wH, int hH) {
        super(presenter);

        setBackground(Color.LIGHT_GRAY);
        setBounds(x, y, wH, hH);
        setLayout(null);

        headerLabel = new Label("Таблица значений", Label.CENTER);
        headerLabel.setBounds(0,0,wH, 20);
        add(headerLabel);

        tableModel = new TableModel();
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoCreateColumnsFromModel(true);
        table.setTableHeader(null);
        table.setBounds(5, 20, wH - 10, 60);

        JScrollPane scrollPane =  new JScrollPane(table);

        scrollPane.setBounds(5, 20, wH - 10, 60);

        add(scrollPane);
    }

    private void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 60; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setWidth(width);
        }
    }

    @Override
    public void updateTable(Coordinates coordinates) {
        tableModel.setCoord(coordinates.getCoordinates());
    }

    private class TableModel extends AbstractTableModel {

        Map<Double, Double> coord;

        public void setCoord(Map<Double, Double> coord) {
            this.coord = coord;

            fireTableStructureChanged();
            fireTableDataChanged();
            resizeColumnWidth(table);
        }

        @Override
        public int getRowCount() {
            return 2;
        }

        @Override
        public int getColumnCount() {
            if (coord == null)
                return 0;

            return coord.keySet().size() + 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                if (rowIndex == 0) {
                    return "X";
                } else {
                    return "Y";
                }
            }

            if (rowIndex == 0) {
                return coord.keySet().toArray()[columnIndex - 1].toString();
            } else {
                return coord.values().toArray()[columnIndex - 1].toString();
            }
        }
    }

    private String genTable(Map<Double, Double> map) {


        StringBuilder sb = new StringBuilder();

        Double[] xarray = new Double[map.keySet().size()];
        map.keySet().toArray(xarray);

        Double[] yarray = new Double[map.values().size()];
        map.values().toArray(yarray);

        for (int x = 0; x < 2; x++) {
            if (x == 0) {
                sb.append("X |");
            } else {
                sb.append("Y |");
            }

            for (int y = 0; y < map.keySet().size(); y++) {

                if (x == 0) {
                    sb.append("  ").append(xarray[y]).append("\t\t|");
                } else {
                    sb.append("  ");

                    String ystring = String.format("%.4f", yarray[y]);
                    sb.append(yarray[y]);

//                    if (yarray.length < 13) {
//                        sb.append("\t");
//                    }
                    sb.append("\t\t|");
                }
            }
            if (x != 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
