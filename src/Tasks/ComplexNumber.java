package Tasks;

public class ComplexNumber {

    private double real, imaginary;
    final double eps = 0.0000001;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public ComplexNumber add(ComplexNumber second) {
        return ComplexMath.add(this, second);
    }

    public ComplexNumber subtract(ComplexNumber second) {
        return ComplexMath.subtract(this, second);
    }

    public ComplexNumber multiply(ComplexNumber second) {
        return ComplexMath.multiply(this, second);
    }

    public ComplexNumber divide(ComplexNumber second) {
        return ComplexMath.divide(this, second);
    }

    @Override
    public String toString() {
        if (Double.isNaN(this.real) || Double.isNaN(this.imaginary))
            return "NaN";
        String result = "";
        if (real != 0)
            if ((real == Math.floor(real)) && !Double.isInfinite(real))
                result += (int)real;
            else
                result += real;

        if (imaginary != 0) {
            if (imaginary > 0 && real != 0)
                result += "+";
            if ((imaginary == Math.floor(imaginary)) && !Double.isInfinite(imaginary))
                result += (int)imaginary;
            else
                result += imaginary;
            result += "i";
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        ComplexNumber complexNumber = (ComplexNumber)obj;
        if (Math.abs(this.real-complexNumber.getReal())<eps && Math.abs(this.imaginary-complexNumber.getImaginary())<eps)
            return true;
        return false;
    }

    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }
}
