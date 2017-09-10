package lc222ak_assign1;

public class Fraction {
    private int N;
    private int D;

    Fraction(int N, int D) {
        if(N == 0) {
            throw new IllegalArgumentException("Numerator must not be zero or negative!");
        } else if(D == 0) {
            throw new IllegalArgumentException("Denominator must not be zero or negative!");
        } else {
            this.N = N;
            this.D = D;
        }
    }

    int getNumerator() {
        return N;
    }

    int getDenominator() {
        return D;
    }

    boolean isNegative(Fraction fraction) {
        return getDecimal(fraction) < 0;
    }

    double getDecimal(Fraction fraction) {
        return ((double) fraction.N) / fraction.D;
    }

    Fraction add(Fraction fraction) {
        int newN = (this.N*fraction.D) + (fraction.N*this.D);
        int newD = (this.D*fraction.D);
        return new Fraction(newN, newD);
    }

    Fraction subtract(Fraction fraction) {
        int newN = (this.N*fraction.D) - (fraction.N*this.D);
        int newD = (this.D*fraction.D);
        return new Fraction(newN, newD);
    }

    Fraction multiply(Fraction fraction) {
        int newN = (this.N*fraction.N);
        int newD = (this.D*fraction.D);
        return new Fraction(newN, newD);
    }

    Fraction divide(Fraction fraction) {
        int newN = (this.N*fraction.D);
        int newD = (this.D*fraction.N);
        return new Fraction(newN, newD);
    }

    boolean isEqualTo(Fraction fraction) {
        return getDecimal(fraction) == getDecimal(this);
    }

    public String toString() {
        return String.valueOf(new StringBuilder().append(this.N).append("/").append(this.D));
    }
}
