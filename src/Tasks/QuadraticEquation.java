package Tasks;

public class QuadraticEquation {

    private double a, b, c;
    private ComplexNumber x1, x2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        double discriminant = b*b-4*a*c;

        if (discriminant > 0) {
            double discriminantRoot = Math.sqrt(discriminant);
            x1 = new ComplexNumber((-b + discriminantRoot)/(2 * a));
            x2 = new ComplexNumber((-b - discriminantRoot)/(2 * a));
        }
        else if (discriminant == 0) {
            x1 = x2 = new ComplexNumber(-b/(2*a));
        }
        else {
            double discriminantRoot = Math.sqrt(Math.abs(discriminant));
            double real = -b/(2*a);
            double imaginary = discriminantRoot/(2*a);
            x1 = new ComplexNumber(real, imaginary);
            x2 = ComplexMath.getReciprocal(x1);
        }
    }

    public ComplexNumber getFirstRoot() {
        return x1;
    }
    public ComplexNumber getSecondRoot() {
        return x2;
    }
}
