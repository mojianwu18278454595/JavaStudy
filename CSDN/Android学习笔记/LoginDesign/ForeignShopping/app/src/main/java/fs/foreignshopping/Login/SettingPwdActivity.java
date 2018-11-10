package fs.foreignshopping.Login;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import fs.foreignshopping.R;

public class SettingPwdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_pwd);

        final EditText pwd=(EditText)findViewById(R.id.editText_rgsrPwd);
        final EditText pwdAgain=(EditText)findViewById(R.id.editText_rgsrPwdAgain);

        //标题布局
        TextView title=(TextView)findViewById(R.id.textView_rgsrTitle);
        title.setText("设置密码");

        //确定按钮设置
        Button btnOk=(Button)findViewById(R.id.button_rgsrPwdSubmit);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pwd.getText().toString().equals(pwdAgain.getText().toString())&&
                        !pwd.getText().toString().isEmpty())
                {
                    Toast.makeText(SettingPwdActivity.this, "密码设置成功", Toast.LENGTH_SHORT)
                            .show();
                    //页面数据交互
                    Intent intent=new Intent();
                    intent.putExtra("userPwd",pwd.getText().toString().trim());
                    intent.putExtra("status","true");
                    setResult(RESULT_OK,intent);

                    Log.e("测试",pwd.getText().toString().trim());
                    finish();  //关闭当前页面
                }
                else
                {
                    if(pwd.getText().toString().trim().isEmpty()
                            ||pwdAgain.getText().toString().trim().isEmpty())
                        Toast.makeText(SettingPwdActivity.this, "密码不能为空", Toast.LENGTH_LONG)
                                .show();
                    else
                        Toast.makeText(SettingPwdActivity.this, "输入密码不一致", Toast.LENGTH_LONG)
                                .show();
                }

            }
        });
    }
}
