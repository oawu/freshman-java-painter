import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class MySpray extends MyShape{
	Random rand =new Random();
	private int x1;
	private int y1;
	private int big;
	private Color myColor;
	public MySpray(){
		this( 0, 0, 0, 0, Color.BLACK,0);
	}
	public MySpray( int x1, int y1, int x2, int y2, Color color ,int big){
		super();
		setbig(big);
		setX1( x1 );
		setY1( y1 );
		setColor( color );
	}
	
	public void setX1( int x1 ){ this.x1 = ( x1 >= 0 ? x1-getbig()/2+rand.nextInt(getbig()) : 0 ); }
	public int getX1(){ return x1; }

	public void setY1( int y1 ){ this.y1 = ( y1 >= 0 ? y1-getbig()/2+rand.nextInt(getbig()) : 0 ); } 
	public int getY1(){ return y1; }

	public void setColor( Color color ){ myColor = color; }
	public Color getColor(){ return myColor; }
	
	public void setbig( int big ){ this.big = ( big >= 0 ? big : 0 ); }
	public int getbig(){ return big*8; }
	
	public void draw( Graphics g ){
		Graphics2D g2d = ( Graphics2D ) g; 
		g2d.setPaint( getColor() );    
		g2d.fill( new Ellipse2D.Double(  getX1(), getY1(),1, 1 ) );
	}
}

