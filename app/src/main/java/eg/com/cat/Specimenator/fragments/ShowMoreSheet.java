package eg.com.cat.Specimenator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import eg.com.cat.Specimenator.R;

public class ShowMoreSheet extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";
    Adapter3 adapter;
    ArrayList<Integer> picList = new ArrayList<>();


    public ShowMoreSheet(ArrayList<Integer> picList) {
        this.picList = picList;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
        Button exist = view.findViewById(R.id.exist);
        exist.setOnClickListener(view1 -> super.dismiss());


    }

    private void initRecyclerView(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new Adapter3(getActivity(), picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}