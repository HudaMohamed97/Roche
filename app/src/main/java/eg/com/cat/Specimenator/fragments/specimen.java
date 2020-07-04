package eg.com.cat.Specimenator.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eg.com.cat.Specimenator.R;

public class specimen extends AppCompatActivity implements Adapter2.ItemClickListener {
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    Adapter2 adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_specimen);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioPAH);
        ImageView image = findViewById(R.id.image);
        RadioButton Radio1 = findViewById(R.id.Radio1);
        RadioButton Radio2 = findViewById(R.id.Radio2);
        initRecyclerView();
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
                Radio2.setChecked(true);


            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Radio1.setChecked(true);
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        picList.clear();
                        picList.add(R.drawable.section1pic1);
                        picList.add(R.drawable.section1pic2);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio2:
                        picList.clear();
                        picList.add(R.drawable.section1pic1in2);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        picList.clear();
        picList.add(R.drawable.section1pic1);
        picList.add(R.drawable.section1pic2);
        adapter = new Adapter2(this, this, picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onItemClick(View view, int position) {
        /*picList3.clear();
        picList3.add(R.drawable.ref1);
        picList3.add(R.drawable.ref2);
        ShowMoreSheet addPhotoBottomDialogFragment = new ShowMoreSheet(picList3);
        if (getFragmentManager() != null) {
            addPhotoBottomDialogFragment.show(getFragmentManager(), "");
        }
*/
    }
}
