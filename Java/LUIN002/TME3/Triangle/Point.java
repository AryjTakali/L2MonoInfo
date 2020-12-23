public class Point{
	private int posx;
	private int posy;

	public Point(int x, int y){
		posx = x;
		posy = y;
	}

	public Point(){
		this((int)(Math.random()*10), (int)(Math.random()*10));
	}

	public void setPosx(int x){
		posx = x;
	}

	public void setPosy(int y){
		posy = y;
	}

	public int getPosx(){
		return posx;
	}

	public int getPosy(){
		return posy;
	}

	public String toString(){
		return "(" + posx + ", " + posy + ")";
	}

	public double distance(Point p){
		return Math.sqrt(Math.pow(posx - p.getPosx(), 2) + Math.pow(posy - p.getPosy(), 2));	
	}

	public boolean equals(Point p){
		if (p == null)
			return false;
		else
			return (posx == p.posx && posy == p.posy);
	}

	public void deplaceToi(int newx, int newy){
		posx = newx;
		posy = newy;
	}
		public static void main(String args[]){
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();

		System.out.println("p1 : " + p1.toString());
		System.out.println("p2 : " + p2.toString());
		System.out.println("p3 : " + p3.toString());
		System.out.println("distance p1 - p2: " );
		System.out.printf("%.2f\n", p1.distance(p2));
		System.out.println("set  p1 to (0,0): " );
		p1.deplaceToi(0,0);;
		System.out.println(p1.toString());

	
	}

}
