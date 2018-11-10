package fs.foreignshopping;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import fs.foreignshopping.Login.LoginActivity;
import fs.foreignshopping.connDB.connMysql;

public class MainActivity extends AppCompatActivity {
    final int REQUESTMAIN=101;
    private User user;

    connMysql connMysqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显示设置
        TextView userName=(TextView)findViewById(R.id.textView_mainName);
        userName.setText("未登录");
        TextView mainGrade=(TextView)findViewById(R.id.textView_mainGrade);
        mainGrade.setText("无状态");

        //创建user
        user=new User();

        //点击登陆
        ImageButton imBtn_login=(ImageButton)findViewById(R.id.imBtn_login);
        imBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                startActivityForResult(intent,REQUESTMAIN);
            }
        });

        //点击setting
        ImageButton imBtn_mainSetting =(ImageButton)findViewById(R.id.imBtn_mainSetting);
        imBtn_mainSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注销当前账户
                SharedPreferences sharedPref = getSharedPreferences("FSLogin", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username", "");
                editor.putString("password", "");
                editor.commit();

                Toast.makeText(MainActivity.this,"当前账户已注销",Toast.LENGTH_SHORT).show();
            }
        });

        //连接数据库
        try {
            connMysqlDB=new connMysql();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class User
    {
        public String userID;
        public String userName;
        public String userPhone;
        public String userPwd;
        private boolean status=false;

        public User( String userID,String userName,String userPwd,boolean status)
        {
            this.userID=userID;
            this.userName=userName;
            this.userPwd=userPwd;
            this.status=status;
        }

        public User()
        {

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // 是否 REQ_GET_INPUT 的返回
        if (requestCode == REQUESTMAIN&&resultCode == 103)
        {
            // 从intent中取出数据
            user.userID= data.getStringExtra("userID");
            user.userName= data.getStringExtra("userName");
            user.userPwd= data.getStringExtra("userPwd");
            user.userPhone=data.getStringExtra("userID");
            user.status=Boolean.valueOf(data.getStringExtra("status"));
        }

        if (requestCode == REQUESTMAIN&&resultCode == 104)
        {
            // 从intent中取出数据
            user.userPwd= data.getStringExtra("loginPwd");
            user.userPhone=data.getStringExtra("loginPhone");
            TextView userName=(TextView)findViewById(R.id.textView_mainName);
            userName.setText(user.userPhone);
            TextView mainGrade=(TextView)findViewById(R.id.textView_mainGrade);
            mainGrade.setText(user.userPwd);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(user.status)
        {
            //设置登陆主界面
            TextView userName=(TextView)findViewById(R.id.textView_mainName);
            userName.setText(user.userName);
            TextView mainGrade=(TextView)findViewById(R.id.textView_mainGrade);
            mainGrade.setText(user.userPwd);
            Log.e("测试",user.userName+user.userID+user.userPwd+user.userPhone);
        }
    }
}
