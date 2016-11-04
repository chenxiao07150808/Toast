package cn.edu.gdmec.s07150808.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Toast的显示，要获取Ativity的上下文，才支持SHOW();
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v){
        Toast.makeText(this,"Taost直接输出的，纯天然，难度系数为1",Toast.LENGTH_SHORT).show();
    }
    public void click2(View v){
        //开启适配器.
        LayoutInflater lf=LayoutInflater.from(this);
        //新建UI界面,并加入到View中.
        View vroots=lf.inflate(R.layout.vroot,null);

        LinearLayout ll= (LinearLayout) vroots.findViewById(R.id.clayou);
        lf.inflate(R.layout.vroot,ll);
        //创建toast，然后把建立好的适配器加载到toast中
        Toast toast=new Toast(this);
        toast.setView(vroots);
        //toast的show实现显示，但注意的是：一定要获取上下文。例如Toast toast=new Toast(this);
        toast.show();
    }
public  void click3(View v){
    //直接的显示内容
    Toast toast=Toast.makeText(this,"我是小黄人-图文页面显示",Toast.LENGTH_LONG);
    //
    LinearLayout ll=new LinearLayout(this);
    ll.setOrientation(LinearLayout.VERTICAL);
    ImageView mImage=new ImageView(this);
    mImage.setImageResource(R.drawable.yellowman);
    View toastView=toast.getView();
    ll.addView(mImage);
    ll.addView(toastView);
    toast.setView(ll);
    toast.show();
}
}
