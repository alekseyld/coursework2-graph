package com.alekseyld.ui.plotframe;

import com.alekseyld.ui.plotframe.controls.ButtonPanel;
import com.alekseyld.ui.plotframe.controls.ButtonPanelPresenter;
import com.alekseyld.ui.plotframe.graph.GraphPanel;
import com.alekseyld.ui.plotframe.graph.GraphPanelPresenter;
import com.alekseyld.ui.plotframe.helper.TablePanel;
import com.alekseyld.ui.plotframe.helper.TablePanelPresenter;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PlotFrame extends Frame {

    private final int FONT_SIZE = 11;

    public PlotFrame(int xF, int yF, int wF, int hF) {
        setTitle("График функции");
        setBounds(xF, yF, wF, hF);
        setBackground(Color.GRAY);
        setLayout(null);

        Font f = new Font("Aria", Font.BOLD, FONT_SIZE);
        setFont(f);

        setUpMVP(wF, hF);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setResizable(false);
        setVisible(true);
    }

    private void setUpMVP(int wF, int hF) {
        ButtonPanelPresenter buttonPanelPresenter = new ButtonPanelPresenter();
        GraphPanelPresenter graphPanelPresenter = new GraphPanelPresenter();
        TablePanelPresenter tablePanelPresenter = new TablePanelPresenter();

        ButtonPanel buttonPanel = new ButtonPanel(buttonPanelPresenter,6, 25, wF/4, hF-30);
        buttonPanelPresenter.setView(buttonPanel);
        add(buttonPanel);

        GraphPanel graphPanel = new GraphPanel(graphPanelPresenter,wF/4+10, 25, 3*wF/4-15, hF-120, buttonPanel);
        graphPanelPresenter.setView(graphPanel);
        add(graphPanel);

        TablePanel tablePanel = new TablePanel(tablePanelPresenter, wF/4+10, hF-90, 3*wF/4-15, 85);
        tablePanelPresenter.setView(tablePanel);
        add(tablePanel);
    }
}
