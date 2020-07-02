package eg.com.cat.roche.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import eg.com.cat.roche.R;

public class Microtomy extends DialogFragment implements Adapter2.ItemClickListener {
    Adapter2 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ImageButton readMore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_microtomy, container, false);
        getDialog().setTitle("Simple Dialog");
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioPAH);
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
        readMore = (ImageButton) rootView.findViewById(R.id.readMore);
        readMore.setVisibility(View.GONE);
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
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
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picList.clear();
        picList.add(R.drawable.section811);
        picList.add(R.drawable.section812);
        adapter = new Adapter2(this, getActivity(), picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onItemClick(View view, int position) {
        picList3.clear();
        picList3.add(R.drawable.ref1);
        picList3.add(R.drawable.ref2);
        ShowMoreSheet addPhotoBottomDialogFragment = new ShowMoreSheet(picList3);
        if (getFragmentManager() != null) {
            addPhotoBottomDialogFragment.show(getFragmentManager(), "");
        }


    }
}

