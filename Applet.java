import java.io.*;
import java.awt.*;
import java.util.*;
import java.applet.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.*;


public class Applet extends JApplet{
	static final int WIDTH = 500;
	static final int HEIGHT = 60;

//	private JFrame mainFrame;
	private Game sudoku;
	private JButton sudokuCheck;
	private Spot[] sudokuOriginal;
	private int[] sudokuOriginalChange;
//	private int[] sudokuBoard;
	private Game ken;
	private JButton kenCheck;
	private Spot[] kenOriginal;
	private int[] kenOriginalChange;
	private int[] kenBoardOperators = {4, 4, 2, 2,4, 4, 3, 3,4, 2, 3, 3,4, 2, 1, 1};
	private int[] kenBoardOpNumbers= {1, 1, 2, 2,1, 1, 5, 7,3, 2, 5, 7,3, 2, 6, 6};
	private int[] kenBoardGroups= {1, 2, 3, 3,1, 2, 4, 5,6, 7, 4, 5,6, 7, 8, 8};
	private int [] sudokuBoard = {7, 8, 0, 0, 1, 0, 0, 0, 5,0, 1, 2, 0, 0, 5, 6, 0, 0,0, 0, 9, 0, 0, 0, 0, 0, 0,0, 0, 0, 1, 0, 0, 9, 0, 0,8, 7, 0, 0, 0, 0, 0, 6, 2,0, 0, 6, 0, 0, 2, 0, 0, 0,0, 0, 0, 0, 0, 0, 5, 0, 0,0, 0, 5, 3, 0, 0, 4, 8, 0,2, 0, 0, 0, 4, 0, 0, 7, 3};
	/*	int[]one = {4, 4, 2, 2,4, 4, 3, 3,4, 2, 3, 3,4, 2, 1, 1};//f.go(args[0]);

	int[]two = {1, 1, 2, 2,1, 1, 5, 7,3, 2, 5, 7,3, 2, 6, 6};//f.go(args[1]);

	int[]three = {1, 2, 3, 3,1, 2, 4, 5,6, 7, 4, 5,6, 7, 8, 8};//f.go(args[2]);
	    	
	int[]four = {3, 3, 3, 3, 3, 3,4, 4, 4, 4, 4, 4,5, 5, 5, 5, 5, 5,1, 1, 1, 1, 1, 1,3, 3, 3, 3, 3, 3,2, 2, 2, 2, 2, 2};// f.go(args[3]);
	    	
	int[]five = {1, 1, 1, 1, 1, 1,2, 2, 2, 2, 2, 2,0, 0, 0, 0, 0, 0,2, 2, 2, 2, 2, 2,1, 1, 1, 1, 1, 1,1, 1, 1, 1, 1, 1};// f.go(args[4]);

	int[]six ={5, 5, 5, 5, 5, 5,2, 2, 2, 2, 2, 2,4, 4, 4, 4, 4, 4,5, 5, 5, 5, 5, 5,5, 5, 5, 5, 5, 5,5, 5, 5, 5, 5, 5};// f.go(args[5]);
	
	int[]seven = {0, 0, 0, 0, 0, 0,2, 2, 2, 2, 2, 2,1, 1, 1, 1, 1, 1,0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0}; //f.go(args[6]);

	int[]eight = {1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5};// f.go(args[7]);
	
	int[]nine = {2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0};// f.go(args[8]);
	
	int[]ten = {5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1,4};// f.go(args[9]);
	
	int[]eleven = {0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1};//f.go(args[10]);

	int[]twelve = {7, 8, 0, 0, 1, 0, 0, 0, 5,0, 1, 2, 0, 0, 5, 6, 0, 0,0, 0, 9, 0, 0, 0, 0, 0, 0,0, 0, 0, 1, 0, 0, 9, 0, 0,8, 7, 0, 0, 0, 0, 0, 6, 2,0, 0, 6, 0, 0, 2, 0, 0, 0,0, 0, 0, 0, 0, 0, 5, 0, 0,0, 0, 5, 3, 0, 0, 4, 8, 0,2, 0, 0, 0, 4, 0, 0, 7, 3};// f.go(args[11]);    	*/
	private Game abc;
	private JButton abcCheck;
	private Spot[] abcOriginal;
	private int[] abcOriginalChange;
	private String [] operators = {"null","multiplication","division","addition","subtraction"};
	private int[]abcRowLetterTypeLeft= {3, 3, 3, 3, 3, 3,4, 4, 4, 4, 4, 4,5, 5, 5, 5, 5, 5,1, 1, 1, 1, 1, 1,3, 3, 3, 3, 3, 3,2, 2, 2, 2, 2, 2};
	private int[]abcRowOrderTypeLeft= {1, 1, 1, 1, 1, 1,2, 2, 2, 2, 2, 2,0, 0, 0, 0, 0, 0,2, 2, 2, 2, 2, 2,1, 1, 1, 1, 1, 1,1, 1, 1, 1, 1, 1};
	private int[]abcRowLetterTypeRight={5, 5, 5, 5, 5, 5,2, 2, 2, 2, 2, 2,4, 4, 4, 4, 4, 4,5, 5, 5, 5, 5, 5,5, 5, 5, 5, 5, 5,5, 5, 5, 5, 5, 5};
	private int[]abcRowOrderTypeRight= {0, 0, 0, 0, 0, 0,2, 2, 2, 2, 2, 2,1, 1, 1, 1, 1, 1,0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0}; 
	private int[]abcColumnLetterTypeDown= {1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5,1, 3, 5, 1, 3, 5};
	private int[]abcColumnOrderTypeDown= {2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0,2, 2, 0, 1, 2, 0};
	private int[]abcColumnLetterTypeUp= {5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1, 4,5, 5, 1, 5, 1,4};
	private int[]abcColumnOrderTypeUp= {0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1,0, 0, 1, 0, 1, 1};
	private JButton [] sudokuButtons=new JButton[81];
	private JButton [] kenButtons=new JButton[16];
	private JButton [] abcButtons=new JButton[36];
	private String [] ABCintToString = {"","A","B","C","D"};
	
	
	public void init() { 
		
//		prepareGUI();
//		this.sudokuBoard=sudokuBoard;
		sudoku = new SudokuGame(sudokuBoard);
		sudokuOriginal = sudoku.getSpots();
		sudokuOriginalChange = new int[sudokuOriginal.length];
		for(int i=0;i<sudokuOriginal.length;i++){
			sudokuOriginalChange[i] = sudokuOriginal[i].getValue();
		}

//		this.kenBoardOperators=kenBoardOperators;
//		this.kenBoardOpNumbers=kenBoardOpNumbers;
//		this.kenBoardGroups=kenBoardGroups;
		ken = new KenKenGame(4,4,kenBoardOperators,kenBoardOpNumbers,kenBoardGroups);
		kenOriginal = ken.getSpots();
		kenOriginalChange = new int[kenOriginal.length];
		for(int i=0;i<kenOriginal.length;i++){
			kenOriginalChange[i] = kenOriginal[i].getValue();
		}
		
/*		this.abcRowLetterTypeLeft=abcRowLetterTypeLeft;
		this.abcRowOrderTypeLeft=abcRowOrderTypeLeft;
		this.abcRowLetterTypeRight=abcRowLetterTypeRight;
		this.abcRowOrderTypeRight=abcRowOrderTypeRight;
		this.abcColumnLetterTypeDown=abcColumnLetterTypeDown;
		this.abcColumnOrderTypeDown=abcColumnOrderTypeDown;
		this.abcColumnLetterTypeUp=abcColumnLetterTypeUp;
		this.abcColumnOrderTypeUp=abcColumnOrderTypeUp;*/
		abc = new ABCGame(6,6,abcRowLetterTypeLeft,abcRowOrderTypeLeft,abcRowLetterTypeRight,abcRowOrderTypeRight,abcColumnLetterTypeDown,abcColumnOrderTypeDown,abcColumnLetterTypeUp,abcColumnOrderTypeUp);
		abcOriginal = abc.getSpots();
		abcOriginalChange = new int[abcOriginal.length];
		for(int i=0;i<abcOriginal.length;i++){
			abcOriginalChange[i] = abcOriginal[i].getValue();
		}			
		

		
		System.out.println("Applet initializing");
		
		JPanel mainFrame = new JPanel();
		
		AnimationPanel amPanel = new AmherstPanel();
		amPanel.setPreferredSize(new Dimension(700,100));
//		AnimationPanel d = new AmherstPanel();
		mainFrame.add(amPanel);
		
		JPanel welcomePanel = new JPanel();
		welcomePanel.setPreferredSize(new Dimension(700,100));
		JLabel welcomeLabel = new JLabel("Welcome to CS112 Puzzles!");
		welcomeLabel.getFont().deriveFont(64f);
		welcomePanel.add(welcomeLabel);
		mainFrame.add(welcomePanel);
		
		JPanel selectionPanel = new JPanel();
		JLabel selectionLabel = new JLabel ("Please select which game you would like to play: ");
		selectionPanel.add(selectionLabel);
		JButton sudoku = new JButton("Sudoku");
		SwitchAppletFrameListener sfl = new SwitchAppletFrameListener(this,"sudoku");
		sudoku.addActionListener(sfl);
		selectionPanel.add(sudoku);
		JButton kenken = new JButton("KenKen");
		SwitchAppletFrameListener sfl2 = new SwitchAppletFrameListener(this,"kenken");
		kenken.addActionListener(sfl2);
		selectionPanel.add(kenken);
		JButton abc = new JButton("ABC's");
		SwitchAppletFrameListener sfl3 = new SwitchAppletFrameListener(this,"abc");
		abc.addActionListener(sfl3);
		selectionPanel.add(abc);
		mainFrame.add(selectionPanel);
		
		AnimationPanel c = new WelcomePanel();
		c.loadpics();
		mainFrame.add(c);
		c.setPreferredSize(new Dimension(300,300));
		AnimateThread thread = new AnimateThread(c);
		thread.start();
		
		getContentPane().add(mainFrame);
		
	}
	
	public void welcomeGUI(){
		
	}
	
	public void sudokuGUI(){
		
		JPanel mainFrame = new JPanel();
		
		AnimationPanel amPanel = new AmherstPanel();
		amPanel.setPreferredSize(new Dimension(450,100));
		mainFrame.add(amPanel);
		
		JPanel welcomePanel = new JPanel();
		
		JLabel welcomeLabel = new JLabel("Welcome to Sudoku!");
		welcomeLabel.getFont().deriveFont(64f);
		
		welcomePanel.add(welcomeLabel);
		
		mainFrame.add(welcomePanel);
		
		JPanel puzzle = new JPanel();
		puzzle.setLayout(new GridLayout(9,9));
/*		for(int i =0;i<81;i++){
			JButton gameSpot;
			if(sudokuOriginal[i].getValue()==0){
				gameSpot = new JButton(sudokuOriginal[i].getValue()+"");
			}else{
				gameSpot = new JButton();
			}
			sudokuButtons[i]=gameSpot;
			SudokuButtonToMenuListener sbml = new SudokuButtonToMenuListener(gameSpot,i,this);
			gameSpot.addActionListener(sbml);
			gameSpot.setPreferredSize(new Dimension(50,50));
			puzzle.add(gameSpot);
		}*/
		for (int i=0;i<9;i++){
			String s = Integer.toString(sudokuOriginal[i].getValue());
			JButton changer = new JButton();
		    sudokuButtons[i]=changer;
		    if(i<3)
		    	changer.setBackground(Color.yellow);
		    else if(i<6)
		    	changer.setBackground(Color.green);
		    else if(i<9)
		    	changer.setBackground(Color.orange);
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		for (int i=9;i<18;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();
		    sudokuButtons[i]=changer;	 
		    if(i<12)
		    	changer.setBackground(Color.yellow);
		    else if(i<15)
		    	changer.setBackground(Color.green);
		    else if(i<18)
		    	changer.setBackground(Color.orange);   
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		for (int i=18;i<27;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();
		    sudokuButtons[i]=changer;	
		    if(i<21)
		    	changer.setBackground(Color.yellow);
		    else if(i<24)
		    	changer.setBackground(Color.green);
		    else if(i<27)
		    	changer.setBackground(Color.orange);    
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		for (int i=27;i<36;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();
		    sudokuButtons[i]=changer;
		    if(i<30)
		    	changer.setBackground(Color.orange);
		    else if(i<33)
		    	changer.setBackground(Color.yellow);
		    else if(i<36)
		    	changer.setBackground(Color.green);    	    
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}

		for (int i=36;i<45;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();
		    sudokuButtons[i]=changer;
		    if(i<39)
		    	changer.setBackground(Color.orange);
		    else if(i<42)
		    	changer.setBackground(Color.yellow);
		    else if(i<45)
		    	changer.setBackground(Color.green);    	    	    
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		for (int i=45;i<54;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();
		    sudokuButtons[i]=changer;	   
		    if(i<48)
		    	changer.setBackground(Color.orange);
		    else if(i<51)
		    	changer.setBackground(Color.yellow);
		    else if(i<54)
		    	changer.setBackground(Color.green);    	     
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		for (int i=54;i<63;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();	
		    sudokuButtons[i]=changer;
		    if(i<57)
		    	changer.setBackground(Color.green);
		    else if(i<60)
		    	changer.setBackground(Color.orange);
		    else if(i<63)
		    	changer.setBackground(Color.yellow);    
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);	     	    
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		for (int i=63;i<72;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();
		    sudokuButtons[i]=changer;
		    if(i<66)
		    	changer.setBackground(Color.green);
		    else if(i<69)
		    	changer.setBackground(Color.orange);
		    else if(i<72)
		    	changer.setBackground(Color.yellow);    	     	    
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		for (int i=72;i<81;i++){
		    String s = Integer.toString(sudokuOriginal[i].getValue());
		    JButton changer = new JButton();
		    sudokuButtons[i]=changer;
		    if(i<75)
		    	changer.setBackground(Color.green);
		    else if(i<78)
		    	changer.setBackground(Color.orange);
		    else if(i<81)
		    	changer.setBackground(Color.yellow);    	     	    
		    if (sudokuOriginal[i].getValue()!=0)
		    	changer.setText(s);
		    if(sudokuOriginal[i].getValue()==0){
		    	SudokuAppletButtonToMenuListener number = new SudokuAppletButtonToMenuListener(changer,i,this);
		    	changer.addActionListener(number);
		    }
			changer.setPreferredSize(new Dimension(50,50));
		    puzzle.add(changer);
		}
		
		mainFrame.add(puzzle);
		
		JPanel userOptions = new JPanel();
		userOptions.setLayout(new FlowLayout());
		userOptions.setSize(600, 100);
		
		JLabel homePageReturnLabel = new JLabel("Return to CS112 Puzzles Home Page");
		
		userOptions.add(homePageReturnLabel);

		JButton homePageReturnButton = new JButton("Click Here");
		SwitchAppletFrameListener sfl = new SwitchAppletFrameListener(this,"welcome");
		homePageReturnButton.addActionListener(sfl);
	
		userOptions.add(homePageReturnButton);
		
		JLabel solveSudokuLabel = new JLabel("See the solution: ");
		
		userOptions.add(solveSudokuLabel);
		
		JButton solveSudokuButton = new JButton("Click Here");
		DisplayAppletSolutionListener dsl = new DisplayAppletSolutionListener("sudoku",this);
		solveSudokuButton.addActionListener(dsl);
		
		userOptions.add(solveSudokuButton);
		
		JLabel checkSudokuLabel = new JLabel("Did you solve it? ");
		
		JPanel userOptions2 = new JPanel();
		userOptions2.setLayout(new FlowLayout());
		userOptions2.setSize(600, 100);
		
		userOptions2.add(checkSudokuLabel);

		sudokuCheck = new JButton("Click Here");
		
		CheckAppletSolved cs = new CheckAppletSolved ("sudoku",this);
		
		sudokuCheck.addActionListener(cs);
		
		userOptions2.add(sudokuCheck);
		
		mainFrame.add(userOptions);
		mainFrame.add(userOptions2);

//		mainFrame.setVisible(true);
		
		getContentPane().add(mainFrame);
		
		
	}
	
	public void kenkenGUI(){
		
		JPanel mainFrame = new JPanel();
		
		AnimationPanel amPanel = new AmherstPanel();
		amPanel.setPreferredSize(new Dimension(450,100));
		mainFrame.add(amPanel);
		
		JPanel welcomePanel = new JPanel();
		
		JLabel welcomeLabel = new JLabel("Welcome to KenKen!");
		welcomeLabel.getFont().deriveFont(64f);
		
		welcomePanel.add(welcomeLabel);
		
		mainFrame.add(welcomePanel);
		
		JPanel kenkenpuzzle = new JPanel();
		kenkenpuzzle.setLayout(new GridLayout(4,4));
		for(int i =0;i<16;i++){
			String opType = operators[kenBoardOperators[i]];
			if(opType.equals("subtraction"))
				opType="-";
			if(opType.equals("multiplication"))
				opType="*";
			if(opType.equals("addition"))
				opType="+";
			if(opType.equals("division"))
				opType="�";	       
			String opNum = Integer.toString(kenBoardOpNumbers[i]);
			JButton changer = new JButton();
			int group = kenBoardGroups[i];
		    if(group==1)
		    	changer.setBackground(Color.yellow);
		    if(group==2)
		    	changer.setBackground(Color.green);
		    if(group==3)
		    	changer.setBackground(Color.orange);
		    if(group==4)
		    	changer.setBackground(Color.red);
		    if(group==5)
		    	changer.setBackground(Color.blue);
		    if(group==6)
		    	changer.setBackground(Color.orange);
		    if(group==7)
		    	changer.setBackground(Color.yellow);
		    if(group==8)
		    	changer.setBackground(Color.green);
		    JLabel info = new JLabel(opNum+opType);
		    info.setHorizontalAlignment(JLabel.LEFT);
		    info.setVerticalAlignment(JLabel.TOP);
		    changer.add(info);
			kenButtons[i]=changer;
			KenAppletButtonToMenuListener sbml = new KenAppletButtonToMenuListener(changer,i,this);
			changer.addActionListener(sbml);
			changer.setPreferredSize(new Dimension(100,100));
			kenkenpuzzle.add(changer);
		}
		
		mainFrame.add(kenkenpuzzle);
		
		JPanel userOptions = new JPanel();
		userOptions.setLayout(new FlowLayout());
		userOptions.setSize(600, 100);
		
		JLabel homePageReturnLabel = new JLabel("Return to CS112 Puzzles Home Page");
		
		userOptions.add(homePageReturnLabel);

		JButton homePageReturnButton = new JButton("Click Here");
		SwitchAppletFrameListener sfl = new SwitchAppletFrameListener(this,"welcome");
		homePageReturnButton.addActionListener(sfl);
	
		userOptions.add(homePageReturnButton);
		
		JLabel solveKenLabel = new JLabel("See the solution: ");
		
		userOptions.add(solveKenLabel);
		
		JButton solveKenButton = new JButton("Click Here");
		DisplayAppletSolutionListener dsl = new DisplayAppletSolutionListener("ken",this);
		solveKenButton.addActionListener(dsl);
		
		userOptions.add(solveKenButton);
		
		JPanel userOptions2 = new JPanel();
		userOptions2.setLayout(new FlowLayout());
		userOptions2.setSize(600, 100);
		
		JLabel checkKenLabel = new JLabel("Did you solve it? ");
		
		userOptions2.add(checkKenLabel);
		
		kenCheck = new JButton("Click Here");
		CheckAppletSolved cs = new CheckAppletSolved ("ken",this);
		kenCheck.addActionListener(cs);
		
		userOptions2.add(kenCheck);
		
		mainFrame.add(userOptions);
		mainFrame.add(userOptions2);

		getContentPane().add(mainFrame);
//		mainFrame.setVisible(true);
	}
	
	public void abcGUI(){
		
		JPanel mainFrame = new JPanel();
		
		AnimationPanel amPanel = new AmherstPanel();
		amPanel.setPreferredSize(new Dimension(450,100));
		mainFrame.add(amPanel);
		
		JPanel welcomePanel = new JPanel();
		
		JLabel welcomeLabel = new JLabel("Welcome to ABCs!");
		welcomeLabel.getFont().deriveFont(64f);
		
		welcomePanel.add(welcomeLabel);
		
		mainFrame.add(welcomePanel);
		
		JPanel abcpuzzle = new JPanel();
		abcpuzzle.setLayout(new GridLayout(8,8));
//		loadpics();
		int counter =0;
		for(int i=0;i<8;i++){
			if(i==1){
				ABCPanel panel = new ABCPanel();
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			} else if (i==2){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("C2Down");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			} else if (i==4){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("A1Down");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			} else if (i==5){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("C2Down");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			} else {
				ABCPanel panel = new ABCPanel();
				panel.changeImage("null");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}
		}
		for(int i =0;i<48;i++){
			if(i==0||i==32){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("C1Right");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}else if(i==7||i==16||i==31||i==39||i==47){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("null");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}else if(i==8){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("D2Right");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}else if(i==15){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("B2Left");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}else if(i==23){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("D1Left");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}else if(i==24){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("A2Right");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}else if(i==40){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("B1Right");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			} else {
				
				JButton gameSpot = new JButton();
				gameSpot.repaint();
				abcButtons[counter]=gameSpot;
				ABCAppletButtonToMenuListener sbml = new ABCAppletButtonToMenuListener(gameSpot,i,this);
				gameSpot.addActionListener(sbml);
				gameSpot.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(gameSpot);
				counter++;
			}
		}
		for(int i=0;i<8;i++){
			if (i==3||i==5){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("A1Up");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			} else if (i==6){
				ABCPanel panel = new ABCPanel();
				panel.changeImage("D1Up");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}else {
				ABCPanel panel = new ABCPanel();
				panel.changeImage("null");
				panel.setPreferredSize(new Dimension(50,50));
				abcpuzzle.add(panel);
			}
		}
		
		mainFrame.add(abcpuzzle);
		
		JPanel userOptions = new JPanel();
		userOptions.setLayout(new FlowLayout());
		userOptions.setSize(600, 100);
		
		JLabel homePageReturnLabel = new JLabel("Return to CS112 Puzzles Home Page");
		
		userOptions.add(homePageReturnLabel);

		JButton homePageReturnButton = new JButton("Click Here");
		SwitchAppletFrameListener sfl = new SwitchAppletFrameListener(this,"welcome");
		homePageReturnButton.addActionListener(sfl);
	
		userOptions.add(homePageReturnButton);
		
		JLabel solveABCLabel = new JLabel("See the solution: ");
		
		userOptions.add(solveABCLabel);
		
		JButton solveABCButton = new JButton("Click Here");
		DisplayAppletSolutionListener dsl = new DisplayAppletSolutionListener("abc",this);
		solveABCButton.addActionListener(dsl);
		
		userOptions.add(solveABCButton);
		
		JPanel userOptions2 = new JPanel();
		userOptions2.setLayout(new FlowLayout());
		userOptions2.setSize(600, 100);
		
		JLabel checkABCLabel = new JLabel("Did you solve it? ");
		
		userOptions2.add(checkABCLabel);
		
		abcCheck = new JButton("Click Here");
		CheckAppletSolved cs = new CheckAppletSolved ("abc",this);
		abcCheck.addActionListener(cs);
		
		userOptions2.add(abcCheck);
		
		mainFrame.add(userOptions);
		mainFrame.add(userOptions2);
		
		getContentPane().add(mainFrame);
//		mainFrame.setVisible(true);
		
		
	}
	
	public void setSudoku(int index, int value){
		this.sudokuOriginalChange[index]=value;
	}
	
	public void setKen(int index, int value){
		this.kenOriginalChange[index]=value;
	}
	
	public void setABC(int index, int value){
		this.abcOriginalChange[index]=value;
	}
	
	public void displaySudoku(){
		Solver solversudoku = new Solver(sudoku);
		solversudoku.solve();
		Spot[]sudokuSolved = solversudoku.getSpots();
		
		for(int i=0;i<81;i++){
			sudokuButtons[i].setText(sudokuSolved[i].getValue()+"");
		}
		for (JButton b :sudokuButtons) {	
		    b.setEnabled(false);
		}
		sudokuCheck.setText("SOLVED!");
		AnimationPanel c = new Loser();
		c.loadpics();
		// this adds the loser animation, if you get to it
//		mainFrame.add(c);
		c.setPreferredSize(new Dimension(100,100));
		AnimateThread thread = new AnimateThread(c);
		thread.start();
	}
	
	public void displayKen(){
		Solver solverken = new Solver(ken);
		solverken.solve();
		Spot [] kenSolved = solverken.getSpots();
		for(int i=0;i<16;i++){
			kenButtons[i].setText(kenSolved[i].getValue()+"");
		}
		for (JButton b :kenButtons) {	
		    b.setEnabled(false);
		}
		sudokuCheck.setText("SOLVED!");
		AnimationPanel c = new Loser();
		c.loadpics();
		// this will display the loser animation
//		mainFrame.add(c);
		c.setPreferredSize(new Dimension(100,100));
		AnimateThread thread = new AnimateThread(c);
		thread.start();
	}
	
	public void displayABC(){
		Solver solverabc = new Solver(abc);
		solverabc.solve();
		Spot[]abcSolved = solverabc.getSpots();
		for(int i=0;i<36;i++){
			abcButtons[i].setText(ABCintToString[abcSolved[i].getValue()]);
		}
		for (JButton b :abcButtons) {	
		    b.setEnabled(false);
		}
		sudokuCheck.setText("SOLVED!");
		AnimationPanel c = new Loser();
		c.loadpics();
		// displays loser animation
//		mainFrame.add(c);
		c.setPreferredSize(new Dimension(100,100));
		AnimateThread thread = new AnimateThread(c);
		thread.start();
		
	}
	
	public void checkSudoku(){
		Solver solversudoku = new Solver(sudoku);
		solversudoku.solve();
		Spot[]sudokuSolved = solversudoku.getSpots();
		boolean solved = true;
		for(int i=0;i<sudokuSolved.length;i++){
			if(this.sudokuOriginalChange[i]!=sudokuSolved[i].getValue()){
				solved=false;
				break;
			}
		}
		if(solved){
			sudokuCheck.setText("SOLVED!");
			AnimationPanel c = new Conner();
			c.loadpics();
			// i think this adds the winner animation, if you get to it
//			mainFrame.add(c);
			c.setPreferredSize(new Dimension(100,100));
			AnimateThread thread = new AnimateThread(c);
			thread.start();
		}else{
			sudokuCheck.setText("KEEP TRYING!");
		}
	}
	
	public void checkKen(){
		Game ken2 = this.ken;
		Solver solverken = new Solver(ken2);
		solverken.solve();
		Spot[]kenSolved = solverken.getSpots();
		boolean solved = true;
		for(int i=0;i<kenSolved.length;i++){
			if(this.kenOriginalChange[i]!=kenSolved[i].getValue()){
				solved=false;
				break;
			}
		}
		if(solved){
			kenCheck.setText("SOLVED!");
			AnimationPanel c = new Conner();
			c.loadpics();
			// this will add winner animation
//			mainFrame.add(c);
			c.setPreferredSize(new Dimension(100,100));
			AnimateThread thread = new AnimateThread(c);
			thread.start();
		} else {
			kenCheck.setText("KEEP TRYING!");
		}
	}
	
	public boolean checkABC(){
		Game abc2 = this.abc;
		Solver solverabc = new Solver(abc2);
		solverabc.solve();
		Spot[]abcSolved = solverabc.getSpots();
		for(int i=0;i<abcSolved.length;i++){
			if(this.abcOriginalChange[i]!=abcSolved[i].getValue()){
				abcCheck.setText("KEEP TRYING!");
				return false;
			}
		}
		abcCheck.setText("SOLVED!");
		AnimationPanel c = new Conner();
		c.loadpics();
		// this'll add the winner animation
//		mainFrame.add(c);
		c.setPreferredSize(new Dimension(100,100));
		AnimateThread thread = new AnimateThread(c);
		thread.start();
		return true;
	}
	
	public void start() {
		System.out.println("Applet starting");
	}
	public void stop() {
		System.out.println("Applet stopping");
	}
	public void destroy() {
		System.out.println("Applet destroyed");
	}
	
}
