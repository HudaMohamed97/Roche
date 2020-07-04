package eg.com.cat.Specimenator.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import eg.com.cat.Specimenator.R;

public class refrence extends DialogFragment {
    Adapter3 adapter;
    ArrayList<Integer> picList = new ArrayList<>();
    ArrayList<Integer> picList2 = new ArrayList<>();
    int style = DialogFragment.STYLE_NO_TITLE;
    int theme = R.style.MyDialog;
    ImageButton readMore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.refrence, container, false);
        getDialog().setTitle("Simple Dialog");
        ImageView image = rootView.findViewById(R.id.image);
        initRecyclerView(rootView);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return rootView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);

    }

    private void initRecyclerView(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        picList.clear();
        picList.add(R.drawable.ref1);
        picList.add(R.drawable.ref2);
        adapter = new Adapter3(getActivity(), picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(style, theme);
    }

}
