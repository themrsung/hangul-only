package pegasus.텐서;

import pegasus.오류.영으로나누기오류;

import java.io.Serializable;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

/**
 * [주석 필요]
 *
 * @param <벡> 벡
 */
public interface 벡터<벡 extends 벡터> extends Serializable {
    boolean 영인가();

    boolean 숫자가아닌가();

    boolean 유한한가();

    boolean 무한한가();

    double 크기제곱();

    double 크기();

    double 맨해튼크기();

    벡 더하기(double 스케일러);

    벡 빼기(double 스케일러);

    벡 곱하기(double 스케일러);

    벡 나누기(double 스케일러) throws 영으로나누기오류;

    벡 더하기(벡 벡);

    벡 빼기(벡 벡);

    벡 절댓값();

    벡 내림();

    벡 올림();

    벡 반올림();

    벡 음수();

    벡 정규화() throws 영으로나누기오류;

    벡 작은(벡 벡);

    벡 큰(벡 벡);

    벡 범위제한(벡 최소, 벡 최대);

    벡 변환(DoubleUnaryOperator 변환함수);

    벡 병합(벡 벡, DoubleBinaryOperator 병합함수);

    double 거리(벡 벡);

    double 거리제곱(벡 벡);

    double 맨해튼거리(벡 벡);

    DoubleStream 스트림();

    double[] 배열();
}
