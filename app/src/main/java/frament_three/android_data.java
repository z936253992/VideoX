package frament_three;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuqi.project_three.R;
import com.example.liuqi.project_three.Three_web_cent;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import http_web.data_web;
import http_web.magess_web;
import sorket_three.Msg_three;
import sorket_three.cent_data_three;
import sorket_three.datarsAdapter;
import sorket_three.titleAdapter;

/**
 * Created by liuqi on 2017/12/20.
 */

public class android_data extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener{
    View android_data;
    ListView data_stryes,lsvMore;

    private String []arr;//数据组
    private List<String> datas = new ArrayList<String>();
    private List<cent_data_three> title_data= new ArrayList<cent_data_three>();
    private cent_data_three datas_web;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android_data = inflater.inflate(R.layout.pager_frament, container, false);
        New();
        data();
        //添加基本布局
        data_stryes.setAdapter(new datarsAdapter(android_data.getContext(),R.layout.dataes_android, datas));
        data_stryes.setOnItemClickListener(this);
        return android_data ;
    }
    //实例化控件
    public void New(){
        data_stryes=(ListView)android_data.findViewById(R.id.data_stryes);
    }
    //添加data适配器数据
    private void data(){
        if(datas.size()==0) {
            datas.add("Textview");
            datas.add("Button");
            datas.add("SharePrefences");
            datas.add("Mysql");
            datas.add("Socket");
            datas.add("Bitmap");
            datas.add("String");
        }
    }
    //添加title适配器数据
    public void Title_data(final int i){
        title_data.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                arr = data_web.executeHttpGet(i);
                if(arr!=null&&arr.length>0) {
                    for (int se = 1; se < arr.length; se += 3) {
                        cent_data_three users = new cent_data_three(Integer.parseInt(arr[se]), arr[se + 1] , arr[se + 2]);
                        title_data.add(users);
                    }
                }

            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        popwind();
    }
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        switch (arg0.getId()){
            case R.id.data_stryes:
                Title_data(arg2);
                break;
            case R.id.list_cent:
                datas_web=title_data.get(arg2);//得到url
                if(datas_web!=null) {
                    runweb(datas_web.getData_url());
                }
                break;
            default:
                break;
        }
    }
    //构建一个popupwindow
    public void popwind(){
                        // TODO: 2016/5/17 构建一个popupwindow的布局
                View popupView = LayoutInflater.from(android_data.getContext()).inflate(R.layout.popupwindow_cent, null);
                // TODO: 2016/5/17 为了演示效果，简单的设置了一些数据，实际中大家自己设置数据即可，相信大家都会。
                 lsvMore = (ListView) popupView.findViewById(R.id.list_cent);
                lsvMore.setAdapter(new titleAdapter(android_data.getContext(), R.layout.dataes_title, title_data));
                lsvMore.setOnItemClickListener(this);
                // TODO: 2016/5/17 创建PopupWindow对象，指定宽度和高度
                PopupWindow window = new PopupWindow(popupView,android_data.getWidth()-data_stryes.getWidth(),android_data.getHeight());
                // TODO: 2016/5/17 设置动画
                window.setAnimationStyle(R.style.popup_window_anim);
                // TODO: 2016/5/17 设置背景颜色
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#de9b8181")));
                // TODO: 2016/5/17 设置可以获取焦点
              //  window.setFocusable(true);
                // TODO: 2016/5/17 设置可以触摸弹出框以外的区域
                window.setOutsideTouchable(true);
                // TODO：更新popupwindow的状态
                window.update();
                 // TODO: 2016/5/17 以下拉的方式显示，并且可以设置显示的位置
                window.showAsDropDown(data_stryes,data_stryes.getWidth(), 0);
    }
    //转跳webview具体数据
    public void runweb(String url){
        Intent ite=new Intent();
        ite.setClass(android_data.getContext(), Three_web_cent.class);
        ite.putExtra("data_url", url);
        startActivity(ite);
    }
}
