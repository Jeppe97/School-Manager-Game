
public class Main {

	public static void main(String[] args) {
		
			int nrStudents=10;
			money[] money = new money[1];
			money[0]= new money();
			double price =100;
			int newStudents=2;
			nrStudents = nrStudents + newStudents;
			
			buy(money,price);
			amountIncrease(money,newStudents);
			amountIncreaseDay(money,nrStudents);
			
			System.out.println(money[0].getAmountMoney());


	}
	
	public static void buy(money[] money,double price) {
		
		System.out.println(money[0].amountDecreaseBuy(price));
		
	}
	public static void amountIncrease(money[] money,int newStudents) {
		
		money[0].amountIncrease(newStudents);
		
	}
	public static void amountIncreaseDay(money[] money,int nrStudents) {
		
		money[0].amountIncreaseDay(nrStudents);
		
	}
	

}
