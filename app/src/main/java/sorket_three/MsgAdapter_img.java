package sorket_three;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liuqi.project_three.R;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by liuqi on 2017/11/21.
 */

public class MsgAdapter_img extends ArrayAdapter<Msg_three> {
    int resourced;
    public MsgAdapter_img(Context context, int textViewResourced, List<Msg_three> objects)
    {
        super(context,textViewResourced,objects);
        resourced = textViewResourced;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg_three msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null)
        {
            view = LayoutInflater.from(getContext()).inflate(resourced,null);
            viewHolder = new ViewHolder();
            viewHolder.liftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout)view.findViewById(R.id.right_layout);
            viewHolder.liftLayoutS = (LinearLayout)view.findViewById(R.id.left_layoutS);
            viewHolder.rightLayoutS = (LinearLayout)view.findViewById(R.id.right_layoutS);
            viewHolder.dataLayout = (LinearLayout)view.findViewById(R.id.datalayout);
            viewHolder.leftMsg = (TextView)view.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView)view.findViewById(R.id.right_msg);
            viewHolder.leftMsgs = (ImageView) view.findViewById(R.id.left_msgs);
            viewHolder.rightMsgs = (ImageView) view.findViewById(R.id.right_msgs);
            viewHolder.leftname = (TextView)view.findViewById(R.id.left_name);
            viewHolder.rightname = (TextView)view.findViewById(R.id.right_name);
            viewHolder.leftnames = (TextView)view.findViewById(R.id.left_names);
            viewHolder.rightnames = (TextView)view.findViewById(R.id.right_names);

            viewHolder.dataMsg = (TextView)view.findViewById(R.id.beforedata);
            view.setTag(viewHolder);
        } else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        if(msg.getType() == Msg_three.RECEIVED)
        {
            viewHolder.liftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.liftLayoutS.setVisibility(View.GONE);
            viewHolder.rightLayoutS.setVisibility(View.GONE);
            viewHolder.dataLayout.setVisibility(View.GONE);
            String [] arr = msg.getContent().split("Γ");
            arr[0] = arr[0].replaceAll(">@","" );
            viewHolder.leftname.setText(arr[0]);
            viewHolder.leftMsg.setText(arr[1]);
        }
        else if(msg.getType() == Msg_three.SENT)
        {
            viewHolder.liftLayout.setVisibility(View.GONE);
            viewHolder.liftLayoutS.setVisibility(View.GONE);
            viewHolder.rightLayoutS.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.dataLayout.setVisibility(View.GONE);
            String [] arr = msg.getContent().split("Γ");
            System.out.println(arr[0]+"sx");
            arr[0] = arr[0].replaceAll(">@","" );
            viewHolder.rightname.setText(arr[0]);
            viewHolder.rightMsg.setText(arr[1]);

        }
        else if(msg.getType() == Msg_three.SENTS)
        {
            viewHolder.liftLayoutS.setVisibility(View.GONE);
            viewHolder.liftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.rightLayoutS.setVisibility(View.VISIBLE);
            viewHolder.dataLayout.setVisibility(View.GONE);
            String [] arr = msg.getContent().split("Γ");
            System.out.println(arr[0]+"ss");
            String sy=arr[1];
            Bitmap bit=onDecodeClicked(sy);
            arr[0] = arr[0].replaceAll(">@","" );
            viewHolder.rightnames.setText(arr[0]);
            if(bit!=null) {
                viewHolder.rightMsgs.setImageBitmap(bit);
            }
        }
        else if(msg.getType() == Msg_three.RECEIVEDS)
        {
            viewHolder.liftLayoutS.setVisibility(View.VISIBLE);
            viewHolder.liftLayout.setVisibility(View.GONE);
            viewHolder.rightLayoutS.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.dataLayout.setVisibility(View.GONE);
            String [] arr = msg.getContent().split("Γ");
            arr[0] = arr[0].replaceAll(">@","" );
            Bitmap bit=onDecodeClicked(arr[1]);
            viewHolder.leftnames.setText(arr[0]);
            if(bit!=null) {
                viewHolder.leftMsgs.setImageBitmap(bit);
            }
        }else if(msg.getType() == Msg_three.DATA)
        {
            viewHolder.liftLayoutS.setVisibility(View.GONE);
            viewHolder.liftLayout.setVisibility(View.GONE);
            viewHolder.rightLayoutS.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.dataLayout.setVisibility(View.VISIBLE);

                viewHolder.dataMsg.setText(msg.getContent());

        }
        return view;
    }
    class  ViewHolder{
        LinearLayout liftLayout;
        LinearLayout rightLayout;
        LinearLayout liftLayoutS;
        LinearLayout rightLayoutS;
        LinearLayout dataLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView leftMsgs;
        ImageView rightMsgs;
        TextView leftname;
        TextView rightname;
        TextView leftnames;
        TextView rightnames;
        TextView dataMsg;
    }
    public Bitmap onDecodeClicked(String img) {
        byte[] decode = Base64.decode(img,Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        //save to image on sdcard
       // String str=saveBitmap(bitmap);
        if(bitmap!=null){
            return bitmap;
        }
        return null;
    }

    private String saveBitmap(Bitmap bitmap) {
        try {
            String path = Environment.getExternalStorageDirectory().getPath()
                    +"/decodeImage.jpg";

            OutputStream stream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
            stream.close();
            Log.e("linc","jpg okay!");
            return path;

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("linc","failed: "+e.getMessage());
        }
        return  null;
    }
}
