package section4.item17;

// 코드 17-1 불변 복소수 클래스 (106-107쪽)
public final class Complex {
    private final double re;
    private final double im;

    // 변경되지 않는 객체라면 상수로 사용해도 된다.
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart()      { return re; }
    public double imaginaryPart() { return im; }

    // 본인이 갖고있는 필드를 새로운 인스턴스를 만들어서 return 해줌 >> 변경하지않음
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    // 코드 17-2 정적 팩터리(private 생성자와 함께 사용해야 한다.) (110-111쪽)
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        // == 대신 compare를 사용하는 이유는 63쪽을 확인하라.
        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }
    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
