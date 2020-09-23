package xin.xisx.MAPD.TP1;

public class Rational {

    private Integer numerator;
    private Integer denominator;

    /**
     * Euclidean algorithm to get the greatest common divisor
     * @param i1
     * @param i2
     * @return the greatest common divisor
     */
    private Integer gcd(int i1, int i2) {
        while (i2 != 0) {
            int t = i2;
            i2 = i1 % i2;
            i1 = t;
        }
        return i1;
    }

    /**
     * Reduction of a fraction
     */
    private void reduce() {
        if (numerator == null || denominator == null)
            return;
        Integer g = gcd(numerator, denominator);
        if (g == 0)
            return;
        numerator /= g;
        denominator /= g;
        if (denominator < 0 && numerator >= 0) {
            denominator = - denominator;
            numerator = - numerator;
        }
    }

    public Rational() {}

    public Rational(Integer numerator, Integer denominator) {
        this.numerator = new Integer(numerator);
        this.denominator = new Integer(denominator);
        reduce();
    }

    /**
     * The add of two rationals
     * @param r
     * @return A new result rational
     */
    public Rational add(Rational r) {
        Rational res = new Rational();
        if (r.getDenominator().equals(this.denominator)) {
            res.setDenominator(r.denominator);
            res.setNumerator(this.numerator + r.numerator);
        }
        else {
            res.setDenominator(r.denominator * this.denominator);
            res.setNumerator(r.denominator * this.numerator + this.denominator + r.numerator);
        }
        return res;
    }

    /**
     * The subtract of two rationals
     * @param r
     * @return A new result rational
     */
    public Rational sub(Rational r) {
        Rational tmp = new Rational();
        tmp.setNumerator(-r.getNumerator());
        tmp.setDenominator(r.getDenominator());
        return add(tmp);
    }

    /**
     * The multiply of two rationals
     * @param r
     * @return A new result rational
     */
    public Rational multiply(Rational r) {
        Rational res = new Rational();
        res.setDenominator(this.denominator * r.getDenominator());
        res.setNumerator(this.numerator * r.getNumerator());
        return res;
    }

    /**
     * The division of two rationals
     * @param r
     * @return A new result rational
     */
    public Rational divideBy(Rational r) {
        Rational tmp = new Rational();
        tmp.setNumerator(r.getDenominator());
        tmp.setDenominator(r.getNumerator());
        return multiply(tmp);
    }

    // Setter and getter
    public Integer getNumerator() {
        return numerator;
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
        reduce();
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
        reduce();
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rational rational = (Rational) o;

        if (!getNumerator().equals(rational.getNumerator())) return false;
        return getDenominator().equals(rational.getDenominator());
    }

    @Override
    public int hashCode() {
        int result = getNumerator().hashCode();
        result = 31 * result + getDenominator().hashCode();
        return result;
    }
}
