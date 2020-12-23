
public class TestLettre{

	public static void main(String args[]){
		char i = 'a';
		int n = 0;
		Lettre letter = new Lettre(i);
		
		for (i = 'a'; i <= 'z'; i++){
			letter = new Lettre(i);
		/*
			print "<lettre> - <CodeAscii>" 
			System.out.printf("%s - %d\n", letter.getCarac(), letter.getCodeAscii()); */
			System.out.printf("%s%s", letter.getCarac(), n == 4 ? "\n" : " " );
			n = n == 4 ? 0 : n + 1;
		}
	}

}
