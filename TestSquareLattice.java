import java.util.*;

public class TestSquareLattice {
	public static void main(String[] args) {
		int a = SquareLattice.degeneracy(0);//1
		int b = SquareLattice.degeneracy(5);//8
		int c = SquareLattice.degeneracy(25);//12
		boolean k = SquareLattice.isSquare(121);//true
		boolean l = SquareLattice.isSquare(131);//false
		System.out.println("Z(0)="+a+"; Z(5)="+b+"; Z(25)="+c);
		System.out.println("121 is a square:"+k+"; 131 is a square:"+l);
		for (int i = 0; i <= 150; i++) {
			System.out.println(i+"  "+SquareLattice.degeneracy(i));
		}
	}
}
