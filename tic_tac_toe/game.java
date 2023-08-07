package tic_tac_toe;
import java.util.*;
public class game {
	static List <Integer> l = new ArrayList <Integer>();
	static Scanner sc = new Scanner(System.in);
	static int gameover = -1;
	static String p1;
	static String p2;
	static String[][]board = {{" "," "," "},
							  {" "," "," "},
							  {" "," "," "}};
	public static void change_state(String [][]b,int m,String ss,List <Integer> ll)
	{
		boolean bb = ll.contains(m);
		if(bb)
		{
			if(m<=3)
			{
				b[0][m-1] = ss;
			}
			else if(m>3 && m<=6)
			{
				b[1][m-4] = ss;
			}
			else
			{
				b[2][m-7] = ss;
			}
		}
		else
		{
			System.out.println("Invalid move");
		}
	}
	public static int check_state(String [][]b,String p,int pp)
	{
		for(int i=0;i<3;i++)
		{
			if(b[i][0]==p && b[i][1]==p && b[i][2]==p)
			{
				return pp;
			}
		}
		for(int i = 0;i<3;i++)
		{
			if(b[0][i]==p && b[1][i]==p && b[2][i]==p)
			{
				return pp;
			}
		}
		if(b[0][0]==p && b[1][1]==p && b[2][2]==p)
		{
			return pp;
		}
		if(b[0][2]==p && b[1][1]==p && b[2][0]==p)
		{
			return pp;
		}
		return -1;
	}
	public static void display(String[][] b)
	{	
		System.out.println(" "+b[0][0] + " | " + b[0][1] + " | " + b[0][2] + " ");
		System.out.println("---+---+---");
		System.out.println(" "+b[1][0] + " | " + b[1][1] + " | " + b[1][2] + " ");
		System.out.println("---+---+---");
		System.out.println(" "+b[2][0] + " | " + b[2][1] + " | " + b[2][2] + " ");
		}
	public static void main(String args[])
	{
		System.out.println();
		System.out.println("******** Welcome to Tic-Tac-Toe ********");
		System.out.println();
		System.out.println("********         Menu           ********");
		System.out.println("Press '1' to start the game");
		System.out.println("Press '2' to quit game");
		int mm = sc.nextInt();
		while(mm!=2)
		{
			String[][]pos = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
			l.add(1);
			l.add(2);
			l.add(3);
			l.add(4);
			l.add(5);
			l.add(6);
			l.add(7);
			l.add(8);
			l.add(9);
			System.out.println("Select the pieces");
			System.out.println(" 1. 'X' or 2. 'O'");
			int aa = sc.nextInt();
			if(aa==1)
			{
				p1 = "X";
				p2 = "O";
			}
			else
			{
				p1 = "O";
				p2 = "X";
			}
			System.out.println("Player 1:" + p1);
			System.out.println("Player 2:" + p2);
			System.out.println("Board positions:");
			display(pos);
			System.out.println();
			int i=0;
			int p = 1;
			int move;
			while(gameover!=0 && gameover!=1 && gameover!=2)
			{
				if(i==9)
				{
					gameover = 0;
					break;
				}
				display(board);
				System.out.println(l);
				System.out.println("Player " + p + " move:");
				move = sc.nextInt();
				if(p==1)
				{
					change_state(board,move,p1,l);
					gameover = check_state(board,p1,p);
					l.remove(Integer.valueOf(move));
					p=2;
				}
				else
				{
					change_state(board,move,p2,l);
					gameover=check_state(board,p2,p);
					l.remove(Integer.valueOf(move));
					p=1;
				}
				i++;
				System.out.println(gameover);
			}
			display(board);
			if(gameover==1)
			{
				System.out.println("Player 1 wins!");
			}
			else if(gameover==2)
			{
				System.out.println("Player 2 wins!");
			}
			else
			{
				System.out.println("Tie!");
			}
			System.out.println("Play again?(y/n)");
			String ch = sc.next();
			if(ch=="n")
			{
				mm=2;
			}
		}
		if(mm==2)
		{
			System.exit(0);
		}
	}
}