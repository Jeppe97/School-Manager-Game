
public class money {
	
	private double amountMoney=1000;
	private double amountStudent=100;
	private double amountDay=20;
	
	public void amountIncrease(int increaseNrStudents)
	{
		amountMoney= amountMoney + (increaseNrStudents*amountStudent);
	}
	public void amountIncreaseDay(int nrOfStudents)
	{
		//Main??
		amountMoney = amountMoney + (nrOfStudents*amountDay);
	}

	public double getAmountMoney() {
		return amountMoney;
	}

	public String amountDecreaseBuy(double price)
	{
		String message="You don't have enough of money";
		if(price<=amountMoney)
		{
			amountMoney= amountMoney-price;
			message= "The transaction was succesfull";
		}
		return message;
	}
	
	
	
	

}
