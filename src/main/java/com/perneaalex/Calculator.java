package com.perneaalex;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class Calculator {
    int boardWidth = 360;
    int boardHeight = 540;
    Color customColor1 = new Color(212, 212,210);
    Color customColor2 = new Color(80,80,80);
    Color customColor3 = new Color(28,28,28);
    Color customColor4 = new Color(255,149,0);

    JFrame frame = new JFrame("SimpleMath");

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightButtons = {"÷", "×", "-", "+", "="};
    String[] topButtons = {"AC", "+/-", "%"};

    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String a = "0";
    String b = null;
    String operator = null;
    boolean newNumber = false;

    Calculator(){
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(customColor2);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(customColor3);
        buttonsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.add(buttonsPanel, BorderLayout.CENTER);
        for(int i = 0; i < buttonValues.length; i++){

            JButton button = new JButton();
            String buttonVal = buttonValues[i];
            button.setFont(new Font("Times New Roman", Font.BOLD, 30));
            button.setText(buttonVal);
            button.setFocusable(false);

            if(Arrays.asList(topButtons).contains(buttonVal)){
                button.setBackground(customColor1);
                button.setForeground(Color.black);
            } else if(Arrays.asList(rightButtons).contains(buttonVal)){
                button.setBackground(customColor2);
                button.setForeground(Color.black);
            } else{
                button.setBackground(customColor3);
                button.setForeground(Color.black);
            }

            buttonsPanel.add(button);
            button.addActionListener(e -> handleButtonClick(buttonVal));
        }

        try {
            frame.setIconImage(ImageIO.read(new File("src/main/resources/Icon.jpg")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        frame.setVisible(true);
    }

    void handleButtonClick(String buttonVal){
        if(Arrays.asList(topButtons).contains(buttonVal)){
            handleTop(buttonVal);
        } else if(Arrays.asList(rightButtons).contains(buttonVal)){
            handleRight(buttonVal);
        } else{
            handleNum(buttonVal);
        }
    }

    void handleTop(String buttonVal){
        switch(buttonVal){
            case "AC":
                clearAll();
                displayLabel.setText("0");
                break;
            case "+/-":
                toggleSign();
                break;
            case "%":
                percentageSign();
                break;
        }
    }

    void toggleSign() {
        String text = displayLabel.getText();
        if (!text.equals("0")) {
            if (text.startsWith("-")) {
                displayLabel.setText(text.substring(1));
            } else {
                displayLabel.setText("-" + text);
            }
        }
        if (operator == null) {
            a = displayLabel.getText();
        } else {
            b = displayLabel.getText();
        }
    }

    String formatNumber(double num) {
        if (num == (long) num) {
            return String.format("%d", (long) num);
        } else {
            return String.format("%.2f", num);
        }
    }

    void percentageSign() {
        double value = Double.parseDouble(displayLabel.getText()) / 100;
        displayLabel.setText(formatNumber(value));
        if (operator == null) {
            a = String.valueOf(value);
        } else {
            b = String.valueOf(value);
        }
    }

    void handleRight(String buttonVal) {
        if (buttonVal.equals("=")) {
            if (operator != null) {
                double result = performOperation();
                displayLabel.setText(formatNumber(result));
                a = String.valueOf(result);
                b = null;
                operator = null;
                newNumber = true;
            }
        } else if (buttonVal.equals("√")) {
            operator = "√";
            newNumber = true;
        } else {
            if (operator == null) {
                operator = buttonVal;
                newNumber = true;
            }
        }
    }


    double performOperation() {
        double num1 = Double.parseDouble(a);
        double num2 = (b != null) ? Double.parseDouble(b) : 0;

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "×":
                return num1 * num2;
            case "÷":
                if(num2 != 0){
                    return num1 / num2;
                }
            case "√":
                if (num1 >= 0) {
                    return Math.sqrt(num1);
                } else {
                    displayLabel.setText("Err");
                    return 0;
                }
            default:
                return 0;
        }
    }

    void handleNum(String buttonVal){
        if (newNumber) {
            displayLabel.setText(buttonVal);
            newNumber = false;
        } else {
            if (displayLabel.getText().equals("0")) {
                displayLabel.setText(buttonVal);
            } else {
                displayLabel.setText(displayLabel.getText() + buttonVal);
            }
        }

        if (operator == null) {
            a = displayLabel.getText();
        } else {
            b = displayLabel.getText();
        }
    }

    void clearAll(){
        a = "0";
        operator = null;
        b = null;
    }
}

