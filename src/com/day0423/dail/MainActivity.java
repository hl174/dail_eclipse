package com.day0423.dail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
   private EditText ed_number;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局文件
		setContentView(R.layout.activity_main);
		//查找按钮
		 Button bt_dail=(Button)this.findViewById(R.id.button1);
	     //查找文本框
		 ed_number=(EditText) MainActivity.this.findViewById(R.id.et_number);
		 
		 //给按钮注册点击事件//1,创建一个内部类，定义点击事件
		/* bt_dail.setOnClickListener(new Mylistener());*/
		 //2,创建一个匿名内部类的方式
		/* bt_dail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callphone();
				
			}
		});*/
		/* 3,让activity实现点击事件的接口（用的最多常见的情况）
		 * bt_dail.setOnClickListener(this);*/
	}
	
	//4,在布局文件里面绑定一个点击的方法
	public void dailButtonClicked(View view){
		callphone();
	}
	
	private void callphone() {
		String number=ed_number.getText().toString().trim();
		  if(TextUtils.isEmpty(number)){
			 Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT).show();
			  return ;
		  }
		  
		  Intent intent=new Intent();
		  intent.setAction(Intent.ACTION_CALL);
		  //uri类型
		  intent.setData(Uri.parse("tel:"+number));
		  startActivity(intent);
	}
	private class Mylistener implements OnClickListener{

		/*
		 *按钮被点击的时候调用的方法
		 */
		@Override
		public void onClick(View v) {
		 
		  callphone();
		}
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 callphone();
	}

}
