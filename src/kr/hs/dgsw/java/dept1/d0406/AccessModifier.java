package kr.hs.dgsw.java.dept1.d0406;

public class AccessModifier {

	public int publicValue;
	private int privateValue;
	protected  int protectedValue;
	int defaultvalue;
	
	public static void main(String[] args) {
		AccessModifier accessModifier = new AccessModifier();
		accessModifier.publicValue = 5;
		accessModifier.privateValue = 7;
		accessModifier.protectedValue = 3;
		accessModifier.defaultvalue = 1;
	}
}


//public 은 그냥 오픈 된 것
//private 은 선언된 클래스내에서만 사용 가능하다. 상속해도 안됨
//protected 는 다 되지만 다른 패키지에서 상속을 받지 않고 썼을때 에러가 남.
//아무것도 적지 않으면 default로 선언되고 default는 같은 모듈에서만 사용가능하다. 