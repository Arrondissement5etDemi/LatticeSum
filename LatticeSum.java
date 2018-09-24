import java.util.*;
import java.io.*;

public class LatticeSum{
	private static double threshold = 0.000001;  //the threshold for convergence criterion.

	public static void main(String[] args) {
		String fileName = "task2_5.txt";
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
		}
		catch (FileNotFoundException e) {
			System.out.println("PrintWriter error opening the file " + fileName);
			System.out.println(e.getMessage());
		}
		for (double x = -Math.PI; x <= Math.PI; x = x + 0.001) {
			Complex z = new Complex(x,0.05);
			writer.println(x+"	"+squareLatticeSum(z));
		}
		writer.close();
	}

	
	/**computes the lattice sum of a square lattice in 2D.
 	@param z Complex. The complex variable where Im(z) must be greater than 0.
	@return Complex. The value of the lattice sum at the variable z. */
	public static Complex squareLatticeSum(Complex z) {
		if (z.getIm() <= 0) {
			throw new ArithmeticException("The imaginary part of the variable must be positive.");
		}
		int stop = stoppingTerm(threshold,z);
                Complex theta = new Complex(0.0); //0 as a complex number
                for (int m = 1; m <= stop ; m++) {
                        int d = SquareLattice.degeneracy(m);
                        Complex mComp = new Complex((double) m);
                        Complex dComp = new Complex((double) d);
                        Complex zm = z.times(mComp);
                        Complex mthTerm = dComp.times(zm.expIpithis());
                        theta = theta.add(mthTerm);
                }
		return theta;
	}

	/**computes at which term we can safely stop the summation such that the convergence is already good.
 	@param threshold double. The max residue allowed for the series sum_{m=stoppingTerm}^{\infty} exp(-pi*y*m) .
	@param y double. The imaginary part of the complex variable z in the lattice sum expression.
	@return int. The index m of the stopping term. */
	private static int stoppingTerm(double threshold, Complex z) {
		double y = z.getIm();
		return (int) Math.floor((Math.log(threshold * (-Math.expm1(-Math.PI*y))))/(-Math.PI * y)) + 1;
	}
}
