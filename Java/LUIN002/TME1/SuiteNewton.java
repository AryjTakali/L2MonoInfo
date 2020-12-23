
public class SuiteNewton{

	public static void main(String[] args) {

		System.out.println(suiteNewton(100,0.01));
		System.out.println(suiteNewton(2,0.001));


	}

	public static double suiteNewton(double x, double eps){

		double u = x/2;
		
		while (Math.abs(u*u - x) >= eps) { //On va donc trouver u tel que u^2 ϵ [x-eps; x+eps].
											//Je pense que la consigne veut que que u ϵ [sqrt(x)-eps;sqrt(x)+eps]
											//Avec ça on est plus précis, donc au pire, c'est pas grave
			u = (u + x/u) / 2;
		}

		return u;
	}

}
