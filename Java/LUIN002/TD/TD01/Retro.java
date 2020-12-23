public class Retro{

	public static void main(String args[]){

		int limit = 60; 
		int past = 1, current = 1;
		while (current < limit){
			System.out.printf("%d ", current);
			current += past;
			past = current - past;
		}
	}
}
