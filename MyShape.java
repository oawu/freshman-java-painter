import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class MyShape extends JPanel{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int big;
	private Color color;
	private Color leftcolor;
	private Color rightcolor;
	private boolean filled;
	
	public MyShape(){
		this( 0, 0, 0, 0, Color.BLACK,0);
	}
	public MyShape(int x1,int y1,int x2,int y2,Color color,int big){
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.big=big;
		this.color=color;
	}
	public MyShape(int x1,int y1,int x2,int y2,Color color,Color leftcolor,Color rightcolor, boolean filled ,int big){
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		set();
		this.big=big;
		this.color=color;
		this.leftcolor=leftcolor;
		this.rightcolor=rightcolor;
		this.filled=filled;
	}
	public void set(){ 
		int a; 
		if(x1<x2){ } else{ a=x1; x1=x2; x2=a; } 
		if(y1<y2){ } else{ a=y1; y1=y2; y2=a; }
	}
	public void setbig( int big ){
		this.big=big;
	}
	public void setcolor( Color color ){
		this.color=color;
	}
	
	public int getx1(){ return x1; }
	public int gety1(){ return y1; }
	public int getx2(){ return x2; }
	public int gety2(){ return y2; }
	public int getbig(){ return big; }
	public Color getcolor(){ return color; }
	public Color getleftcolor(){ return leftcolor; }
	public Color getrightcolor(){ return rightcolor; }
	public boolean getisfilled(){ return filled; }
	public int getminlong(){  return Math.min( x2 - x1,y2 - y1 ); }
	public int     getwidth( )      { return (  x2 -  x1 ); }
	public int     getheight( )     { return (  y2 -  y1 ); }
	
	public abstract void draw( Graphics g );
}
