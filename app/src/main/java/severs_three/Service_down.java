package severs_three;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.example.liuqi.project_three.Three_login;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import sorket_three.DownUtil;

/**
 * Created by liuqi on 2017/12/15.
 */

public class Service_down extends Service {
    @Nullable
    public static final String TAG = "MyService";
    //更新文件储存路径
    String target=createSDCardDir();
    //下载工具类
    DownUtil downUtil;
    Context context;
    private Handler mHandler;//登入界面住线程
    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        onClick();
        Log.d(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class MyBinder extends Binder {

        public void startDownload(Context contexts,Handler handler ) {
            context=contexts;
            mHandler=handler;
            System.out.println("fufufufufufuwuwuuwuwuwuwuw");
            Log.d("TAG", "startDownload() executed");
            // 执行具体的下载任务
        }

    }
    //删除文件
    public void delFile(){
        String fileName = createSDCardDir();
        File file = new File(fileName);
        Boolean tue=file.isFile();
        if(tue){
            file.delete();
        }
        Boolean tu=file.exists();
        Log.e("TAG",tu+""+tue);

    }
    //文件储存路径
    public String createSDCardDir() {
        String path;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            // 创建一个文件夹对象，赋值为外部存储器的目录
            File sdcardDir =Environment.getExternalStorageDirectory();
            //得到一个路径，内容是sdcard的文件夹路径和名字
            path=sdcardDir.getPath()+"/cardthree";
            File path1 = new File(path);
            if (!path1.exists()) {
                //若不存在，创建目录，可以在应用启动的时候创建
                path1.mkdirs();
               // setTitle("paht ok,path:"+path);
            }
        }
        else{
           // setTitle("false");
            return "";

        }
        return  path+"/three.apk";

    }
    public void onClick() {
        delFile();
        String url = "http://120.77.39.76:8080/three.apk";

        // 初始化DownUtil对象（最后一个参数指定线程数）
        // 创建一个Handler对象
        if(!target.equals(false)) {
            downUtil = new DownUtil(url, target, 6);
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 开始下载
                        downUtil.download();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            final Timer timer = new Timer();
            TimerTask tasks;
            final Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    Log.i("SIZs",downUtil.getCompleteRate()+"");
                    System.out.println(downUtil.getCompleteRate()+"");
                    Message  msgss= new Message();
                    msgss.what=1;
                    msgss.arg1=(int)downUtil.getCompleteRate();
                    mHandler.sendMessage(msgss);
                    if (downUtil.getCompleteRate() == 100) {
                       installApk(context, new File(target));
                        timer.cancel();
                    }
                    super.handleMessage(msg);
                }
            };
            tasks = new TimerTask() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                }
            };
            timer.schedule(tasks, 2000, 2000);
        }
    }
    //文件路径的访问申请
    public static void installApk(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data;
        // 判断版本大于等于7.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // "net.csdn.blog.ruancoder.fileprovider"即是在清单文件中配置的authorities
            data = FileProvider.getUriForFile(context, "com.example.liuqi.project_three.fileprovider", file);
            // 给目标应用一个临时授权
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            data = Uri.fromFile(file);
        }
        intent.setDataAndType(data, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

}
