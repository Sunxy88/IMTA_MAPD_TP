package xin.xisx.MAPD.TP2;

public class UndefinedRationalException extends RuntimeException {

    public UndefinedRationalException() {
        super("The denominator is 0");
    }
}
