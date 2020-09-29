package xin.xisx.MAPD.TP1;

import xin.xisx.MAPD.TP2.UndefinedRationalException;

public class Rational extends Number {

    protected Integer numerator;
    protected Integer denominator;


    public Rational() {
        throw new UndefinedRationalException();
    }

    public Rational(Integer numerator, Integer denominator) {
        if (denominator == 0)
            throw new UndefinedRationalException();
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * To test override in WithPGCD class.
     * @param r
     * @return
     * @throws UndefinedRationalException
     */
    public Rational sum(Rational r) throws UndefinedRationalException {
        return add(r);
    }

    /**
     * The add of two rationals
     * @param r
     * @return A new result rational
     */
    public Rational add(Rational r) {
        Rational res = new Rational(0, 1);
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
        Rational tmp = new Rational(0, 1);
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
        Rational res = new Rational(0, 1);
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
        Rational tmp = new Rational(0, 1);
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
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    @Override
    public int intValue() {
        return (int) longValue();
    }

    @Override
    public long longValue() {
        return Math.round((0.0 + numerator) / (0.0 + denominator));
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (0.0 + numerator) / (0.0 + denominator);
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
