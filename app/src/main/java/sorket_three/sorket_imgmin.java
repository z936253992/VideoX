package sorket_three;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import usermage.UserManage;

/**
 * Created by liuqi on 2017/10/15.
 */

public class sorket_imgmin {
    // 线程池
    private ExecutorService mThreadPool;
    Socket socket;
    // 输入流对象
    InputStream is;
    // 输出流对象
    OutputStream outputStream;
    //输出流数据
    String str;
    //对输出流数据的分包
    String []se;
    // 输入流读取器对象
    InputStreamReader isr ;
    BufferedReader br ;
    long i_flag=0,sum=0;
    // 接收服务器发送过来的消息
    String response,img="";
    private Handler mHandler;
    int iss;//判断消息来源
    Context context;
    public sorket_imgmin(Handler handler){
        mThreadPool= Executors.newCachedThreadPool();
        mHandler=handler;


    }
    /**
     * 创建客户端 & 服务器的连接
     */
    public void sorket_connectiones(int i)  {
        iss=i;
        // 利用线程池直接开启一个线程 & 执行该线程
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                    try {
                        i_flag=0;
                        // 创建Socket对象 & 指定服务端的IP 及 端口号
                        if(socket!=null){
                            sorket_finash();
                        }
                        while (true) {
                            socket = new Socket("120.77.39.76", 52000);
                            socket.setReceiveBufferSize(10240*1024);
                            timers.schedule(task, 1000, 6000);
                            sum++;
                            if(socket.isConnected()|sum==5){
                                break;
                            }
                        }
                        sorket_send();
                        //从Socket 获得输出流对象OutputStream
                        // 该对象作用：发送数据
                        outputStream = socket.getOutputStream();
                        // 判断客户端和服务器是否连接成功
                        Log.d("xds",socket.isConnected()+"");
                        while (true){
                            if(i_flag==1){
                                break;
                            }
                            Thread.sleep(5000);
                        }
                    }  catch (UnknownHostException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("連接失敗，IP或者端口不可用");
                    }catch (SocketTimeoutException e) {
                        System.out.println("連接超時，服務器未開啟或IP錯誤");
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("連接失敗，12IP或者端口不可用");

                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        });

    }
    /**
     * 接收 服务器消息
     */
    public void sorket_send(){
        // 利用线程池直接开启一个线程 & 执行该线程
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // 步骤1：创建输入流对象InputStream
                    is = socket.getInputStream();

                    // 步骤2：创建输入流读取器对象 并传入输入流对象
                    // 该对象作用：获取服务器返回的数据
                    isr = new InputStreamReader(is);
                    br = new BufferedReader(isr);

                    // 步骤3：通过输入流读取器对象 接收服务器发送过来的数据

                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                if ((response=br.readLine()).equals(">@")) {
                                    img="";
                                    while ((response = br.readLine()) != null) {
                                        System.out.println(response);
                                        if (response.equals(">@#")) {
                                            runs();
                                            Log.d("ssss32", "kokokokokokokokoko");
                                        } else {
                                            img = img + '\n' + response;
                                        }
                                    }

                                }

                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public void runs(){
        Log.d("xjj",img);
        Message msg = new Message();
        msg.what = 0;
        if (img!=null) {
            img = img.replaceAll(">@#","" );

        }
        msg.obj = img;
        System.out.println(img);
        String[] arr = img.split("Γ");
        if (arr != null && arr[2].equals(iss+"")){
            msg.arg1 = Msg_three.SENTS;
        }else{
            msg.arg1 = Msg_three.RECEIVEDS;
        }
        img="";
        mHandler.sendMessage(msg);
    }
    Timer timers = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
                try {
                    if(outputStream!=null) {
                        outputStream.write(("hqcy" + "\n").getBytes("utf-8"));
                        outputStream.flush();
                        System.out.println("hqcy");
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    };
    /**
     * 发送消息 给 服务器
     */
    byte[] data;
    public void sorket_receive(String st,  Context context){
         str=st;
        this.context=context;
        se=str.split("\\\n");
        // 利用线程池直接开启一个线程 & 执行该线程
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    data=(str+"\n").getBytes("utf-8");
                    int start=0,s=0,n=str.length();
                    while((start+512)<n)
                    {
                        outputStream.write(data,start,512);

                        // 特别注意：数据的结尾加上换行符才可让服务器端的readline()停止阻塞
                        //+df.format(new Date()) + "\n"
                        // 步骤2：发送数据到服务端
                        outputStream.flush();
                        start=start+512;
                        s=s+512;
                        if(s>20000){
                            s=0;
                            Thread.sleep(5);
                        }

                    }
                    if(start<data.length)
                    {
                        outputStream.write(data, start,(data.length-start));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
    /**
     * 断开客户端 & 服务器的连接
     */
    public  void sorket_finash(){
        try {
            i_flag=1;
            // 断开 客户端发送到服务器 的连接，即关闭输出流对象OutputStream
            outputStream.close();
            timers.cancel();
            // 断开 服务器发送到客户端 的连接，即关闭输入流读取器对象BufferedReader
            br.close();

            // 最终关闭整个Socket连接
            socket.close();

            // 判断客户端和服务器是否已经断开连接
            System.out.println(socket.isConnected());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
