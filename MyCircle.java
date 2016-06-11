import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyCircle   extends MyShape{
	public MyCircle(){
		this( 0, 0, 0, 0, Color.BLACK,Color.BLACK,Color.BLACK, false ,0);
	}
	public MyCircle( int x1, int y1, int x2, int y2,Color color,Color leftcolor,Color rightcolor, boolean filled ,int big){
		super(x1,y1,x2,y2,color,leftcolor,rightcolor,filled,big);
	}
	public void draw( Graphics g ){
		Graphics2D g2d = ( Graphics2D ) g; 
		if ( super.getisfilled() ){
			g2d.setStroke( new BasicStroke( 1 ) ); 
			g2d.setPaint( new GradientPaint( super.getx1(),super.gety1() , super.getleftcolor(),super.getx2(),super.gety2(),super.getrightcolor(), true ) );  
			g2d.fill( new Ellipse2D.Double(super.getx1(), super.gety1(),super.getminlong(), super.getminlong() ) );
		}
		else{
			g2d.setStroke( new BasicStroke( super.getbig() ) ); 
			g2d.setPaint( super.getcolor() );  
			g2d.draw( new Ellipse2D.Double(super.getx1(), super.gety1(),super.getminlong(),super.getminlong() ) );
		}
	} 
}
