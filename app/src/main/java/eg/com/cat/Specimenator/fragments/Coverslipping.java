package eg.com.cat.Specimenator.fragments;

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

import eg.com.cat.Specimenator.R;

public class Coverslipping extends DialogFragment  implements Adapter2.ItemClickListener{
    Adapter2 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    ImageButton readMore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coverslipping, container, false);
        getDialog().setTitle("Simple Dialog");

        RadioGroup radioGroup = rootView.findViewById(R.id.radioPAH);
        initRecyclerView(rootView);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        readMore.setVisibility(View.VISIBLE);
                        picList.clear();
                        picList.add(R.drawable.section101);
                        picList.add(R.drawable.section102);
                        adapter.notifyDataSetChanged();
                        break;

                }
            }
        });
        readMore = rootView.findViewById(R.id.readMore);
        readMore.setOnClickListener(v -> {
            picList2.clear();
            picList2.add(R.drawable.sec10inner1);
            picList2.add(R.drawable.sec10inner2);
            picList2.add(R.drawable.sec10inner3);
            picList2.add(R.drawable.sec10inner4);
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
        picList.add(R.drawable.section101);
        picList.add(R.drawable.section102);
        adapter = new Adapter2(this,getActivity(), picList);
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