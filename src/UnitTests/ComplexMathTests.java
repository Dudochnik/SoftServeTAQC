package UnitTests;

import Tasks.ComplexMath;
import Tasks.ComplexNumber;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComplexMathTests {

    static ComplexNumber complexNumberFirst, complexNumberSecond, complexNumberThird, complexNumberFourth, complexNumberFullZero;

    @BeforeClass
    public static void createComplexNumberInstance() {
        complexNumberFirst = new ComplexNumber(5.5, -2.4);
        complexNumberSecond = new ComplexNumber(-1.6, 1.7);
        complexNumberThird = new ComplexNumber(3.8);
        complexNumberFourth = new ComplexNumber(0, 4.5);
        complexNumberFullZero = new ComplexNumber(0);
    }

    @Test
    public void sumOfTwoComplexNumberIsCorrect() {
        Assert.assertEquals(new ComplexNumber(3.9, -0.7), ComplexMath.add(complexNumberFirst, complexNumberSecond));
        Assert.assertEquals(new ComplexNumber(3.9, -0.7), ComplexMath.add(complexNumberSecond, complexNumberFirst));
    }
    @Test
    public void differenceOfTwoComplexNumberIsCorrect() {
        Assert.assertEquals(new ComplexNumber(7.1, -4.1), ComplexMath.subtract(complexNumberFirst, complexNumberSecond));
        Assert.assertEquals(new ComplexNumber(-7.1, 4.1), ComplexMath.subtract(complexNumberSecond, complexNumberFirst));
    }
    @Test
    public void productOfTwoComplexNumberIsCorrect() {
        Assert.assertEquals(new ComplexNumber(-4.72, 13.19), ComplexMath.multiply(complexNumberFirst, complexNumberSecond));
        Assert.assertEquals(new ComplexNumber(-4.72, 13.19), ComplexMath.multiply(complexNumberSecond, complexNumberFirst));
        Assert.assertEquals(new ComplexNumber(20.9, -9.12), ComplexMath.multiply(complexNumberFirst, complexNumberThird));
        Assert.assertEquals(new ComplexNumber(10.8, 24.75), ComplexMath.multiply(complexNumberFirst, complexNumberFourth));
        Assert.assertEquals(new ComplexNumber(0), ComplexMath.multiply(complexNumberFirst, complexNumberFullZero));
        Assert.assertEquals(new ComplexNumber(0), ComplexMath.multiply(complexNumberFullZero, complexNumberFirst));
    }
    @Test
    public void quotientOfTwoComplexNumberIsCorrect() {
        Assert.assertEquals(new ComplexNumber(-12.88/5.45, -5.51/5.45), ComplexMath.divide(complexNumberFirst, complexNumberSecond));
        Assert.assertEquals(new ComplexNumber(0), ComplexMath.divide(complexNumberFullZero, complexNumberFirst));
        Assert.assertNotEquals(new ComplexNumber(Double.NaN, Double.NaN), ComplexMath.divide(complexNumberFirst, complexNumberFullZero));
        Assert.assertNotEquals(new ComplexNumber(0), ComplexMath.divide(complexNumberFirst, complexNumberFullZero));
    }

    @Test
    public void testReciprocal() {
        Assert.assertEquals(new ComplexNumber(5.5, 2.4), ComplexMath.getReciprocal(complexNumberFirst));
    }
}
