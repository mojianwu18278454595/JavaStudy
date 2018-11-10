package fs.foreignshopping.Login;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.mob.MobSDK;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import fs.foreignshopping.R;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EventHandler eventHandler;
    private String userPwd;
    private Button rgsr_getVerify;
    private Button rgsr_submit;
    private ImageButton rgsr_back;

    private  EditText rgsr_userName;
    private EditText rgsr_phone;
    private EditText rgsr_inputVerify;
    private String AppKey = "2854552b5a0b4";
    private String APPSECRET = "6c0e5f42b08954c534fea990cf7f0dff";
    public String phone;
    private String verifyText;
    private String userName;
    private boolean statusSubmit;
    final int ANSWER=103;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //设置标题
        TextView title=(TextView)findViewById(R.id.textView_rgsrTitle);
        title.setText("注册");

        //第三方登录
        ImageButton imbtn_loginQQ=(ImageButton)findViewById(R.id.imbtn_loginQQ);
        imbtn_loginQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"该功能还待完善",Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton imbtn_loginWchat=(ImageButton)findViewById(R.id.imbtn_loginWchat);
        imbtn_loginWchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"该功能还待完善",Toast.LENGTH_SHORT).show();
            }
        });

        //smssdk初始化
        init();
        MobSDK.init(this);

        // 在尝试读取通信录时以弹窗提示用户（可选功能）
        SMSSDK.setAskPermisionOnReadContact(true);

        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // afterEvent会在子线程被调用，因此如果后续有UI相关操作，需要将数据发送到UI线程
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                new Handler(Looper.getMainLooper(), new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        int event = msg.arg1;
                        int result = msg.arg2;
                        Object data = msg.obj;
                        if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                            if (result == SMSSDK.RESULT_COMPLETE) {
                                // TODO 处理成功得到验证码的结果
                                // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                                Toast.makeText(getApplicationContext(), "验证码已经发送",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                // TODO 处理错误的结果
                                Toast.makeText(getApplicationContext(), "申请验证码失败",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                            if (result == SMSSDK.RESULT_COMPLETE) {
                                // TODO 处理验证码验证通过的结果
                                Toast.makeText(getApplicationContext(), "提交验证码成功",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                // TODO 处理错误的结果
                                Toast.makeText(getApplicationContext(), "验证码输入失败",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        // TODO 其他接口的返回结果也类似，根据event判断当前数据属于哪个接口
                        return false;
                    }
                }).sendMessage(msg);
            }
        };

        //注册回调接口
        SMSSDK.registerEventHandler(eventHandler);

    }

    private void init() {
        rgsr_getVerify = (Button) findViewById(R.id.button_rgsrVerify);
        rgsr_submit= (Button) findViewById(R.id.button_rgsrSubmit);
        rgsr_back=(ImageButton)findViewById(R.id.imbtn_rgtrBack);

        rgsr_userName=(EditText)findViewById(R.id.editText_rgsrUser);
        rgsr_phone = (EditText) findViewById(R.id.editText_rgsrPhone);
        rgsr_inputVerify = (EditText) findViewById(R.id.editText_rgsrVerify);

        rgsr_getVerify.setOnClickListener(this);
        rgsr_submit.setOnClickListener(this);
        rgsr_back.setOnClickListener(this);

        statusSubmit=false;
        userPwd=new String();
    }

    //按钮响应
    @Override
    public void onClick(View v) {

        userName=rgsr_userName.getText().toString().trim();
        phone=rgsr_phone.getText().toString().trim();
        switch (v.getId()) {
            case R.id.button_rgsrVerify: // 获取验证码的过程.
                if (!TextUtils.isEmpty(phone)&& phone.length()==11)
                {
                    SMSSDK.getVerificationCode("86", rgsr_phone.getText().toString());
                    phone = rgsr_phone.getText().toString();
                }
                else
                {
                    if(TextUtils.isEmpty(rgsr_phone.getText().toString().trim()))
                    Toast.makeText(RegisterActivity.this, "手机号不能为空", Toast.LENGTH_LONG)
                            .show();
                    else
                        Toast.makeText(RegisterActivity.this, "手机号格式错误", Toast.LENGTH_LONG)
                                .show();
                }
                break;
            case R.id.button_rgsrSubmit:
                if(userName.trim().length()>0) {
                    //提交验证码
                    SMSSDK.submitVerificationCode("86", phone, rgsr_inputVerify.getText()
                            .toString());
                    statusSubmit=true;
                    if(statusSubmit)
                    {
                        Intent intent2=new Intent(RegisterActivity.this,SettingPwdActivity.class);
                        startActivityForResult(intent2,ANSWER);
                    }
                }
                else
                    Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_LONG)
                            .show();
                break;
            case R.id.imbtn_rgtrBack:
                onBackPressed(); // 调用父类的onBackPressed()
                break;
        }
    }


       @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // 是否 REQ_GET_INPUT 的返回
        if (requestCode == ANSWER&&resultCode == RESULT_OK)
        {
            // 从intent中取出数据
            userPwd = data.getStringExtra("userPwd");

            if(data.getStringExtra("status").trim().equals("true"))
            {
                //注册页面销毁前返回数据给上一页
                Intent intent= new Intent();
                intent.putExtra("userID",phone);
                intent.putExtra("userName",userName);
                intent.putExtra("userPwd",userPwd);
                intent.putExtra("status","true");
                setResult(110,intent);

                finish();
            }
        }
    }



    @Override
    protected void onDestroy() {

        Log.e("测试",userName+phone+userPwd);
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
