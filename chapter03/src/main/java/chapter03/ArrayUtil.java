package chapter03;

public class ArrayUtil {
	
	public static double[] intToDouble(int[] is) {
		double[] result =new double[is.length]; //지역변수는 초기화 안시켜주기때문에 쓰레기값이 있음
		
		for(int i=0; i<result.length; i++) {
			result[i] = is[i];
		}
		return result;
	}

	public static int[] doubleToInt(double[] ds) {
		int[] result = new int[ds.length];
		for(int i=0; i<result.length; i++) {
			result[i] = (int)ds[i];
		}
		return result;
	}

	public static int[] concat(int[] is, int[] is2) {
		int[] result = new int[is.length+is2.length];
//		0,1,2    0,1
//		1,2,3    4,5
		for(int i=0; i<is.length; i++) {
			result[i] = is[i];
		}
		int idx=0;
		for(int i=is.length; i<result.length; i++) {
			result[i] = is2[idx++];
		}
		return result;
	}

}
