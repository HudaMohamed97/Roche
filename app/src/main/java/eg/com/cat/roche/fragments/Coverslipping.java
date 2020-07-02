package eg.com.cat.roche.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import eg.com.cat.roche.R;

public class Coverslipping extends DialogFragment {
    Adapter2 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ImageButton readMore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coverslipping, container, false);
        getDialog().setTitle("Simple Dialog");

        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioPAH);
        initRecyclerView(rootView);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Radio1:
                        readMore.setVisibility(View.GONE);
                        picList.clear();
                        picList.add(R.drawable.section101);
                        picList.add(R.drawable.section102);
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

        return rootView;
    }

    private void initRecyclerView(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        picList.clear();
        picList.add(R.drawable.section101);
        picList.add(R.drawable.section102);
        adapter = new Adapter2(getActivity(), picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
