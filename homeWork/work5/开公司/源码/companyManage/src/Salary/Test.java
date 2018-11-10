package Salary;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test
{
	ArrayList<BaseInfo> listAll;
	double sumEpy=0;
	double sumManager=0;
	configInfo config;  //配置对象
	randInfo randInformation; //随机生成对象
	
	//构造基本信息
	public Test()
	{
		listAll=new ArrayList<BaseInfo>();
		config=new configInfo();
		randInformation = new randInfo();
	}
	
	//添加员工
	public void addEpy() throws Exception
	{
		//手动添加
		int n=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入"+n+"号员工信息{(格式提示:沈翀,4000,1997-09-01 )( 退出:exit)}：");
		String data=sc.nextLine();
		data=data.trim();
		while(!data.equals("exit"))
		{
			n++;
			String[] epyInfo=data.split(",");
			String name=epyInfo[0].trim();
			double salary=Double.valueOf(epyInfo[1].trim());
			String birthday=epyInfo[2].trim();
			listAll.add(new Employee(name,salary,birthday));
			sumEpy=sumEpy+salary;
			
			System.out.println("请输入"+n+"员工信息：");
			data=sc.nextLine();
			data=data.trim();
		}
		
		//自动添加
		int eNumber=config.configXML()[0];
		for(int i=0;i<eNumber-n;i++)
		{
			//按默认工资构造
			Employee e=new Employee(randInformation.randToName(),randInformation.randToBirthday());
			listAll.add(e);
			sumEpy=sumEpy+e.Salary(); //总工资（不算生日）
		}
		
		System.out.println("员工信息录入完成！(包含系统自动生成员工部分)\n");
	}
	
	//添加经理
	public void addMng() throws Exception
	{
		int mNumber=config.configXML()[1];
		for(int i=0;i<mNumber;i++)
		{
			Manager m=new Manager(randInformation.randToName(),
					randInformation.randToBirthday(),randInformation.randToBonus());
			listAll.add(m);
			sumManager=sumManager+m.sumSalary();  //总工资(不算生日)
		}
		
		System.out.println("经理信息录入成功！");
	}
	
	//添加股东
	public void addShdr() throws Exception
	{
		double sumPoint=0;
		Shareholder.sumProfit=5000000;  //总盈利当前500 0000
		//固定两个股东
		Shareholder s1=new Shareholder("沈总","1997-09-01",0.3);
		Shareholder s2=new Shareholder("汪总","1998-10-13",0.4);
		listAll.add(s1);
		listAll.add(s2);
		sumPoint=s1.share+s2.share;
		
		//自动添加
		int sNumber=config.configXML()[2];
		if(sNumber>2)
			for(int i=2;i<sNumber;i++)
			{
				//默认股份0.05
				Shareholder s=new Shareholder(randInformation.randToName(),randInformation.randToBirthday(),0.05);
				listAll.add(s);
				sumPoint=sumPoint+s.share;
				if(sumPoint>1)
				{
					System.out.println("股东股份信息有误！");
					break ;
				}
			}
		System.out.println("股东信息录入成功！");
	}
	
	//每月工资清单
	public void monthSalary() throws Exception
	{
		int bool=0;
		Connection conn=config.mysqlConn();
		
		for(int i=1;i<=12;i++)
		{
			System.out.println("****************"+i+"月份工资清单："+"****************");
			
			//增强for遍历
			//Iterator<BaseInfo> iter=listAll.iterator();
			//while(iter.hasNext())
			for(BaseInfo bInfo:listAll)
			{
				bInfo.print(i,bool);
				if(bool==1)
					Shareholder.sumProfit=Shareholder.sumProfit-Employee.eGiftMoney;
				if(bool==2)
					Shareholder.sumProfit=Shareholder.sumProfit-Manager.mGiftMoney;
				
				//取得listAll的实际类型
				String tableName=bInfo.getClass().getName().toString();
				tableName=tableName.substring(7);
				
				//BaseInfo bInfo=(BaseInfo)iter.next();
				config.executeQuiryEpy(conn, tableName, bInfo, i);
				
			}
			Shareholder.sumProfit=Shareholder.sumProfit-sumManager-sumEpy;
			System.out.println("当前总盈利："+Shareholder.sumProfit);
			
			System.out.println("*******************************************\n");
		}
		config.closeConn(conn);
	}
	
	public static void main(String[] args) throws Exception
	{
		Test myCompany=new Test();
		
		//加载全体人员
		myCompany.addEpy();
		myCompany.addMng();
		myCompany.addShdr();
		
		//工资清单展示
		myCompany.monthSalary();
		
	}

}
