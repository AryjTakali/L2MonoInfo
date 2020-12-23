public class Circle extends Shape{
    private double radius;

    public Circle(){
        super();
        radius = 1;
    }

    public Circle(double x, double y, double r){
        super(x, y);
        radius = r;
    }

    public double surface(){
        return Math.PI * radius * radius;
    }

    public String toString(){
        return super.toString() + " Rayon : " + radius;
    }
}