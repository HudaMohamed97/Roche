package eg.com.cat.Specimenator.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.Objects;

import eg.com.cat.Specimenator.R;

public class specimen extends DialogFragment implements Adapter2.ItemClickListener {
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    Adapter2 adapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_specimen, container, false);
        getDialog().setTitle("Simple Dialog");
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioPAH);
        ImageView image = rootView.findViewById(R.id.image);
        RadioButton Radio1 = (RadioButton) rootView.findViewById(R.id.Radio1);
        RadioButton Radio2 = (RadioButton) rootView.findViewById(R.id.Radio2);
        initRecyclerView(rootView);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        recyclerView.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

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
        return rootView;
    }

    private void initRecyclerView(View rootView) {
        recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picList.clear();
        picList.add(R.drawable.section1pic1);
        picList.add(R.drawable.section1pic2);
        adapter = new Adapter2(this, getActivity(), picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(getDialog().getWindow()).setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
