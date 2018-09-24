import java.util.*;

public class TestComplex {
	public static void main(String[] args) {
		//construct a complex number
		Complex z1 = new Complex(1.0,1.0);
		Complex z2 = new Complex(0.0,2.0);
		System.out.println(z1.getRe());
		System.out.println(z1.getIm());
		System.out.println(z2.getNorm());
		System.out.println(z2.getAngle());
		Complex z3 = z1.times(z2);
		System.out.println(z3.toString());
		Complex z4 = z1.expIpithis();
		System.out.println(z4.toString());
		Complex z5 = new Complex(1,Math.PI,Math.PI/2); //this is the complex number pi*i;
		System.out.println(z5.expThis()); //should be e^(pi*i)=(-1,0)
	}
}
