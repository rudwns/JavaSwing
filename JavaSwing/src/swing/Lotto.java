package swing;

import java.util.Arrays;

public class Lotto {
 
	public int[] lotto;

	public int[] getLotto(){
		return lotto;
	}
	// 로또는 외부에서 숫자를 주입받는 것이아니라
	// 자ㅔ적으로 랜덤숫자를 발생시켜야 ㅎ나다.
	// 통장 계좌 번호와 흡사
	public void setLotto() {
		for (int i = 0; i < lotto.length; i++) {
		lotto[i] = 0; // 배열 내부의 지역변수 6개를
		// for 문을 이용해서 0으로 초기화 로직
	}
		for (int i = 0; i < lotto.length; i++) {
			// 로또의 사이즈 6만큼 회전하면서 랜덤숫자 6개를 생성
			int randomNum = (int) ((Math.random()*45)+1);
			// 로또의 법칙 : 로또는 숫자가 중복이 있어서는 안된다.
			// 나중에 나온 숫자가 먼저 나온 숫자와 같다면
			// 그 숫자는 폐기하고 다시 돌아야한다.
			// 이때, 카운트 숫자는 증가하면 안도내다.
			boolean exist = false;
			// for 문 내부에 다시 for 문을 주어 (이중for문)
			// 번호의 중복 여부를 체크하고 만약 중복되었다면
			// 회전 카운트( i ) 값을 마이너스 처리하여
			// 이번 회전을 무효화 시킨다.
			for (int j = 0; j < lotto.length; j++) {
				if (randomNum == lotto[j]) {
					exist = true;
					break;
				}
			}
			if (exist) {
				i--;
				continue;
			}else {
				this.lotto[i] = randomNum;
			}
		}
		// 중복이 되지 않은 6개의 랜덤숫자가 배열에 담겻다면
		// 그배열의 숫자를 오름차순으로 정렬해야 함
		Arrays.sort(lotto); 
		// 오름차순으로 정렬하는 소스 내부로직은 알수없다.
	}
}
