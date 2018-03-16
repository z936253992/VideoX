package sorket_three;

import android.util.Log;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/8/5 0005.
 */

public class DownUtil {
    /**下载资源的路径**/
    private String path;
    /**下载的文件的保存位置**/
    private String targetFile;
    /**需要使用多少线程下载资源**/
    private int threadNum;
    /**下载的线程对象**/
    private DownThread[] threads;
    /**下载的文件的总大小**/
    private int fileSize;
    int currentPartSize;
    int startPos;
    RandomAccessFile currentPart,file;

    public DownUtil(String path, String targetFile, int threadNum)
    {
        this.path = path;
        this.threadNum = threadNum;
        // 初始化threads数组
        threads = new DownThread[threadNum];
        this.targetFile = targetFile;

    }

    public void download() throws Exception
    {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty(
                "Accept",
                "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                        + "application/x-shockwave-flash, application/xaml+xml, "
                        + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                        + "application/x-ms-application, application/vnd.ms-excel, "
                        + "application/vnd.ms-powerpoint, application/msword, */*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");
        // 得到文件大小
        fileSize = conn.getContentLength();
        conn.disconnect();
        this.currentPartSize=(fileSize / threadNum )+ 1;
        file = new RandomAccessFile(targetFile, "rw");
        // 设置本地文件的大小
        file.setLength(fileSize);
        file.close();
        for (int i = 0; i < threadNum; i++)
        {
            // 计算每条线程的下载的开始位置
            startPos = i * currentPartSize;
            // 每个线程使用一个RandomAccessFile进行下载
            currentPart = new RandomAccessFile(targetFile, "rw");
            // 定位该线程的下载位置
            currentPart.seek(startPos);
            // 创建下载线程
            threads[i] = new DownThread(startPos,currentPartSize,currentPart);
            // 启动下载线程
            threads[i].start();
        }
    }

    // 获取下载的完成百分比
    public double getCompleteRate()
    {
        // 统计多条线程已经下载的总大小
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++)
        {
            sumSize += threads[i].length;
        }
        // 返回已经完成的百分比
        return (int)((sumSize * 1.0 / fileSize)*100);
    }

    private class DownThread extends Thread
    {
        /**当前线程的下载位置**/
        private int startPos;
        /**定义当前线程负责下载的文件大小**/
        private int currentPartSize;
        /**当前线程需要下载的文件块**/
        private RandomAccessFile currentPart;
        /**定义该线程已下载的字节数**/
        public int length;

        public DownThread(int startPos, int currentPartSize,
                          RandomAccessFile currentPart)
        {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
        }

        @Override
        public void run()
        {
            try
            {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection)url
                        .openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty(
                        "Accept",
                        "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                                + "application/x-shockwave-flash, application/xaml+xml, "
                                + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                                + "application/x-ms-application, application/vnd.ms-excel, "
                                + "application/vnd.ms-powerpoint, application/msword, */*");
                conn.setRequestProperty("Accept-Language", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                InputStream inStream = conn.getInputStream();
                // 跳过startPos个字节，表明该线程只下载自己负责哪部分文件。
                inStream.skip(this.startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                // 读取网络数据，并写入本地文件
                while (length < currentPartSize
                        && (hasRead = inStream.read(buffer)) > 0)
                {
                    currentPart.write(buffer, 0, hasRead);
                    // 累计该线程下载的总大小
                    length += hasRead;
                }
                Log.i("file","ok");
                currentPart.close();
                inStream.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
