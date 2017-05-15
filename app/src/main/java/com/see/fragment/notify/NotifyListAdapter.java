package com.see.fragment.notify;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.see.bean.NotifyBean;
import com.see.examsystemteacher.R;

import java.util.List;

/**
 * Created by see on 2016/11/25.
 */
public class NotifyListAdapter extends BaseAdapter {

    private List<NotifyBean> list;
    private Context context;
    private LayoutInflater lnflater;

    public NotifyListAdapter(Context context, List<NotifyBean> list) {
        this.list = list;
        this.context = context;
        lnflater = LayoutInflater.from(context);
    }

    public void setRefrashData(List<NotifyBean> tempList){
        tempList.addAll(list);
        list = tempList;

    }

    public void setLoadMoreData(List<NotifyBean> tempList){

        list.addAll(tempList);
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

        NotifyViewHolder notifyViewHolder = null;
        if (convertView == null) {

            convertView = lnflater.inflate(R.layout.notify_listview_item, parent, false);
            notifyViewHolder = new NotifyViewHolder(convertView);
            convertView.setTag(notifyViewHolder);
        } else {

            notifyViewHolder = (NotifyViewHolder) convertView.getTag();
        }

        notifyViewHolder.text.setText(list.get(position).getTitle());
        notifyViewHolder.author.setText(list.get(position).getAuthor());
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//        String str = formatter.format(curDate);
        notifyViewHolder.time.setText(list.get(position).getTime());
        return convertView;
    }


    public class NotifyViewHolder {
        private TextView text;
        private TextView author;
        private TextView time;

        public NotifyViewHolder(View itemView) {
            text = (TextView) itemView.findViewById(R.id.notify_lv_item_tv);
            author = (TextView) itemView.findViewById(R.id.notify_lv_item_author);
            time = (TextView) itemView.findViewById(R.id.notify_lv_item_time);
        }
    }
}
