package sorket_three;

/**
 * Created by liuqi on 2017/12/20.
 */

public class cent_data_three {
    private int Data_srtyex;
    private  String Data_url;

    public int getData_srtyex() {
        return Data_srtyex;
    }

    public void setData_srtyex(int data_srtyex) {
        Data_srtyex = data_srtyex;
    }

    private  String Data_title;

    public String getData_url() {
        return Data_url;
    }

    public void setData_url(String data_url) {
        Data_url = data_url;
    }

    public String getData_title() {
        return Data_title;
    }

    public void setData_title(String data_title) {
        Data_title = data_title;
    }
    public cent_data_three(int Data_srtyex,String Data_title,String Data_url){
        this.Data_srtyex=Data_srtyex;
        this.Data_title=Data_title;
        this.Data_url=Data_url;

    }
}
