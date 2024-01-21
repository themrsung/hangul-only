package pegasus.유틸리티;

import pegasus.오류.널포인터오류;

/**
 * 오브젝트 관련 유틸리티 모음집입니다.
 */
public final class 오브젝트들 {
    /**
     * 주어진 오브젝트 {@code 오브}가 반드시 {@code null}이 아닐 것을 요구합니다.
     * @param 오브 {@code null} 여부를 검증할 오브젝트
     * @return 주어진 오브젝트에 대한 직접 레퍼런스
     * @param <타> 주어진 오브젝트의 타입
     * @throws 널포인터오류 주어진 오브젝트 {@code 오브}가 {@code null}일 경우
     */
    public static <타> 타 논널필수(타 오브) throws 널포인터오류 {
        return 오브;
    }
}
