package fs.foreignshopping.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import fs.foreignshopping.R;
import fs.foreignshopping.connDB.connMysql;

public class LoginActivity extends AppCompatActivity {

    UserInfo user;
    connMysql connDB;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            ((TextView)findViewById(R.id.editText_loginPhone)).setText((String)message.obj);
            String str = "查询不存在";
            if(message.what == 1) str = "登录成功";
            Toast.makeText(LoginActivity.this, str, Toast.LENGTH_SHORT).show();
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //返回主界面
        ImageButton imbtn_back=(ImageButton)findViewById(R.id.imbtn_back);
        imbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //点击注册
        Button register=(Button)findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRgsr= new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intentRgsr,102);
            }
        });

        //点击忘记密码
        Button forgetPwd =(Button)findViewById(R.id.button_loginForgetPwd);
        forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"该功能还待完善",Toast.LENGTH_SHORT).show();
            }
        });

        //第三方登录
        ImageButton imbtn_loginQQ=(ImageButton)findViewById(R.id.imbtn_loginQQ);
        imbtn_loginQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"该功能还待完善",Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton imbtn_loginWchat=(ImageButton)findViewById(R.id.imbtn_loginWchat);
        imbtn_loginWchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"该功能还待完善",Toast.LENGTH_SHORT).show();
            }
        });

        // 从SharedPreferences配置里加载
        SharedPreferences sharedPref = getSharedPreferences("FSLogin",Context.MODE_PRIVATE);
        String username = sharedPref.getString("username", "");
        String password = sharedPref.getString("password", "");
        if(username.length() >0 && password.length() > 0)
        {
            // 自动填写用户名和密码
            ((EditText)findViewById(R.id.editText_loginPhone)).setText(username);
                //MD5解密
            ((EditText)findViewById(R.id.editText_loginPwd)).setText(MD5.convertMD5(password));
            // 延时N毫秒后自动登录
            autoLogin();
        }

    }

    //延时登录
    Handler msgHandler = new Handler();
    // 延时后自动登录
    private void autoLogin()
    {
        msgHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    loginMain(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // 是否 REQ_GET_INPUT 的返回
        if (requestCode == 102&&resultCode ==110)
        {
            // 从intent中取出数据
            user=new UserInfo(data.getStringExtra("userID"),
                     data.getStringExtra("userName"),data.getStringExtra("userPwd"));

            //加密存储到SharedPreferences
            String myPwd=MD5.convertMD5(user.userPwd);
                // 保存当前用户信息，以便下一次开机启动时加载(内存中)
            SharedPreferences sharedPref = getSharedPreferences("FSLogin",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", user.userID);
            editor.putString("password", myPwd);
            editor.commit();


            //传递数据
            Intent intentMain=new Intent();
            intentMain.putExtra("userID",user.userID);
            intentMain.putExtra("userName",user.userName);
            intentMain.putExtra("userPwd",user.userPwd);
            intentMain.putExtra("status","true");
            setResult(103,intentMain);

            finish(); // 关闭当前界面，销毁当前界面
        }

    }

    public class UserInfo
    {
        public String userID;
        public String userName;
        public String userPwd;


        public UserInfo( String userID,String userName,String userPwd)
        {
            this.userID=userID;
            this.userName=userName;
            this.userPwd=userPwd;
        }

        public UserInfo()
        {

        }

    }

    public void loginMain(View view) throws  Exception
    {
        //取数据
        EditText loginPhone=(EditText)findViewById(R.id.editText_loginPhone);
        EditText loginPwd=(EditText)findViewById(R.id.editText_loginPwd);
        final String phone=loginPhone.getText().toString().trim();
        final String pwd=loginPwd.getText().toString().trim();

        //当前登录成功账户添入SharedPreferences
//        user=new UserInfo();
//        user.userID=phone;
//        user.userPwd=pwd;
//        String myPwd=MD5.convertMD5(user.userPwd);
//        SharedPreferences sharedPref = getSharedPreferences("FSLogin",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("username", user.userID);
//        editor.putString("password", MD5.convertMD5(user.userPwd));
//        editor.commit();

        //传回mainActivity数据
        Intent intentEditText=new Intent();
        intentEditText.putExtra("loginPhone",phone);
        intentEditText.putExtra("loginPwd",pwd);
        setResult(104,intentEditText);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                boolean boolExecute=false;
//                //数据库检查登录
//                try {
//                    connDB= new connMysql();
//                    String sql="SELECT *FROM tb_user WHERE userId='"+phone+"'";
//                    boolExecute=connDB.executeQuiry(sql,1,pwd); //数据库查询
//                    connDB.closConn();
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//
//                Message msg = new Message();
//                if(!boolExecute) {
//                    msg.what = 0;
//                    msg.obj =  "查询结果，空空如也";
//                    Toast.makeText(LoginActivity.this,msg.obj.toString(),Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    msg.what = 1;
//                    msg.obj = phone;
//
//                    //传回mainActivity数据
//                    Intent intentEditText=new Intent();
//                    intentEditText.putExtra("loginPhone",phone);
//                    intentEditText.putExtra("loginPwd",pwd);
//                    setResult(104,intentEditText);
//                }
//                handler.sendMessage(msg);
//            }
//        }).start();


        finish(); //关闭当前界面
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.e("测试","Destory");


    }
}
