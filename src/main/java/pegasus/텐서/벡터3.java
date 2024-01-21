package pegasus.텐서;

import java.io.Serial;
import java.util.Objects;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

import pegasus.오류.영으로나누기오류;
import pegasus.유틸리티.오브젝트들;

/**
 * 3차원 벡터를 나타냅니다.
 */
public class 벡터3 implements 벡터<벡터3> {
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
     * 이 벡터가 영인지 검토한 후, 그 여부를 반환합니다. 정확히 영({@code == 0})인 경우에만 해당합니다.
     * @return 이 벡터가 영인지 여부
     */
    @Override
    public boolean 영인가() {
        return 엑스 == 0 && 와이 == 0 && 제트 == 0;
    }

    /**
     * 이 벡터에 숫자가 아닌 값({@code NaN})이 포함되어 있는지 검토한 후, 그 여부를 반환합니다.
     * @return 이 벡터가 숫자가 아닌지 여부
     */
    @Override
    public boolean 숫자가아닌가() {
        return Double.isNaN(엑스) || Double.isNaN(와이) || Double.isNaN(제트);
    }

    /**
     * 이 벡터가 {@link Double#isFinite(double) 유한한지} 검토한 후, 그 여부를 반환합니다.
     * @return 이 벡터가 유한한지 여부
     */
    @Override
    public boolean 유한한가() {
        return Double.isFinite(엑스) && Double.isFinite(와이) && Double.isFinite(제트);
    }

    /**
     * 이 벡터가 {@link Double#isInfinite(double) 무한한지} 검토한 후, 그 여부를 반환합니다.
     * @return 이 벡터가 무한한지 여부
     */
    @Override
    public boolean 무한한가() {
        return Double.isInfinite(엑스) || Double.isInfinite(와이) || Double.isInfinite(제트);
    }

    /**
     * 이 벡터의 제곱 크기를 반환합니다.
     * @return 이 벡터의 제곱 크기
     */
    @Override
    public double 크기제곱() {
        return 엑스 * 엑스 + 와이 * 와이 + 제트 * 제트;
    }

    /**
     * 이 벡터의 크기를 반환합니다. 제곱근 메서드가 호촐됩니다.
     * @return 이 벡터의 크기
     */
    @Override
    public double 크기() {
        return Math.sqrt(크기제곱());
    }

    /**
     * 이 벡터의 맨해튼 크기를 반환합니다.
     * @return 이 벡터의 맨해튼 크기
     */
    @Override
    public double 맨해튼크기() {
        return Math.abs(엑스) + Math.abs(와이) + Math.abs(제트);
    }

    /**
     * 이 벡터에 주어진 스케일러 {@code 스케일러}를 더한 뒤, 그 결과를 반환합니다.
     * @param 스케일러 이 벡터에 더할 스케일러
     * @return 벡터-스케일러 덧셈의 결과
     */
    @Override
    public 벡터3 더하기(double 스케일러) {
        return new 벡터3(엑스 + 스케일러, 와이 + 스케일러, 제트 + 스케일러);
    }

    /**
     * 이 벡터에서 주어진 스케일러 {@code 스케일러}를 뺀 뒤, 그 결과를 반환합니다.
     * @param 스케일러 이 벡터에서 뺄 스케일러
     * @return 벡터-스케일러 뺄셈의 결과
     */
    @Override
    public 벡터3 빼기(double 스케일러) {
        return new 벡터3(엑스 - 스케일러, 와이 - 스케일러, 제트 - 스케일러);
    }

    /**
     * 이 벡터를 주어진 스케일러 {@code 스케일러}와 곱한 뒤, 그 결과를 반환합니다.
     * @param 스케일러 이 벡터와 곱할 스케일러
     * @return 벡터-스케일러 곱셈의 결과
     */
    @Override
    public 벡터3 곱하기(double 스케일러) {
        return new 벡터3(엑스 * 스케일러, 와이 * 스케일러, 제트 * 스케일러);
    }

    /**
     * 이 벡터를 주어진 스케일러 {@code 스케일러}로 나눈 뒤, 그 결과를 반환합니다.
     * @param 스케일러 이 벡터를 나눌 스케일러
     * @return 벡터-스케일러 나눗셈의 결과
     * @throws 영으로나누기오류 {@code 0}으로 나누기를 시도할 경우
     */
    @Override
    public 벡터3 나누기(double 스케일러) throws 영으로나누기오류 {
        if (스케일러 == 0) throw new 영으로나누기오류();
        var 역수 = 1 / 스케일러;

        return new 벡터3(엑스 * 역수, 와이 * 역수, 제트 * 역수);
    }

    /**
     * 이 벡터와 주어진 벡터를 더한 뒤, 그 결과를 반환합니다.
     * @param 벡 이 벡터와 더할 벡터
     * @return 벡터-벡터 덧셈의 결과
     */
    @Override
    public 벡터3 더하기(벡터3 벡) {
        오브젝트들.논널필수(벡);
        return new 벡터3(엑스 + 벡.엑스, 와이 + 벡.와이, 제트 + 벡.제트);
    }

    /**
     * 이 벡터에서 주어진 벡터를 뺀 뒤, 그 결과를 반환합니다.
     * @param 벡 이 벡터에서 뺄 벡터
     * @return 벡터-벡터 뺄셈의 결과
     */
    @Override
    public 벡터3 빼기(벡터3 벡) {
        오브젝트들.논널필수(벡);
        return new 벡터3(엑스 - 벡.엑스, 와이 - 벡.와이, 제트 - 벡.제트);
    }

    /**
     * 이 벡터와 주어진 벡터 {@code 벡}과의 점 프로덕트를 반환합니다.
     * @param 벡 이 벡터와의 점 프로덕트를 연산할 벡터
     * @return 벡터-벡터간의 점 프로덕트 결과
     */
    public double 점(벡터3 벡) {
        오브젝트들.논널필수(벡);
        return 엑스 * 벡.엑스 + 와이 * 벡.와이 + 제트 * 벡.제트;
    }

    /**
     * 이 벡터와 주어진 벡터 {@code 벡}과의 크로스 프로덕트를 반환합니다.
     * @param 벡 이 벡터와의 크로스 프로덕트를 연산할 벡터
     * @return 벡터-벡터간의 크로스 프로덕트 결과
     */
    public 벡터3 크로스(벡터3 벡) {
        오브젝트들.논널필수(벡);
        return new 벡터3(
                와이 * 벡.제트 - 제트 * 벡.와이,
                제트 * 벡.엑스 - 엑스 * 벡.제트,
                엑스 * 벡.와이 - 와이 * 벡.엑스
        );
    }

    /**
     * 이 벡터의 절댓값을 반환합니다.
     * @return 이 벡터의 절댓값
     */
    @Override
    public 벡터3 절댓값() {
        return new 벡터3(Math.abs(엑스), Math.abs(와이), Math.abs(제트));
    }

    /**
     * 이 벡터를 가장 가까운 정수로 내림한 뒤, 그 결과를 반환합니다.
     * @return 이 벡터의 내림값
     */
    @Override
    public 벡터3 내림() {
        return new 벡터3(Math.floor(엑스), Math.floor(와이), Math.floor(제트));
    }

    /**
     * 이 벡터를 가장 가까운 정수로 올림한 뒤, 그 결과를 반환합니다.
     * @return 이 벡터의 올림값
     */
    @Override
    public 벡터3 올림() {
        return new 벡터3(Math.ceil(엑스), Math.ceil(와이), Math.ceil(제트));
    }

    /**
     * 이 벡터를 가장 가까운 정수로 반올림한 뒤, 그 결과를 반환합니다.
     * @return 이 벡터의 반올림값
     */
    @Override
    public 벡터3 반올림() {
        return new 벡터3(Math.round(엑스), Math.round(와이), Math.round(제트));
    }

    /**
     * 이 벡터의 부호를 바꾼 뒤, 그 결과를 반환합니다.
     * @return 이 벡터의 음수값
     */
    @Override
    public 벡터3 음수() {
        return new 벡터3(-엑스, -와이, -제트);
    }

    /**
     * 이 벡터를 정규화한 뒤, 그 결과를 반환합니다.
     * @return 이 벡터의 정규화값
     * @throws 영으로나누기오류 이 벡터의 크기가 영인 경우
     */
    @Override
    public 벡터3 정규화() throws 영으로나누기오류 {
        var 크기 = Math.sqrt(엑스 * 엑스 + 와이 * 와이 + 제트 * 제트);
        if (크기 == 0) throw new 영으로나누기오류();
        var 역수 = 1 / 크기;
        return new 벡터3(엑스 * 역수, 와이 * 역수, 제트 * 역수);
    }

    /**
     * 이 벡터와 주어진 벡터 {@code 벡} 간의 최솟값을 반환합니다.
     * @param 벡 이 벡터와의 최솟값을 산출할 벡터
     * @return 두 벡터간의 최솟값
     */
    @Override
    public 벡터3 작은(벡터3 벡) {
        오브젝트들.논널필수(벡);
        return new 벡터3(
                Math.min(엑스, 벡.엑스),
                Math.min(와이, 벡.와이),
                Math.min(제트, 벡.제트)
        );
    }

    /**
     * 이 벡터와 주어진 벡터 {@code 벡} 간의 최댓값을 반환합니다.
     * @param 벡 이 벡터와의 최댓값을 산출할 벡터
     * @return 두 벡터간의 최댓값
     */
    @Override
    public 벡터3 큰(벡터3 벡) {
        오브젝트들.논널필수(벡);
        return new 벡터3(
                Math.max(엑스, 벡.엑스),
                Math.max(와이, 벡.와이),
                Math.max(제트, 벡.제트)
        );
    }

    /**
     * 이 벡터를 주어진 범위에 맞도록({@code [최소, 최대]}) 제한한 뒤, 그 결과를 반환합니다.
     * @param 최소 최소값
     * @param 최대 최댓값
     * @return 주어진 범위에 맞게끔 조정된 값
     */
    @Override
    public 벡터3 범위제한(벡터3 최소, 벡터3 최대) {
        오브젝트들.논널필수(최소);
        오브젝트들.논널필수(최대);
        return new 벡터3(
                Math.min(Math.max(엑스, 최소.엑스), 최대.엑스),
                Math.min(Math.max(와이, 최소.와이), 최대.와이),
                Math.min(Math.max(제트, 최소.제트), 최대.제트)
        );
    }

    /**
     * 이 벡터의 스케일러값에 각각 주어진 변환함수를 적용한 뒤, 그 결과를 반환합니다.
     * @param 변환함수 각 스케일러값에 적용할 함수
     * @return 결과값
     */
    @Override
    public 벡터3 변환(DoubleUnaryOperator 변환함수) {
        오브젝트들.논널필수(변환함수);
        return new 벡터3(
                변환함수.applyAsDouble(엑스),
                변환함수.applyAsDouble(와이),
                변환함수.applyAsDouble(제트)
        );
    }

    /**
     * 이 벡터를 주어진 벡터 {@code 벡}과 병합합니다.
     * @param 벡 이 벡터와 병합할 벡터
     * @param 병합함수 병합을 주도할 함수
     * @return 병합된 벡터
     */
    @Override
    public 벡터3 병합(벡터3 벡, DoubleBinaryOperator 병합함수) {
        오브젝트들.논널필수(벡);
        오브젝트들.논널필수(병합함수);
        return new 벡터3(
                병합함수.applyAsDouble(엑스, 벡.엑스),
                병합함수.applyAsDouble(와이, 벡.와이),
                병합함수.applyAsDouble(제트, 벡.제트)
        );
    }

    /**
     * 이 벡터와 주어진 벡터 {@code 벡}과의 거리를 반환합니다.
     * @param 벡 이 벡터와의 거리를 산출할 벡터
     * @return 두 벡터단의 거리
     */
    @Override
    public double 거리(벡터3 벡) {
        오브젝트들.논널필수(벡);

        var 디엑스 = 엑스 - 벡.엑스;
        var 디와이 = 와이 - 벡.와이;
        var 디제트 = 제트 - 벡.제트;

        return Math.sqrt(디엑스 * 디엑스 + 디와이 * 디와이 + 디제트 * 디제트);
    }

    /**
     * 이 벡터와 주어진 벡터 {@code 벡}과의 제곱 거리를 반환합니다.
     * @param 벡 이 벡터와의 제곱 거리를 산출할 벡터
     * @return 두 벡터단의 제곱 거리
     */
    @Override
    public double 거리제곱(벡터3 벡) {
        오브젝트들.논널필수(벡);

        var 디엑스 = 엑스 - 벡.엑스;
        var 디와이 = 와이 - 벡.와이;
        var 디제트 = 제트 - 벡.제트;

        return 디엑스 * 디엑스 + 디와이 * 디와이 + 디제트 * 디제트;
    }

    /**
     * 이 벡터와 주어진 벡터 {@code 벡}과의 맨해튼 거리를 반환합니다.
     * @param 벡 이 벡터와의 맨해튼 거리를 산출할 벡터
     * @return 두 벡터단의 맨해튼 거리
     */
    @Override
    public double 맨해튼거리(벡터3 벡) {
        오브젝트들.논널필수(벡);

        var 에이엑스 = Math.abs(엑스 - 벡.엑스);
        var 에이와이 = Math.abs(와이 - 벡.와이);
        var 에이제트 = Math.abs(제트 - 벡.제트);

        return 에이엑스 + 에이와이 + 에이제트;
    }

    /**
     * 이 벡터의 스케일러값으로 이루어진 스트림을 반환합니다.
     * @return 이 벡터에 대한 스트림
     */
    @Override
    public DoubleStream 스트림() {
        return DoubleStream.of(엑스, 와이, 제트);
    }

    /**
     * 이 벡터를 배열로 변환한 뒤 그 값을 반환합니다.
     * @return 이 벡터의 값으로 이루어진 배열
     */
    @Override
    public double[] 배열() {
        return new double[] {엑스, 와이, 제트};
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

// 님들 인텔리제이 영->한으로 리팩토링 안돼요 살려주세요
