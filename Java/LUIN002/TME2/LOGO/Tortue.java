import java.awt.Graphics;

public class Tortue {

    private Vecteur position, direction; 
    boolean draw;
    Graphics g;

    public Tortue(Graphics g){
        direction = new Vecteur(1,0);
        position = new Vecteur(200,200);
        draw = true;
        this.g = g;
    }

    public void baisserStylo(){
        draw = true;
    }
    public void leverStylo(){
        draw = false;
    }

    public void avancer(int lg){
        Vecteur oldPosition; 
            for (int i = 1; i < lg; i++){
                oldPosition = position.clone(); 
                position = position.addition(direction);
                if (draw == true){
                    System.out.println(position.toString());
                    System.out.println(oldPosition.toString());
                    g.drawLine((int)oldPosition.getX(), (int)oldPosition.getY(), (int)position.getX(), (int)position.getY());
            }
            }
    }

    public void rotation(double theta){
        direction.rotation(theta);
    }
}