package calculator;

import javax.swing.JFrame;
import java.awt.EventQueue;

/**
 * the Runner class
 * @author hassan
 */
public class Runner {
    /**
     * launch the application
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(()->{
            try {
                MainFrame frame = MainFrame.initialize();
                ICalculator calculator = new Calculator();

                frame.setTitle("Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setResizable(false);

                Controller controller = new Controller(frame, calculator);
                controller.control();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

    }
}