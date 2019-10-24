package br.com.barrsoft.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    private AlertDialog alertDialog;
    private AlertDialog alertDialog1;
    private AlertDialog alertDialog2;
    private String [] opcoes = {"Item 1","Item 2","Item 3"};
    private Boolean [] selecionado = new Boolean[opcoes.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle(getString(R.string.alert_title));
        builder.setMessage(getString(R.string.alert_msg));
        builder.setPositiveButton(getString(R.string.alert_button_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),R.string.alert_button_ok,Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(getString(R.string.alert_button_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),R.string.alert_button_cancel,Toast.LENGTH_LONG).show();
            }
        });
        alertDialog = builder.create();


        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setTitle(R.string.alert_title_checkbox);
        builder1.setSingleChoiceItems(opcoes, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext()," " + opcoes[which],Toast.LENGTH_LONG).show();
            }
        });
        builder1.setPositiveButton(getString(R.string.alert_button_ok),null);
        builder1.setNegativeButton(getString(R.string.alert_button_cancel),null);
        alertDialog1 = builder1.create();


        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);

        builder2.setTitle(R.string.alert_title_radio);
        builder2.setMultiChoiceItems(opcoes, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    selecionado[which]=isChecked;
                    Toast.makeText(getApplicationContext(),getText(R.string.item).toString() + (which+1) + " " + selecionado[which].toString(),Toast.LENGTH_SHORT).show();
                }else {
                    selecionado[which]=isChecked;
                    Toast.makeText(getApplicationContext(),getText(R.string.item).toString() + (which+1) + " "+ selecionado[which].toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder2.setPositiveButton(getString(R.string.alert_button_ok), null);
        builder2.setNegativeButton(getString(R.string.alert_button_cancel),null);
        alertDialog2 = builder2.create();
    }

    @OnClick(R.id.button)
    public void submit(View view) {
        // TODO submit data to server...
        alertDialog.show();
    }

    @OnClick(R.id.button1)
    public void submit1(View view) {
        // TODO submit data to server...
        alertDialog1.show();
    }

    @OnClick(R.id.button2)
    public void submit2(View view) {
        // TODO submit data to server...
        alertDialog2.show();
    }
}