package com.example.lenovo.sieveoferatosthenes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ShowResult extends Activity {
    private TextView resultText;
    private TextView title;
    private Button back;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        resultText = (TextView)this.findViewById(R.id.Result);
        title = (TextView)this.findViewById(R.id.ResultTitle);
        back = (Button)this.findViewById(R.id.Back);
        title.setText(R.string.resultTitle);
        back.setText(R.string.back);
        intent = getIntent();
        String result = intent.getStringExtra("result");
        resultText.setMovementMethod(new ScrollingMovementMethod());
        resultText.setText(result);
        back.setOnClickListener(new BackButtonListener());

    }

    class BackButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            setResult(RESULT_OK, intent);
            finish();
        }
    }





}
