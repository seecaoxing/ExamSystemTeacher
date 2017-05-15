package com.see.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.see.examsystemteacher.R;

/**
 * Created by see on 2017/4/9.
 */
public class NotifyBannerItenClickActivity extends Activity {
    private TextView notifybanneritemclick_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifybanneritemclick_layout);
        notifybanneritemclick_tv = (TextView) findViewById(R.id.notifybanneritemclick_tv);
        notifybanneritemclick_tv.setText("第十九届CUBA中国大学生篮球联赛西北赛区开幕式在西安邮电大学长安校区隆重举行。中国大学生体育协会专职副主席张燕军宣布比赛开幕，陕西省教育厅副厅长王海波、西安邮电大学校长范九伦分别致辞，中国大学生体育协会竞赛部主任程洁、篮球分会秘书长刘庆广，陕西省教育厅体育卫生艺术处处长李鸣、中国篮球协会副主席王立彬，陕西省学生体育协会专职副主席张原耕，非凡中国体育副总裁李芸姗，第十九届CUBA中国大学生篮球联赛（西北赛区）裁判长郑军出席仪式，我校副校长巩稼民主持开幕式，西北赛区全体裁判员、教练员、运动员参加开幕。\n" +
                "\n" +
                "开幕式在雄壮的国歌声中拉开帷幕，西安邮电大学街舞队带来动感绚丽的街舞表演，来自郑州大学、西安交通大学城市学院等6支啦啦操队带来充满青春活力的啦啦操表演，充分展示大学生青春风采。随后，在现场观众热情的欢呼中，西北赛区16支男篮代表队、12支女篮代表队、裁判员方队依次入场。            \n" +
                "\n" +
                "范九伦在致辞中代表学校向大赛的开幕表示热烈祝贺，向全体裁判员、教练员、运动员致以诚挚的问候。他指出，西邮在努力提升人才培养质量、科学研究水平和服务社会能力的同时，高度重视发展大学生体育事业，积极响应教育部、国家体育总局“阳光体育运动”的号召。在竞技体育方面，通过精心组织，科学训练，体育竞技水平稳步提高，在径赛尤其是竞走、马拉松等项目上优势突出，多次在国际、国家级高水平赛事中斩金夺银，为国家争得了荣誉。他表示，西邮将精心组织，热情服务，全力为赛事的顺利进行提供良好的后勤保障，努力将本届赛事办成一场精彩难忘、欢乐祥和的体育文化盛会。  ");
    }

    public static void launcherNotifyBannerItenClickActivity(Context context) {
        Intent intent = new Intent(context, NotifyBannerItenClickActivity.class);
        context.startActivity(intent);
    }

}
