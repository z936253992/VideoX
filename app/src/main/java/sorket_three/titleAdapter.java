package sorket_three;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.liuqi.project_three.R;

import java.util.List;

/**
 * Created by liuqi on 2017/12/20.
 */

public class titleAdapter extends ArrayAdapter<cent_data_three> {
    int resourced;
    public titleAdapter(Context context, int textViewResourced, List<cent_data_three> objects)
    {
        super(context,textViewResourced,objects);
        resourced = textViewResourced;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        cent_data_three msg = getItem(position);
        View view;
        titleAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourced, null);
            viewHolder = new titleAdapter.ViewHolder();
            viewHolder.titles = (TextView)view.findViewById(R.id.list_data_title);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (titleAdapter.ViewHolder) view.getTag();
        }
        viewHolder.titles.setText(msg.getData_title());
        return view;
    }
    class  ViewHolder{
        TextView titles;
    }

}
