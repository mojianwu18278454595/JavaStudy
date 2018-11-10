import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestList
{
	public TestList()
	{
		
	}
	
	public void TestLinkedList(ArrayList<Points> points)
	{
		LinkedList<Integer> LList=new LinkedList<Integer>();
		//记录查询时间点
		double[] averTimeY=new double[10];
		int[] averTimeX=new int[10];
		
		//改变LinkedList的数据量
		int n=100000;
		//记录查找100次总时长
		double total=0;
		
		
		for(int average=0;average<10;average++)
		{
			//向LinkedList加入数据
			for(int i=0;i<n;i++)
				LList.add(i);
			
			//将LList载入迭代器
			Iterator<Integer> iter=LList.iterator();
			
			//100次查找
			for(int m=0;m<100;m++)
			{
				//生成随即查找数
				Random rand=new Random();
				int goal=rand.nextInt();
				int start=(int)System.currentTimeMillis();
				//遍历查找
				while(iter.hasNext())
					if(iter.next()==goal)
						break;
				int end=(int)System.currentTimeMillis();
				//取得100次查找的总时间
				total=total+end-start;
			}
			//取得100次查找的averageTime
			averTimeY[average]=total/100.0;
			averTimeX[average]=n;
			points.add(new Points(averTimeX[average],averTimeY[average]));
			n=n+100000;
		}
	}

	public void TestArrayList(ArrayList<Points> points)
	{
		ArrayList<Integer> AList=new ArrayList<Integer>();
		//记录查询时间点
		double[] averTimeY=new double[10];
		int[] averTimeX=new int[10];
		
		//改变LinkedList的数据量
		int n=100000;
		//记录查找100次总时长
		double total=0;
		
		
		for(int average=0;average<10;average++)
		{
			//向ArrayList加入数据
			for(int i=0;i<n;i++)
				AList.add(i);
			
			//将AList载入迭代器
			Iterator<Integer> iter=AList.iterator();
			
			//100次查找
			for(int m=0;m<100;m++)
			{
				//生成随即查找数
				Random rand=new Random();
				int goal=rand.nextInt();
				int start=(int)System.currentTimeMillis();
				//遍历查找
				while(iter.hasNext())
					if(iter.next()==goal)
						break;
				int end=(int)System.currentTimeMillis();
				//取得100次查找的总时间
				total=total+end-start;
			}
			//取得100次查找的averageTime
			averTimeY[average]=total/100.0;
			averTimeX[average]=n;
			points.add(new Points(averTimeX[average],averTimeY[average]));
			n=n+100000;
		}
	}
	
	public void TestHashMap(ArrayList<Points> points)
	{
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
		//记录查询时间点
		double[] averTimeY=new double[10];
		int[] averTimeX=new int[10];
		
		//改变HashMap的数据量
		int n=100000;
		//记录查找100次总时长
		double total=0;
		
		
		for(int average=0;average<10;average++)
		{
			//向HashMap加入数据
			for(int i=0;i<n;i++)
				hash.put(i, i);
			
			//100次查找
			for(int m=0;m<100;m++)
			{
				//生成随即查找数
				Random rand=new Random();
				int goal=rand.nextInt();
				int start=(int)System.currentTimeMillis();
				
				//查找
				hash.get(goal);
				
				int end=(int)System.currentTimeMillis();
				//取得100次查找的总时间
				total=total+end-start;
			}
			//取得100次查找的averageTime
			averTimeY[average]=total/100.0;
			averTimeX[average]=n;
			points.add(new Points(averTimeX[average],averTimeY[average]));
			n=n+100000;
		}
	}

	public void TestHashSet(ArrayList<Points> points)
	{
		HashSet<Integer> hashSet=new HashSet<Integer>();
		//记录查询时间点
		double[] averTimeY=new double[10];
		int[] averTimeX=new int[10];
		
		//改变HashSet的数据量
		int n=100000;
		//记录查找100次总时长
		double total=0;
		
		
		for(int average=0;average<10;average++)
		{
			//向HashSet加入数据
			for(int i=0;i<n;i++)
				hashSet.add(i);
			
			//将hashSet载入迭代器
			Iterator<Integer> iter=hashSet.iterator();
			
			//100次查找
			for(int m=0;m<100;m++)
			{
				//生成随即查找数
				Random rand=new Random();
				int goal=rand.nextInt();
				int start=(int)System.currentTimeMillis();
				//遍历查找
				while(iter.hasNext())
					if(iter.next()==goal)
						break;
				int end=(int)System.currentTimeMillis();
				//取得100次查找的总时间
				total=total+end-start;
			}
			//取得100次查找的averageTime
			averTimeY[average]=total/100.0;
			averTimeX[average]=n;
			points.add(new Points(averTimeX[average],averTimeY[average]));
			n=n+100000;
		}
	}

	public void TestTreeMap(ArrayList<Points> points)
	{
		TreeMap<Integer,Integer> tree=new TreeMap<Integer,Integer>();
		//记录查询时间点
		double[] averTimeY=new double[10];
		int[] averTimeX=new int[10];
		
		//改变TreeMap的数据量
		int n=100000;
		//记录查找100次总时长
		double total=0;
		
		
		for(int average=0;average<10;average++)
		{
			//向TreeMap加入数据
			for(int i=0;i<n;i++)
				tree.put(i, i);
			
			//100次查找
			for(int m=0;m<100;m++)
			{
				//生成随即查找数
				Random rand=new Random();
				int goal=rand.nextInt();
				int start=(int)System.currentTimeMillis();
				
				//查找
				tree.get(goal);
				
				int end=(int)System.currentTimeMillis();
				//取得100次查找的总时间
				total=total+end-start;
			}
			//取得100次查找的averageTime
			averTimeY[average]=total/100.0;
			averTimeX[average]=n;
			points.add(new Points(averTimeX[average],averTimeY[average]));
			n=n+100000;
		}
	}
	
	public void TestTreeSet(ArrayList<Points> points)
	{
		TreeSet<Integer> treeSet=new TreeSet<Integer>();
		//记录查询时间点
		double[] averTimeY=new double[10];
		int[] averTimeX=new int[10];
		
		//改变TreeSet的数据量
		int n=100000;
		//记录查找100次总时长
		double total=0;
		
		
		for(int average=0;average<10;average++)
		{
			//向TreeSet加入数据
			for(int i=0;i<n;i++)
				treeSet.add(i);
			
			//将treeSet载入迭代器
			Iterator<Integer> iter=treeSet.iterator();
			
			//100次查找
			for(int m=0;m<100;m++)
			{
				//生成随即查找数
				Random rand=new Random();
				int goal=rand.nextInt();
				int start=(int)System.currentTimeMillis();
				//遍历查找
				while(iter.hasNext())
					if(iter.next()==goal)
						break;
				int end=(int)System.currentTimeMillis();
				//取得100次查找的总时间
				total=total+end-start;
			}
			//取得100次查找的averageTime
			averTimeY[average]=total/100.0;
			averTimeX[average]=n;
			points.add(new Points(averTimeX[average],averTimeY[average]));
			n=n+100000;
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Points> points=new ArrayList<Points>();
		TestList tl=new TestList();
		
		//测试LinkedList
		//tl.TestLinkedList(points);

		//测试ArrayList
		//tl.TestArrayList(points);
		
		//测试HashMap
		//tl.TestHashMap(points);
		
		//测试HashSet
		//tl.TestHashSet(points); //需要调大n值
		
		//测试TreeMap
		//tl.TestTreeMap(points);
		
		//测试TreeSet
		//tl.TestTreeSet(points);
		
		System.out.println("Exit!");
	}

}
