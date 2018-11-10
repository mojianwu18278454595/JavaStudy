package Salary;

public class Employee extends BaseInfo
{
	public static double eGiftMoney=300;
	
	public double Salary()
	{
		return this.salary;
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
			System.out.print(",生日快乐，发礼物+红包共计："+eGiftMoney+"元 ！");
			return 1;
		}
		
		return 0;
	}
	
	//自定义工资
	public Employee(String name,double salary,String birthday)
	{
		this.name=name;
		this.salary=salary;
		this.birthday=birthday;
	}
	//默认工资
	public Employee(String name,String birthday)
	{
		this.name=name;
		this.salary=4000;  //默认工资为4000元
		this.birthday=birthday;
	}
	
	
	public void print(int month,int bool)
	{
		System.out.print("员工:"+name+",当月工资:"+salary);
		bool=getGift(month);
		System.out.println();
	}
}
