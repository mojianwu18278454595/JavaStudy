package Test1;

import java.lang.reflect.Field;

public class Test
{

	public static void main(String[] args) throws Exception
	{

	  //  方法1
//		Integer a=new Integer(12);
//		Integer b=a;
//		System.out.println("将a对象赋值给b对象后：");
//		System.out.println("a:"+a);
//		System.out.println("b:"+b);
//		System.out.println("a:"+a.hashCode());
//		
//		a=Integer.valueOf(56);
//		System.out.println("给b对象赋予新的值后：");
//		System.out.println("a:"+a);
//		System.out.println("b:"+b);
//		System.out.println("a:"+a.hashCode());
		
		//方法2
		Integer a1 = 200;
		Integer b1 = a1;
		System.out.println("将a对象赋值给b对象后：");
		System.out.println("a1=" + a1);
		System.out.println("b1=" + b1);
		
		
		Field field = null;
		field = a1.getClass().getDeclaredField("value");
		System.out.println("field："+field);
		field.setAccessible(true);
		field.set(a1, 5000);
		
		System.out.println("给a1对象赋予新的值后：");
		System.out.println("a1=" + a1);
		System.out.println("b1=" + b1);

	

 
	}

}
