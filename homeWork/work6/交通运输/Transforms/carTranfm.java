package Transforms;

public class carTranfm extends BaseTranfm
{
	public carTranfm() throws Exception
	{
		this.everyMoney=0.32;
		if(distance<=0)
		{
			Exception ex=new Exception("Exception:距离输入错误");
			throw ex;
		}
		price=distance*everyMoney;	
	}

	@Override
	String countTimePrice()
	{	
		return "( 汽车从"+fromPlace+"到"+toPlace+"全程"+distance+"公里共需";
	}

}
