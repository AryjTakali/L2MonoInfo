public class Triangle{

	private Point p1, p2, p3;

	public Triangle(){
		p1 = new Point();
		p2 = new Point();
		p3 = new Point();
	}

	public Triangle(Point p1, Point p2, Point p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public double getPerimetre(){
		return p1.distance(p2) + p1.distance(p3) + p2.distance(p3);
	}

	public boolean equals(Triangle t){
		if (t == null)
			return false;
		else
			return (p1.equals(t.p1) && p2.equals(t.p2) && p3.equals(t.p3));
	}

	public String toString(){
		return "Le triangle est composé des points " + p1.toString() + ", " + p2.toString() + ", " + p3.toString() + "\nDe périmètre : " + String.format("%.2f", getPerimetre());  
	
	}
}
