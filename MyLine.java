import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyLine extends MyShape{
	public MyLine(){
		this( 0, 0, 0, 0, Color.BLACK,0);
	}
	public MyLine( int x1, int y1, int x2, int y2,Color color,int big){
		super(x1,y1,x2,y2,color,big);
	}
	public void setbig( int big ){ super.setbig(big); }
	public void setcolor( Color color ){ super.setcolor(color); }
	public void draw( Graphics g ){
		Graphics2D g2d = ( Graphics2D ) g; 
		g2d.setPaint( super.getcolor() );    
		g2d.setStroke( new BasicStroke(  super.getbig() ) ); 
		g2d.draw( new Line2D.Double(  super.getx1(),  super.gety1(),  super.getx2(),  super.gety2() ));
	}
}