import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class PainterTest{
	public static void main( String args[] ){ 
		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(Exception e){e.printStackTrace();}
		MyFrame myframe = new MyFrame("小小畫家");
		myframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		myframe.setExtendedState(Frame.MAXIMIZED_BOTH);
		myframe.setSize( 1200, 800 );
		myframe.setVisible( true );
	}
}