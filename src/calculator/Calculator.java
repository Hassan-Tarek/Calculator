package calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * the logic of the calculator application
 */
public class Calculator implements ICalculator {

    private final Deque<String> history = new LinkedList<>();
    private final Stack<String> next = new Stack<>();

    @Override
    public void input(String input) {
        if(history.size() >= 10) {
            history.removeFirst();
        }
        history.addLast(input);
    }

    @Override
    public String getResult() {
        String current = getCurrent();

        double operand1 = 0;
        String operator = "";
        double operand2 = 0;

        Pattern p1 = Pattern.compile("\\d+[.]\\d+|\\d+|-\\d+[.]\\d|-\\d+");
        Pattern p2 = Pattern.compile("[+-÷×t%]");

        Matcher m1 = p1.matcher(current);
        Matcher m2 = p2.matcher(current);

        boolean b1 = m1.find();
        if(b1)
            operand1 = Double.parseDouble(m1.group());

        boolean b2 = m2.find(m1.end());
        if(b2)
            operator = m2.group();

        boolean b3 = m1.find(m2.end());
        if(b3)
            operand2 = Double.parseDouble(m1.group());

        System.out.println(operand1 + operand2);
        String result;
        result = switch (operator) {
            case "+" -> String.valueOf(operand1 + operand2);
            case "-" -> String.valueOf(operand1 - operand2);
            case "×" -> String.valueOf(operand1 * operand2);
            case "÷" -> String.valueOf(operand1 / operand2);
            case "%" -> String.valueOf(operand1 % operand2);
            default -> null;
        };
        return result;
    }

    @Override
    public String getCurrent() {
        return history.getLast();
    }

    @Override
    public String prev() {
        if(!history.isEmpty()) {
            next.push(history.getLast());
            history.removeLast();

            if(history.isEmpty())
                return null;
            else
                return history.getLast();
        }
        return null;
    }

    @Override
    public String next() {
        if(next.isEmpty())
            return null;
        history.addLast(next.pop());
        return history.getLast();
    }

    @Override
    public void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"));
            // the values of history
            writer.write("History:\n");
            for (String s : history) {
                writer.write(s + "\n");
            }

            // the values of next stack
            writer.write("Next:\n");
            for (String s : next){
                writer.write(s + "\n");
            }

            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
            String line;
            boolean flag = false;
            history.clear();
            next.clear();
            while((line = reader.readLine()) != null){
                if(line.equals("History:") || line.equals("Next:")){
                    if(line.equals("Next:"))
                        flag = true;
                    continue;
                }

                if(!flag){
                    history.addLast(line);
                }
                else{
                    next.push(line);
                }
            }

            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}