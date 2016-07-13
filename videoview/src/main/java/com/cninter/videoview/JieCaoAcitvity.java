package com.cninter.videoview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class JieCaoAcitvity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_cao_acitvity);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new VideoAdapter(this));
    }


}
class VideoAdapter extends BaseAdapter{
    private Context context;
    String[] videos ={"http://vf1.mtime.cn/Video/2015/03/20/mp4/150320094140850937_480.mp4",
            "http://biggame1.b0.upaiyun.com/mp4/551afdd301f2de21adac87045f4b2c3f.mp4",
            "http://biggame1.b0.upaiyun.com/mp4/09b3e57ac49db94cc8ad6afc2e926ae9.mp4",
            "http://biggame1.b0.upaiyun.com/video/c62d78f7a3f87bde8d56ca63016aacde.mp4",
            "http://biggame1.b0.upaiyun.com/video/a9d366a3c18911e631bf9327d458feb9.mp4"};
    String [] titls ={"标题1","标题2","标题3","标题4","标题5",};
    String [] pics={"http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
            "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
            "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
            "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
            "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"};

    int index[] = {0,3,2,4,1};

    public VideoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return videos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.jiecao_listview,null);
            viewHolder.jcVideoPlayer = (JCVideoPlayerStandard) convertView.findViewById(R.id.jiecao_standard);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jcVideoPlayer.setUp(videos[i],titls[i]);
        //使用ImageLoader设置显示的图片
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        imageLoader.displayImage(pics[i],viewHolder.jcVideoPlayer.thumbImageView);



        return convertView;
    }

    class ViewHolder{
        JCVideoPlayerStandard jcVideoPlayer;
    }
}