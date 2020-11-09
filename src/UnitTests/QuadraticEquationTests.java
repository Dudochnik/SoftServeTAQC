package UnitTests;

import Tasks.QuadraticEquation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuadraticEquationTests {
    static QuadraticEquation quadraticEquationPositive, quadraticEquationZero, quadraticEquationNegative;

    @BeforeClass
    public static void createQuadraticEquationInstance() {
        quadraticEquationPositive = new QuadraticEquation(4, 5, 1);
        quadraticEquationZero = new QuadraticEquation(2, 4, 2);
        quadraticEquationNegative = new QuadraticEquation(5, 2, 2);
    }

    @Test
    public void testQuadraticEquationsRoots() {
        Assert.assertEquals("-0.25", quadraticEquationPositive.getFirstRoot().toString());
        Assert.assertEquals("-1", quadraticEquationPositive.getSecondRoot().toString());

        Assert.assertEquals("-1", quadraticEquationZero.getFirstRoot().toString());
        Assert.assertEquals("-1", quadraticEquationZero.getSecondRoot().toString());

        Assert.assertEquals("-0.2+0.6i", quadraticEquationNegative.getFirstRoot().toString());
        Assert.assertEquals("-0.2-0.6i", quadraticEquationNegative.getSecondRoot().toString());
    }
}
