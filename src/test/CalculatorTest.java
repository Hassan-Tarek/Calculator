package test;

import calculator.Calculator;
import calculator.ICalculator;
import org.junit.Assert;

import java.io.File;

public class CalculatorTest {

    @org.junit.Test
    public void testGetResultWithSumOperator() {
        ICalculator calc = new Calculator();
        calc.input("55+45");
        String result = calc.getResult();

        Assert.assertEquals(result, "100.0");
    }

    @org.junit.Test
    public void testGetResultWithSubOperator() {
        ICalculator calc = new Calculator();
        calc.input("55-45");
        String result = calc.getResult();

        Assert.assertEquals(result, "10.0");
    }

    @org.junit.Test
    public void testGetResultWithMultipleOperator() {
        ICalculator calc = new Calculator();
        calc.input("55×45");
        String result = calc.getResult();

        Assert.assertEquals(result, "2475.0");
    }

    @org.junit.Test
    public void testGetResultWithDivOperator() {
        ICalculator calc = new Calculator();
        calc.input("55÷10");
        String result = calc.getResult();

        Assert.assertEquals(result, "5.5");
    }

    @org.junit.Test
    public void testGetResultWitModSOperator() {
        ICalculator calc = new Calculator();
        calc.input("55%45");
        String result = calc.getResult();

        Assert.assertEquals(result, "10.0");
    }

    @org.junit.Test
    public void testPrev() {
        ICalculator calc = new Calculator();
        calc.input("55-5");
        calc.input("55+5");
        calc.input("55*5");
        calc.input("55/5");

        String result = calc.prev();

        Assert.assertEquals(result, "55*5");
    }

    @org.junit.Test
    public void testNext() {
        ICalculator calc = new Calculator();
        calc.input("55-5");
        calc.input("55+5");
        calc.input("55*5");
        calc.input("55/5");

        calc.prev();
        String result = calc.next();

//        Assert.assertNull(result);
        Assert.assertEquals(result, "55/5");
    }

    @org.junit.Test
    public void testSave() {
        ICalculator calc = new Calculator();
        calc.input("55-5");
        calc.input("55+5");
        calc.input("55*5");
        calc.input("55/5");

        calc.prev();

        calc.save();
        Assert.assertTrue((new File("save.txt")).exists());
    }

    @org.junit.Test
    public void testLoad() {
        ICalculator calc = new Calculator();

        calc.load();
        String result = calc.getCurrent();

        Assert.assertEquals(result, "55*5");
    }

}