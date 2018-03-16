package sorket_three;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liuqi.project_three.R;

import java.util.List;

import frament_three.H5_data;
import frament_three.android_data;
import frament_three.javaEE_data;

/**
 * Created by liuqi on 2017/12/20.
 */

public class datarsAdapter extends ArrayAdapter<String> {
    int resourced;
    public datarsAdapter(Context context, int textViewResourced, List<String> objects)
    {
        super(context,textViewResourced,objects);
        resourced = textViewResourced;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String msg = getItem(position);
        View view;
        datarsAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourced, null);
            viewHolder = new datarsAdapter.ViewHolder();
            viewHolder.titles = (TextView)view.findViewById(R.id.list_data);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (datarsAdapter.ViewHolder) view.getTag();
        }
        viewHolder.titles.setText(msg);
        return view;
    }
    class  ViewHolder{
        TextView titles;
    }

}
