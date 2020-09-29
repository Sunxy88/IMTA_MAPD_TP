package xin.xisx.MAPD.TP2;

import xin.xisx.MAPD.TP1.Rational;

public class WithPGCD extends Rational {

    private Integer pgcd;

    public WithPGCD() {
        super();
    }

    public WithPGCD(Integer numerator, Integer denominator) {
        super(numerator, denominator);
        pgcd = gcd(numerator, denominator);
        reduce();
    }

    public WithPGCD(Rational r) {
        this(r.getNumerator(), r.getDenominator());
    }

    /*
    Question 2.3
        1. public Rational sum(Rational r) throws UndefinedRational, Exception
            This signature can not override Rational sum(Rational) function in Rational class because
            this signature throws a wider exception.
        2. public WithPGCD sum(WithPGCD r) throws UndefinedRational
            This signature could be declared but it is not a override because the arguments list is different
        3. public WithPGCD sum(Rational r ) throws UndefinedRational
            This signature could override because the return type is a subclass of the return type in superclass.
        4. public Object sum(WithPGCD r) throws UndefinedRational
            This This signature could override because the return type is not a subclass of
            the return type in superclass.
        5. public Object sum(WithPGCD r) throws UndefinedRational
            It could be done. This is not an override but an overload.
        6. public Object sum(WithPGCD r, Object o) throws UndefinedRational
            It could be done. This is not an override but an overload.
     */

    @Override
    public WithPGCD add(Rational r) {
        Rational res = super.add(r);

        return new WithPGCD(res);
    }

    @Override
    public WithPGCD sub(Rational r) {
        Rational res = super.sub(r);
        return new WithPGCD(res);
    }

    @Override
    public WithPGCD multiply(Rational r) {
        Rational res = super.multiply(r);
        return new WithPGCD(res);
    }

    @Override
    public WithPGCD divideBy(Rational r) {
        Rational res = super.divideBy(r);
        return new WithPGCD(res);
    }

    @Override
    public void setNumerator(Integer numerator) {
        super.setNumerator(numerator);
        reduce();
    }

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
        if (numerator == null || super.denominator == null)
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

    @Override
    public String toString() {
        return "WithPGCD{" +
                "pgcd=" + pgcd +
                ", numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
