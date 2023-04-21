package calculator;

/**
 * the controller class
 */
public class Controller {

    private final ICalculator calc;
    private final MainFrame gui;

    private boolean hasOperator;

    /**
     * controller constructor
     * @param gui gui instance
     * @param calc calc instance
     */
    public Controller(MainFrame gui, ICalculator calc) {
        this.gui = gui;
        this.calc = calc;
        hasOperator = false;
    }

    /**
     * control method
     */
    public void control() {

        for(int i = 0; i <= 9; i++) {
            final int curBtn = i;
            gui.getButtonList().get(i).addActionListener(e -> {
                // clear the result label text
                gui.getResLbl().setText("");

                String text = gui.getCurLbl().getText();
                if(text.equals("0"))
                    text = "";

                text += String.valueOf(curBtn);
                gui.getCurLbl().setText(text);
            });

        }

        gui.getPlusMinus().addActionListener(e -> {
            String text =gui.getCurLbl().getText();

            if(hasOperator) {
                StringBuilder newText = new StringBuilder();
                StringBuilder operand = new StringBuilder();

                boolean beforeOperator = true;
                for(int i = 0; i < text.length(); i++) {
                    if(beforeOperator)
                        newText.append(text.charAt(i));

                    if(!beforeOperator)
                        operand.append(text.charAt(i));

                    if(isOperator(text.charAt(i))) {
                        if (i != 0) {
                            beforeOperator = false;
                        }
                    }
                }

                if(operand.charAt(0) == '-')
                    operand = new StringBuilder(operand.substring(1));
                else if(operand.charAt(0) == '+') {
                    operand = new StringBuilder(operand.substring(1));
                    operand.insert(0, '-');
                }
                else
                    operand.insert(0, '-');

                newText.append(operand);
                text = newText.toString();
            }
            else if(!text.isEmpty()){
                if(text.charAt(0) == '-')
                    text = text.substring(1);
                else if(text.charAt(0) == '+') {
                    text = text.substring(1);
                    text = '-' + text;
                }
                else
                    text = '-' + text;
            }
            gui.getCurLbl().setText(text);
        });

        gui.getPlus().addActionListener(e->{
            if(!hasOperator) {
                String text = gui.getCurLbl().getText();

                // check if the cur label is empty then check the res
                if (text.equals("")) {
                    if (!gui.getResLbl().getText().equals("")) {
                        text = gui.getResLbl().getText();
                    }
                }
                text += '+';
                gui.getResLbl().setText("");
                gui.getCurLbl().setText(text);
                hasOperator = true;
            }
        });

        gui.getMinus().addActionListener(e -> {
            if(!hasOperator) {
                String text = gui.getCurLbl().getText();

                // check if the cur label is empty then check the res
                if (text.equals("")) {
                    if (!gui.getResLbl().getText().equals("")) {
                        text = gui.getResLbl().getText();
                    }
                }
                text += '-';
                gui.getResLbl().setText("");
                gui.getCurLbl().setText(text);
                hasOperator = true;
            }
        });

        gui.getMul().addActionListener(e -> {
            if(!hasOperator) {
                String text = gui.getCurLbl().getText();

                // check if the cur label is empty then check the res
                if (text.equals("")) {
                    if (!gui.getResLbl().getText().equals("")) {
                        text = gui.getResLbl().getText();
                    }
                }
                text += "×";
                gui.getResLbl().setText("");
                gui.getCurLbl().setText(text);
                hasOperator = true;
            }
        });

        gui.getDiv().addActionListener(e -> {
            if(!hasOperator) {
                String text = gui.getCurLbl().getText();

                // check if the cur label is empty then check the res
                if (text.equals("")) {
                    if (!gui.getResLbl().getText().equals("")) {
                        text = gui.getResLbl().getText();
                    }
                }
                text += '÷';
                gui.getResLbl().setText("");
                gui.getCurLbl().setText(text);
                hasOperator = true;
            }
        });

        gui.getMod().addActionListener(e -> {
            if(!hasOperator) {
                String text = gui.getCurLbl().getText();

                // check if the cur label is empty then check the res
                if (text.equals("")) {
                    if (!gui.getResLbl().getText().equals("")) {
                        text = gui.getResLbl().getText();
                    }
                }
                text += '%';
                gui.getResLbl().setText("");
                gui.getCurLbl().setText(text);
                hasOperator = true;
            }
        });

        gui.getEqual().addActionListener(e -> {
            if(hasOperator) {
                // check if last char is digit or not
                String text = gui.getCurLbl().getText();
                if(Character.isDigit(text.charAt(text.length() - 1))) {
                    calc.input(text);
                    String result = calc.getResult();

                    // set text of the result label test to text
                    gui.getResLbl().setText(result);
                    // clear the current label text
                    gui.getCurLbl().setText("");

                    // control the history textarea
                    if(gui.getHistory().getLineCount() > 26) {
                        // clear the history textarea
                        gui.getHistory().setText("");

                        String str = "          ";
                        str += "History";
                        gui.getHistory().append("\n\n\n");
                        gui.getHistory().append(str);
                        gui.getHistory().append("\n\n");

                    }

                    gui.getHistory().append("     " + text + "=" + result + "\n\n");

                    hasOperator = false;
                }
            }
        });

        gui.getDot().addActionListener(e -> {
            String text = gui.getCurLbl().getText();

            if(text.equals("")) {
                text = "0.";
            }
            else {
                if(isOperator(text.charAt(text.length() - 1))) {
                    text += "0.";
                }
                else{
                    text += '.';
                }
            }

            gui.getResLbl().setText("");
            gui.getCurLbl().setText(text);
        });

        gui.getDelete().addActionListener(e -> {
            String text = gui.getCurLbl().getText();
            if(!text.isEmpty()) {
                if(Character.isDigit(text.charAt(text.length() - 1))) {
                    text = text.substring(0, text.length()-1);
                }
            }
            gui.getCurLbl().setText(text);
        });

        gui.getClear().addActionListener(e -> {
            String text = "";
            gui.getCurLbl().setText(text);
            gui.getResLbl().setText(text);
        });

        gui.getClearCur().addActionListener(e -> {
            String text = gui.getCurLbl().getText();
            if(hasOperator) {
                boolean afterOperator = false;
                int index = text.length();
                for(int i = 0; i < text.length(); i++) {
                    if(afterOperator) {
                        index = i;
                        break;
                    }

                    if(isOperator(text.charAt(i))) {
                        afterOperator = true;
                    }
                }
                text = text.substring(0, index);
            }
            else {
                text = "";
            }
            gui.getCurLbl().setText(text);
        });

        gui.getNext().addActionListener(e -> {
            String next = calc.next();

            if(next != null) {
                gui.getCurLbl().setText(next);
                gui.getResLbl().setText(calc.getResult());
            }
        });

        gui.getPrev().addActionListener(e -> {
            String prev = calc.prev();

            if(prev != null) {
                gui.getCurLbl().setText(prev);
                gui.getResLbl().setText(calc.getResult());
            }
        });

        gui.getSave().addActionListener(e -> calc.save());

        gui.getLoad().addActionListener(e -> calc.load());

    }

    /**
     * check if the char is operator or not
     * @param c char
     * @return true if the char is operator false otherwise
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷' || c == '%';
    }

}