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

public class Storage extends DialogFragment implements Adapter2.ItemClickListener {
    Adapter2 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    ArrayList<Integer> picList3 = new ArrayList<>();
    ImageButton readMore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_storage, container, false);
        getDialog().setTitle("Simple Dialog");

        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioPAH);
        initRecyclerView(rootView);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section911);
                        picList.add(R.drawable.section912);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.Radio2:
                        readMore.setVisibility(View.VISIBLE);
                        picList.clear();
                        picList.add(R.drawable.section921);
                        picList.add(R.drawable.section922);
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
                picList2.clear();
                picList2.add(R.drawable.sec9inner1);
                picList2.add(R.drawable.sec9inner2);
                picList2.add(R.drawable.sec9inner3);
                picList2.add(R.drawable.sec9inner4);
                BottomSheet addPhotoBottomDialogFragment = new BottomSheet(picList2);
                if (getFragmentManager() != null) {
                    addPhotoBottomDialogFragment.show(getFragmentManager(), "");
                }


            }
        });


        return rootView;
    }


    private void initRecyclerView(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picList.clear();
        picList.add(R.drawable.section911);
        picList.add(R.drawable.section912);
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

