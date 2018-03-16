package sorket_three;

/**
 * Created by liuqi on 2017/11/21.
 */

public class Msg_three {
    public static int RECEIVED = 0; //收到的消息
    public static  int SENT = 1;    //发送的消息
    public static int RECEIVEDS = 2; //收到的图片
    public static  int SENTS = 3;    //发送的图片
    public static  int DATA = 4;    //时间
    private String content;
    private  int type;

    public void setContent(String content) {
        this.content = content;
    }

    public Msg_three(String content, int type)
    {
        this.content = content; //消息内容
        this.type = type;  //消息类型
    }
    public String getContent()
    {
        return content;
    }
    public int getType()
    {
        return  type;
    }
}
