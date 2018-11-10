package Salary;

public class Manager extends BaseInfo
{
	public double bonus;
	public static double mGiftMoney=500;
	
	public Manager(String name,String birthday,double bonus)
	{
		this.name=name;
		this.salary=6000;  //默认基本工资
		this.birthday=birthday;
		this.bonus=bonus;
	}
	
	public int getGift(int month)
	{
		String date=birthday;
		String[] ymd=date.split("-");
		
		if(ymd[1].charAt(0)=='0')
		{
			ymd[1]=ymd[1].substring(1, 2);
		}
		
		int Month=Integer.valueOf(ymd[1].trim());
		if(Month==month)
		{
			System.out.print(",生日快乐，礼物+红包共计："+mGiftMoney+"元 ！");
			return 2;
		}
		
		return 0;
	}
	
	public double sumSalary()
	{
		return salary+bonus;
	}
	
	public void print(int month,int bool)
	{
		System.out.print("经理:"+name+",当月工资:"+salary+",当月奖金:"+bonus);
		bool=getGift(month);
		System.out.println();
	}
	
}
