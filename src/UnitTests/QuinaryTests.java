package UnitTests;

import Tasks.Quinary;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuinaryTests {
    static Quinary first, second, third, fourth, fifth;
    static double tolerance = 0.00000001;

    @BeforeClass
    public static void createQuinaryInstances() {
        first = new Quinary(9);
        second = new Quinary(-9);
        third = new Quinary(-9.4);
        fourth = new Quinary("-1.4");
        fifth = new Quinary("-1.5");
    }

    @Test
    public void checkQuinaryValues() {
        Assert.assertEquals("14", first.toString());
        Assert.assertEquals("-14", second.toString());
        Assert.assertEquals("-14.2", third.toString());
        Assert.assertEquals("-1.4", fourth.toString());
        Assert.assertNotEquals("-1.5", fifth.toString());
    }

    @Test
    public void checkQuinaryToDecimalConvertation() {
        Assert.assertEquals(9, first.getDecimal(), tolerance);
        Assert.assertEquals(-9, second.getDecimal(), tolerance);
        Assert.assertEquals(-9.4, third.getDecimal(), tolerance);
        Assert.assertEquals(-1.8, fourth.getDecimal(), tolerance);
        Assert.assertEquals(-1.8, fourth.getDecimal(), tolerance);
        Assert.assertEquals(0, fifth.getDecimal(), tolerance);
    }
}
