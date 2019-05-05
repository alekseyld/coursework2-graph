package com.alekseyld.ui.plotframe.controls;

import com.alekseyld.model.GraphParams;
import com.alekseyld.ui.base.view.AbstractViewPanel;
import com.alekseyld.ui.plotframe.controls.interfaces.IButtonPanelPresenter;
import com.alekseyld.ui.plotframe.controls.interfaces.IButtonPanelView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import static com.alekseyld.model.GraphParams.GraphColors.*;
import static com.alekseyld.model.GraphParams.GridColors.*;

public class ButtonPanel extends AbstractViewPanel<IButtonPanelPresenter> implements IButtonPanelView {

    private Label[] labels;

    private CheckboxGroup checkboxGroup;
    private Checkbox[] checkboxes;
    private Checkbox needGridCheckboxes;

    private Choice gridColorChoice;

    private TextField fromTextField;

    private TextField intervalTextField;

    private Button buttonSave;
    private Button buttonLoad;
    private Button buttonClose;

    private TextField paramTextField;

    private final int FONT_SIZE = 12;

    private boolean isUpdating;

    public ButtonPanel(IButtonPanelPresenter presenter, int xP, int yP, int wP, int hP) {
        super(presenter);

        setLayout(null);
        setBounds(xP, yP, wP, hP);
        setBackground(Color.LIGHT_GRAY);

        labels = new Label[6];

        SetUpColorsPickers(wP);

        SetUpParameterPickers(wP);

        SetUpButtons(wP, hP);
    }

    @Override
    public boolean isUpdating() {
        return isUpdating;
    }

    @Override
    public void setGraphParams(GraphParams graphParams) {
        isUpdating = true;

        for (Checkbox cb: checkboxes) {
            if(cb.getLabel().equals(
                    graphParams.getGraphColorEnum().getName())
            ) {
                checkboxGroup.setSelectedCheckbox(cb);
                break;
            }
        }

        gridColorChoice.select(graphParams.getGridColorEnum().getName());

        needGridCheckboxes.setState(graphParams.isNeedGrid());
        paramTextField.setText(Double.toString(graphParams.getParamA()));
        intervalTextField.setText(Double.toString(graphParams.getIntervalTo()));

        isUpdating = false;
    }

    private void SetUpButtons(int wP, int hP) {
        buttonSave = new Button("Сохранить");
        buttonLoad = new Button("Открыть");
        buttonClose = new Button("Закрыть");

        buttonSave.setBounds(5, hP - 115, wP - 10, 30);
        buttonLoad.setBounds(5, hP - 75, wP - 10, 30);
        buttonClose.setBounds(5, hP - 35, wP - 10, 30);

        buttonClose.addActionListener(e -> System.exit(0));

        buttonLoad.addActionListener(this::onLoadButtonListener);
        buttonSave.addActionListener(this::onSaveButtonListener);

        add(buttonSave);
        add(buttonLoad);
        add(buttonClose);
    }

    private void SetUpParameterPickers(int wP) {
        labels[4] = new Label("График функции y(x)=a^x", Label.CENTER);
        labels[4].setFont(new Font("Aria", Font.BOLD, FONT_SIZE));
        labels[4].setBounds(5,  190, wP - 10, 30);
        add(labels[4]);

        labels[1] = new Label("Интервал по X: ", Label.CENTER);
        labels[1].setFont(new Font("Aria", Font.BOLD, FONT_SIZE));
        labels[1].setBounds(5,  220, wP - 10, 30);
        add(labels[1]);

        labels[2] = new Label("От x= ", Label.LEFT);
        labels[2].setFont(new Font("Aria", Font.BOLD, FONT_SIZE));
        labels[2].setBounds(5,  250, 75, 20);
        add(labels[2]);

        labels[5] = new Label("До x= ", Label.LEFT);
        labels[5].setFont(new Font("Aria", Font.BOLD, FONT_SIZE));
        labels[5].setBounds(5,  275, 75, 20);
        add(labels[5]);

        fromTextField = new TextField("0");
        fromTextField.setBounds(80, 250, 60, 20);

        fromTextField.addTextListener(e -> {

            Double result = parseDoubleAndShowError(fromTextField.getText(), 100000,
                    "стартового x");

            if (result != null) {

                if (result > mPresenter.getIntervalTo()) {
                    showError("Стартовое значение не может быть больше максимального");
                    fromTextField.setText(Double.toString(mPresenter.getIntervalFrom()));
                } else {
                    mPresenter.intervalFromChanged(result);
                }

            } else {
                if (fromTextField.getText().equals("-")) return;

                fromTextField.setText("");
            }
        });

        add(fromTextField);

        intervalTextField = new TextField("10");
        intervalTextField.setBounds(80, 275, 60, 20);

        intervalTextField.addTextListener(e -> {

            Double result = parseDoubleAndShowError(intervalTextField.getText(), 100000,
                    "максимального x");

            if (result != null) {
                if (result < mPresenter.getIntervalFrom()) {
                    showError("Максимального значение не может быть меньше стартового");
                    intervalTextField.setText(Double.toString(mPresenter.getIntervalTo()));
                } else {
                    mPresenter.intervalToChanged(result);
                }
            } else {
                if (intervalTextField.getText().equals("-")) return;

                intervalTextField.setText("");
            }
        });

        add(intervalTextField);

        labels[3] = new Label("Параметр а = ", Label.CENTER);
        labels[3].setFont(new Font("Aria", Font.BOLD, FONT_SIZE));
        labels[3].setBounds(5,  300, 90, 20);
        add(labels[3]);

        paramTextField = new TextField("2");
        paramTextField.setBounds(90, 300, 55, 20);

        paramTextField.addTextListener(e -> {
            Double result = parseDoubleAndShowError(paramTextField.getText(), 100000,
                    "параметра а");

            if (result != null) {
                mPresenter.paramAChanged(result);
            } else {
                if (paramTextField.getText().equals("-")) return;

                paramTextField.setText("");
            }
        });

        add(paramTextField);
    }

    private Double parseDoubleAndShowError(String doubleValue, int max, String nameForError) {
        if (doubleValue.equals("") || doubleValue.equals("-"))
            return null;

        try {
            double d = Double.valueOf(doubleValue);

            if (Math.abs(d) >= max) {
                showError("Превышен предел значения " + nameForError);
                return null;
            }

            return d;

        } catch (NumberFormatException ex) {
            showError("Некорректное значение " + nameForError);
            return null;
        }
    }

    private void showError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage);
    }

    private void SetUpColorsPickers(int wP) {
        labels[0] = new Label("Выбор цвета: ", Label.CENTER);
        labels[0].setFont(new Font("Aria", Font.BOLD, FONT_SIZE));
        labels[0].setBounds(5, 5, wP - 10, 30);
        add(labels[0]);

        ItemListener graphColorListener = e -> {

            GraphParams.GraphColors graphColor = null;

            if (checkboxes[0].getState()) {
                graphColor = RED;
            } else if (checkboxes[1].getState()) {
                graphColor = BLUE;
            } else if (checkboxes[2].getState()) {
                graphColor = BLACK;
            }

            mPresenter.graphColorChanged(graphColor);
        };

        checkboxGroup = new CheckboxGroup();
        checkboxes = new Checkbox[3];
        checkboxes[0] = new Checkbox(RED.getName(), checkboxGroup, true);
        checkboxes[1] = new Checkbox(BLUE.getName(), checkboxGroup, false);
        checkboxes[2] = new Checkbox(BLACK.getName(), checkboxGroup, false);
        needGridCheckboxes = new Checkbox(" сетка ",true);

        for (int i = 0; i < 3; i++){
            checkboxes[i].setBounds(5, 30 + i * 25, wP - 10, 30);
            checkboxes[i].addItemListener(graphColorListener);
            add(checkboxes[i]);
        }

        needGridCheckboxes.setBounds(5, 30 + 3 * 25, wP - 10, 30);
        needGridCheckboxes.addItemListener(e -> {
            mPresenter.needGridChanged(needGridCheckboxes.getState());
        });
        add(needGridCheckboxes);

        gridColorChoice = new Choice();
        gridColorChoice.add(GREEN.getName());
        gridColorChoice.add(YELLOW.getName());
        gridColorChoice.add(GREY.getName());
        gridColorChoice.setBounds(20, 140, wP - 25, 30);

        gridColorChoice.addItemListener(e -> {
            gridColorChoice.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
            mPresenter.gridColorChanged(GraphParams.GridColors.getEnumByName(gridColorChoice.getSelectedItem()));
        });

        add(gridColorChoice);
    }

    private JFileChooser getFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("Открыть график");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("График", "gph");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        return fileChooser;
    }

    private void onLoadButtonListener(ActionEvent e) {
        JFileChooser fileChooser = getFileChooser();

        int ret = fileChooser.showDialog(null, "Открыть график");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            mPresenter.loadGraph(file);
        }
    }

    private void onSaveButtonListener(ActionEvent e) {
        JFileChooser fileChooser = getFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int ret = fileChooser.showDialog(null, "Сохранить");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            file = new File(file.toString() + ".gph");
            mPresenter.saveGraph(file);
        }
    }

}
