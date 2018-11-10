package Salary;

public class Shareholder extends BaseInfo
{
	public double share;
	static double sumProfit; //年终总盈利
	public double pip;
	
	public Shareholder(String name,String birthday,double share)
	{
		this.name=name;
		this.salary=0;
		this.birthday=birthday;
		this.share=share;
	}
	
	public double getPip()
	{
		pip=sumProfit*0.1*share;
		return pip;
	}
	
	public void print(int month,int bool)
	{
		if(month==12)
			System.out.println("股东:"+name+",年终分红:"+getPip());
		else
			System.out.println("股东:"+name+",等待年终分红！");
	}
}
