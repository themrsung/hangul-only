package pegasus.오류;

/**
 * {@code null} 발생 시 던져지는 오류입니다.
 */
public class 널포인터오류 extends NullPointerException {
    /**
     * 새로운 오류를 생성합니다.
     */
    public 널포인터오류() {
    }

    /**
     * 새로운 오류를 생성합니다.
     * @param 오류메시지 오류 메시지
     */
    public 널포인터오류(String 오류메시지) {
        super(오류메시지);
    }
}
