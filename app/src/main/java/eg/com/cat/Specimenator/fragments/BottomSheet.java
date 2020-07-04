package eg.com.cat.Specimenator.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Objects;

import eg.com.cat.Specimenator.R;

public class BottomSheet extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";
    AdapterSheet adapter;
    ArrayList<Integer> picList = new ArrayList<>();


    public BottomSheet(ArrayList<Integer> picList) {
        this.picList = picList;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style. AppBottomSheetDialogTheme);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
        Button exist = view.findViewById(R.id.button_close);
        exist.setOnClickListener(view1 -> super.dismiss());


    }


    private void initRecyclerView(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterSheet(getActivity(), picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}