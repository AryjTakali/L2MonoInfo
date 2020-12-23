public class Cone{
	private double r;
	private double h;
	public static final double PI = 3.14159;
	private static int nbCones = 0;

	public Cone(double r, double h){
		this.r = r;
		this.h = h;
		nbCones++;
	}

	public Cone(){
		this(Math.random() * 10, Math.random() * 10);
	}

	public double getVolume(){
		return (1./3.)*PI*r*r*h ;
	}

	public static double getVolume2(Cone c){
		return (1./3.)*PI*c.r*c.r*c.h ;
	}

	public String toString(){
		return String.format("Cone r = %.2f  h = %.2f  V = %.3f ", r, h, getVolume());
	}

	public static int getNbCones(){
		return nbCones;
	}

}
