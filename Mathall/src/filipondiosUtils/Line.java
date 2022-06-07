package filipondiosUtils;

public class Line {
	//Constants for normal line equations
	public double [] normal = new double[6];
	public double x, x1;
	public double y, y1;
	public double z, z1;
	
	//Constants for lines defined as planes intersection
	public double xP, x1P;
	public double yP, y1P;
	public double zP, z1P;
	public double dP, d1P;
	
	public Line(double x, double x1, double y, double y1, double z, double z1) {
		super();
		this.x = x; this.x1 = x1;
		this.y = y; this.y1 = y1;
		this.z = z; this.z1 = z1;
	}
	
	public Line(double xP, double x1P, double yP, double y1P, double zP, double z1P, double dP, double d1P) {
		super();
		this.xP = xP; this.x1P = x1P;
		this.yP = yP; this.y1P = y1P;
		this.zP = zP; this.z1P = z1P;
		this.dP = dP; this.d1P = d1P;
	}
	
	public String toStringContinue() {
		String signX=" - ", signY=" - ", signZ=" - ";
		double xT=x, yT=y, zT=z;
		
		if (x <0) { signX = new String(" + ");  xT = Math.abs(x);}
		if (y <0) { signY = new String(" + ");  yT = Math.abs(y);}
		if (z <0) { signZ = new String(" + ");  zT = Math.abs(z);}
		
		return "[x"+signX+xT+"]/"+x1 + " = " + "[y"+signY+yT+"]/"+y1 + " = " +"[z"+signZ+zT+"]/"+z1;
	}
	
	public String toStringParametric() {
		String signX=" + ", signY=" + ", signZ=" + ";
		double x1T=x, y1T=y, z1T=z;
		
		if (x1 <0) { signX = new String(" - ");  x1T = Math.abs(x1);}
		if (y1 <0) { signY = new String(" - ");  y1T = Math.abs(y1);}
		if (z1 <0) { signZ = new String(" - ");  z1T = Math.abs(z1);}
		
		return " | x = "+x+signX+x1T+"t\n"+ "-| y = "+y+signY+y1T+"t\n"+ " | z = "+z+signZ+z1T+"t\n";
	}
	
	public String toStringReduced() {
		String signX="", signY="", signZ="", signD="";
		double xT=xP, yT=yP, zT=zP, dT=dP;
		
		if (xP >0) { signX = new String(" +");}		else if (xP <0) { signX = new String(" -");  xT = Math.abs(xP);}
		if (yP >0) { signY = new String(" +");} 	else if (yP <0) { signY = new String(" -");  yT = Math.abs(yP);}
		if (zP >0) { signZ = new String(" +");}		else if (zP <0) { signZ = new String(" -");  zT = Math.abs(zP);}
		if (dP >0) { signD = new String(" +");}		else if (dP <0) { signD = new String(" -");  dT = Math.abs(dP);}
		
		
		String chain = "_|"+signX+xT+"x"+signY+yT+"y"+signZ+zT+"z"+signD+dT+" = 0\n";
		
		String signXP="", signYP="", signZP="", signDP="";
		double x1T=x1P, y1T=y1P, z1T=z1P, d1T=d1P;
		
		if (x1P >0) { signXP = new String(" +");}	else if (x1P <0) { signXP = new String(" -");  x1T = Math.abs(x1P);}
		if (y1P >0) { signYP = new String(" +");}	else if (y1P <0) { signYP = new String(" -");  y1T = Math.abs(y1P);}
		if (z1P >0) { signZP = new String(" +");}	else if (z1P <0) { signZP = new String(" -");  z1T = Math.abs(z1P);}
		if (d1P >0) { signDP = new String(" +");}	else if (d1P <0) { signDP = new String(" -");  d1T = Math.abs(d1P);}
		
		return chain + " |" + signXP+x1T+"x"+signYP+y1T+"y"+signZP+z1T+"z"+signDP+d1T+" = 0\n";
	}	
}

