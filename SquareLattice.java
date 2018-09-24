import java.util.*;

//This is for treatment of square lattices.

public class SquareLattice {
	//computes the eligible pairs of integer (n,m) such that n^2+m^2=k, where k is an integer >=0.
	public static int degeneracy(int k) {
		if (k<0) {
			throw new ArithmeticException("The input value k of degeneracy has to be >= 0.");
		}
		else {
			int count = 0;
			for (int n = 0; n <= Math.sqrt((double)k); n++) {
				int mSquare = k - n * n;
				if (isSquare(mSquare)) {
					if (n==0 && mSquare==0) {
						count++;
					}
					else if (n==0 || mSquare==0) {
						count = count + 2;
					}
					else {
						count = count + 4;	
					}
				}
			}
			return count;
		}
	}
	//determines whether an integer mm is a square of some integer.
	public static boolean isSquare(int mm) {
		//the candidate square root
		int mCandi = (int) Math.round(Math.sqrt((double) mm));
		return (mm == mCandi * mCandi);
	}
}
