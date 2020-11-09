package Tasks;

public class ComplexMath {

    public static ComplexNumber add(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(
                first.getReal() + second.getReal(),
                first.getImaginary() + second.getImaginary());
    }

    public static ComplexNumber subtract(ComplexNumber first, ComplexNumber second) {
        return ComplexMath.add(first, new ComplexNumber(-second.getReal(), -second.getImaginary()));
    }

    public static ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(
                first.getReal() * second.getReal() - first.getImaginary() * second.getImaginary(),
                first.getImaginary() * second.getReal() + first.getReal() * second.getImaginary());
    }

    public static ComplexNumber divide(ComplexNumber first, ComplexNumber second) {
        double divisor = second.getReal() * second.getReal() + second.getImaginary() * second.getImaginary();
        ComplexNumber auxiliaryMultiplied = ComplexMath.multiply(first , ComplexMath.getReciprocal(second));
        return new ComplexNumber(auxiliaryMultiplied.getReal() / divisor, auxiliaryMultiplied.getImaginary() / divisor);
    }

    public static ComplexNumber getReciprocal(ComplexNumber number) {
        return new ComplexNumber(number.getReal(), -number.getImaginary());
    }
}
