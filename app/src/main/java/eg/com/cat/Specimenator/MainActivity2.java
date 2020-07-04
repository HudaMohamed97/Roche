package eg.com.cat.Specimenator;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import eg.com.cat.Specimenator.fragments.Coverslipping;
import eg.com.cat.Specimenator.fragments.Duration;
import eg.com.cat.Specimenator.fragments.Fixation;
import eg.com.cat.Specimenator.fragments.Grossing;
import eg.com.cat.Specimenator.fragments.Handling;
import eg.com.cat.Specimenator.fragments.Microtomy;
import eg.com.cat.Specimenator.fragments.Preparation;
import eg.com.cat.Specimenator.fragments.Processing;
import eg.com.cat.Specimenator.fragments.Storage;
import eg.com.cat.Specimenator.fragments.list;
import eg.com.cat.Specimenator.fragments.refrence;
import eg.com.cat.Specimenator.fragments.specimen;

public class MainActivity2 extends AppCompatActivity {

    LinearLayout one, two, three, four, five, six, seven, eight, nine, ten;
    ImageView ref, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Make sure this is before calling super.onCreate
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUi();
        initializeClicks();

    }

    private void initializeClicks() {
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), specimen.class));

/*

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("specimen");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                specimen fragment = new specimen();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();*/

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Fixation.class));

                /*FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("Fixation");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                Fixation dialogFragment = new Fixation();
                dialogFragment.show(getSupportFragmentManager(), "Fixation");
*/
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Preparation.class));

               /* FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("prepartion");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                Preparation dialogFragment = new Preparation();
                dialogFragment.show(getSupportFragmentManager(), "prepation");*/

            }
        });

        four.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Handling.class));

                /*FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("handling");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                Handling dialogFragment = new Handling();
                dialogFragment.show(getSupportFragmentManager(), "handling");*/

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Grossing.class));

           /*     FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("Grossing");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                Grossing dialogFragment = new Grossing();
                dialogFragment.show(getSupportFragmentManager(), "Grossing");*/

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Duration.class));

              /*  FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("Fixation");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                Duration dialogFragment = new Duration();
                dialogFragment.show(getSupportFragmentManager(), "Fixation");
*/
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Processing.class));

              /*  FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("Processing");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                Processing dialogFragment = new Processing();
                dialogFragment.show(getSupportFragmentManager(), "Processing");*/

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Microtomy.class));
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Storage.class));
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Coverslipping.class));

            }
        });
        ref.setOnClickListener(v -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment prev = getFragmentManager().findFragmentByTag("Fixation");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);
            refrence dialogFragment = new refrence();
            dialogFragment.show(getSupportFragmentManager(), "Fixation");

        });
        list.setOnClickListener(v -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment prev = getFragmentManager().findFragmentByTag("Fixation");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);
            list dialogFragment = new list();
            dialogFragment.show(getSupportFragmentManager(), "Fixation");

        });
    }

    private void initializeUi() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ten = findViewById(R.id.ten);
        ref = findViewById(R.id.ref);
        list = findViewById(R.id.list);
    }
}
