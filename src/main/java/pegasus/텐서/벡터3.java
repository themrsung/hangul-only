package pegasus.텐서;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * 3차원 벡터를 나타냅니다.
 */
public class 벡터3 implements Serializable {
    /**
     * 해당 클래스의 시리얼 버전 UID입니다.
     */
    @Serial
    private static final long serialVersionUID = 0;

    /**
     * 이 벡터의 엑스 값입니다.
     */
    protected final double 엑스;

    /**
     * 이 벡터의 와이 값입니다.
     */
    protected final double 와이;

    /**
     * 이 벡터의 제트 값입니다.
     */
    protected final double 제트;

    /**
     * 새로운 벡터를 생성합니다.
     * @param 엑스 벡터의 엑스 값
     * @param 와이 벡터의 와이 값
     * @param 제트 벡터의 제트 값
     */
    public 벡터3(double 엑스, double 와이, double 제트) {
        this.엑스 = 엑스;
        this.와이 = 와이;
        this.제트 = 제트;
    }

    /**
     * 이 벡터의 엑스 값을 반환합니다.
     * @return 이 벡터의 엑스 값
     */
    public double 엑스() {
        return 엑스;
    }

    /**
     * 이 벡터의 와이 값을 반환합니다.
     * @return 이 벡터의 와이 값
     */
    public double 와이() {
        return 와이;
    }

    /**
     * 이 벡터의 제트 값을 반환합니다.
     * @return 이 벡터의 제트 값
     */
    public double 제트() {
        return 제트;
    }

    /**
     * 이 벡터의 제곱 크기를 반환합니다.
     * @return 이 벡터의 제곱 크기
     */
    public double 크기제곱() {
        return 엑스 * 엑스 + 와이 * 와이 + 제트 * 제트;
    }

    /**
     * 이 벡터의 크기를 반환합니다. 제곱근 메서드가 호촐됩니다.
     * @return 이 벡터의 크기
     */
    public double 크기() {
        return Math.sqrt(크기제곱());
    }

    /**
     * 이 벡터의 맨해튼 크기를 반환합니다.
     * @return 이 벡터의 맨해튼 크기
     */
    public double 맨해튼크기() {
        return Math.abs(엑스) + Math.abs(와이)
    }

    /**
     * 이 벡터의 해시코드를 반환합니다.
     * @return 이 벡터의 해시코드
     */
    @Override
    public int hashCode() {
        return Objects.hash(엑스, 와이, 제트);
    }

    /**
     * 이 벡터와 주어진 오브젝트 {@code 오브젝트}를 비교한 뒤, 두 오브젝트가 일치할 경우 {@code true}를,
     * 두 오브젝트가 일치하지 않을 경우 {@code false}를 반환합니다.
     * @param 오브젝트 이 벡터와 비교할 오브젝트
     * @return 주어진 오브젝트가 이 벡터와 일치할 경우 {@code true}, 그렇지 않을 경우 {@code false}
     */
    @Override
    public boolean equals(Object 오브젝트) {
        if (!(오브젝트 instanceof 벡터3 벡터)) return false;
        return 엑스 == 벡터.엑스 && 와이 == 벡터.와이 && 제트 == 벡터.제트;
    }

    /**
     * 이 벡터를 문자열로 나타낸 값을 반환합니다.
     * @return 이 벡터를 문자열로 나타낸 값
     */
    @Override
    public String toString() {
        return "[" + 엑스 + ", " + 와이 + ", " + 제트 + "]";
    }
}
