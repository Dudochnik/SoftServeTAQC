package UnitTests;

import Tasks.ComplexNumber;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ComplexNumberTests {

    static double a = -5.3, b = 10.11111111;
    static final double tolerance = .00001;
    static ComplexNumber complexNumberNonZeroImaginary, complexNumberZeroImaginary, complexNumberNegativeImaginary, complexNumberZeroReal;

    @BeforeClass
    public static void createComplexNumberInstance() {
        complexNumberNonZeroImaginary = new ComplexNumber(a, b);
        complexNumberZeroImaginary = new ComplexNumber(2);
        complexNumberNegativeImaginary = new ComplexNumber(2.5, -7.8);
        complexNumberZeroReal = new ComplexNumber(0, 5);
    }

    @Test
    public void constructorsMustAssignPropertiesAndReturnCorrectValues() {
        Assert.assertEquals("Real part must be -5.3", a, complexNumberNonZeroImaginary.getReal(), tolerance);
        Assert.assertEquals("Imaginary part must be 10.11111111", b, complexNumberNonZeroImaginary.getImaginary(), tolerance);
        Assert.assertEquals("Real part must be 2", 2, complexNumberZeroImaginary.getReal(), tolerance);
        Assert.assertEquals("Imaginary part must be 0", 0, complexNumberZeroImaginary.getImaginary(), tolerance);
    }

    @Test
    public void toStringReturnsCorrectValue() {
        Assert.assertEquals("-5.3+10.11111111i", complexNumberNonZeroImaginary.toString());
        Assert.assertEquals("2", complexNumberZeroImaginary.toString());
        Assert.assertEquals("2.5-7.8i", complexNumberNegativeImaginary.toString());
        Assert.assertEquals("5i", complexNumberZeroReal.toString());
    }

}
