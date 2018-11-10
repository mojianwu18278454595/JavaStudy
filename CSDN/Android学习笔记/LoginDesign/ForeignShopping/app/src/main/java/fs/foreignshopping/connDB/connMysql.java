package fs.foreignshopping.connDB;

import android.util.Log;
import android.widget.Toast;

import com.mysql.jdbc.*;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sc on 2018/10/19.
 */

public class connMysql
{
    Connection conn;
    public connMysql() throws Exception
    {
        // 注册MySQL驱动 (可以省略这一步)
        Class.forName("com.mysql.jdbc.Driver");

        // 连接MySQL服务器
        String username= "root";
        String password = "123456";
        String connectionUrl = "jdbc:mysql://10.157.186.97:3306/db_goodsInfo?useUnicode=true&characterEncoding=UTF-8";

        //建立连接
        conn = (Connection) DriverManager.getConnection(connectionUrl, username, password);
        if(conn!=null)
            Log.w("测试","conn success");
        Log.w("测试","conn faile");
    }

    public boolean executeQuiry(String sql,int table,String pwd) throws  Exception
    {
        // 数据库查询, Statement语句  ResultSet结果集
        Statement stmt = (Statement) conn.createStatement();


        //如果有数据，rs.next()返回true
        if(table==1)  //执行select
        {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                // 取出这一行记录
                int userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String userPwd = rs.getString("userPwd");
                String userPhone = rs.getString("userPhone");

                if(userPwd==pwd)
                    return true;
                rs.close();
            }
        }

        if(table==2)  //执行insert
        {
            stmt.execute(sql);

            return true;
        }

        stmt.close();
        return false;
    }

    public void closConn() throws Exception
    {
        conn.close();
        Log.w("测试","关闭成功");
    }

//    public static void main(String[] args)
//    {
//        String sql="SELECT *FROM tb_user WHERE userId='13277351070'";
//        try {
//            connMysql mysql=new connMysql();
//            mysql.executeQuiry(sql,1,"sc1997");
//            mysql.closConn();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
