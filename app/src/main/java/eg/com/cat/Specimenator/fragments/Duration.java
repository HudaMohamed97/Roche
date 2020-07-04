package eg.com.cat.Specimenator.fragments;

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

public class Duration extends AppCompatActivity implements Adapter2.ItemClickListener {
    Adapter2 adapter;
    ArrayList<Integer> picList2 = new ArrayList<>();
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    ImageButton readMore;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_duration);
        ImageView image = findViewById(R.id.image);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioPAH);
        RadioButton Radio1 = (RadioButton) findViewById(R.id.Radio1);
        RadioButton Radio2 = (RadioButton) findViewById(R.id.Radio2);
        initRecyclerView();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section6pic11);
                        picList.add(R.drawable.section6pic12);
                        picList.add(R.drawable.section6pic13);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio2:
                        readMore.setVisibility(View.VISIBLE);
                        picList.clear();
                        picList.add(R.drawable.section6pic21);
                        picList.add(R.drawable.section6pic22);
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
                Radio2.setChecked(true);


            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Radio1.setChecked(true);
            }
        });


        readMore = (ImageButton) findViewById(R.id.readMore);
        readMore.setVisibility(View.GONE);
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picList2.clear();
                picList2.add(R.drawable.sec6inner1);
                picList2.add(R.drawable.sec6inner2);
                BottomSheet addPhotoBottomDialogFragment = new BottomSheet(picList2);
                if (getFragmentManager() != null) {
                    addPhotoBottomDialogFragment.show(getSupportFragmentManager(), "");
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        picList.clear();
        picList.add(R.drawable.section6pic11);
        picList.add(R.drawable.section6pic12);
        picList.add(R.drawable.section6pic13);
        adapter = new Adapter2(this, this, picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onItemClick(View view, int position) {
       /* picList3.clear();
        picList3.add(R.drawable.ref1);
        picList3.add(R.drawable.ref2);
        ShowMoreSheet addPhotoBottomDialogFragment = new ShowMoreSheet(picList3);
        if (getFragmentManager() != null) {
            addPhotoBottomDialogFragment.show(getFragmentManager(), "");
        }
*/

    }
}

