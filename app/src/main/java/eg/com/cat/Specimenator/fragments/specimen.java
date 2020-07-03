package eg.com.cat.Specimenator.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


import java.util.ArrayList;

import eg.com.cat.Specimenator.R;

public class specimen extends DialogFragment implements Adapter2.ItemClickListener {
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    Adapter2 adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_specimen, container, false);
        getDialog().setTitle("Simple Dialog");
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioPAH);
        initRecyclerView(rootView);
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
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picList.clear();
        picList.add(R.drawable.section1pic1);
        picList.add(R.drawable.section1pic2);
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
