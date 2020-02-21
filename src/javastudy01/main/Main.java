package javastudy01.main;

import javastudy01.data.Data;
import javastudy01.data.Result;
import javastudy01.val.TotalValidation;
import javastudy01.val.Validation;
/**
 * 
 * @author 한선
 * 
 * 메인
 *
 */
public class Main {

	/**
	 * 메인메서드
	 * rule 클래스를 실행하는 메인메서드
	 * @param args
	 */
	public static void main(String[] args) {

		Data data = new Data();
		
		data.setA("3");
	data.setB("4");
		data.setC("5");
		
		Validation val = new Validation(data);
//		Result result = val.start();
		
		TotalValidation vv = new TotalValidation(data);
		
		Result result = vv.mainStart();
		

		System.out.println(result.getMsg());


	}
}
