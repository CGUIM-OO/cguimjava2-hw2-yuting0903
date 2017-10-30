import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * ID: TODO: please add student ID here (5 points)B0544202
 * Name: TODO: please add student name here (5 points) 丁于庭
 * Try to write some comments for your codes (methods, 15 points)
 * 在Deck這個Class中有cards這個ArrayList，cards一格代表一副牌，public Deck裡面所寫的for迴圈可以從Card這個Class中輪流取出不同的花色、號碼的牌放入cards這個陣列中
 * Card這個Class是在安排牌的rank和花色(4種花色，一種花色會有13張牌)
 * 所以花色中先設為1-4如果花色為1則為Clubs，為2則是Diamonds，為3則是Hearts=3，為4則是Spades
 * 如果牌的數字為1則print出A，為11則print出J，為12則print出Q，為13則print出K
 * 在public void printDeck()中我使用for迴圈來依序取出cards中的每副牌的每張卡，讓它一張一張牌顯示出來

 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/*
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;//Class Card
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int deck=1;deck<=nDeck;deck++)
		{
			for(int suit=1;suit<=4;suit++)
			{
				for(int rank=1;rank<=13;rank++)
					{
					Card card = new Card(suit,rank);
					cards.add(card);
					}
			}
		}
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(int n=0;n<cards.size();n++)
		{
			Card card = new Card(cards.get(n).getSuit(),cards.get(n).getRank());
			card.printCard();
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/*
 * Description: TODO: please add description here
 * Card這個Class是在安排牌的rank和花色(4種花色，一種花色會有13張牌)
 * 所以花色中先設為1-4如果花色為1則為Clubs，為2則是Diamonds，為3則是Hearts=3，為4則是Spades
 * 如果牌的數字為1則print出A，為11則print出J，為12則print出Q，為13則print出K
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
			if(suit==1)
				System.out.print("Clubs");
			else if(suit==2)
				System.out.print("Diamonds");
			else if(suit==3)
				System.out.print("Hearts");
			else if(suit==4)
				System.out.print("Spades");
			if(rank==1)
				System.out.println("A");
			else if(rank==2)
				System.out.println("2");
			else if(rank==3)
				System.out.println("3");
			else if(rank==4)
				System.out.println("4");
			else if(rank==5)
				System.out.println("5");
			else if(rank==6)
				System.out.println("6");
			else if(rank==7)
				System.out.println("7");
			else if(rank==8)
				System.out.println("8");
			else if(rank==9)
				System.out.println("9");
			else if(rank==10)
				System.out.println("10");
			else if(rank==11)
				System.out.println("J");
			else if(rank==12)
				System.out.println("Q");
			else if(rank==13)
				System.out.println("K");
			}
		
	public int getSuit(){
			return suit;
		
	}
	public int getRank(){
		return rank;
	}
}
