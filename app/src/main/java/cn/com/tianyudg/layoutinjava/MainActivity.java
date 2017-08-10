package cn.com.tianyudg.layoutinjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        test();
    }

    private void test() {
        RelativeLayout rootlayout = new RelativeLayout(this);
        rootlayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, dip2px(120)));
        rootlayout.setId(0);

        ImageView imageView = new ImageView(this);
        RelativeLayout.LayoutParams image_Params = new RelativeLayout.LayoutParams(dip2px(60), dip2px(60));
        image_Params.setMargins(dip2px(20), dip2px(25), 0, dip2px(10));
        imageView.setLayoutParams(image_Params);
        imageView.setImageResource(R.mipmap.ic_launcher_round);
//        imageView.setId(1);

        TextView text_Name = new TextView(this);
        RelativeLayout.LayoutParams text_Name_Params = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        text_Name_Params.addRule(RelativeLayout.RIGHT_OF, imageView.getId());
        text_Name_Params.addRule(RelativeLayout.ALIGN_TOP, imageView.getId());
        text_Name_Params.setMargins(dip2px(20), dip2px(10), 0, 0);
        text_Name.setLayoutParams(text_Name_Params);
        text_Name.setText("Mr.Zdy");
        text_Name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        text_Name.setId(2);


        TextView text_Email = new TextView(this);
        RelativeLayout.LayoutParams text_Email_Params = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        text_Email_Params.addRule(RelativeLayout.RIGHT_OF, imageView.getId());
        text_Email_Params.addRule(RelativeLayout.BELOW, text_Name.getId());
        text_Email_Params.setMargins(dip2px(20), dip2px(3), 0, 0);
        text_Email.setLayoutParams(text_Email_Params);
        text_Email.setText("zhudongya123@gmail.com");
        text_Email.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

        rootlayout.addView(imageView, image_Params);
        rootlayout.addView(text_Name, text_Name_Params);
        rootlayout.addView(text_Email, text_Email_Params);
        setContentView(rootlayout);

    }


    public int dip2px(float dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }




}
