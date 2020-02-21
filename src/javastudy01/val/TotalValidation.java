package javastudy01.val;

import java.lang.invoke.SwitchPoint;

import javastudy01.data.Data;
import javastudy01.data.Result;

/**
 * 
 * @author MetabizTeam1
 *
 */
public class TotalValidation {

	public Data data;
	double lastResult = 0;

	public TotalValidation() {

	}

	public TotalValidation(Data data) {
		this.data = data;
	}

	/**
	 * 시작메서드
	 * 
	 * @param data
	 * @return
	 */

	public Result mainStart() {
		
		Result vo = new Result();

		int msgGo =this.validation();
		 vo = this.msg(msgGo);

		return vo;
	}

	public int validation() {

		
		int result=0;
		// 전부다 널이 아닐때 - 메세지
		if (data.getA() != null && data.getB() != null && data.getC() != null) {

			result = 11;

			// a,b가 널이 아니고 c가 널일때 -- 방정식으로 ㄱㄱ
		} else if (data.getC() == null && data.getB() != null && data.getA() != null) {
			result = 2;

			// a,c가 널이 아니고 b가 널일때 -- 방정식으로 ㄱㄱ
		} else if (data.getB() == null && data.getA() != null && data.getC() != null) {
			result = 3;

			// 메세지로
			if (Integer.parseInt(data.getA()) > Integer.parseInt(data.getC())) {
				result = 9;

				// 방정식
			} else if (Integer.parseInt(data.getA()) < Integer.parseInt(data.getC())) {
				result = 3;
			}

			// a가 널이고 b가 널이고 c 가 널이 아닐때 --
		} else if (data.getA() == null && data.getB() != null && data.getC() != null) {
			result = 8;

			// 메세지로
			if (Integer.parseInt(data.getB()) > Integer.parseInt(data.getC())) {
				result = 10;

				// 방정식
			} else if (Integer.parseInt(data.getB()) < Integer.parseInt(data.getC())) {
				result = 1;
			}
		} else {

			// 1. 다 널일때
			// 2. b,c,가 널일때
			// 3. a,c,가 널일때
			// 4. a,b,가 널일때

			if (data.getA() == null && data.getB() == null && data.getC() == null) {
				result = 5;
			} else if (data.getB() == null && data.getC() == null) {
				result = 6;
			} else if (data.getA() == null && data.getC() == null) {
				result = 7;
			} else if (data.getA() == null && data.getB() == null) {
				result = 8;
			}

		}

		return result;

	}

	public Result msg(int result) {
		
		Result vo = new Result();

		String msg = "";

		if (result == 8) {
			msg = "A와 B가 입력되지 않으면 실행할 수 없습니다.";
		} else if (result == 7) {
			msg = "A와 C가 입력되어있지 않아서 실행할 수 없습니다.";
		} else if (result == 6) {
			msg = "B와 C가 입력되어 있지 않아서 실행할 수 없습니다.";
		} else if (result == 5) {
			msg = "모든 데이터가 입력되어 있어야 실행할 수 없습니다.";
		} else if (result == 10) {
			msg = "당신이 입력한 B 값  " + data.getB() + " 는 " + "C" + data.getC() + "값 보다 클 수 없습니다.";
		} else if (result == 9) {
			msg = "당신이 입력한 A 값  " + data.getA() + " 는 " + "C" + data.getC() + "값 보다 클 수 없습니다.";
		} else if (result == 11) {
			int allData = (int) (Math.pow(Integer.parseInt(data.getA()), 2)
					+ Math.pow(Integer.parseInt(data.getB()), 2));
			if (allData == (int) (Math.pow(Integer.parseInt(data.getC()), 2))) {
				msg = "당신이 입력한 값은 피타고라스 방정식에 맞습니다 A =" + data.getA() + "B=" + data.getB() + "C=" + data.getC();
			} else {
				msg = "당신이 입력한 값은 피타고라스 방정식에 맞지않는 결과다";
			}
		} else if (result == 2) {
			vo = this.rule(2);
			msg = "당신이 입력한 값 A :" + data.getA() + "당신이 입력한 값 B" + data.getB() + "의 결과는 " + vo.getIresult();
		} else if (result == 3) {
			vo = this.rule(3);
			msg = "당신이 입력한 값 A :" + data.getA() + "당신이 입력한 값 C" + data.getC() + "의 결과는 " + vo.getIresult();
		} else if (result == 1) {
			vo = this.rule(1);
			msg = "당신이 입력한 값 B :" + data.getB() + "당신이 입력한 값 C" + data.getC() + "의 결과는 " +vo.getIresult();
		}

		vo.setMsg(msg);

		return vo;
	}

	public Result rule(int ab) {
		Result vo = new Result();

		if (ab == 2) {
			double c = Math.pow(Integer.parseInt(data.getA()), 2) + Math.pow(Integer.parseInt(data.getB()), 2);

			lastResult = Math.sqrt(c);
			vo.setDresult(lastResult);

		} else if (ab == 3) {
			double b = Math.pow(Integer.parseInt(data.getA()), 2) + Math.pow(Integer.parseInt(data.getC()), 2);
			lastResult = Math.sqrt(b);
			vo.setDresult(lastResult);
		} else if (ab == 1) {
			double a = Math.pow(Integer.parseInt(data.getB()), 2) + Math.pow(Integer.parseInt(data.getC()), 2);
			lastResult = Math.sqrt(a);
			vo.setDresult(lastResult);
		}
		return vo;
	}

}
