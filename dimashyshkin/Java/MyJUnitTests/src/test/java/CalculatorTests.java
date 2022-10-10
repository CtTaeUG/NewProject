import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTests {

    private CalculatorDemo calculatorDemo;

    @BeforeAll
    public static void setupClass(){
        System.out.println("Setup class");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Setup test");
        calculatorDemo = new CalculatorDemo();
    }

    public static double[][] data(){ // data provider
        return new double[][] {{0,1,1}, {-1.5, 1.5,0},{2.5, 3.5, 6}};
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void addTest (double[] data) {
        double a = data[0];
        double b = data[1];
        double expected = data[2];
        double result = calculatorDemo.add(a, b);
        Assertions.assertEquals(expected, result, "Calculator sum is not expected");
    }

    //@Disabled("Diasbled until bug #99 has been fixed")
    @Test
    public void multiplyTest() {
        double resultMultiply = calculatorDemo.multiply(2.5, 3.2);
        Assertions.assertEquals(8, resultMultiply, "Multiply is not expected");
    }

    @AfterEach
    public void teardown(){
        System.out.println("Tear down test");
    }

    @AfterAll
    public static void teardownClass(){
        System.out.println("Tear down class");
    }
}
