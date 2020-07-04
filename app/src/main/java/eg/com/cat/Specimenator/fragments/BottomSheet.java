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
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Objects;

import eg.com.cat.Specimenator.R;

public class BottomSheet extends AppCompatActivity {
    public static final String TAG = "ActionBottomDialog";
    AdapterSheet adapter;
    int style = DialogFragment.STYLE_NO_TITLE;
    int theme = R.style.MyDialog;
    ArrayList<Integer> picList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet);
        Button button_close = findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Bundle b = getIntent().getExtras();
        if (b != null)
            picList = b.getIntegerArrayList("key");
        initRecyclerView();

    }


    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterSheet(this, picList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}