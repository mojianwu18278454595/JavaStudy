package Transforms;

import java.text.DecimalFormat;

abstract class BaseTranfm 
{
	double price;
	double everyMoney;
	double time;
	static String fromPlace;
	static String toPlace;
	static double distance;
	
	public BaseTranfm() 
	{
		
	}
	
	
	abstract String countTimePrice();
	
	public void print()
	{
		DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(countTimePrice()+df.format(price)+"元 )");
        System.out.println();
	}
	
}
