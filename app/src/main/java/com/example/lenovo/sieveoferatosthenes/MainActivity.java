package com.example.lenovo.sieveoferatosthenes;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private TextView title;
    private TextView result;
    private EditText input;
    private TextView hint;
    private Button button;
    private int num;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView)this.findViewById(R.id.Title);
        input = (EditText)this.findViewById(R.id.Input);
        hint = (TextView)this.findViewById(R.id.Hint);
        button = (Button)this.findViewById(R.id.Button);
        title.setText(R.string.title);
        hint.setText(R.string.hint);
        button.setText(R.string.cal);
        button.setOnClickListener(new CalculateButtonListener());

    }

    class CalculateButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String inputStr = input.getText().toString();
            if(inputStr.isEmpty()||!isNumeric(inputStr)||Integer.parseInt(inputStr)<2) {
                Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_LONG).show();
                return;
            }else {
                num = Integer.parseInt(input.getText().toString());
                String allPrime = Calculate.getPrime(num);
                Intent intent = new Intent(MainActivity.this, ShowResult.class);
                intent.putExtra("result", allPrime);
                startActivityForResult(intent, 1);
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private boolean isNumeric(String s) {
        for(int i=0;i<s.length();i++) {
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
