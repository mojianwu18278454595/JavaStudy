package Transforms;

public class trainTranfm extends BaseTranfm
{

	public trainTranfm() throws Exception
	{
		this.everyMoney=0.45;
		
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
		
		return "( 高铁从"+fromPlace+"到"+toPlace+"全程"+distance+"公里共需";
	}

}
