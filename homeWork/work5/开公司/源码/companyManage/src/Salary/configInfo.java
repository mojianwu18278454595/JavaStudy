package Salary;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.dom4j.*;
import org.dom4j.io.SAXReader;


public class configInfo
{
	public  int[] configXML() throws Exception
	{
		// 解析 sample.xml
		FileInputStream inputStream = new FileInputStream("numberInfo.xml");
		SAXReader xmlReader = new SAXReader();
				
		Document x_doc = xmlReader.read(inputStream);
		Element x_root = x_doc.getRootElement();
		inputStream.close();	
				
		// 直接获取 classId元素的文本值
		String eNumber = x_root.elementText("employeeNumber");
		String mNumber = x_root.elementText("managerNumber");
		String sNumber=x_root.elementText("shareholderNumber");
		int[] number= {Integer.valueOf(eNumber.trim()),Integer.valueOf(mNumber.trim()),Integer.valueOf(sNumber.trim())};
		
		return number;
	}
	
	//创建连接
	public Connection mysqlConn() throws Exception
	{
		// 注册MySQL驱动 (可以省略这一步)
		Class.forName("com.mysql.jdbc.Driver");

		// 连接MySQL服务器
		String username= "root";
		String password = "123456";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/companyInfo?useUnicode=true&characterEncoding=UTF-8";
				
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("数据库连接成功!");
		
		return conn;
	}
	
	//执行SQL语句
	public void executeQuiryEpy(Connection conn,String tableName,
			BaseInfo bInfo,int month) throws Exception
	{
		// 1 构造一个SQL, 参数值用?号代替，称为占位符
		String sql=new String();
		if(tableName.equals("Employee"))
			sql = "INSERT INTO "+tableName+"(month,name,salary,birthday,gift) VALUES (?,?, ?, ?, ?) ";
		if(tableName.equals("Manager"))
			sql="INSERT INTO "+tableName+"(month,name,salary,birthday,bonus,gift) VALUES (?,?, ?, ?, ?, ?) ";
		if(tableName.equals("Shareholder"))
			sql="INSERT INTO "+tableName+"(month,name,salary,birthday,share,pip,sumProfit) VALUES (?,?, ?, ?,?,?,?) ";
		
		// 2 创建 PreparedStatement 对象 ( 与MySQL产生一次交互 )
		PreparedStatement ptmt = conn.prepareStatement(sql);	
				
		// 3 设置参数值
		if(tableName.equals("Employee"))
		{
			Employee epy=(Employee)bInfo;
			ptmt.setInt(1, month);
			ptmt.setString(2, epy.name);
			ptmt.setDouble(3, epy.salary);
			ptmt.setString(4, epy.birthday);
			ptmt.setBoolean(5, epy.getGift(month)==1);
		}
			
		if(tableName.equals("Manager"))
		{
			Manager mng=(Manager)bInfo;
			ptmt.setInt(1, month);
			ptmt.setString(2, mng.name);
			ptmt.setDouble(3, mng.salary);
			ptmt.setString(4, mng.birthday);
			ptmt.setDouble(5, mng.bonus);
			ptmt.setBoolean(6, mng.getGift(month)==2);
		}	
		if(tableName.equals("Shareholder"))
		{
			Shareholder srhd=(Shareholder)bInfo;
			ptmt.setInt(1, month);
			ptmt.setString(2, srhd.name);
			ptmt.setDouble(3, srhd.salary);
			ptmt.setString(4, srhd.birthday);
			ptmt.setDouble(5, srhd.share);
			ptmt.setDouble(6, srhd.pip);
			ptmt.setDouble(7, Shareholder.sumProfit);
		}
				
		// 4 执行查询
		ptmt.execute();		
	}
	
	//关闭连接
	public void closeConn(Connection conn) throws SQLException
	{
		conn.close();
		System.out.println("数据库连接关闭！");
	}
	
	//测试
//	public static void main(String[] args) throws Exception
//	{
//		configInfo conf=new configInfo();
//		int[] a=conf.configXML();
//		for(int i=0;i<a.length;i++)
//			System.out.println(a[i]);
//	}
	
}
