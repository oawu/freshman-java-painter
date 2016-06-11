import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends JFrame {
	private int b=-1,ch=0,ck=0,img=0,level=0,t=2,newpanel=0,fragmentbig;
	
	private JToolBar jToolBar=new JToolBar("工具箱",JToolBar.VERTICAL);
	
	private Color   colors[ ]                           = new Color            [ 17 ];
	private JButton erasersizebutton[ ] 				= new JButton          [  4 ];
	private JButton spraysizebutton[ ] 					= new JButton          [  3 ];
	private JButton brushsizebutton[ ]					= new JButton          [  4 ];
	private JButton linesizebutton[ ] 					= new JButton          [  5 ];
	private JButton arrowheadsizebutton[ ] 				= new JButton          [  5 ];
	private JButton rectsizebutton[ ] 					= new JButton          [  4 ];
	private JButton ovalsizebutton[ ] 					= new JButton          [  4 ];
	private JButton roundrectsizebutton[ ] 				= new JButton          [  4 ];
	private JButton circlesizebutton[ ] 				= new JButton          [  4 ];
	private JButton squaresizebutton[ ] 			    = new JButton          [  4 ];
	private JButton parallelogramsizebutton[ ] 			= new JButton          [  3 ];
	private JButton trapezoidsizebutton[ ] 				= new JButton          [  3 ];
	private JButton rhombussizebutton[ ] 				= new JButton          [  3 ];
	private JButton octanglesizebutton[ ] 				= new JButton          [  3 ];
	private JButton right_angled_trianglesizebutton[ ] 	= new JButton          [  3 ];
	private JButton hexagonsizebutton[ ] 				= new JButton          [  3 ];
	private JButton crosssizebutton[ ] 					= new JButton          [  3 ];
	private JButton pentagonsizebutton[ ] 				= new JButton          [  3 ];
	private JButton trianglesizebutton[ ] 				= new JButton          [  3 ];
	private JButton cylinder[ ] 			        	= new JButton          [  3 ];
	private JToggleButton toolbutton[ ] 						= new JToggleButton          [ 21 ];
	private JCheckBoxMenuItem item6_2[ ]                = new JCheckBoxMenuItem[  3 ];
	private JCheckBoxMenuItem item2[ ]                  = new JCheckBoxMenuItem[  4 ];
	private JLabel filllabel[ ]                         = new JLabel           [  2 ];
	private JLabel blanklabel[ ]                        = new JLabel           [  2 ];
	private JMenu menu[ ]                               = new JMenu            [  8 ];
	private JMenu item6[ ]                              = new JMenu            [  2 ];
	private JMenuItem item0[ ]                          = new JMenuItem        [  5 ];
	private JMenuItem item1[ ]                          = new JMenuItem        [  2 ];
	private JMenuItem item3[ ]                          = new JMenuItem        [  1 ];
	private JMenuItem item4[ ]                          = new JMenuItem        [  1 ];
	private JMenuItem item5[ ]                          = new JMenuItem        [  1 ];
	private JMenuItem item6_1[ ]                        = new JMenuItem        [  2 ];
	private JMenuItem item7[ ]                          = new JMenuItem        [  2 ];
	private JPanel  panel[]                             = new JPanel           [ 54 ];
	private JTextField colorbutton[ ] 					= new JTextField       [ 16 ];
	private JTextField filltextfield[ ]                 = new JTextField       [  2 ]; 
	private MyShape  back[]                             = new MyShape          [10000];
	private Painter Bpanel[]                            = new Painter          [ 50 ];
	
	private JButton backbutton;
	private JButton nextbutton;
	private JButton fragmentbackbutton;
	private JButton fragmentnextbutton;
	private JLabel  statelabel; 
	private JLabel toollabel;
	private JLabel rightcolorlabel;
	private JLabel leftcolorlabel;
	private JLabel fragmentlinebiglabel;
	private JTextField rightcolortextfield; 
	private JTextField leftcolortextfield; 
	private JTextField coordtetextfield; 
	private JTextField areatetextfield; 
	private JTextField tooltextfield; 
	private JTextField fragmenttextfield;
	private JTabbedPane tabbedPane;
	private JTabbedPane tabbedPane2;
	private JMenuBar bar; 
	private ImageIcon bug;
	private ButtonGroup radiogroup;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textarea1; 
	private JTextArea textarea2; 
	private JSpinner fragmentlinebig;
	private MyShape fragment;
	private boolean filled;
	
	public MyFrame(String caption){
		super( caption );
		
		declare( );			/*宣告物件*/
		set( );				/*設定初始*/
		setpanellayout( );	/*設定排列*/
		setpanelcolor( );	/*設定顏色*/
		Add( );				/*加入*/
		handler( );			/*監聽*/
		
	  	add( panel[ 0 ] );
   } 
	
	public void declare( ){
		for(int i=0 ; i < panel.length                           ; i++ ){ panel[i]                           = new JPanel    ( ); }
		for(int i=0 ; i < Bpanel.length                          ; i++ ){ Bpanel[i]                          = new Painter   ( ); }
		for(int i=0 ; i < colorbutton.length                     ; i++ ){ colorbutton[i]                     = new JTextField(2); 
			                                                              colorbutton[i].setEditable( false ); }
		for(int i=0 ; i < colors.length                          ; i++ ){ colors[i]				             = new Color (0,0,0); }
		for(int i=0 ; i < erasersizebutton.length                ; i++ ){ erasersizebutton[i] 	             = new JButton   ( ); }
		for(int i=0 ; i < spraysizebutton.length                 ; i++ ){ spraysizebutton[i] 		         = new JButton   ( ); }
		for(int i=0 ; i < brushsizebutton.length                 ; i++ ){ brushsizebutton[i] 		         = new JButton   ( ); }
		for(int i=0 ; i < linesizebutton.length                  ; i++ ){ linesizebutton[i] 		         = new JButton   ( ); }
		for(int i=0 ; i < arrowheadsizebutton.length             ; i++ ){ arrowheadsizebutton[i] 		     = new JButton   ( ); }
		for(int i=0 ; i < rectsizebutton.length                  ; i++ ){ rectsizebutton[i] 		         = new JButton   ( ); }
		for(int i=0 ; i < ovalsizebutton.length                  ; i++ ){ ovalsizebutton[i] 		         = new JButton   ( ); }
		for(int i=0 ; i < roundrectsizebutton.length             ; i++ ){ roundrectsizebutton[i] 	         = new JButton   ( ); }
		for(int i=0 ; i < circlesizebutton.length                ; i++ ){ circlesizebutton[i] 	             = new JButton   ( ); }
		for(int i=0 ; i < squaresizebutton.length                ; i++ ){ squaresizebutton[i]                = new JButton   ( ); }
		for(int i=0 ; i < parallelogramsizebutton.length         ; i++ ){ parallelogramsizebutton[i]         = new JButton   ( ); }
		for(int i=0 ; i < trapezoidsizebutton.length             ; i++ ){ trapezoidsizebutton[i]  	 	     = new JButton   ( ); }
		for(int i=0 ; i < rhombussizebutton.length               ; i++ ){ rhombussizebutton[i]  	 	     = new JButton   ( ); }
		for(int i=0 ; i < octanglesizebutton.length              ; i++ ){ octanglesizebutton[i] 	 	 	 = new JButton   ( ); }
		for(int i=0 ; i < right_angled_trianglesizebutton.length ; i++ ){ right_angled_trianglesizebutton[i] = new JButton   ( ); }
		for(int i=0 ; i < hexagonsizebutton.length               ; i++ ){ hexagonsizebutton[i] 	             = new JButton   ( ); }
		for(int i=0 ; i < crosssizebutton.length                 ; i++ ){ crosssizebutton[i] 	             = new JButton   ( ); }
		for(int i=0 ; i < pentagonsizebutton.length              ; i++ ){ pentagonsizebutton[i] 	         = new JButton   ( ); }
		for(int i=0 ; i < trianglesizebutton.length              ; i++ ){ trianglesizebutton[i] 	         = new JButton   ( ); }
		for(int i=0 ; i < cylinder.length                        ; i++ ){cylinder[i] 	                     = new JButton   ( ); }
		for(int i=0 ; i < filllabel.length                       ; i++ ){ filllabel[i] 		                 = new JLabel    ( ); }
		for(int i=0 ; i < filltextfield.length                   ; i++ ){ filltextfield[i]                   = new JTextField( ); }
		for(int i=0 ; i < menu.length                            ; i++ ){ menu[i] 		                     = new JMenu     ( ); }
		for(int i=0 ; i < item0.length                           ; i++ ){ item0[i] 		                     = new JMenuItem ( ); }
		for(int i=0 ; i < item1.length                           ; i++ ){ item1[i] 		                     = new JMenuItem ( ); }
		for(int i=0 ; i < item2.length                           ; i++ ){ item2[i]                           = new JCheckBoxMenuItem( ); }	
		for(int i=0 ; i < item3.length                           ; i++ ){ item3[i] 		                     = new JMenuItem ( ); }
		for(int i=0 ; i < item4.length                           ; i++ ){ item4[i] 		                     = new JMenuItem ( ); }
		for(int i=0 ; i < item5.length                           ; i++ ){ item5[i] 		                     = new JMenuItem ( ); }
		for(int i=0 ; i < blanklabel.length                      ; i++ ){ blanklabel[i]                      = new JLabel    ( ); }
		for(int i=0 ; i < toolbutton.length                      ; i++ ){ toolbutton[i]                      = new JToggleButton   ( ); }
		backbutton = new JButton();
		nextbutton = new JButton();
		fragmentbackbutton = new JButton();
		fragmentnextbutton = new JButton();
		
		bar = new JMenuBar( ); 
		
	    toollabel       = new JLabel( );
		rightcolorlabel = new JLabel( );
		leftcolorlabel  = new JLabel( );
		statelabel      = new JLabel( );
		fragmentlinebiglabel = new JLabel();
		
		rightcolortextfield = new JTextField ( );
		leftcolortextfield  = new JTextField ( );
		coordtetextfield    = new JTextField ( );
		areatetextfield     = new JTextField ( );
		tooltextfield       = new JTextField ( ); 
		fragmenttextfield   = new JTextField();
		
		tabbedPane          = new JTabbedPane( );
		tabbedPane2         = new JTabbedPane();
		
		radiogroup = new ButtonGroup();

		textarea1 = new JTextArea();
		textarea2 = new JTextArea();
		
		fragmentlinebig = new JSpinner();
	}
	public void set( ){
		colors[ 0] = new Color(   0,   0,   0);
		colors[ 1] = new Color( 128, 128, 128);
		colors[ 2] = new Color( 128,   0,   0);
		colors[ 3] = new Color( 128, 128,   0);
		colors[ 4] = new Color(   0, 128,   0);
		colors[ 5] = new Color(   0, 128, 128);
		colors[ 6] = new Color(   0,   0, 128);
		colors[ 7] = new Color( 128,   0, 128);
		colors[ 8] = new Color( 255, 255, 255);
		colors[ 9] = new Color( 192, 192, 192);
		colors[10] = new Color( 255,   0,   0);
		colors[11] = new Color( 255, 255,   0);
		colors[12] = new Color(   0, 255,   0);
		colors[13] = new Color(   0, 255, 255);
		colors[14] = new Color(   0,   0, 255);
		colors[15] = new Color( 255,   0, 255);
		
		for(int i = 0 ; i < colorbutton.length ; i++ ){ colorbutton[i].setBackground(colors[i]); }
		
		rightcolorlabel      = new JLabel("您右鍵所選的顏色:");
		leftcolorlabel       = new JLabel("您左鍵所選的顏色:");
		statelabel           = new JLabel("如需說明，請按一下[說明]功能表中的[說明主題]");
		toollabel            = new JLabel("工具:");
		filllabel[0]         = new JLabel("筆[預定工具]。          ");
		filllabel[1]         = new JLabel("<=>");
		fragmentlinebiglabel = new JLabel("選擇大小 : ");
		
		rightcolortextfield = new JTextField( 3); 
		leftcolortextfield  = new JTextField( 3); 
		coordtetextfield    = new JTextField( 6);
		areatetextfield     = new JTextField( 6);
		tooltextfield       = new JTextField( 6);
		filltextfield[0]    = new JTextField( 3); 
		filltextfield[1]    = new JTextField( 3); 
		fragmenttextfield   = new JTextField(20);
		fragmenttextfield.setText(String.format("第%d層",1));
		tooltextfield.setText( "筆" );
		rightcolortextfield.setBackground( new Color(255,255,255));
		leftcolortextfield.setBackground(  new Color(0,0,0));
		coordtetextfield.setBackground(    new Color(215,215,215));
		areatetextfield.setBackground(     new Color(215,215,215));
		filltextfield[0].setBackground(    new Color(0,0,0));
		filltextfield[1].setBackground(    new Color(255,255,255));
		fragmenttextfield.setBackground(   new Color(215,215,215));
		rightcolortextfield.setEditable( false );
		leftcolortextfield.setEditable(  false );
		coordtetextfield.setEditable(    false );
		areatetextfield.setEditable(     false );
		tooltextfield.setEditable(       false );
		filltextfield[0].setEditable(    false );
		filltextfield[1].setEditable(    false );
		fragmenttextfield.setEditable(   false );
		
		for(int i=0 ; i<toolbutton.length;i++){
			toolbutton[i]=new JToggleButton(new ImageIcon( getClass().getResource(String.format("0%d.gif",i)) ));
			if(i==2){ toolbutton[i].setBackground(new Color(160,160,160)); }
			else{     toolbutton[i].setBackground(new Color(215,215,215)); }
		}
		for(int i = 0 ; i < erasersizebutton.length                ; i++ ){ erasersizebutton[i]                = new JButton( new ImageIcon( getClass().getResource( String.format( "1%d.gif" , i)) ));
			                                                                brushsizebutton[i]                 = new JButton( new ImageIcon( getClass().getResource( String.format( "1%d.gif" , i)) )); }
		for( int i = 0 ; i < spraysizebutton.length                ; i++ ){ spraysizebutton[i]                 = new JButton( new ImageIcon( getClass().getResource( String.format( "2%d.gif" , i)) )); }
		for( int i = 0 ; i < linesizebutton.length                 ; i++ ){ linesizebutton[i]                  = new JButton( new ImageIcon( getClass().getResource( String.format( "3%d.gif" , i)) )); }
		for( int i = 0 ; i < arrowheadsizebutton.length            ; i++ ){ arrowheadsizebutton[i]             = new JButton( new ImageIcon( getClass().getResource( String.format( "4%d.gif" , i)) )); }
		for( int i = 0 ; i < rectsizebutton.length                 ; i++ ){ rectsizebutton[i]                  = new JButton( new ImageIcon( getClass().getResource( String.format( "5%d.gif" , i)) )); }
		for( int i = 0 ; i < ovalsizebutton.length                 ; i++ ){ ovalsizebutton[i]                  = new JButton( new ImageIcon( getClass().getResource( String.format( "6%d.gif" , i)) )); }
		for( int i = 0 ; i < roundrectsizebutton.length            ; i++ ){ roundrectsizebutton[i]             = new JButton( new ImageIcon( getClass().getResource( String.format( "7%d.gif" , i)) )); }
		for( int i = 0 ; i < circlesizebutton.length               ; i++ ){ circlesizebutton[i]                = new JButton( new ImageIcon( getClass().getResource( String.format( "8%d.gif" , i)) )); }
		for( int i = 0 ; i < squaresizebutton.length               ; i++ ){ squaresizebutton[i]                = new JButton( new ImageIcon( getClass().getResource( String.format( "9%d.gif" , i)) )); }
		for( int i = 0 ; i < parallelogramsizebutton.length        ; i++ ){ parallelogramsizebutton[i]         = new JButton( new ImageIcon( getClass().getResource( String.format( "10%d.gif" , i)) )); }
		for( int i = 0 ; i < trapezoidsizebutton.length            ; i++ ){ trapezoidsizebutton[i]             = new JButton( new ImageIcon( getClass().getResource( String.format( "11%d.gif" , i)) )); }
		for( int i = 0 ; i < rhombussizebutton.length              ; i++ ){ rhombussizebutton[i]               = new JButton( new ImageIcon( getClass().getResource( String.format( "12%d.gif" , i)) )); }
		for( int i = 0 ; i < octanglesizebutton.length             ; i++ ){ octanglesizebutton[i]              = new JButton( new ImageIcon( getClass().getResource( String.format( "13%d.gif" , i)) )); }
		for( int i = 0 ; i < right_angled_trianglesizebutton.length; i++ ){ right_angled_trianglesizebutton[i] = new JButton( new ImageIcon( getClass().getResource( String.format( "14%d.gif" , i)) )); }
		for( int i = 0 ; i < hexagonsizebutton.length              ; i++ ){ hexagonsizebutton[i]               = new JButton( new ImageIcon( getClass().getResource( String.format( "15%d.gif" , i)) )); }
		for( int i = 0 ; i < crosssizebutton.length                ; i++ ){ crosssizebutton[i]                 = new JButton( new ImageIcon( getClass().getResource( String.format( "16%d.gif" , i)) )); }
		for( int i = 0 ; i < pentagonsizebutton.length             ; i++ ){ pentagonsizebutton[i]              = new JButton( new ImageIcon( getClass().getResource( String.format( "17%d.gif" , i)) )); }
		for( int i = 0 ; i < trianglesizebutton.length             ; i++ ){ trianglesizebutton[i]              = new JButton( new ImageIcon( getClass().getResource( String.format( "18%d.gif" , i)) )); }
		for( int i = 0 ; i < cylinder.length                       ; i++ ){ cylinder[i]                        = new JButton( new ImageIcon( getClass().getResource( String.format( "21%d.gif" , i)) )); }
		backbutton         = new JButton(new ImageIcon( getClass().getResource(String.format("192.gif")) ));
		nextbutton         = new JButton(new ImageIcon( getClass().getResource(String.format("193.gif")) ));
		fragmentbackbutton = new JButton("回上一個圖");
		fragmentnextbutton = new JButton("往下一個圖");
		backbutton.setBackground(        new Color(215,215,215));
		nextbutton.setBackground(        new Color(215,215,215));
		fragmentbackbutton.setBackground(new Color(215,215,215));
		fragmentnextbutton.setBackground(new Color(215,215,215));
		
		textarea1 = new JTextArea(75,30);
		textarea2 = new JTextArea(35,30);
		textarea1.setText(" 本程式有分四個區域 :  1.顏色區   2.工具區   3.進階工具圖形區   4.選單區、狀態列區\n\n 1.顏色區\n\n     顏色區在程式執行畫面下方(南方)，一共有16種顏色，可以任意選色，顏色按鈕\n     其中功能有 : 1.顏色選擇有細分為滑鼠左鍵選色、右鍵選色，在畫面上方各有兩處會\n     顯示目前的選色(上、下兩方)2. 當要進階選色時可以點兩下任何顏色按鈕(與小畫家\n     功能相同)\n\n\n 2.工具區\n\n     工具區在程式執行畫面的左方(西方)，一共有6種功能鍵，當點及任何功能鍵時會\n     再此區的下方出現相關的功能 (如:粗、細)； 功能鍵分別為 1.橡皮擦 2.噴漆 \n     3.筆4.筆刷 5.直線 6.箭頭。\n    \n     工具區功能鍵說明:\n         1.當點擊橡皮擦鍵時，會出現四種大小選擇鈕，橡皮擦的顏色是決定於滑鼠的\n            右鍵(此特色與小畫家相同)。\n         2.當點擊噴漆鍵時，會出現三種範圍選擇。\n         3.當點擊筆鍵時，不會出現任何大小選擇(此特色與小畫家相同)。\n         4.當點擊筆刷鍵時，會出現和橡皮擦一樣的四種大小選擇鈕。\n         5.當點擊直線鍵時，會出現五種粗、細選擇鈕。\n         6.當點擊箭頭鍵時，會出現五種粗、細選擇鈕。\n\n\n 3.進階工具圖形區\n\n     進階工具圖形區在程式執行畫面的右方(東方)，此區一共有兩種選單 1.多邊型 \n     2.碎行圖\n\n     多邊型說明:\n         此區全部有15種圖形，分別有長方形、橢圓型、圓角型、(正)圓型、(正)方形、\n         平行四邊形、梯形、菱形、八角型、直角三角形、六角型、十字型、五角型、\n         三角形、圓柱型；當點選長方形、橢圓型、圓角型、(正)圓型、(正)方形時會\n         有\"填充的功能\"而填充顏色的選擇在於左右鍵 ( 例如:左鍵>黑、右鍵>白;出現\n         由黑到白的漸層)，而粗、細的功能每個圖形間皆有。\n     碎行圖說明:\n        當點及選單(碎型圖)時，功能將自動跳至直線(使用者可自己選直線)，當畫完\n        直線後，請點選下一步，當點選完下一步後即可看到用遞迴執行完的碎形圖案。\n        在這個選單中也可以調線的粗細(選單中間)和顏色(點選色塊)。\n\n\n 4.選單區、狀態列區\n\n     選單區在程式執行畫面的上方(東方)、狀態列區程式執行畫面的最下方(最南方)。\n\n     選單區說明:\n         此區由左而右分別為檔案、編輯、檢視、影像、色彩、說明、Settings、\n         Programs。\n        \n         檔案鍵說明:\n             此內容一共有開新檔案、開啟舊檔、儲存檔案、另存新檔、離開，此區的\n             開新檔案、開啟舊檔、離開皆可以使用，可以開啟圖片檔，而儲存功能能\n             尚未完成。\n         編輯鍵說明:\n              此內容一共有復原、重複兩種功能。\n         檢視鍵說明:\n              此內容可以勾選是否顯示工具箱(工具區)、色塊(顏色區)、狀態列、進階\n          功能列表。\n         影像鍵說明:\n              此內容有清除清除影像的功能，當點擊此鍵時則會跳出選擇清除哪一圖層\n              的選單。(選單:請注意畫布)\n         色彩鍵說明:\n              此內容有選擇色彩的功能，當點擊時則會跳出選單，此選擇是左鍵的顏色\n              (橡皮擦是右鍵)。\n         說明鍵說明:\n              此內容有關於此程式的資訊。\n         Settings、 Programs鍵說明:\n              此內容則是作業要求內容。\n\n     狀態列區說明:\n         此區可細分為兩區，一區在選單區下方、另一區在顏色區下方。此區會顯示使用者\n         的使用狀態。在顏色區下方的狀態列會顯示滑鼠在畫布的座標，其顯示座標的規格\n         和小畫家一樣。");
   		textarea2.setText(" 完成度說明:\n \n     這個程式的完成度說明我分成兩部分來說明!\n \n\n     1.完成的功能:\n\n         在執行中最讓我引以為傲的功能是當滑鼠在色塊區點兩下時\n\n         會跳出一個視窗讓你有更多的顏色選擇，於在我的畫布中，\n\n         滑鼠的左右鍵分別可以有不同的顏色!也就是說可以用右鍵\n\n         選色；再來是我的回到上一步，當一開始都沒有劃任何圖按\n\n         前，如果把滑鼠移到按鍵上，按鍵是不會有任何的反應的(不\n\n         能回到上一步)，如果有話圖案的話，當滑鼠一到按鍵上時，\n\n         則有顏色的變化。在這次的要求中我自己另外學到其他的語法\n\n         如:開啟舊檔，本程式可以開啟任何的圖片檔。還有一些細部\n\n         的小功能，如:按Shift+E的話可以開啟選色單...!\n\n\n     2.尚未完成的功能:\n\n         對於本程式能有一些尚未完成的功能，如存檔!其中還有回到上\n\n         一步這個功能能然有小問題(當回上一步後在畫圖之後的回上一\n\n         步)，除此之外大致都差不多完成了。\n");
   		textarea1.setFocusable( false );
   		textarea2.setFocusable( false );
		fragmentlinebig.setValue(new Integer(1));
   		
		setJMenuBar( bar ); 
	
		menu[0] = new JMenu( "檔案 (F)" );
		menu[1] = new JMenu( "編輯 (E)" ); 
		menu[2] = new JMenu( "檢視 (V)" ); 
		menu[3] = new JMenu( "影像 (I)" ); 
		menu[4] = new JMenu( "色彩 (c)" ); 
		menu[5] = new JMenu( "說明(H)" ); 
		menu[6] = new JMenu( "Settings (S)" ); 
		menu[7] = new JMenu( "Programs (P)" ); 
		menu[0].setMnemonic( 'F' ); 
		menu[1].setMnemonic( 'E' );
		menu[2].setMnemonic( 'V' );
		menu[3].setMnemonic( 'I' );
		menu[4].setMnemonic( 'c' );
		menu[5].setMnemonic( 'H' );
		menu[6].setMnemonic( 'S' );
		menu[7].setMnemonic( 'P' );
		
		item6[0] = new JMenu( "Colors C)" ); 
		item6[1] = new JMenu( "Toolbox (T)" ); 
		item6[0].setMnemonic( 'C' );
		item6[1].setMnemonic( 'T' );
		
		item0[0] = new JMenuItem( "開新檔案 (N)" );
		item0[1] = new JMenuItem( "開啟舊檔 (O)" );
		item0[2] = new JMenuItem( "儲存檔案 (S)" );
		item0[3] = new JMenuItem( "另存新黨 (A)" );
		item0[4] = new JMenuItem( "離開 (X)" );
		item0[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("78"), ActionEvent.CTRL_MASK));
		item0[1].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("81"), ActionEvent.CTRL_MASK));
		item0[2].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("83"), ActionEvent.CTRL_MASK));
		item0[3].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("65"), ActionEvent.CTRL_MASK));
		item0[4].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("88"), ActionEvent.CTRL_MASK));
		item0[0].setMnemonic( 'N' ); 
		item0[1].setMnemonic( 'O' ); 
		item0[2].setMnemonic( 'S' ); 
		item0[3].setMnemonic( 'A' ); 
		item0[4].setMnemonic( 'X' ); 
		
		item1[0] = new JMenuItem( "復原 (U)" );
		item1[1]= new JMenuItem( "重複 (R)" ); 
		item1[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("90"), ActionEvent.CTRL_MASK));
		item1[1].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("89"), ActionEvent.CTRL_MASK));
		item1[0].setMnemonic( 'U' ); 
		item1[1].setMnemonic( 'R' );
		item1[0].setEnabled(false);
		item1[1].setEnabled(false);
		
		item2[0] = new JCheckBoxMenuItem( "工具箱 (T)" );
		item2[1] = new JCheckBoxMenuItem( "色塊 (C)" );
		item2[2] = new JCheckBoxMenuItem( "狀態列 (D)" );
		item2[3] = new JCheckBoxMenuItem( "進階功能列表 (G)" );
		item2[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("84"), ActionEvent.CTRL_MASK));
		item2[1].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("76"), ActionEvent.CTRL_MASK));
		item2[2].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("68"), ActionEvent.CTRL_MASK));
		item2[3].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("71"), ActionEvent.CTRL_MASK));
		item2[0].setMnemonic( 'T' ); 
		item2[1].setMnemonic( 'C' );
		item2[2].setMnemonic( 'D' );
		item2[3].setMnemonic( 'G' );
		item2[0].setSelected(true);
		item2[1].setSelected(true);
		item2[2].setSelected(true);
		item2[3].setSelected(true);
		
		item3[0]= new JMenuItem( "清除影像 (C)" ); 
		item3[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("67"), ActionEvent.SHIFT_MASK));
		item3[0].setMnemonic( 'C' );
		item3[0].setEnabled(false);
		
		item4[0]= new JMenuItem( "編輯色彩 (E)" ); 
		item4[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("69"), ActionEvent.SHIFT_MASK));
		item4[0].setMnemonic( 'E' );
		item4[0].setEnabled(true);
		
		item5[0] = new JMenuItem( "關於小小畫家 (A)" );
		item5[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("65"), ActionEvent.SHIFT_MASK));
		item5[0].setMnemonic( 'A' ); 
		
		
		item6_1[0] = new JMenuItem( "Foreground (F)" );
		item6_1[1] = new JMenuItem( "Background (B)" );
		
		item6_1[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("70"), ActionEvent.CTRL_MASK));
		item6_1[1].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("66"), ActionEvent.CTRL_MASK));
		item6_1[0].setMnemonic( 'F' );
		item6_1[1].setMnemonic( 'B' ); 
		
		item6_2[0] = new JCheckBoxMenuItem( "Flowchard (F)" );
		item6_2[1] = new JCheckBoxMenuItem( "Advanced (A)" );
		item6_2[2] = new JCheckBoxMenuItem( "All            (L)" );
		item6_2[0].setSelected(false);
		item6_2[1].setSelected(false);
		item6_2[2].setSelected(true);
		item6_2[0].setMnemonic( 'F' );
		item6_2[1].setMnemonic( 'A' );
		item6_2[2].setMnemonic( 'L' );
		  	
		for(int i=0;i < item6_2.length;i++){
			radiogroup.add(item6_2[i]); 
		}	  	
		 	
		item7[0] = new JMenuItem( "Help (H)" );
		item7[1] = new JMenuItem( "Done (D)" );
		item7[0].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("72"), ActionEvent.CTRL_MASK));
		item7[1].setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt("68"), ActionEvent.SHIFT_MASK));
		item7[0].setMnemonic( 'H' ); 
		item7[1].setMnemonic( 'D' );
		  	
		
	}
	public void setpanellayout(){
		panel[11].setLayout( new FlowLayout( ) );
		panel[12].setLayout( new FlowLayout( ) );
		panel[14].setLayout( new FlowLayout( ) );
		panel[16].setLayout( new FlowLayout( ) );
		panel[18].setLayout( new FlowLayout( ) );
		panel[20].setLayout( new FlowLayout( ) );
		panel[25].setLayout( new FlowLayout( ) );
		panel[27].setLayout( new FlowLayout( ) );
		panel[28].setLayout( new FlowLayout( ) );
		panel[30].setLayout( new FlowLayout( ) );
		panel[32].setLayout( new FlowLayout( ) );
		panel[34].setLayout( new FlowLayout( ) );
		panel[36].setLayout( new FlowLayout( ) );
		panel[37].setLayout( new FlowLayout( ) );
		panel[43].setLayout( new FlowLayout( ) );
		panel[45].setLayout( new FlowLayout( ) );
		panel[46].setLayout( new FlowLayout( ) );
		panel[48].setLayout( new FlowLayout( ) );
		panel[50].setLayout( new FlowLayout( ) );
		panel[52].setLayout( new FlowLayout( ) );
		panel[53].setLayout( new FlowLayout( ) );
		
		panel[ 0].setLayout( new BorderLayout( 4, 4) );
		panel[ 1].setLayout( new BorderLayout( 2, 2) );
		panel[ 2].setLayout( new BorderLayout( 4, 4) );
		panel[ 3].setLayout( new BorderLayout( 2, 2) );
		panel[ 4].setLayout( new BorderLayout( 2, 2) );
		panel[ 6].setLayout( new BorderLayout( 2, 2) );
		panel[ 8].setLayout( new BorderLayout( 2, 2) );
		panel[10].setLayout( new BorderLayout( 2, 2) );
		panel[13].setLayout( new BorderLayout( 2, 2) );
		panel[15].setLayout( new BorderLayout( 2, 2) );
		panel[17].setLayout( new BorderLayout( 2, 2) );
		panel[19].setLayout( new BorderLayout( 2, 2) );
		panel[21].setLayout( new BorderLayout( 2, 2) );
		panel[22].setLayout( new BorderLayout( 2, 2) );
		panel[24].setLayout( new BorderLayout( 2, 2) );
		panel[26].setLayout( new BorderLayout( 2, 2) );
		panel[29].setLayout( new BorderLayout( 2, 2) );
		panel[31].setLayout( new BorderLayout( 2, 2) );
		panel[33].setLayout( new BorderLayout( 2, 2) );
		panel[35].setLayout( new BorderLayout( 2, 2) );
		panel[38].setLayout( new BorderLayout( 2, 2) );
		panel[39].setLayout( new BorderLayout( 2, 2) );
		panel[41].setLayout( new BorderLayout( 2, 2) );
		panel[44].setLayout( new BorderLayout( 2, 2) );
		panel[47].setLayout( new BorderLayout( 2, 2) );
		panel[49].setLayout( new BorderLayout( 2, 2) );
		panel[51].setLayout( new BorderLayout( 2, 2) );
	 	
		panel[ 5].setLayout( new GridLayout( 2, 1, 2, 2) );
		panel[ 7].setLayout( new GridLayout( 2, 4, 2, 2) );
		panel[ 9].setLayout( new GridLayout( 2, 8, 2, 2) );
		
		panel[23].setLayout( new GridLayout( 3, 2, 1, 1) );
		jToolBar.setLayout( new GridLayout( 3, 2, 0, 0) );
		jToolBar.setFloatable(false);
		panel[40].setLayout( new GridLayout( 5, 3, 1, 1) );
	}		
	public void setpanelcolor(){
		panel[0].setBackground(new Color(176,176,176));
		panel[1].setBackground(new Color(176,176,176));
		panel[2].setBackground(new Color(176,176,176));
		panel[3].setBackground(new Color(176,176,176));
		panel[4].setBackground(new Color(176,176,176));
		panel[6].setBackground(new Color(176,176,176));
		panel[8].setBackground(new Color(176,176,176));
		panel[10].setBackground(new Color(176,176,176));
		panel[13].setBackground(new Color(176,176,176));
		panel[15].setBackground(new Color(176,176,176));
		panel[17].setBackground(new Color(176,176,176));
		panel[19].setBackground(new Color(176,176,176));
		panel[22].setBackground(new Color(176,176,176));
		panel[24].setBackground(new Color(176,176,176));
		panel[29].setBackground(new Color(176,176,176));
		panel[31].setBackground(new Color(176,176,176));
		panel[33].setBackground(new Color(176,176,176));
		panel[35].setBackground(new Color(176,176,176));
		panel[38].setBackground(new Color(176,176,176));
		panel[39].setBackground(new Color(176,176,176));
		panel[44].setBackground(new Color(176,176,176));
		panel[47].setBackground(new Color(176,176,176));
		panel[49].setBackground(new Color(176,176,176));
		panel[51].setBackground(new Color(176,176,176));
		
		panel[5].setBackground(new Color(215,215,215));
		panel[7].setBackground(new Color(215,215,215));
		panel[9].setBackground(new Color(215,215,215));
		panel[11].setBackground(new Color(215,215,215));
		panel[12].setBackground(new Color(215,215,215));
		panel[14].setBackground(new Color(215,215,215));
		panel[16].setBackground(new Color(215,215,215));
		panel[18].setBackground(new Color(215,215,215));
		panel[20].setBackground(new Color(215,215,215));
		panel[21].setBackground(new Color(215,215,215));
		panel[23].setBackground(new Color(215,215,215));
		panel[25].setBackground(new Color(215,215,215));
		panel[26].setBackground(new Color(215,215,215));
		panel[27].setBackground(new Color(215,215,215));
		panel[28].setBackground(new Color(215,215,215));
		panel[30].setBackground(new Color(215,215,215));
		panel[32].setBackground(new Color(215,215,215));
		panel[34].setBackground(new Color(215,215,215));
		panel[36].setBackground(new Color(215,215,215));
		panel[37].setBackground(new Color(215,215,215));
		panel[39].setBackground(new Color(215,215,215));
		panel[40].setBackground(new Color(215,215,215));
		panel[41].setBackground(new Color(215,215,215));
		panel[42].setBackground(new Color(215,215,215));
		panel[43].setBackground(new Color(215,215,215));
		panel[45].setBackground(new Color(215,215,215));
		panel[46].setBackground(new Color(215,215,215));
		panel[48].setBackground(new Color(215,215,215));
		panel[50].setBackground(new Color(215,215,215));
		panel[52].setBackground(new Color(215,215,215));
		panel[53].setBackground(new Color(215,215,215));
	}
	public void Add(){
		for(int i=0; i<colorbutton.length;i++){ panel[9].add(colorbutton[i]); }
		panel[7].add(leftcolortextfield);
		panel[7].add(blanklabel[0]);
		panel[7].add(rightcolortextfield);
		panel[7].add(blanklabel[1]);
		panel[5].add(leftcolorlabel);
		panel[5].add(rightcolorlabel);
		panel[10].add(panel[11],BorderLayout.WEST);
		panel[10].add(panel[12],BorderLayout.CENTER);
		panel[8].add(panel[9],BorderLayout.WEST);
		panel[8].add(panel[10],BorderLayout.CENTER);
		panel[6].add(panel[7],BorderLayout.WEST);
		panel[6].add(panel[8],BorderLayout.CENTER);
		panel[4].add(panel[5],BorderLayout.WEST);
		panel[4].add(panel[6],BorderLayout.CENTER);
		panel[16].add(areatetextfield);
		panel[21].add(statelabel);
		panel[18].add(coordtetextfield);
		panel[19].add(panel[20],BorderLayout.EAST);
		panel[19].add(panel[21],BorderLayout.CENTER);
		panel[17].add(panel[18],BorderLayout.EAST);
		panel[17].add(panel[19],BorderLayout.CENTER);
		panel[15].add(panel[16],BorderLayout.EAST);
		panel[15].add(panel[17],BorderLayout.CENTER);
		panel[13].add(panel[14],BorderLayout.EAST);
		panel[13].add(panel[15],BorderLayout.CENTER);
		panel[3].add(panel[4],BorderLayout.CENTER);
		panel[3].add(panel[13],BorderLayout.SOUTH);
		panel[25].add(toollabel);
		panel[25].add(tooltextfield);
		
		for(int i=0;i<6;i++){ 
			jToolBar.add(toolbutton[i]);
			toolbutton[i].setFocusable( false );
			buttonGroup.add(toolbutton[i]);
		}
		
		panel[26].add(panel[27],BorderLayout.NORTH);
		panel[24].add(panel[25],BorderLayout.NORTH);
		panel[24].add(panel[26],BorderLayout.CENTER);
		panel[22].add(jToolBar,BorderLayout.NORTH);
		panel[22].add(panel[24],BorderLayout.CENTER);
		panel[2].add(panel[3],BorderLayout.SOUTH);
		panel[2].add(tabbedPane,BorderLayout.CENTER);
		panel[2].add(panel[22],BorderLayout.WEST);
		panel[30].add(filllabel[0]);
		panel[32].add(filltextfield[0]);
		panel[34].add(filllabel[1]);
		panel[36].add(filltextfield[1]);
		panel[37].add(backbutton);
		panel[37].add(nextbutton);
		panel[44].add(panel[37],BorderLayout.WEST);
		panel[44].add(panel[45],BorderLayout.CENTER);
		panel[35].add(panel[36],BorderLayout.WEST);
		panel[35].add(panel[44],BorderLayout.CENTER);
		panel[33].add(panel[34],BorderLayout.WEST);
		panel[33].add(panel[35],BorderLayout.CENTER);
		panel[31].add(panel[32],BorderLayout.WEST);
		panel[31].add(panel[33],BorderLayout.CENTER);
		panel[29].add(panel[30],BorderLayout.WEST);
		panel[29].add(panel[31],BorderLayout.CENTER);
		
		for(int i=6;i<toolbutton.length;i++){ panel[40].add(toolbutton[i]); }
		
		
		panel[41].add(panel[42],BorderLayout.NORTH);
		panel[41].add(panel[43],BorderLayout.CENTER);
		panel[38].add(panel[40],BorderLayout.NORTH);
		panel[38].add(panel[41],BorderLayout.CENTER);
		panel[46].add(fragmenttextfield);
		panel[48].add(fragmentlinebiglabel);
		panel[48].add(fragmentlinebig);
		panel[50].add(fragmentbackbutton);
		panel[50].add(fragmentnextbutton);
		panel[51].add(panel[52],BorderLayout.NORTH);
		panel[51].add(panel[53],BorderLayout.CENTER);
		panel[49].add(panel[50],BorderLayout.NORTH);
		panel[49].add(panel[51],BorderLayout.CENTER);
		panel[47].add(panel[48],BorderLayout.NORTH);
		panel[47].add(panel[49],BorderLayout.CENTER);
		panel[39].add(panel[46],BorderLayout.NORTH);
		panel[39].add(panel[47],BorderLayout.CENTER);
		tabbedPane2.addTab( "多邊形", new ImageIcon( getClass().getResource(String.format("202.gif")) ), panel[38], "多邊形選單"  ); 
	  	tabbedPane2.addTab( "碎形圖", new ImageIcon( getClass().getResource(String.format("203.gif")) ), panel[39], "碎形圖選單"  );
		panel[1].add(tabbedPane2);
		panel[0].add(panel[29],BorderLayout.NORTH);
		panel[0].add(panel[2],BorderLayout.CENTER);
		panel[0].add(panel[1],BorderLayout.EAST);
		
		for(int i=0;i<item0.length;i++){
		    menu[0].add( item0[i] ); 
		    if(i==3){
		    	menu[0].addSeparator();
		    }
		}
	  	for(int i = 0 ; i < item1.length   ; i++ ){ menu[ 1].add( item1[i]   ); }
	  	for(int i = 0 ; i < item2.length   ; i++ ){ menu[ 2].add( item2[i]   ); }
	  	for(int i = 0 ; i < item3.length   ; i++ ){ menu[ 3].add( item3[i]   ); }
	  	for(int i = 0 ; i < item4.length   ; i++ ){ menu[ 4].add( item4[i]   ); }
	  	for(int i = 0 ; i < item5.length   ; i++ ){ menu[ 5].add( item5[i]   ); }
	  	for(int i = 0 ; i < item6_1.length ; i++ ){ item6[0].add( item6_1[i] ); }
	  	for(int i = 0 ; i < item6_2.length ; i++ ){ item6[1].add( item6_2[i] ); }
	  	for(int i = 0 ; i < item6.length   ; i++ ){ menu[ 6].add( item6[i]   ); }
	  	for(int i = 0 ; i < item7.length   ; i++ ){ menu[ 7].add( item7[i]   ); }
	  	for(int i = 0 ; i < menu.length    ; i++ ){ bar.add     ( menu[ i]    ); }
	  	
	  	Bpanel[newpanel].setBackground(new Color(255,255,255));
		tabbedPane.addTab( "未命名"+(newpanel+1), new ImageIcon( getClass().getResource(String.format("201.gif")) ), Bpanel[newpanel], "未命名"+(newpanel+1)  ); 
	}
	public void handler(){
		MouseClickcolorbuttonHandler colorbuttonhandler = new MouseClickcolorbuttonHandler();
		for(int i=0;i<colorbutton.length;i++){ colorbutton[i].addMouseListener( colorbuttonhandler ); }
		
		MouseClickfilltextfieldHandler filltextfieldhandler = new MouseClickfilltextfieldHandler();
		for(int i=0;i<filltextfield.length;i++){ filltextfield[i].addMouseListener( filltextfieldhandler ); }
		
		toolbuttonHandler toolbuttonhandler = new toolbuttonHandler();
		for(int i=0;i<toolbutton.length;i++){ toolbutton[i].addActionListener( toolbuttonhandler ); }
		
		MouseClicktoolbuttonHandler mousetoolbuttonhandler = new MouseClicktoolbuttonHandler();
		for(int i=0;i<toolbutton.length;i++){ toolbutton[i].addMouseListener( mousetoolbuttonhandler ); }
		backbutton.addMouseListener( mousetoolbuttonhandler );
		nextbutton.addMouseListener( mousetoolbuttonhandler );
		fragmentbackbutton.addMouseListener( mousetoolbuttonhandler );
		fragmentnextbutton.addMouseListener( mousetoolbuttonhandler );

		Panel27buttonHandler panel27buttonHandler = new Panel27buttonHandler();
		for(int i=0;i<erasersizebutton.length    ;i++){ erasersizebutton[i].addActionListener   ( panel27buttonHandler ); }
		for(int i=0;i<spraysizebutton.length     ;i++){ spraysizebutton[i].addActionListener    ( panel27buttonHandler ); }
		for(int i=0;i<brushsizebutton.length     ;i++){ brushsizebutton[i].addActionListener    ( panel27buttonHandler ); }
		for(int i=0;i<linesizebutton.length      ;i++){ linesizebutton[i].addActionListener     ( panel27buttonHandler ); }
		for(int i=0;i<arrowheadsizebutton.length ;i++){ arrowheadsizebutton[i].addActionListener( panel27buttonHandler ); }
		for(int i=0;i<rectsizebutton.length      ;i++){ rectsizebutton[i].addActionListener     ( panel27buttonHandler ); }
		for(int i=0;i<ovalsizebutton.length      ;i++){ ovalsizebutton[i].addActionListener     ( panel27buttonHandler ); }
		for(int i=0;i<roundrectsizebutton.length ;i++){ roundrectsizebutton[i].addActionListener( panel27buttonHandler ); }
		for(int i=0;i<circlesizebutton.length    ;i++){ circlesizebutton[i].addActionListener   ( panel27buttonHandler ); }
		for(int i=0;i<squaresizebutton.length;i++){ squaresizebutton[i].addActionListener       ( panel27buttonHandler ); }
		for(int i=0;i<parallelogramsizebutton.length         ;i++){ parallelogramsizebutton[i].addActionListener        ( panel27buttonHandler ); }
		for(int i=0;i<trapezoidsizebutton.length             ;i++){ trapezoidsizebutton[i].addActionListener            ( panel27buttonHandler ); }
		for(int i=0;i<rhombussizebutton.length               ;i++){ rhombussizebutton[i].addActionListener              ( panel27buttonHandler ); }
		for(int i=0;i<octanglesizebutton.length              ;i++){ octanglesizebutton[i].addActionListener             ( panel27buttonHandler ); }
		for(int i=0;i<right_angled_trianglesizebutton.length ;i++){ right_angled_trianglesizebutton[i].addActionListener( panel27buttonHandler ); }
		for(int i=0;i<hexagonsizebutton.length               ;i++){ hexagonsizebutton[i].addActionListener              ( panel27buttonHandler ); }
		for(int i=0;i<crosssizebutton.length                 ;i++){ crosssizebutton[i].addActionListener                ( panel27buttonHandler ); }
		for(int i=0;i<pentagonsizebutton.length              ;i++){ pentagonsizebutton[i].addActionListener             ( panel27buttonHandler ); }
		for(int i=0;i<trianglesizebutton.length              ;i++){ trianglesizebutton[i].addActionListener             ( panel27buttonHandler ); }
		for(int i=0;i<cylinder.length              ;i++){ cylinder[i].addActionListener             ( panel27buttonHandler ); }
		
		MenuHandler Menuhandler = new MenuHandler();
		for(int i=0;i<item0.length       ;i++){ item0[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item1.length       ;i++){ item1[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item2.length       ;i++){ item2[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item3.length       ;i++){ item3[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item4.length       ;i++){ item4[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item5.length       ;i++){ item5[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item6_1.length       ;i++){ item6_1[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item6_2.length       ;i++){ item6_2[i].addActionListener       ( Menuhandler ); }
	  	for(int i=0;i<item7.length       ;i++){ item7[i].addActionListener       ( Menuhandler ); }
	  	
	  	BackNextHandler backnexthandler = new BackNextHandler();
	  	backbutton.addActionListener(backnexthandler);
	  	nextbutton.addActionListener(backnexthandler);
	  	
	  	FragmentHandler fragmentHandler = new FragmentHandler();
	  	fragmentbackbutton.addActionListener(fragmentHandler);
	  	fragmentnextbutton.addActionListener(fragmentHandler);
	  	fragmentlinebig.addChangeListener(fragmentHandler);
	  	tabbedPane2.addChangeListener(fragmentHandler);
	}
	private class FragmentHandler implements ActionListener,ChangeListener {
		public void actionPerformed( ActionEvent event ){
			
			if(event.getSource()==fragmentnextbutton ){
				 if(ck==1){
					 Bpanel[0].sett(-1);
					 fragmentbig = Integer.parseInt(fragmentlinebig.getValue().toString());
					 level++;
					 fragment = new MyFragment(level,Bpanel[0].getx1(),Bpanel[0].gety1(),Bpanel[0].getx2(),Bpanel[0].gety2(),fragmentbig,Bpanel[0].getleftcolor());
					 fragmenttextfield.setText(String.format("第%d層",level+1));
				 }
				 else{
					 JOptionPane.showMessageDialog( MyFrame.this,"請先拉出一直線!!","警告", JOptionPane.INFORMATION_MESSAGE );
				 }
				  repaint();
			}
			if(event.getSource()==fragmentbackbutton){
				 if(ck==1){
					level--;
					if(level<-1){
						JOptionPane.showMessageDialog( MyFrame.this,"沒有上一步!!","警告", JOptionPane.ERROR_MESSAGE );
						Bpanel[0].setlineclear();
						ck=0;
						level=0;
						Bpanel[0].sett(21);
					}
					else{
						fragment = new MyFragment(level,Bpanel[0].getx1(),Bpanel[0].gety1(),Bpanel[0].getx2(),Bpanel[0].gety2(),fragmentbig,Bpanel[0].getleftcolor());
						fragmenttextfield.setText(String.format("第%d層",level+1));
					}
				 }
				 else{
					 JOptionPane.showMessageDialog( MyFrame.this,"請先拉出一直線!!","警告", JOptionPane.INFORMATION_MESSAGE );
				 }
				repaint();
			}
		}
		public void stateChanged(ChangeEvent e) {
			if(e.getSource()==fragmentlinebig){
				fragmentbig = Integer.parseInt(fragmentlinebig.getValue().toString());
				if(fragmentbig <= 0) {
					fragmentlinebig.setValue(new Integer(1));
					fragmentbig = 1;
				}
				repaint();
			}
			if(e.getSource()==tabbedPane2){
				Bpanel[0].sett(21);
				if(ch==0){
					JOptionPane.showMessageDialog( MyFrame.this,"請先拉出一直線!!","警告", JOptionPane.INFORMATION_MESSAGE );
					fragmentbig = Integer.parseInt(fragmentlinebig.getValue().toString());
					fragmenttextfield.setText(String.format("第%d層",1));
					ch++;
				}
				else{ 
					ch=0; 
					ck=0;
					level=0;
					Bpanel[0].setlineclear();
					Bpanel[0].sett(2);
				}
			}
			repaint();
		}
	}
	private class BackNextHandler implements ActionListener {
		public void actionPerformed( ActionEvent event ){
			if(event.getSource()==backbutton){
				Bpanel[0].setback();
			}
			if(event.getSource()==nextbutton ){
				Bpanel[0].setnext();
			}
		}
	}
	private class MouseClickfilltextfieldHandler  extends MouseAdapter {
		public void mouseClicked( MouseEvent event ){
			Color c;
			if ( event.getSource() == filltextfield[0] ){
				c=JColorChooser.showDialog(null, "選擇顏色",leftcolortextfield.getBackground());
				for(int j=0;j<Bpanel.length;j++){
					if(c==null){
						c=Bpanel[j].getleftcolor();
					}
					Bpanel[j].setleftcolor(c);
				}
				leftcolortextfield.setBackground(c);
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
			}
			else if( event.getSource() == filltextfield[1] ){
				c=JColorChooser.showDialog(null, "選擇顏色",rightcolortextfield.getBackground());
				
				for(int j=0;j<Bpanel.length;j++){
					if(c==null){
						c=Bpanel[j].getrightcolor();
					}
					Bpanel[j].setrightcolor(c);
				}
				rightcolortextfield.setBackground(c);
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
			}
		}	
	}
	private class MouseClicktoolbuttonHandler implements MouseListener{
		public void mouseClicked( MouseEvent e ){
		}
		public void mouseEntered(MouseEvent e) {
			if(e.getSource()==backbutton && Bpanel[0].geti()>-1 && (Bpanel[0].geti()>b)){
				backbutton.removeAll();
				
				backbutton.setIcon(new ImageIcon( getClass().getResource(String.format("190.gif")) ));
				backbutton.setBackground(new Color(240,240,240));
				
			}
			if(e.getSource()==nextbutton && Bpanel[0].geti()>-1 && (b>-1)){
				nextbutton.removeAll();
				nextbutton.setIcon(new ImageIcon( getClass().getResource(String.format("191.gif")) ));
				nextbutton.setBackground(new Color(240,240,240));
			}
			for(int i=0 ; i < toolbutton.length ; i++){
				if(e.getSource()==toolbutton[i]){
					if(t==i){
						toolbutton[i].setBackground(new Color(160,160,160));
					}
					else{
						toolbutton[i].setBackground(new Color(240,240,240));
					}
				}
			}
			if(e.getSource()==fragmentbackbutton){
				fragmentbackbutton.setBackground(new Color(240,240,240));
			}
			if(e.getSource()==fragmentnextbutton){
				fragmentnextbutton.setBackground(new Color(240,240,240));
			}
		}
		public void mouseExited(MouseEvent e) {
			if(e.getSource()==backbutton){
				backbutton.setIcon(new ImageIcon( getClass().getResource(String.format("192.gif")) ));
				backbutton.setBackground(new Color(215,215,215));
			}
			if(e.getSource()==nextbutton){
				nextbutton.setIcon(new ImageIcon( getClass().getResource(String.format("193.gif")) ));
				nextbutton.setBackground(new Color(215,215,215));
			}
			for(int i=0 ; i < toolbutton.length ; i++){
				if(i==t){
					toolbutton[i].setBackground(new Color(160,160,160));
				}
				else{
					toolbutton[i].setBackground(new Color(215,215,215));
				}
			}
			if(e.getSource()==fragmentbackbutton){
				fragmentbackbutton.setBackground(new Color(215,215,215));
			}
			if(e.getSource()==fragmentnextbutton){
				fragmentnextbutton.setBackground(new Color(215,215,215));
			}
		}
		public void mousePressed(MouseEvent e) {
			for(int i=0 ; i < toolbutton.length ; i++){
				if(e.getSource()==toolbutton[i]){
					if(t==i){
						toolbutton[t].setBackground(new Color(160,160,160));
					}
					else{
						toolbutton[t].setBackground(new Color(215,215,215));
					}
				}
			}
		}
		public void mouseReleased(MouseEvent e) { }
	}
	private class MouseClickcolorbuttonHandler  extends MouseAdapter {
		public void mouseClicked( MouseEvent event ){
			if ( event.isMetaDown() ){
				if(event.getClickCount()==2){
					colors[16]=JColorChooser.showDialog(null, "選擇顏色",rightcolortextfield.getBackground());
					for(int j=0;j<Bpanel.length;j++){
						if(colors[16]==null){
							colors[16]=Bpanel[j].getrightcolor();
						}
						Bpanel[j].setrightcolor(colors[16]);
					}
					rightcolortextfield.setBackground(colors[16]);
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
				}
				else{
					for(int i=0;i<colorbutton.length;i++){
						if ( event.getSource() == colorbutton[i] ){
							
								for(int j=0;j<Bpanel.length;j++){
									Bpanel[j].setrightcolor(colors[i]);
								}
								rightcolortextfield.setBackground(colors[i]);
								filltextfield[1].setBackground(rightcolortextfield.getBackground());
						}
					}	
				}
			}
			else if (event.isAltDown()){ }
			else{
				if(event.getClickCount()==2){
					colors[16]=JColorChooser.showDialog(null, "選擇顏色",leftcolortextfield.getBackground());
					for(int j=0;j<Bpanel.length;j++){
						if(colors[16]==null){
							colors[16]=Bpanel[j].getleftcolor();
						}
						Bpanel[j].setleftcolor(colors[16]);
					}
					leftcolortextfield.setBackground(colors[16]);
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
				}
				else{
					for(int i=0;i<colorbutton.length;i++){
						if ( event.getSource() == colorbutton[i] ){
								for(int j=0;j<Bpanel.length;j++){
									Bpanel[j].setleftcolor(colors[i]);
								}
								leftcolortextfield.setBackground(colors[i]);
								filltextfield[0].setBackground(leftcolortextfield.getBackground());
						}
					}
				}
			}
		}
	}
	private class toolbuttonHandler implements ActionListener {
		public void actionPerformed( ActionEvent event ){
			if ( event.getSource() == toolbutton[0] ){
				panel[27].removeAll();panel[42].removeAll();
				panel[27].setVisible(true);
				panel[27].setLayout( new GridLayout( 4, 1,1,1) );
				for(int i=0;i<erasersizebutton.length;i++){
					panel[27].add(erasersizebutton[i]);
					erasersizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=0;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
				}
				filllabel[0].setText("橡皮擦(1)                     ");
				filltextfield[0].setBackground(rightcolortextfield.getBackground());
				filltextfield[1].setBackground(leftcolortextfield.getBackground());
				erasersizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("橡皮擦(1)");
				statelabel.setText("選擇了橡皮擦。");
			}
			if ( event.getSource() == toolbutton[1] ){
				panel[27].removeAll();panel[42].removeAll();
				panel[27].setVisible(true);
				panel[27].setLayout( new GridLayout( 4, 1,1,1) );
				for(int i=0;i<spraysizebutton.length;i++){
					panel[27].add(spraysizebutton[i]);
					spraysizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=1;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(2); 
				}
				filllabel[0].setText("噴漆(2)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				spraysizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("噴漆(2)");
				statelabel.setText("你選擇了噴漆。");
			}
			if ( event.getSource() == toolbutton[2] ){
				panel[27].removeAll();panel[42].removeAll();
				panel[27].setVisible(false);
				validate();
				t=2;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
				}
				filllabel[0].setText("筆。                              ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				tooltextfield.setText("筆");
				statelabel.setText("選擇了筆。");
			}
			if ( event.getSource() == toolbutton[3] ){
				panel[27].removeAll();panel[42].removeAll();
				panel[27].setVisible(true);
				panel[27].setLayout( new GridLayout( 4, 1,1,1) );
				for(int i=0;i<brushsizebutton.length;i++){
					panel[27].add(brushsizebutton[i]);
					brushsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=3;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(2); 
				}
				filllabel[0].setText("刷子(2)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				brushsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("刷子(2)");
				statelabel.setText("你選擇了刷子。");
			}
			if ( event.getSource() == toolbutton[4] ){
				panel[27].removeAll();panel[42].removeAll();
				panel[27].setVisible(true);
				panel[27].setLayout( new GridLayout( 5, 1,1,1) );
				for(int i=0;i<linesizebutton.length;i++){
					panel[27].add(linesizebutton[i]);
					linesizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=4;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
				}
				filllabel[0].setText("直線(1)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				linesizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("直線(1)");
				statelabel.setText("選擇了直線。");
			}
			if ( event.getSource() == toolbutton[5] ){
				panel[27].removeAll();panel[42].removeAll();
				panel[27].setVisible(true);
				panel[27].setLayout( new GridLayout( 6, 1,1,1) );
				for(int i=0;i<arrowheadsizebutton.length;i++){
					panel[27].add(arrowheadsizebutton[i]);
					arrowheadsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=5;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
				}
				filllabel[0].setText("箭頭(1)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				arrowheadsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("箭頭(1)");
				statelabel.setText("選擇了箭頭。");
			}
			if ( event.getSource() == toolbutton[6] ){
				panel[42].removeAll();panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 4, 1,1,1) );
				for(int i=0;i<rectsizebutton.length;i++){
					panel[42].add(rectsizebutton[i]);
					rectsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=6;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("矩形(1)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				rectsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("矩形(1)");
				statelabel.setText("你選擇了畫矩形。");
			}
			if ( event.getSource() == toolbutton[7] ){
				panel[42].removeAll();panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 5, 1,1,1) );
				for(int i=0;i<ovalsizebutton.length;i++){
					panel[42].add(ovalsizebutton[i]);
					ovalsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=7;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("橢圓形(1)                     ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				ovalsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("橢圓形(1)");
				statelabel.setText("你選擇了畫橢圓形。");
			}
			if ( event.getSource() == toolbutton[8] ){
				panel[42].removeAll();panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 6, 1,1,1) );
				for(int i=0;i<roundrectsizebutton.length;i++){
					panel[42].add(roundrectsizebutton[i]);
					roundrectsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=8;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("圓角矩形(1)                 ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				roundrectsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("圓角矩形(1)");
				statelabel.setText("你選擇了圓角矩形。");
			}
			if ( event.getSource() == toolbutton[9] ){
				panel[42].removeAll();panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 6, 1,1,1) );
				for(int i=0;i<circlesizebutton.length;i++){
					panel[42].add(circlesizebutton[i]);
					circlesizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=9;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("圓形(1)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				circlesizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("圓形(1)");
				statelabel.setText("你選擇了圓形。");
			}
			if ( event.getSource() == toolbutton[10] ){
				panel[42].removeAll();panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 6, 1,1,1) );
				for(int i=0;i<squaresizebutton.length;i++){
					panel[42].add(squaresizebutton[i]);
					squaresizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=10;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("正方形(1)                     ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				squaresizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("正方形(1)");
				statelabel.setText("你選擇了正方形。");
			}
			if ( event.getSource() == toolbutton[11] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 6, 1,1,1) );
				for(int i=0;i<parallelogramsizebutton.length;i++){
					panel[42].add(parallelogramsizebutton[i]);
					parallelogramsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=11;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("平行四邊形(1)            ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				parallelogramsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("平行四邊形(1)");
				statelabel.setText("你選擇了平行四邊。");
			}
			if ( event.getSource() == toolbutton[12] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 7, 1,1,1) );
				for(int i=0;i<trapezoidsizebutton.length;i++){
					panel[42].add(trapezoidsizebutton[i]);
					trapezoidsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=12;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("梯形(1)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				trapezoidsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("梯形(1)");
				statelabel.setText("你選擇了梯形。");
			}
			if ( event.getSource() == toolbutton[13] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 8, 1,1,1) );
				for(int i=0;i<rhombussizebutton.length;i++){
					panel[42].add(rhombussizebutton[i]);
					rhombussizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=13;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("菱形(1)                         ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				rhombussizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("菱形(1)");
				statelabel.setText("你選擇了菱形。");
			}
			if ( event.getSource() == toolbutton[14] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 9, 1,1,1) );
				for(int i=0;i<octanglesizebutton.length;i++){
					panel[42].add(octanglesizebutton[i]);
					octanglesizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=14;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("八角形(1)                      ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				octanglesizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("八角形(1)");
				statelabel.setText("你選擇了八角形。");
			}
			if ( event.getSource() == toolbutton[15] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 10, 1,1,1) );
				for(int i=0;i<right_angled_trianglesizebutton.length;i++){
					panel[42].add(right_angled_trianglesizebutton[i]);
					right_angled_trianglesizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=15;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("直角三角形(1)            ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				right_angled_trianglesizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("直角三角形(1)");
				statelabel.setText("你選擇了直角三角形。");
			}
			if ( event.getSource() == toolbutton[16] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 11, 1,1,1) );
				for(int i=0;i<hexagonsizebutton.length;i++){
					panel[42].add(hexagonsizebutton[i]);
					hexagonsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=16;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("六角形(1)                      ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				hexagonsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("六角形(1)");
				statelabel.setText("你選擇了六角形。");
			}
			if ( event.getSource() == toolbutton[17] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 12, 1,1,1) );
				for(int i=0;i<crosssizebutton.length;i++){
					panel[42].add(crosssizebutton[i]);
					crosssizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=17;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("十字形(1)                      ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				crosssizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("十字形(1)");
				statelabel.setText("你選擇了十字形。");
			}
			if ( event.getSource() == toolbutton[18] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 13, 1,1,1) );
				for(int i=0;i<pentagonsizebutton.length;i++){
					panel[42].add(pentagonsizebutton[i]);
					pentagonsizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=18;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("五角形(1)                      ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				pentagonsizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("五角形(1)");
				statelabel.setText("你選擇了五角形。");
			}
			if ( event.getSource() == toolbutton[19] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 14, 1,1,1) );
				for(int i=0;i<trianglesizebutton.length;i++){
					panel[42].add(trianglesizebutton[i]);
					trianglesizebutton[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=19;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("三角形(1)                      ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				trianglesizebutton[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("三角形(1)");
				statelabel.setText("你選擇了三角形。");
			}
			if ( event.getSource() == toolbutton[20] ){
				panel[42].removeAll();
				panel[27].removeAll();
				panel[42].setVisible(true);
				panel[42].setLayout( new GridLayout( 15, 1,1,1) );
				for(int i=0;i<cylinder.length;i++){
					panel[42].add(cylinder[i]);
					cylinder[i].setBackground(new Color(200,200,200));
				}
				validate();
				t=20;
				for(int j=0;j<Bpanel.length;j++){
					Bpanel[j].sett(t);
					Bpanel[j].setbig(1); 
					Bpanel[j].setFilled(false); 
				}
				filllabel[0].setText("圓柱形(1)                      ");
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
				filltextfield[1].setBackground(rightcolortextfield.getBackground());
				cylinder[0].setBackground(new Color(160,160,160));
				tooltextfield.setText("圓柱形(1)");
				statelabel.setText("你選擇了圓柱形。");
			}
		}
	}
	private class Panel27buttonHandler implements ActionListener {
		public void actionPerformed( ActionEvent event ){
			for(int i=0;i<erasersizebutton.length;i++){
				erasersizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == erasersizebutton[i] ){
					erasersizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setbig((i*2)+1); 
					}
					filllabel[0].setText(String.format( "橡皮擦(%d)                     ",(i*2)+1));
					filltextfield[0].setBackground(rightcolortextfield.getBackground());
					filltextfield[1].setBackground(leftcolortextfield.getBackground());
					tooltextfield.setText(String.format( "橡皮擦(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的橡皮擦。",(i*2)+1));
				}
			}
			for(int i=0;i<brushsizebutton.length;i++){
				brushsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == brushsizebutton[i] ){
					brushsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setbig((i+1)*2);
					}
					filllabel[0].setText(String.format( "刷子(%d)                         ",(i+1)*2));
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "刷子(%d)",(i+1)*2));
					statelabel.setText(String.format( "你選擇了寬%d 的刷子。",(i+1)*2));
				}
			}
			for(int i=0;i<linesizebutton.length;i++){
				linesizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == linesizebutton[i] ){
					linesizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setbig((i*2)+1); 
					}
					filllabel[0].setText(String.format( "直線(%d)                         ",(i*2)+1));
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "直線(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的直線。",(i*2)+1));
				}
			}
			for(int i=0;i<arrowheadsizebutton.length;i++){
				arrowheadsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == arrowheadsizebutton[i] ){
					arrowheadsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setbig((i*2)+1); 
					}
					filllabel[0].setText(String.format( "箭頭(%d)                         ",(i*2)+1));
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "箭頭(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的箭頭。",(i*2)+1));
				}
			}
			for(int i=0;i<spraysizebutton.length;i++){
				spraysizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == spraysizebutton[i] ){
					spraysizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setbig((i+1)*2);
					}
					filllabel[0].setText(String.format( "噴漆(%d)                         ",(i+1)*2));
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "噴漆(%d)",(i+1)*2));
					statelabel.setText(String.format( "你選擇了寬%d 的噴漆。",(i+1)*2));
				}
			}
			for(int i=0;i<rectsizebutton.length;i++){
				rectsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == rectsizebutton[i] ){
					rectsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						if(i<=2){
							Bpanel[j].setFilled(false); 
							filllabel[0].setText(String.format( "矩形(%d)                         ",(i*2)+1));
						}
						else{
							Bpanel[j].setFilled(true); 
							filllabel[0].setText("請再右邊顏色格子內點選顏色以填充色彩。");
						}
						Bpanel[j].setbig((i*2)+1); 
					}
					if(i<=2){
						tooltextfield.setText(String.format( "矩形(%d)",(i*2)+1));
						statelabel.setText(String.format( "你選擇了寬%d 的矩形。",(i*2)+1));
					}
					else{
						tooltextfield.setText(String.format( "矩形(填充)"));
						statelabel.setText(String.format( "你選擇了填充的矩形。"));
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
				}
			}
			for(int i=0;i<ovalsizebutton.length;i++){
				ovalsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == ovalsizebutton[i] ){
					ovalsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						if(i<=2){
							Bpanel[j].setFilled(false); 
							filllabel[0].setText(String.format( "橢圓形(%d)                     ",(i*2)+1));
						}
						else{
							Bpanel[j].setFilled(true); 
							filllabel[0].setText("請再右邊顏色格子內點選顏色以填充色彩。");
						}
						Bpanel[j].setbig((i*2)+1); 
					}
					if(i<=2){
						tooltextfield.setText(String.format( "橢圓形(%d)",(i*2)+1));
						statelabel.setText(String.format( "你選擇了寬%d 的橢圓形。",(i*2)+1));
					}
					else{
						tooltextfield.setText(String.format( "橢圓形(填充)"));
						statelabel.setText(String.format( "你選擇了填充的橢圓形。"));
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
				}
			}
			for(int i=0;i<roundrectsizebutton.length;i++){
				roundrectsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == roundrectsizebutton[i] ){
					roundrectsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						if(i<=2){
							Bpanel[j].setFilled(false); 
							filllabel[0].setText(String.format( "圓角矩形(%d)                 ",(i*2)+1));
						}
						else{
							Bpanel[j].setFilled(true); 
							filllabel[0].setText("請再右邊顏色格子內點選顏色以填充色彩。");
						}
						Bpanel[j].setbig((i*2)+1); 
					}
					if(i<=2){
						tooltextfield.setText(String.format( "圓角矩形(%d)",(i*2)+1));
						statelabel.setText(String.format( "你選擇了寬%d 的圓角矩形。",(i*2)+1));
					}
					else{
						tooltextfield.setText(String.format( "圓角矩形(填充)"));
						statelabel.setText(String.format( "你選擇了填充的圓角矩形。"));
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
				}
			}
			for(int i=0;i<circlesizebutton.length;i++){
				circlesizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == circlesizebutton[i] ){
					circlesizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						if(i<=2){
							Bpanel[j].setFilled(false); 
							filllabel[0].setText(String.format( "圓形(%d)                         ",(i*2)+1));
						}
						else{
							Bpanel[j].setFilled(true); 
							filllabel[0].setText("請再右邊顏色格子內點選顏色以填充色彩。");
						}
						Bpanel[j].setbig((i*2)+1); 
					}
					if(i<=2){
						tooltextfield.setText(String.format( "圓形(%d)",(i*2)+1));
						statelabel.setText(String.format( "你選擇了寬%d 的圓形。",(i*2)+1));
					}
					else{
						tooltextfield.setText(String.format( "圓形(填充)"));
						statelabel.setText(String.format( "你選擇了填充的圓形。"));
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
				}
			}
			for(int i=0;i<squaresizebutton.length;i++){
				squaresizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == squaresizebutton[i] ){
					squaresizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						if(i<=2){
							Bpanel[j].setFilled(false); 
							filllabel[0].setText(String.format( "正方形(%d)                     ",(i*2)+1));
						}
						else{
							Bpanel[j].setFilled(true); 
							filllabel[0].setText("請再右邊顏色格子內點選顏色以填充色彩。");
						}
						Bpanel[j].setbig((i*2)+1); 
					}
					if(i<=2){
						tooltextfield.setText(String.format( "正方形(%d)",(i*2)+1));
						statelabel.setText(String.format( "你選擇了寬%d 的橢圓形。",(i*2)+1));
					}
					else{
						tooltextfield.setText(String.format( "正方形(填充)"));
						statelabel.setText(String.format( "你選擇了填充的正方形。"));
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
				}
			}
			
			for(int i=0;i<parallelogramsizebutton.length;i++){
				parallelogramsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == parallelogramsizebutton[i] ){
					parallelogramsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "平行四邊形(%d)            ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "平行四邊形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的平行四邊形。",(i*2)+1));
				}
			}
			for(int i=0;i<trapezoidsizebutton.length;i++){
				trapezoidsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == trapezoidsizebutton[i] ){
					trapezoidsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "梯形(%d)                        ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "梯形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的梯形。",(i*2)+1));
				}
			}
			for(int i=0;i<rhombussizebutton.length;i++){
				rhombussizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == rhombussizebutton[i] ){
					rhombussizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "菱形(%d)                        ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "菱形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的菱形。",(i*2)+1));
				}
			}
			for(int i=0;i<octanglesizebutton.length;i++){
				octanglesizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == octanglesizebutton[i] ){
					octanglesizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "八角形(%d)                     ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "八角形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的八角形。",(i*2)+1));
				}
			}
			for(int i=0;i<right_angled_trianglesizebutton.length;i++){
				right_angled_trianglesizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == right_angled_trianglesizebutton[i] ){
					right_angled_trianglesizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "直角三角形(%d)            ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "直角三角形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的直角三角形。",(i*2)+1));
				}
			}
			for(int i=0;i<hexagonsizebutton.length;i++){
				hexagonsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == hexagonsizebutton[i] ){
					hexagonsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "六腳形(%d)                     ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "六腳形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的六腳形。",(i*2)+1));
				}
			}
			for(int i=0;i<crosssizebutton.length;i++){
				crosssizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == crosssizebutton[i] ){
					crosssizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "十字形(%d)                     ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "十字形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的十字形。",(i*2)+1));
				}
			}
			for(int i=0;i<pentagonsizebutton.length;i++){
				pentagonsizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == pentagonsizebutton[i] ){
					pentagonsizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "五角形(%d)                     ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "五角形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的五角形。",(i*2)+1));
				}
			}
			for(int i=0;i<trianglesizebutton.length;i++){
				trianglesizebutton[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == trianglesizebutton[i] ){
					trianglesizebutton[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "三角形(%d)                     ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "三角形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的三角形。",(i*2)+1));
				}
			}
			for(int i=0;i<cylinder.length;i++){
				cylinder[i].setBackground(new Color(200,200,200));
				if ( event.getSource() == cylinder[i] ){
					cylinder[i].setBackground(new Color(160,160,160));
					for(int j=0;j<Bpanel.length;j++){
						Bpanel[j].sett(t);
						Bpanel[j].setFilled(false); 
						filllabel[0].setText(String.format( "圓柱形(%d)                     ",(i*2)+1));
						Bpanel[j].setbig((i*2)+1); 
					}
					filltextfield[0].setBackground(leftcolortextfield.getBackground());
					filltextfield[1].setBackground(rightcolortextfield.getBackground());
					tooltextfield.setText(String.format( "圓柱形(%d)",(i*2)+1));
					statelabel.setText(String.format( "你選擇了寬%d 的圓柱形。",(i*2)+1));
				}
			}
		}
	}
	private class MenuHandler implements ActionListener {
	   	public void actionPerformed( ActionEvent event ){
	   		if(event.getSource() == item0[0]){
	   			newpanel++;
	   			Bpanel[newpanel] = new Painter();
	   			Bpanel[newpanel].setBackground(new Color(255,255,255));
				tabbedPane.addTab( "未命名"+(newpanel+1), new ImageIcon( getClass().getResource(String.format("201.gif")) ), Bpanel[newpanel], "未命名"+(newpanel+1) ); 
	   		}
	   		if(event.getSource() == item0[1]){
	   			int C;
				FileDialog fileDialog = new FileDialog( new Frame() , "選擇一個圖檔", FileDialog.LOAD );
				fileDialog.show();
				if(fileDialog.getFile()==null) {
					JOptionPane.showMessageDialog( MyFrame.this,"您沒選圖!","警告", JOptionPane.INFORMATION_MESSAGE );
				}
				if(Bpanel[0].geti()>-1){ C = JOptionPane.showConfirmDialog(null, "儲存修改到 未命名"+(newpanel+1)); }
				else{ C=1; }
				if(C==0){
					img=1;
	   				JOptionPane.showMessageDialog( MyFrame.this,"尚未完成","警告", JOptionPane.INFORMATION_MESSAGE );/*做存檔*/
	   				Bpanel[0].setclear();
					bug = new ImageIcon( fileDialog.getDirectory()+fileDialog.getFile() );
					repaint();
	   			}
	   			if(C==1){
	   				img=1;
					Bpanel[0].setclear();
					bug = new ImageIcon( fileDialog.getDirectory()+fileDialog.getFile() );
					repaint();
	   			}
	   		}
	   		if(event.getSource() == item0[2]){
	   			FileDialog fileDialog = new FileDialog( new Frame() , "請指定一個檔名", FileDialog.SAVE );
	   			fileDialog.show();
	   			String a ;
	   			a = fileDialog.getDirectory()+fileDialog.getFile();
	   			JOptionPane.showMessageDialog( MyFrame.this,"尚未完成","警告", JOptionPane.INFORMATION_MESSAGE );
	   		}
	   		if(event.getSource() == item0[3] ){ JOptionPane.showMessageDialog( MyFrame.this,"尚未完成","警告", JOptionPane.INFORMATION_MESSAGE ); }
	   		if(event.getSource() == item0[4] ){ System.exit( 0 );  }
	   		if(event.getSource() == item1[0] ){ Bpanel[0].setbackmenu(); }
	   		if(event.getSource() == item1[1] ){ Bpanel[0].setnextmenu(); }
	   		
	   		if(item2[0].isSelected()==false  ){ panel[22].setVisible(false); }
	   		else{ panel[22].setVisible(true); }
	   		if(item2[1].isSelected()==false  ){ panel[ 4].setVisible(false); }
			else{ panel[ 4].setVisible(true); }
	   		if(item2[2].isSelected()==false  ){ panel[13].setVisible(false); }
			else{ panel[13].setVisible(true); }
	   		if(item2[3].isSelected()==false  ){ panel[ 1].setVisible(false); }
			else{ panel[ 1].setVisible(true); }
	   		
	   		if(event.getSource() == item3[0] ){
	   			String N = JOptionPane.showInputDialog( "輸入要清除哪一個圖層。" );  
				int n = Integer.parseInt( N );
				Bpanel[n-1].setclear();
				repaint();
	   		}
	   		if(event.getSource() == item4[0]){
	   			Color c;
	   			c=JColorChooser.showDialog(null, "選擇顏色",rightcolortextfield.getBackground());
	   			if(c==null){
	   				c=Bpanel[0].getleftcolor();
	   			}
	   			Bpanel[0].setleftcolor(c);
	   			leftcolortextfield.setBackground(c);
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
	   		}
	   		if(event.getSource() == item5[0]){
	   			JOptionPane.showMessageDialog(null, "程式名稱：小小畫家 (2008/6/5)\n作者：吳政賢\n系級：淡江大學資訊工程1-A\n信箱：comdan66@yahoo.com.tw\nMSN  : com-dan-66@hotmail.om\n\n版本特點：無\n", "關於 小畫家", 1, new ImageIcon("200.gif"));
	   		}
	   		if(event.getSource() == item6_1[0]){
	   			Color c;
	   			c=JColorChooser.showDialog(null, "選擇顏色",rightcolortextfield.getBackground());
	   			if(c==null){
	   				c=Bpanel[0].getleftcolor();
	   			}
	   			Bpanel[0].setleftcolor(c);
	   			leftcolortextfield.setBackground(c);
				filltextfield[0].setBackground(leftcolortextfield.getBackground());
	   		}
	   		if(event.getSource() == item6_1[1]){
	   			Color c;
	   			c=JColorChooser.showDialog(null, "選擇顏色",Bpanel[0].getBackground());
	   			if(c==null){
	   				c=Bpanel[0].getBackground();
	   			}
	   			Bpanel[0].setBackground(c);
	   		}
	   		if(item6_2[0].isSelected()==true){
	   			panel[40].removeAll();
	   			panel[40].setLayout( new GridLayout( 3, 1,1,1) );
	   			panel[40].add(toolbutton[8]);
	   			panel[40].add(toolbutton[13]);
	   			panel[40].add(toolbutton[20]);
	   			repaint();
	   		}
	   		if(item6_2[1].isSelected()==true){
	   			panel[40].removeAll();
	   			panel[40].setLayout( new GridLayout( 4, 3,1,1) );
	   			for(int i=6;i<toolbutton.length;i++){
	   				if(i!=8 && i!= 13 && i!=20){
	   					panel[40].add(toolbutton[i]);
	   				}
	   			}
	   			repaint();
	   		}
	   		if(item6_2[2].isSelected()==true){
	   			panel[40].removeAll();
	   			panel[40].setLayout( new GridLayout( 5, 3,1,1) );
	   			for(int i=6;i<toolbutton.length;i++){
					panel[40].add(toolbutton[i]);
				}
	   			item6_2[0].setSelected(false);
	   			item6_2[1].setSelected(false);
	   			repaint();
	   		}
	   		if(event.getSource() == item7[0]){
		   		JFrame A = new JFrame("小小畫家說明");
		   		A.add( new JScrollPane( textarea1 ) );
		        A.setSize( 500, 500 ); 
		        A.setVisible( true );
		   		}
	   		if(event.getSource() == item7[1]){
		   		JFrame A = new JFrame("完成度說明");
		   		A.add( new JScrollPane( textarea2 ) );
		        A.setSize( 500, 500 ); 
		        A.setVisible( true );
	   		}
	   	}
   	}

	public class Painter extends JPanel{
		private MyShape myShape[] = new MyShape[10000];
		private MyLine line;
		private Color leftcolor,rightcolor,color;
		private int big=1,x1,y1,T,x,y,i=-1,x2=-10,y2=-10,x3,y3,x4,y4;
		
		public Painter(){
			sett(2);/*一開始的工具*/
			setleftcolor(new Color(0,0,0));
			setrightcolor(new Color(255,255,255));
			MouseMotionAdapter mm= new MouseMotionAdapter();
			addMouseMotionListener(mm);
			addMouseListener(mm);
		}
		private class MouseMotionAdapter  implements MouseListener,MouseMotionListener{
			public void mousePressed(MouseEvent e){
				item1[0].setEnabled(true);
				item3[0].setEnabled(true);
				i++;i++;
				if(e.isMetaDown()){ color=getrightcolor(); }
				else if( e.isAltDown()){}
				else{ color=getleftcolor(); }
				switch(T){
					case 0:
						if(e.isMetaDown()){ color=getleftcolor(); }
						else if( e.isAltDown()){}
						else{ color=getrightcolor(); }
						myShape[i]= new MyLine( x,y, e.getX(),e.getY(),color,getbig());
						break;
					case 1:
						i--;
						for(int j=0;j<20;j++){
							i++;
							myShape[i]= new MySpray( e.getX(),e.getY(), e.getX(),e.getY(),color,getbig());
						}
						break;
					case 2:
						myShape[i]= new MyLine( x,y, e.getX(),e.getY(),color,getbig());
						break;
					case 3:
						myShape[i]= new MyLine( x,y, e.getX(),e.getY(),color,getbig());
						break;
					case 4:
						if(ch==1){
							x3=e.getX(); y3=e.getY();
						}
						break;
					case 21:
						x3=e.getX(); y3=e.getY();
						break;
				}
				x1=e.getX(); y1=e.getY();
				x=e.getX(); y=e.getY();
				repaint();
			}
			public void mouseDragged(MouseEvent e){
				if(e.isMetaDown()){ color=getrightcolor(); }
				else if( e.isAltDown()){}
				else{ color=getleftcolor(); }
				switch(T){
					case 0:
						i++;
						if(e.isMetaDown()){ color=getleftcolor(); }
						else if( e.isAltDown()){}
						else{ color=getrightcolor(); }
						coordtetextfield.setText(String.format( "%d,%d",e.getX(),e.getY()));
						myShape[i]= new MyLine( x,y, e.getX(),e.getY(),color,getbig());
						break;
					case 1:
						coordtetextfield.setText(String.format( "%d,%d",e.getX(),e.getY()));
						for(int j=0;j<20;j++){
							i++;
							myShape[i]= new MySpray( e.getX(),e.getY(), e.getX(),e.getY(),color,getbig());
						}
						break;
					case 2:
						i++;
						coordtetextfield.setText(String.format( "%d,%d",e.getX(),e.getY()));
						myShape[i]= new MyLine( x,y, e.getX(),e.getY(),color,getbig());
						break;
					case 3:
						i++;
						coordtetextfield.setText(String.format( "%d,%d",e.getX(),e.getY()));
						myShape[i]= new MyLine( x,y, e.getX(),e.getY(),color,getbig());
						break;
					case 4:
						if(ch==1){
							ck=1;
							areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
							line= new MyLine( x1,y1, e.getX(),e.getY(),color,fragmentbig);
							x4=e.getX(); y4=e.getY();
						}
						else{
							areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
							myShape[i]= new MyLine( x1,y1, e.getX(),e.getY(),color,getbig());
						}
						break;
					case 5:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyLine2( x1,y1, e.getX(),e.getY(),color,getbig());
						break;
					case 6:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyRect( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),getFilled(),getbig());
						break;
					case 7:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyOval( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),getFilled(),getbig());
						break;
					case 8:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyRoundRect( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),getFilled(),getbig());
						break;
					case 9:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyCircle( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),getFilled(),getbig());
						break;
					case 10:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MySquare( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),getFilled(),getbig());
						break;
					case 11:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyParallelogram( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 12:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyTrapezoid( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 13:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyRhombus( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 14:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyOctangle( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 15:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyRight_Angled_Triangle( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 16:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyHexagon( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 17:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyCross( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 18:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyPentagon( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 19:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyTriangle( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 20:
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						myShape[i]= new MyCylinder( x1,y1, e.getX(),e.getY(),color,getleftcolor(),getrightcolor(),false,getbig());
						break;
					case 21:
						ck=1;
						areatetextfield.setText(String.format( "%d x %d",e.getX()-x1,e.getY()-y1));
						line= new MyLine( x1,y1, e.getX(),e.getY(),color,fragmentbig);
						x4=e.getX(); y4=e.getY();
						break;
				}
				x=e.getX(); y=e.getY();
				x2=e.getX(); y2=e.getY();
				repaint();
			}
			public void mouseMoved(MouseEvent e){
				x=e.getX(); y=e.getY();
				x2=e.getX(); y2=e.getY();
				coordtetextfield.setText(String.format( "%d,%d",x,y));
				repaint();
			}
			public void mouseClicked(MouseEvent e){ }
			public void mouseEntered(MouseEvent e){ }
			public void mouseExited(MouseEvent e){ 
				x2=-10; y2=-10; repaint();
			}
			public void mouseReleased(MouseEvent e){ 
				areatetextfield.setText(String.format("")); 
				i++; myShape[i]=null; 
			}
		}
		public int getx1( ){ return x3;  }
		public int gety1( ){ return y3;  }
		public int getx2( ){ return x4;  }
		public int gety2( ){ return y4;  }
		public int geti ( ){ return i;   }
		public int getbig(){ return big; }
		public Color getrightcolor(){ return rightcolor; }
		public Color getleftcolor(){ return leftcolor; }
		public boolean getFilled(){ return filled; }
		
		public void setnextmenu(){
			int j;
   			if(b>-1){
				for(j=i-b;j>=0;j++){
					myShape[j] = back[b];
					b--;
					if(back[b]==null){
						myShape[j+1] = back[b];
						b--;
						System.out.printf("b=%d",b);
						break;
					}
				}
				repaint();
				if(b<0){
					item1[0].setEnabled(true);
					item1[1].setEnabled(false);
				}
			}
			else{}
		}
		public void setbackmenu(){
   			int e,j;
   			if(b<i){
   				item1[1].setEnabled(true);
				e=i-(b+1);
				for(j=e;j>=0;j--){
					b++;
					back[b] = myShape[j];
					myShape[j] = null;
					if(myShape[j-1]==null){
						b++;
						back[b] = myShape[j-1];
						myShape[j-1] = null;
						break;
					}
				}
				repaint();
				if(b>=i){ item1[0].setEnabled(false); }
			}
			else{}
		}
		public void setnext(){
			int j;
			if(b>-1){
				for(j=i-b;j>=0;j++){
					myShape[j] = back[b];
					b--;
					
					if(back[b]==null){
						myShape[j+1] = back[b];
						b--;
						System.out.printf("b=%d",b);
						break;
					}
				}
				if(b<0){
					item1[0].setEnabled(true);
					item1[1].setEnabled(false);
				}
				repaint();
			}
			else{ JOptionPane.showMessageDialog( MyFrame.this,"您尚未畫圖或沒有圖!!","警告", JOptionPane.ERROR_MESSAGE ); }
		}
		public void setback(){
			int j,e;
			if(b<i){
				e=i-(b+1);
				for(j=e;j>=0;j--){
					b++;
					back[b] = myShape[j];
					myShape[j] = null;
					if(myShape[j-1]==null){
						b++;
						back[b] = myShape[j-1];
						myShape[j-1] = null;
						break;
					}
				}
				if(b>=i){
					item1[0].setEnabled(false);
				}
				repaint();
			}
			else{
				JOptionPane.showMessageDialog( MyFrame.this,"您尚未畫圖或沒有圖!!","警告", JOptionPane.ERROR_MESSAGE );
			}
		}
		public void sett          ( int t  ){ T=t; }
		public void setbig        ( int big){ this.big=big; }
		public void setclear      (        ){ myShape = new MyShape[10000]; i=-1;b=-1; }
		public void setrightcolor ( Color c){ rightcolor=c; }
		public void setleftcolor  ( Color c){ leftcolor=c; }
		public void setlineclear  (        ){ line = null; }
		public void setFilled     ( boolean isFilled ){ filled = isFilled; }
		
		public void paintComponent( Graphics g ){
			super.paintComponent( g );
			Graphics2D g2d = ( Graphics2D ) g; 
			
			if(bug!=null && img==1){
				g2d.drawImage(bug.getImage(), 0, 0,null);
			}
			for(MyShape a: myShape ){
				if(a!=null){ a.draw(g2d); } 
			}
			if(level>=1){ fragment.draw(g2d); }
			if(line!=null && level==0){
				line.setbig(fragmentbig);
				line.setcolor(leftcolor);
			    line.draw(g2d);
			}
			g2d.setPaint(Color.black);
			g2d.setStroke(new BasicStroke());
			g2d.draw( new Line2D.Double( x2, y2-8, x2, y2-2 ));
			g2d.draw( new Line2D.Double( x2, y2+8, x2, y2+2 ));
			g2d.draw( new Line2D.Double( x2-8, y2, x2-2, y2 ));
			g2d.draw( new Line2D.Double( x2+8, y2, x2+2, y2 ));
			g2d.draw(new Ellipse2D.Double(x2-4,y2-4,8,8));
		} 
	}
}