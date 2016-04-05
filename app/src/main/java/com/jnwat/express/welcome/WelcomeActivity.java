package com.jnwat.express.welcome;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.jnwat.express.main.MainActivity;
import com.jnwat.express.R;
import com.jnwat.express.base.BaseActivity;
import com.jnwat.express.utils.Utils;
import com.lidroid.xutils.HttpUtils;

public class WelcomeActivity extends BaseActivity {
    private int DELAY_TIME_MILLISECOND = 1300;
    private String url = "";


    /**
     * 延迟操作
     */
    public void initSkip() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WelcomeActivity.this,
                        MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);// 跳转动画
                finish();
            }
        }, DELAY_TIME_MILLISECOND);

    }

    @Override
    protected void initView() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void setListener() {
        // TODO Auto-generated method stub
        //消息推送
        PushManager.startWork(WelcomeActivity.this, PushConstants.LOGIN_TYPE_API_KEY,
                Utils.getMetaValue(WelcomeActivity.this, "api_key"));      //开启   接收推送的服务
        System.out.println("启动推送");
    }

    @Override
    protected void initData() {
        // TODO Auto-generated method stub
        // APP版本升级
    }

    @Override
    protected void setView() {
        // TODO Auto-generated method stub
        setContentView(R.layout.activity_welcome);
        http = new HttpUtils();
        initSkip();
    }
    // 设置IP

    /**
     * handler处理消息机制
     */
    protected Handler uiHandler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 104:// APP下载更新
                    // 网络类型判断，询问是否使用流量下载,通知文件大小

			/*	Intent updateIntent = new Intent(WelcomeActivity.this,
                        UpdateAppService.class);

				startService(updateIntent);*/

                    break;
                case 110:
                    break;
            }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        WelcomeActivity.this.finish();
        return super.onKeyDown(keyCode, event);
    }

}
