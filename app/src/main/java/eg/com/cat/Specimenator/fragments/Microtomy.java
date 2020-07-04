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

public class Microtomy extends DialogFragment implements Adapter2.ItemClickListener {
    Adapter2 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ImageButton readMore;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_microtomy, container, false);
        getDialog().setTitle("Simple Dialog");
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioPAH);
        RadioButton Radio1 = rootView.findViewById(R.id.Radio1);
        RadioButton Radio2 = rootView.findViewById(R.id.Radio2);
        RadioButton Radio3 = rootView.findViewById(R.id.Radio3);
        RadioButton Radio4 = rootView.findViewById(R.id.Radio4);
        ImageView image = rootView.findViewById(R.id.image);

        initRecyclerView(rootView);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section811);
                        picList.add(R.drawable.section812);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio2:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section821);
                        picList.add(R.drawable.section822);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio3:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section831);
                        picList.add(R.drawable.section832);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio4:
                        readMore.setVisibility(View.VISIBLE);
                        picList.clear();
                        picList.add(R.drawable.section841);
                        picList.add(R.drawable.section842);
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
                } else if (Radio3.isChecked()) {
                    Radio4.setChecked(true);
                }


            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (Radio3.isChecked()) {
                    Radio2.setChecked(true);
                } else if (Radio4.isChecked()) {
                    Radio3.setChecked(true);
                } else if (Radio2.isChecked()) {
                    Radio1.setChecked(true);
                }
            }
        });

        readMore = rootView.findViewById(R.id.readMore);
        readMore.setOnClickListener(v -> {
            picList2.clear();
            picList2.add(R.drawable.sec8inner1);
            picList2.add(R.drawable.sec8inner2);
            picList2.add(R.drawable.sec8inner3);
            picList2.add(R.drawable.sec8inner4);
            picList2.add(R.drawable.sec8inner5);
            picList2.add(R.drawable.sec8inner6);
            picList2.add(R.drawable.sec8inner7);
            picList2.add(R.drawable.sec8inner8);
            picList2.add(R.drawable.sec8inner9);
            picList2.add(R.drawable.sec8inner10);
            picList2.add(R.drawable.sec8inner11);
            BottomSheet addPhotoBottomDialogFragment = new BottomSheet(picList2);
            if (getFragmentManager() != null) {
                addPhotoBottomDialogFragment.show(getFragmentManager(), "");
            }
        });

        return rootView;
    }


    private void initRecyclerView(View rootView) {
        recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picList.clear();
        picList.add(R.drawable.section811);
        picList.add(R.drawable.section812);
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
      /*  picList3.clear();
        picList3.add(R.drawable.ref1);
        picList3.add(R.drawable.ref2);
        ShowMoreSheet addPhotoBottomDialogFragment = new ShowMoreSheet(picList3);
        if (getFragmentManager() != null) {
            addPhotoBottomDialogFragment.show(getFragmentManager(), "");
        }
*/

    }
}

