import java.util.Scanner;

public class JeuHanoi {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Hanoi hanoi = new Hanoi(5);
        int a,b;
        while(!(hanoi.aGagne())){
            a=0;
            b=0;
            System.out.println(hanoi);
            while((a<1) || (a>3)){
                System.out.println("Bouger de : ");
                a = sc.nextInt();
            }
            while((b==a) || (b>3) || (b<1)){
                System.out.println("De "+ a +" vers : ");
                b = sc.nextInt();
            }
            if (!(hanoi.deplacer(a,b))){
                System.out.println("Mouvement impossible");
            }
        }
    }
}