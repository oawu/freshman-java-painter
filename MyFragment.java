import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyFragment extends MyShape{

   private int level;



   public MyFragment( int currentLevel ,int x1,int y1,int x2,int y2,int big,Color color){
	   super(x1,y1,x2,y2,color,big);
	  
      level = currentLevel--;
   }

   
   public void drawFractal( int level, int xA, int yA, int xB,int yB, Graphics2D g2d ){
      if ( level == 0 ) {
    	  g2d.setStroke( new BasicStroke( getbig() ) );
    	  g2d.setPaint(  super.getcolor() );    
    	  g2d.draw( new Line2D.Double( xA, yA, xB, yB ));
      }
      else {	
         int xC = ( xA + xB ) / 2;
         int yC = ( yA + yB ) / 2;
         int xD = xA + ( xC - xA ) / 2 - ( yC - yA ) / 2;
         int yD = yA + ( yC - yA ) / 2 + ( xC - xA ) / 2;
         
         drawFractal( level - 1, xD, yD, xA, yA, g2d );
         drawFractal( level - 1, xD, yD, xC, yC, g2d );
         drawFractal( level - 1, xD, yD, xB, yB, g2d );  
      }
   }

   public int getLevel()
   {
      return level;
   }

	public void draw(Graphics g) {
		Graphics2D g2d = ( Graphics2D ) g; 
		drawFractal( level,  super.getx1(),  super.gety1(),  super.getx2(),  super.gety2(), g2d ); 
	}
};