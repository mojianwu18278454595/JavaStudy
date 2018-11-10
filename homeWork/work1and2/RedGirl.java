
//作业2

//唱歌谣的实现
package RedGirl;

public class Sing
{
	public static void main(String[] args)
	{
		int N=99;
		int min=0;
		for(;N>=min;N--)
		{
			if(N>2)
			{
				System.out.println(N+" bottles of beer on the wall,"+N+"bottles of beer");
				System.out.println("Take one down.");
				System.out.println("Pass it around.");
				System.out.println(N-1+" bottles of beer on the wall.");
				System.out.println();
			}
			
			else if(N==2)
			{
				System.out.println(N+" bottles of beer on the wall,"+N+"bottles of beer");
				System.out.println("Take one down.");
				System.out.println("Pass it around.");
				System.out.println(N-1+" bottle of beer on the wall.");
				System.out.println();
			}
			
			else
			{
				System.out.println(N+" bottle of beer on the wall,"+N+"bottles of beer");
				System.out.println("Take one down.");
				System.out.println("Pass it around.");
				System.out.println("NO more bottles of beer on the wall.");
				System.out.println();
			}
		}
	}
}

