package test;

import devmind.MathService;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathServiceTest {
    private static MathService mathService;
    private final Integer INVALID_DIVIDEND = 0;
    private final Integer NEUTRAL_DIVIDEND = 1;
    private final Integer NEGATIVE_NEUTRAL_DIVIDEND = -1;

    @BeforeClass
    public static void globalSetUp() {
        mathService = new MathService();
    }

    @Before("testDivideNumberBy_withNegativeNeutralDividend_expectNegatedValue")
    public void setUp() {
        mathService.setNumber(10);
    }

    @Test
    public void testDivideNumberBy_withNegativeNeutralDividend_expectNegatedValue() {
        Assert.assertEquals((mathService.getNumber()*(-1)), mathService.divideNumberBy(NEGATIVE_NEUTRAL_DIVIDEND).intValue());

        mathService.setNumber(2);
        Assert.assertEquals((mathService.getNumber()*(-1)), mathService.divideNumberBy(NEGATIVE_NEUTRAL_DIVIDEND).intValue());
    }

    @Test
    public void testDivideNumberBy_withNeutralDividend_expectTheSameValue() {
        Assert.assertEquals(mathService.getNumber(), mathService.divideNumberBy(NEUTRAL_DIVIDEND));

        mathService.setNumber(2);
        Assert.assertEquals(mathService.getNumber(), mathService.divideNumberBy(NEUTRAL_DIVIDEND));

        mathService.setNumber(3);
        Assert.assertEquals(mathService.getNumber(), mathService.divideNumberBy(NEUTRAL_DIVIDEND));
    }

    @Test
    public void testDivideNumberBy_withRegularDividend() {
        mathService.setNumber(6);
        Assert.assertEquals(2, mathService.divideNumberBy(3).intValue());
    }

    @Test(expected=ArithmeticException.class)
    public void testDivideNumberBy_withInvalidDividend() {
        Assert.assertEquals(mathService.getNumber(), mathService.divideNumberBy(INVALID_DIVIDEND));
    }
}
