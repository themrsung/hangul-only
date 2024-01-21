package pegasus.텐서;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 */
public class 벡터3 implements Serializable {
    @Serial
    private static final long serialVersionUID = 0;

    protected final double 엑스;
    protected final double 와이;
    protected final double 제트;

    public 벡터3(double 엑스, double 와이, double 제트) {
        this.엑스 = 엑스;
        this.와이 = 와이;
        this.제트 = 제트;
    }

    public double 엑스() {
        return 엑스;
    }

    public double 와이() {
        return 와이;
    }

    public double 제트() {
        return 제트;
    }
}
