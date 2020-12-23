public class MainShape{

    public static void test(){
       Circle c1, c2;
        c1 = new Circle(1, 1, 3);
        c2 = new Circle();
        System.out.println(c1.toString() + '\n' + c2.toString());
        Rectangle r1, r2;
        r1 = new Rectangle();
        r2 = new Rectangle(1,1,2,5);
        System.out.println(r1.toString() + '\n' + r2.toString());
        System.out.println(r2.surface());
    }

    public static void main(String args[]){
        Shape[] shap = new Shape[4];
        shap[0] = new Circle(1, 1, 3);
        shap[1] = new Circle();
        System.out.println(shap[0].toString() + " Surface : " + shap[0].surface() +'\n' + shap[1].toString()+ " Surface : " + shap[1].surface());
        shap[2] = new Rectangle();
        shap[3] = new Rectangle(1,1,2,5);
        System.out.println(shap[2].toString() + " Surface : " + shap[2].surface() + '\n' + shap[3].toString() + " Surface : " + shap[3].surface());

        double aire = shap[0].surface() + shap[1].surface() + shap[2].surface() + shap[3].surface();
        System.out.println("aire figure composite = " + aire);
    }
}