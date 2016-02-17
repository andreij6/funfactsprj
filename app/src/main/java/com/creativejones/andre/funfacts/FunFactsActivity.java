package com.creativejones.andre.funfacts;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.creativejones.andre.funfacts.Model.ColorWheel;
import com.creativejones.andre.funfacts.Model.Fact;
import com.creativejones.andre.funfacts.Model.FactBook;

public class FunFactsActivity extends AppCompatActivity {

    FactBook mFactBook;
    Fact mCurrentFact;
    ColorWheel mColorWheel = new ColorWheel();

    TextView mFact;
    RelativeLayout mBackground;
    Button mFactButton;

    int mCurrentColor;

    private static final String FACT_KEY = "fact_key";
    private static final String FACT_COLOR = "fact_color_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        mFactBook = new FactBook();

        mBackground = (RelativeLayout)findViewById(R.id.background);
        mFact = (TextView)findViewById(R.id.funfactTV);
        mFactButton = (Button)findViewById(R.id.button);

        if(savedInstanceState != null) {
            mCurrentFact = savedInstanceState.getParcelable(FACT_KEY);
            mCurrentColor = savedInstanceState.getInt(FACT_COLOR);
        } else {
            mCurrentFact  = mFactBook.getRandom(mCurrentFact);
            mCurrentColor = ContextCompat.getColor(this, mColorWheel.getRandomColor());
        }

        setFunFactUI();

        mFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentFact  = mFactBook.getRandom(mCurrentFact);
                mCurrentColor = ContextCompat.getColor(FunFactsActivity.this, mColorWheel.getRandomColor());

                setFunFactUI();
            }
        });
    }

    private void setFunFactUI() {
        mFact.setText(mCurrentFact.getFact());

        mBackground.setBackgroundColor(mCurrentColor);
        mFactButton.setTextColor(mCurrentColor);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(FACT_KEY, mCurrentFact);
        outState.putInt(FACT_COLOR, mCurrentColor);
    }
}
