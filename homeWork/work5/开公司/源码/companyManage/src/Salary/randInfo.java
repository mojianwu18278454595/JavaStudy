package Salary;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

public class randInfo
{
	private HashMap<Integer,String> nameAll=new HashMap<Integer,String>();
	Random rand;
	
	//构造函数
	public randInfo()
	{
		rand=new Random();
		String[] strName= {"沈","崔","汤","浩","台","旭","文","万","新","翀"};
		for(int i=0;i<strName.length;i++)
			nameAll.put(i, strName[i]);
	}
	
	//生成随机名
	public String randToName()
	{
		int n1=rand.nextInt(10);
		int n2=rand.nextInt(10);
		String name=nameAll.get(n1)+nameAll.get(n2);
		return name;	
	}
	
	//随机生成生日
	public String randToBirthday()
	{
		String birthday="1998-10-13";
		
		int n1=rand.nextInt(12);
		n1=n1+1990;
		int n2=rand.nextInt(12);
		n2=1+n2;
		int n3=rand.nextInt(30);
		n3=1+n3;
		
		if(n1>=1990&&n2>0&&n3>0)
		birthday=n1+"-"+n2+"-"+n3;
		
		return birthday;
	}
	
	//随机生成bonus
	public double randToBonus()
	{
		double bonus=rand.nextInt(6001);
		bonus=bonus+6000;
		return bonus;
	}
}
