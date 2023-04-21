package calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

public class MainFrame extends JFrame {

    private static JLabel curLbl;
    private static JLabel resLbl;
    private static JTextArea history;

    private static final List<JButton> buttonList = new LinkedList<>();
    private static JButton plusMinus;
    private static JButton plus;
    private static JButton minus;
    private static JButton mul;
    private static JButton div;
    private static JButton mod;
    private static JButton equal;
    private static JButton dot;
    private static JButton clear;
    private static JButton clearCur;
    private static JButton delete;
    private static JButton next;
    private static JButton prev;
    private static JButton save;
    private static JButton load;

    private static final int FRAME_WIDTH = 660;
    private static final int FRAME_HEIGHT = 615;

    public static MainFrame initialize() {
        return new MainFrame();
    }

    private MainFrame() {

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.setBorder(null);
        panel.setLayout(null);

        // create labels
        curLbl = new JLabel("0");
        int PANEL_WIDTH = 451;
        curLbl.setBounds(0, 50, PANEL_WIDTH, 70);
        curLbl.setForeground(Color.WHITE);
        curLbl.setBackground(Color.DARK_GRAY);
        curLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        curLbl.setFont(new Font("Serif", Font.PLAIN, 36));
        curLbl.setOpaque(true);

        resLbl = new JLabel("");
        resLbl.setBounds(0, 0, PANEL_WIDTH, 70);
        resLbl.setForeground(Color.WHITE);
        resLbl.setBackground(Color.DARK_GRAY);
        resLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        resLbl.setFont(new Font("Serif", Font.PLAIN, 36));
        resLbl.setOpaque(true);

        // create buttons
        // number buttons

        for(int i = 0; i <= 9; i++) {
            buttonList.add(new JButton(String.valueOf(i)));
            buttonList.get(i).setFocusable(false);
            buttonList.get(i).setBackground(Color.BLACK);
            buttonList.get(i).setForeground(Color.WHITE);
            buttonList.get(i).setFont(new Font("SansSerif", Font.PLAIN, 30));
            buttonList.get(i).setOpaque(false);
        }

        // seven
        buttonList.get(7).setBounds(90, 225, 80, 80);

        // eight
        buttonList.get(8).setBounds(180, 225, 80, 80);

        // nine
        buttonList.get(9).setBounds(270, 225, 80, 80);

        // four
        buttonList.get(4).setBounds(90, 315, 80, 80);

        // five
        buttonList.get(5).setBounds(180, 315, 80, 80);

        // six
        buttonList.get(6).setBounds(270, 315, 80, 80);

        // one
        buttonList.get(1).setBounds(90, 405, 80, 80);

        // two
        buttonList.get(2).setBounds(180, 405, 80, 80);

        // three
        buttonList.get(3).setBounds(270, 405, 80, 80);

        // zero
        buttonList.get(0).setBounds(180, 495, 80, 80);

        plusMinus = new JButton("±");
        plusMinus.setFocusable(false);
        plusMinus.setBackground(Color.BLACK);
        plusMinus.setForeground(Color.WHITE);
        plusMinus.setFont(new Font("SansSerif", Font.PLAIN, 30));
        plusMinus.setOpaque(true);
        plusMinus.setBounds(90, 495, 80, 80);

        plus = new JButton("+");
        plus.setFocusable(false);
        plus.setBackground(new Color(35, 35, 35));
        plus.setForeground(Color.WHITE);
        plus.setFont(new Font("SansSerif", Font.PLAIN, 30));
        plus.setOpaque(true);
        plus.setBounds(360, 405, 80, 80);

        minus = new JButton("-");
        minus.setFocusable(false);
        minus.setBackground(new Color(35, 35, 35));
        minus.setForeground(Color.WHITE);
        minus.setFont(new Font("SansSerif", Font.PLAIN, 30));
        minus.setOpaque(true);
        minus.setBounds(360, 315, 80, 80);

        mul = new JButton("×");
        mul.setFocusable(false);
        mul.setBackground(new Color(35, 35, 35));
        mul.setForeground(Color.WHITE);
        mul.setFont(new Font("SansSerif", Font.PLAIN, 30));
        mul.setOpaque(true);
        mul.setBounds(360, 225, 80, 80);

        div = new JButton("÷");
        div.setFocusable(false);
        div.setBackground(new Color(35, 35, 35));
        div.setForeground(Color.WHITE);
        div.setFont(new Font("SansSerif", Font.PLAIN, 30));
        div.setOpaque(true);
        div.setBounds(360, 135, 80, 80);

        mod = new JButton("%");
        mod.setFocusable(false);
        mod.setBackground(new Color(35, 35, 35));
        mod.setForeground(Color.WHITE);
        mod.setFont(new Font("SansSerif", Font.PLAIN, 30));
        mod.setOpaque(true);
        mod.setBounds(0, 495, 80, 80);

        equal = new JButton("=");
        equal.setFocusable(false);
        equal.setBackground(new Color(72,61,139));
        equal.setForeground(Color.WHITE);
        equal.setFont(new Font("SansSerif", Font.PLAIN, 30));
        equal.setOpaque(true);
        equal.setBounds(360, 495, 80, 80);

        dot = new JButton(".");
        dot.setFocusable(false);
        dot.setBackground(Color.BLACK);
        dot.setForeground(Color.WHITE);
        dot.setFont(new Font("SansSerif", Font.PLAIN, 30));
        dot.setOpaque(true);
        dot.setBounds(270, 495, 80, 80);

        delete = new JButton("⌫");
        delete.setFocusable(false);
        delete.setBackground(new Color(35, 35, 35));
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("SansSerif", Font.PLAIN, 30));
        delete.setOpaque(true);
        delete.setBounds(270, 135, 80, 80);

        clear = new JButton("C");
        clear.setFocusable(false);
        clear.setBackground(new Color(35, 35, 35));
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("SansSerif", Font.PLAIN, 18));
        clear.setOpaque(true);
        clear.setBounds(180, 135, 80, 80);

        clearCur = new JButton("CE");
        clearCur.setFocusable(false);
        clearCur.setFocusable(false);
        clearCur.setBackground(new Color(35, 35, 35));
        clearCur.setForeground(Color.WHITE);
        clearCur.setFont(new Font("SansSerif", Font.PLAIN, 18));
        clearCur.setOpaque(true);
        clearCur.setBounds(90, 135, 80, 80);

        next = new JButton("Next");
        next.setFocusable(false);
        next.setBackground(new Color(35, 35, 35));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("SansSerif", Font.PLAIN, 18));
        next.setOpaque(true);
        next.setBounds(0, 135, 80, 80);

        prev = new JButton("Prev");
        prev.setFocusable(false);
        prev.setBackground(new Color(35, 35, 35));
        prev.setForeground(Color.WHITE);
        prev.setFont(new Font("SansSerif", Font.PLAIN, 18));
        prev.setOpaque(true);
        prev.setBounds(0, 225, 80, 80);

        save = new JButton("Save");
        save.setFocusable(false);
        save.setBackground(new Color(35, 35, 35));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("SansSerif", Font.PLAIN, 18));
        save.setOpaque(true);
        save.setBounds(0, 315, 80, 80);

        load = new JButton("Load");
        load.setFocusable(false);
        load.setBackground(new Color(35, 35, 35));
        load.setForeground(Color.WHITE);
        load.setFont(new Font("SansSerif", Font.PLAIN, 18));
        load.setOpaque(true);
        load.setBounds(0, 405, 80, 80);

//         add the buttons & labels to the panel
        panel.add(curLbl);
        panel.add(resLbl);

        for(int i = 0; i <= 9; i++) {
            panel.add(buttonList.get(i));
        }

        panel.add(plus);
        panel.add(plusMinus);
        panel.add(minus);
        panel.add(mul);
        panel.add(div);
        panel.add(mod);
        panel.add(equal);
        panel.add(dot);

        panel.add(delete);
        panel.add(clear);
        panel.add(clearCur);
        panel.add(next);
        panel.add(prev);
        panel.add(save);
        panel.add(load);

        history = new JTextArea(25, 15);
        String text = "          ";
        text += "History";
        history.append("\n\n\n");
        history.append(text);
        history.append("\n\n");
        history.setEnabled(false);
        history.setForeground(Color.LIGHT_GRAY);
        history.setBackground(Color.DARK_GRAY);
        history.setOpaque(true);
        history.setBorder(null);
        history.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        // add history textarea to the panel
        add(history, BorderLayout.EAST);

        // add panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);

    }

    public JLabel getCurLbl() {
        return curLbl;
    }

    public JLabel getResLbl() {
        return resLbl;
    }

    public JTextArea getHistory() {
        return history;
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }

    public JButton getPlusMinus() {
        return plusMinus;
    }

    public JButton getPlus() {
        return plus;
    }

    public JButton getMinus() {
        return minus;
    }

    public JButton getMul() {
        return mul;
    }

    public JButton getDiv() {
        return div;
    }

    public JButton getMod() {
        return mod;
    }

    public JButton getEqual() {
        return equal;
    }

    public JButton getDot() {
        return dot;
    }

    public JButton getClear() {
        return clear;
    }

    public JButton getClearCur() {
        return clearCur;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getPrev() {
        return prev;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getLoad() {
        return load;
    }
}