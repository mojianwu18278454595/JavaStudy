package Transforms;

import java.util.Scanner;

public class controlAll
{
	public static void main(String[] args)
	{
		//输入数据
		System.out.println("请输入出发地,目的地,距离:(格式:荆州,北京,1261.4)");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().toString().trim();
		String[] str = input.split(",");
		
		//取出输入数据
		BaseTranfm.fromPlace=str[0];
		BaseTranfm.toPlace=str[1];
		BaseTranfm.distance=Double.valueOf(str[2]);
		
		try 
		{
			//创建三个实例
			carTranfm car = new carTranfm();
			airplaneTranfm airplane = new airplaneTranfm();
			trainTranfm train = new trainTranfm();
			//输出结果
			car.print();
			train.print();
			airplane.print();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
