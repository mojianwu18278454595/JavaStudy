package Car;

public class BaseCar
{
	String name;
	float tank;
	float oilConsumption;
	
	public BaseCar(String Name,float Tank,float OilConsumption)
	{
		this.name=Name;
		this.tank=Tank;
		this.oilConsumption=OilConsumption;
	}
	
	public void Gas(float number)
	{
		this.tank=this.tank+number;
	}
	
	public float Run()
	{
		if(tank<=0)
		{
			System.out.println("当前汽车不能行驶！");
			return 0;
		}
		System.out.println("当前汽车能行驶时长为："+tank/oilConsumption);
		return tank/oilConsumption;
	}
	
	public void print()
	{
		System.out.println("**************BaseCar Information****************");
		System.out.println("( name:"+name+",tank:"+tank+",oilConsumption:"+oilConsumption+" )");
		Run();
		System.out.println();
	}

}
