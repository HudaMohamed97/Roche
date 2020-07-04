package eg.com.cat.Specimenator.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Objects;

import eg.com.cat.Specimenator.R;

public class Fixation extends AppCompatActivity implements Adapter2.ItemClickListener {
    Adapter2 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    ImageButton readMore;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fixation);
        ImageView image = findViewById(R.id.image);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioPAH);
        RadioButton Radio1 = (RadioButton) findViewById(R.id.Radio1);
        RadioButton Radio2 = (RadioButton) findViewById(R.id.Radio2);
        RadioButton Radio3 = (RadioButton) findViewById(R.id.Radio3);
        initRecyclerView();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section2pic1);
                        picList.add(R.drawable.slide2_1_2);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio2:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section2pic1in2);
                        picList.add(R.drawable.slide2_2_2);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio3:
                        readMore.setVisibility(View.VISIBLE);
                        picList.clear();
                        picList.add(R.drawable.section2pic1in3);
                        picList.add(R.drawable.section2pic2in3);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        recyclerView.setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onClick() {
                super.onClick();
                // your on click here
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                // your on onDoubleClick here
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                // your on onLongClick here
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                // your swipe up here
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                // your swipe down here.
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (Radio1.isChecked()) {
                    Radio2.setChecked(true);
                } else if (Radio2.isChecked()) {
                    Radio3.setChecked(true);
                }


            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (Radio3.isChecked()) {
                    Radio2.setChecked(true);
                } else if (Radio2.isChecked()) {
                    Radio1.setChecked(true);
                }
            }
        });
        readMore = (ImageButton) findViewById(R.id.readMore);
        readMore.setVisibility(View.GONE);

        readMore.setOnClickListener(v -> {
            picList2.clear();
            picList2.add(R.drawable.sec4inner1);
            Intent intent = new Intent(getApplicationContext(), BottomSheet.class);
            Bundle b = new Bundle();
            b.putIntegerArrayList("key", picList2); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
        });

    }


    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        picList.clear();
        picList.add(R.drawable.section2pic1);
        picList.add(R.drawable.section2pic2);
        adapter = new Adapter2(this, this, picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onItemClick(View view, int position) {


    }
}
