package pegasus.오류;

/**
 * {@code 0}으로 나누기를 시도할 경우 발생하는 오류입니다.
 */
public class 영으로나누기오류 extends ArithmeticException {
    /**
     * 새로운 오류를 생성합니다.
     */
    public 영으로나누기오류() {
        super("0으로 나눌 수 없습니다.");
    }

    /**
     * 새로운 오류를 생성합니다.
     * @param 오류메시지 오류 메시지
     */
    public 영으로나누기오류(String 오류메시지) {
        super(오류메시지);
    }
}
