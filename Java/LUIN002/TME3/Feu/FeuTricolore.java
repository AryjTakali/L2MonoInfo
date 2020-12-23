public class FeuTricolore {
    private Lampe rouge, orange, vert;

    public FeuTricolore() {
        rouge = new Lampe();
        orange = new Lampe();
        vert = new Lampe();
    }

    public FeuTricolore(Lampe rouge, Lampe orange, Lampe vert) {
        this.rouge = rouge;
        this.orange = orange;
        this.vert = vert;
    }

    public FeuTricolore(String s) {
        this(new Lampe(), new Lampe(), new Lampe());
        if (s.equals("rouge"))
            rouge.switchEtat();
        if (s.equals("orange"))
            orange.switchEtat();
        if (s.equals("vert"))
            vert.switchEtat();
    }

    public void switchRouge() {
        rouge.switchEtat();
    }

    public void switchOrange() {
        orange.switchEtat();
    }

    public void switchVert() {
        vert.switchEtat();
    }

    public String onOff(boolean button) {
        if (button)
            return "on";
        else
            return "off";
    }

    public String toString() {
        return "rouge : " + onOff(rouge.getEtat()) + "\torange : " + onOff(orange.getEtat()) + "\tvert : "
                + onOff(vert.getEtat()) + "\n";
    }

    public static void main(String[] args) {
        FeuTricolore f1 = new FeuTricolore();
        FeuTricolore f2 = new FeuTricolore(new Lampe(), new Lampe(), new Lampe());
        FeuTricolore f3 = new FeuTricolore("rouge");
        FeuTricolore f4 = new FeuTricolore("orange");
        FeuTricolore f5 = new FeuTricolore("vert");

        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println(f5.toString());
    }
}