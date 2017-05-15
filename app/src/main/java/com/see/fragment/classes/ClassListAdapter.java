package com.see.fragment.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.see.examsystemteacher.R;

import java.util.List;

/**
 * Created by see on 2017/4/9.
 */
public class ClassListAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private LayoutInflater lnflater;

    public ClassListAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
        lnflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClassViewHolder classViewHolder = null;
        if (convertView == null) {

            convertView = lnflater.inflate(R.layout.class_listview_item, parent, false);
            classViewHolder = new ClassViewHolder(convertView);
            convertView.setTag(classViewHolder);
        } else {

            classViewHolder = (ClassViewHolder) convertView.getTag();
        }

        classViewHolder.text.setText(list.get(position));

        return convertView;
    }

    public class ClassViewHolder {
        private TextView text;

        public ClassViewHolder(View itemView) {
            text = (TextView) itemView.findViewById(R.id.class_lv_item_tv);
        }
    }
}
