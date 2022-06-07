package filipondiosUtils;

public class Vector {
	public double vector[];
	public double x;
	public double y;
	public double z;
	public double angle;

	public Vector() {super();}

	public Vector(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector(Vector vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
	}
	
	public Vector(double[] vector) {
		if (vector == null) { this.vector = null; }
		else{
			this.vector = new double [vector.length];
			for (int i = 0; i < vector.length; i++) { this.vector[i] = vector[i]; }
		}
	}

	public Vector(double[] vector, int longitude) {
		if (this.vector.length != vector.length) {
			throw new RuntimeException("Vectors don't have the same lenght.");
		}
		else {
			vector = new double [longitude];
			for (int i = 0; i < vector.length; i++) { this.vector[i] = vector[i]; }
		}
	}

	public double getX() { return x; }

	public void setX(double x) { this.x = x; }

	public double getY() { return y; }

	public void setY(double y) { this.y = y; }

	public double getZ() { return z; }

	public void setZ(double z) { this.z = z; }

	public double getAngle() { return angle; }

	public void setAngle(double angle) { this.angle = angle; }
	
	public double[] getVector() { return vector; }

	public void setVector(double[] vector) { this.vector = vector; }

	public Vector normalVector(Vector vector) {
		Vector normal = new Vector(vector);
		double temp = vector.x;
		normal.setX(-vector.y);
		normal.setY(temp);
		normal.setZ(0);
		return normal;
	}

	public Vector normalVectorTo(Vector vector1, Vector vector2) {
		Vector normal = new Vector();
		normal.x = vector1.y*vector2.z + vector1.z*vector2.y;
		normal.y = vector1.z*vector2.x + vector1.x*vector2.z;
		normal.z = vector1.x*vector2.y + vector1.y*vector2.x;
		return normal;
	}

	public Vector crossProductOf(Vector vector1, Vector vector2) {
		return (normalVectorTo(vector1,vector2));
	}
	
	public double vectorModule(Vector vector) {
		return Math.sqrt(Math.pow(vector.x, 2)+Math.pow(vector.y, 2)+Math.pow(vector.z, 2));
	}
	
	public double vectorModule(double[] vector) {
		double module = 0;
		for (int i = 0; i < vector.length; i++) { module += Math.pow(vector[i], 2); }
		return Math.sqrt(module);
	}

	public double dotProduct(double module1, double module2, double angle) {		
		return module1*module2*Math.cos(angle);
	}
	
	public double dotProductOf(Vector vector1, Vector vector2) {
		Vector product = new Vector();
		product.x = vector1.x * vector2.x;
		product.y = vector1.y * vector2.y;
		product.z = vector1.z * vector2.z;
		return product.x+product.y+product.y;
	}
	
	public double dotProductOf(double[] vector1, double[] vector2) {
		if (vector1.length != vector2.length) {
			throw new RuntimeException("Vectors don't have the same lenght.");
		}
		else {
			double sum=0;
			for (int i = 0; i < vector1.length; i++) { sum += vector1[i] + vector2[i]; }
			return sum;
		}
	}

	public double calculateAngle(Vector vector1, Vector vector2) {
		double calc = (dotProductOf(vector1,vector2))/(vectorModule(vector1)*vectorModule(vector2));
		return Math.acos(calc);
	}
	
	public double calculateAngle(double[] vector1, double[] vector2) {
		double calc = (dotProductOf(vector1,vector2))/(vectorModule(vector1)*vectorModule(vector2));
		return Math.acos(calc);
	}
	
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
	
	public String toStringLarge() {
		String chain = "(";
		for (int i = 0; i < vector.length; i++) {
			if (i == vector.length-1) { chain += vector[i]+")"; }
			else chain += vector[i]+",";
		}
		return chain;
	}
}
