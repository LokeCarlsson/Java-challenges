package lc222ak_assign1;


public class FractionMain {
    public void main() throws Error {
        Fraction frac = new Fraction(-3, -4);
        System.out.println("Is equal?: " + frac.isEqualTo(new Fraction(3, 4)));
        System.out.println("Is negative?: " + frac.isNegative(new Fraction(3, 4)));
        System.out.println("Get decimal: " + frac.getDecimal(new Fraction(3, 4)));
        System.out.println("To string: : " + frac.toString());
        System.out.println("Get numerator: " + frac.getNumerator());
        System.out.println("Get denominator: " + frac.getDenominator());
        System.out.println("Add: " + frac.add(new Fraction(2, 5)));
        System.out.println("Subtract: " + frac.subtract(new Fraction(2, 5)));
        System.out.println("Multiply: " + frac.multiply(new Fraction(2, 5)));
        System.out.println("Divide: " + frac.divide(new Fraction(2, 5)));
    }
}
