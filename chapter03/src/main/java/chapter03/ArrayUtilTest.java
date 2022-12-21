package chapter03;
import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		//테스트 코드 TDD
		int[] a = {10, 20, 30, 40};
//		int[] a = new int[4];
//		a[0] = 10;
//		a[1] = 20;
//		a[2] = 30;
//		a[3] = 40;
		
		double[] d = ArrayUtil.intToDouble(a);
//		ArrayUtil.intToDouble(new int[] {10, 20, 30, 40});
//		레퍼런스값..?객체 ID가 호출됨
//		System.out.println(d);
		
//		객체의 toString을 호출
//		주소를 해싱한 값
//		Goods g = new Goods();
//		System.out.println(g);
//		System.out.println(g.toString());
		System.out.println(Arrays.toString(d));
		
		int[] i1 = ArrayUtil.doubleToInt(new double[] {10.0, 20.0, 30.0, 40.0});
		System.out.println(Arrays.toString(i1));
		
		int[] i2 = ArrayUtil.concat(new int[] {1, 2, 3},new int[] {4, 5, 6});
		System.out.println(Arrays.toString(i2));
	}

}
