package Tasks;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quinary {
    private ArrayList<Byte> floor = new ArrayList<Byte>(), fractional = new ArrayList<Byte>();
    private boolean isPositive = true;

    public Quinary(double number) {
        if (number < 0)
            isPositive = false;
        int floor = Math.abs((int)number);
        double fractional = Math.abs(number) - floor;
        findFloor(floor);
        findFractional(fractional);
    }

    public Quinary(String number) {
        Pattern pattern = Pattern.compile("^(|-)[0-4]+(|[.][0-4]*)$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches())
            return;
        if (number.charAt(0) == '-') {
            isPositive = false;
            number = number.replace("-", "");
        }
        String[] parts = number.split("\\.");
        for (char c : parts[0].toCharArray())
            floor.add((byte)Character.getNumericValue(c));
        for (char c : parts[1].toCharArray())
            fractional.add((byte)Character.getNumericValue(c));
    }

    @Override
    public String toString() {
        String string = "";
        for (int i : floor)
            string += i;
        if (fractional.size() > 0)
            string += ".";
        for (int i : fractional)
            string += i;
        if (!isPositive)
            string = "-"+string;
        return string;
    }

    private void findFloor(int n) {
        while (n > 0) {
            floor.add(0, (byte)(n % 5));
            n = n / 5;
        }
    }

    private void findFractional(double next) {
        if (fractional.size() > 10) {
            while (fractional.get(fractional.size()-1) == 0)
                fractional.remove(fractional.size()-1);
            return;
        }
        double newFractional = next * 5;
        double fractionalPart = newFractional - (int)newFractional;
        if (fractionalPart == 0)
            return;
        fractional.add((byte)newFractional);
        findFractional(fractionalPart);
    }

    public double getDecimal() {
        double decimalFloor = 0, decimalFractional = 0;
        int power = floor.size()-1;
        for (int i : floor)
            decimalFloor += i * Math.pow(5, power--);
        for (int i : fractional)
            decimalFractional += i * Math.pow(5, power--);
        double newDecimal =  decimalFloor + decimalFractional;
        if (!isPositive)
            return -newDecimal;
        return newDecimal;
    }
}
