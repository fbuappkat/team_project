package com.example.kat_app.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kat_app.R;
import com.parse.ParseUser;

public class ManageCreditActivity extends AppCompatActivity {

    private ConstraintLayout depositHolder;
    private ImageView ivBack;
    private TextView tvName;
    private TextView tvCurrBalanceCount;

    private static final String KEY_NAME = "name";
    private static final String KEY_BALANCE = "balance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_credit);

        setDepositCreditOption();
        setBackButton();
        setProfileInfo();
    }

    private void setDepositCreditOption() {
        // Find reference for the view
        depositHolder = findViewById(R.id.depositHolder);

        // Open deposit credit options on click
        depositHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageCreditActivity.this, PayPalCheckoutActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setProfileInfo() {
        // Find references for the views
        tvName = findViewById(R.id.tvName);
        tvCurrBalanceCount = findViewById(R.id.tvCurrBalanceCount);

        // Get the current user
        ParseUser currUser = ParseUser.getCurrentUser();

        tvName.setText(currUser.getString(KEY_NAME));
        tvCurrBalanceCount.setText("$" + currUser.getInt(KEY_BALANCE));
    }

    private void setBackButton() {
        // Find reference for the view
        ivBack = findViewById(R.id.ivBack);

        // Set on-click listener for for image view to launch edit account activity
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}