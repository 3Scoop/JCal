
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;

public class JCal {

    JTextField calc;

    private String nums;
    private String num1S;
    private String num2S;
    private int num1;
    private int num2;
    private String inp;
    private int finalNum;
    private boolean hasEquals;
    private boolean hasNum;

    public static void main(String[] args) {
        JCal gui = new JCal();
        gui.go();
    }//end main

    private void findNum(String type) {

        num1S = inp.substring( 0, inp.indexOf(type));
        num2S = inp.substring(inp.indexOf(type)+1);
        num1 = Integer.parseInt(num1S);
        num2 = Integer.parseInt(num2S);

    } //end findNum

    public void calculate() {
        if(inp.contains("+")) {

            findNum("+");

            finalNum = num1 + num2;
            calc.setText("" + finalNum);
        } if (inp.contains("-")) {

            findNum("-");

            finalNum = num1 - num2;
            calc.setText("" + finalNum);

        }//end if
        if (inp.contains("*")) {

            findNum("*");

            finalNum = num1 * num2;
            calc.setText("" + finalNum);
        }//end if
        if (inp.contains("/")) {

            findNum("/");

            finalNum = num1 / num2;
            calc.setText("" + finalNum);
        }//end if
    } // end calculate

    public void go() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panelI = new JPanel();
        JPanel panelE = new JPanel();
        JPanel numPanel = new JPanel();
        calc = new JTextField(20);
        Font calcFont = new Font("Consolas",Font.BOLD,70);
        Font symFont = new Font("Consolas",Font.BOLD,100);
        Font numFont = new Font("Consolas",Font.BOLD,150);
        Color symColor = new Color(247, 152, 68);

        calc.setFont(symFont);

        JButton clear = new JButton("Clear");
        clear.setFont(calcFont);
        clear.addActionListener(new clearListener());
        clear.setBackground(new Color(244, 71, 65));

        JButton equals = new JButton(" = ");
        equals.setFont(symFont);
        equals.addActionListener(new calculatorListener());
        equals.setBackground(new Color(69, 122, 247));
        JButton divide = new JButton("/");
        divide.setFont(symFont);
        divide.addActionListener(new symbolListener());
        divide.setBackground(symColor);
        JButton multiply = new JButton("*");
        multiply.setFont(symFont);
        multiply.addActionListener(new symbolListener());
        multiply.setBackground(symColor);
        JButton minus = new JButton("-");
        minus.setFont(symFont);
        minus.addActionListener(new symbolListener());
        minus.setBackground(symColor);
        JButton add = new JButton("+");
        add.setFont(symFont);
        add.addActionListener(new symbolListener());
        add.setBackground(symColor);

        frame.getContentPane().add(BorderLayout.NORTH,calc);
        calc.setBackground(new Color(66, 244, 155));

        for(int i = 1; i < 10; i++) {
            nums = "" + i;
            JButton num = new JButton(nums);
            num.addActionListener(new listener());
            num.setFont(numFont);
            num.setBackground(Color.gray);
            numPanel.add(num);
        } //end for
        JButton zero = new JButton("0");
        zero.setFont(numFont);
        zero.addActionListener(new listener());
        zero.setBackground(Color.gray);
        numPanel.add(zero);
        numPanel.setBackground(Color.darkGray);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(panelI);
        panelI.add(clear);
        panelI.setBackground(Color.darkGray);
        panel.add(divide);
        panel.add(multiply);
        panel.add(minus);
        panel.add(add);
        panel.add(panelE);
        panelE.add(equals);
        panelE.setBackground(Color.darkGray);
        panel.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.getContentPane().add(BorderLayout.CENTER,numPanel);
        frame.setSize(700,935);
        frame.setVisible(true);
    } //end go

    class clearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            finalNum = 0;
            hasNum = false;
            hasEquals = false;
            calc.setText("");
        }//end actionPerformed
    } //end clearListener


    class calculatorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            inp = calc.getText();
            calculate();
            hasEquals = true;
        }//end actionPerformed
    }//end calculatorListener

    class symbolListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();

            if(hasNum) {
                inp = calc.getText();
                calculate();
                String calcNum = "" + finalNum;
                calc.setText(calcNum);
                hasNum = false;
            } if(hasEquals) {
                String calcNum = "" + finalNum;
                calc.setText(calcNum);
                hasEquals = false;
            }
            if (source instanceof JButton) {
                JButton btn = (JButton)source;
                String butSrcTxt = btn.getText();
                calc.setText(calc.getText() + butSrcTxt);
                hasNum = true;
            }
        }
    }

    class listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(hasEquals == true) {
                String calcNum = "" + finalNum;
                calc.setText(calcNum);
                hasEquals = false;
            }
            if (source instanceof JButton) {
                JButton btn = (JButton)source;
                String butSrcTxt = btn.getText();
                calc.setText(calc.getText() + butSrcTxt);
                //hasNum = true;
            }//end if

        }//end actionPerformed
    }//end listener
}//end calculator
