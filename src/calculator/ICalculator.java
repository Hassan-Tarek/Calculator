package calculator;

public interface ICalculator {

    /**
     * take input from user
     */
    void input(String input);

    /**
     * return the result of the current operation or throw a runtime exception
     */
    String getResult();

    /**
     * return the current operation
     */
    String getCurrent();

    /**
     * return the prev operation or Null if no prev operation exist then update current
     */
    String prev();

    /**
     * return the next operation or Null if no next operation exist then update current
     */
    String next();

    /**
     * save in a file the last 10 operations
     */
    void save();

    /**
     * load from the file the saved operations
     */
    void load();

}