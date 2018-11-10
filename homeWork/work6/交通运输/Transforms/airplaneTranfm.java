package Transforms;

public class airplaneTranfm extends BaseTranfm
{
	
	public airplaneTranfm() throws Exception
	{
		this.everyMoney=0.75;
		
		if(distance<=0)
		{
			if(distance<=0)
			{
				Exception ex=new Exception("Exception:距离输入错误");
				throw ex;
			}
		}
		
		price=distance*everyMoney;
	}
	
	@Override
	String countTimePrice()
	{
		
		return "( 飞机从"+fromPlace+"到"+toPlace+"全程"+distance+"公里共需";
	}

}
