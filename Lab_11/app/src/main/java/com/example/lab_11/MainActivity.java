package com.example.lab_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int voteCount[] = new int[9]; //배열이 가지는 주소는 바뀌지 않기 때문에 값은 바뀔 수 있다.
    final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양",
            "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};
    final Integer[] posterID = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 명화 선호도 투표(11장 실습)");

        final GridView gv = (GridView)findViewById(R.id.gridView);
        MyGridAdapter myAdapter = new MyGridAdapter(this, posterID, imgName);
        gv.setAdapter(myAdapter);

        Button btnResult = (Button)findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("imgName", imgName);

                startActivity(intent);
            }
        });

    }

    public class MyGridAdapter extends BaseAdapter{

        Context context;
        Integer[] posterID;
        String[] imgName;

        public MyGridAdapter(Context c, Integer[] posterID, String[] imgName){
            context = c;
            this.posterID = posterID;
            this.imgName = imgName;
        }

        @Override
        public int getCount() {
            return posterID.length;
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
            ImageView imageView;
            if(convertView == null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 400));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 5, 5, 5);
            }
            else
                imageView = (ImageView) convertView;

            imageView.setImageResource(posterID[position]);

            for(int i = 0; i < 9; i++){
                voteCount[i] = 0;
            }

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[pos]++;
                    Toast.makeText(getApplicationContext(), imgName[pos] + " 총: " + voteCount[pos] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });

            return imageView;
        }
    }


}