package eg.com.cat.Specimenator.fragments;

import android.os.Bundle;

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

public class Handling extends DialogFragment implements Adapter2.ItemClickListener {
    Adapter2 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ImageButton readMore;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_handling, container, false);
        getDialog().setTitle("Simple Dialog");
        ImageView image = rootView.findViewById(R.id.image);
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioPAH);
        RadioButton Radio1 = (RadioButton) rootView.findViewById(R.id.Radio1);
        RadioButton Radio2 = (RadioButton) rootView.findViewById(R.id.Radio2);
        RadioButton Radio3 = (RadioButton) rootView.findViewById(R.id.Radio3);
        initRecyclerView(rootView);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section4pic1);
                        picList.add(R.drawable.section4pic12);
                        picList.add(R.drawable.section4pic13);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio2:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section4pic21);
                        picList.add(R.drawable.section4pic22);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio3:
                        readMore.setVisibility(View.VISIBLE);
                        picList.clear();
                        picList.add(R.drawable.section4pic31);
                        picList.add(R.drawable.section4pic32);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
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
        readMore = (ImageButton) rootView.findViewById(R.id.readMore);
        readMore.setVisibility(View.GONE);
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picList2.clear();
                picList2.add(R.drawable.sec4inner1);
                BottomSheet addPhotoBottomDialogFragment = new BottomSheet(picList2);
                if (getFragmentManager() != null) {
                    addPhotoBottomDialogFragment.show(getFragmentManager(), "");
                }
            }
        });


        return rootView;
    }


    private void initRecyclerView(View rootView) {
        recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picList.clear();
        picList.add(R.drawable.section4pic1);
        picList.add(R.drawable.section4pic12);
        picList.add(R.drawable.section4pic13);
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
        }*/


    }
}

