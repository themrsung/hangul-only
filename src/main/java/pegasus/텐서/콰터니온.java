package pegasus.텐서;

import pegasus.오류.영으로나누기오류;
import pegasus.유틸리티.오브젝트들;

import java.io.Serial;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

/**
 * 4차원 콰터니온입니다.
 */
public class 콰터니온 implements 벡터<콰터니온> {
    @Serial
    private static final long serialVersionUID = 0;

    /**
     * 이 콰터니온의 더블유 값입니다.
     */
    protected final double 더블유;

    /**
     * 이 콰터니온의 엑스 값입니다.
     */
    protected final double 엑스;

    /**
     * 이 콰터니온의 와이 값입니다.
     */
    protected final double 와이;

    /**
     * 이 콰터니온의 제트 값입니다.
     */
    protected final double 제트;

    /**
     * 새로운 콰터니온을 생성합니다.
     * @param 더블유 이 콰터니온읜 더블유 값
     * @param 엑스 이 콰터니온의 엑스 값
     * @param 와이 이 콰터니온의 와이 값
     * @param 제트 이 콰터니온의 제트 값
     */
    public 콰터니온(double 더블유, double 엑스, double 와이, double 제트) {
        this.더블유 = 더블유;
        this.엑스 = 엑스;
        this.와이 = 와이;
        this.제트 = 제트;
    }

    public double 더블유() {
        return 더블유;
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

    public 벡터3 벡터() {
        return new 벡터3(엑스, 와이, 제트);
    }

    @Override
    public boolean 영인가() {
        return 더블유 == 0 && 엑스 == 0 && 와이 == 0 && 제트 == 0;
    }

    @Override
    public boolean 숫자가아닌가() {
        return Double.isNaN(더블유) || Double.isNaN(엑스) || Double.isNaN(와이) || Double.isNaN(제트);
    }

    @Override
    public boolean 유한한가() {
        return Double.isFinite(더블유) && Double.isFinite(엑스) && Double.isFinite(와이) && Double.isFinite(제트);
    }

    @Override
    public boolean 무한한가() {
        return Double.isInfinite(더블유) || Double.isInfinite(엑스) || Double.isInfinite(와이) || Double.isInfinite(제트);
    }

    @Override
    public double 크기제곱() {
        return 더블유 * 더블유 + 엑스 * 엑스 + 와이 * 와이 + 제트 * 제트;
    }

    @Override
    public double 크기() {
        return Math.sqrt(크기제곱());
    }

    @Override
    public double 맨해튼크기() {
        return Math.abs(더블유) + Math.abs(엑스) + Math.abs(와이) + Math.abs(제트);
    }

    @Override
    public 콰터니온 더하기(double 스케일러) {
        return new 콰터니온(더블유 + 스케일러, 엑스, 와이, 제트);
    }

    @Override
    public 콰터니온 빼기(double 스케일러) {
        return new 콰터니온(더블유 - 스케일러, 엑스, 와이, 제트);
    }

    @Override
    public 콰터니온 곱하기(double 스케일러) {
        return new 콰터니온(더블유 * 스케일러, 엑스 * 스케일러, 와이 * 스케일러, 제트 * 스케일러);
    }

    @Override
    public 콰터니온 나누기(double 스케일러) throws 영으로나누기오류 {
        if (스케일러 == 0) throw new 영으로나누기오류();
        var 역수 = 1 / 스케일러;
        return new 콰터니온(더블유 * 역수, 엑스 * 역수, 와이 * 역수, 제트 * 역수);
    }

    @Override
    public 콰터니온 더하기(콰터니온 콰터니온) {
        오브젝트들.논널필수(콰터니온);
        return null;
    }

    @Override
    public 콰터니온 빼기(콰터니온 콰터니온) {
        오브젝트들.논널필수(콰터니온);
        return null;
    }

    @Override
    public 콰터니온 절댓값() {
        return null;
    }

    @Override
    public 콰터니온 내림() {
        return null;
    }

    @Override
    public 콰터니온 올림() {
        return null;
    }

    @Override
    public 콰터니온 반올림() {
        return null;
    }

    @Override
    public 콰터니온 음수() {
        return null;
    }

    @Override
    public 콰터니온 정규화() throws 영으로나누기오류 {
        return null;
    }

    @Override
    public 콰터니온 작은(콰터니온 콰터니온) {
        오브젝트들.논널필수(콰터니온);
        return null;
    }

    @Override
    public 콰터니온 큰(콰터니온 콰터니온) {
        오브젝트들.논널필수(콰터니온);
        return null;
    }

    @Override
    public 콰터니온 범위제한(콰터니온 최소, 콰터니온 최대) {
        오브젝트들.논널필수(최소);
        오브젝트들.논널필수(최대);
        return null;
    }

    @Override
    public 콰터니온 변환(DoubleUnaryOperator 변환함수) {
        오브젝트들.논널필수(변환함수);
        return null;
    }

    @Override
    public 콰터니온 병합(콰터니온 콰터니온, DoubleBinaryOperator 병합함수) {
        오브젝트들.논널필수(콰터니온);
        오브젝트들.논널필수(병합함수);
        return null;
    }

    @Override
    public double 거리(콰터니온 콰터니온) {
        오브젝트들.논널필수(콰터니온);
        return 0;
    }

    @Override
    public double 거리제곱(콰터니온 콰터니온) {
        오브젝트들.논널필수(콰터니온);
        return 0;
    }

    @Override
    public double 맨해튼거리(콰터니온 콰터니온) {
        오브젝트들.논널필수(콰터니온);
        return 0;
    }

    @Override
    public DoubleStream 스트림() {
        return null;
    }

    @Override
    public double[] 배열() {
        return new double[0];
    }
}
