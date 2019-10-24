package br.com.barrsoft.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button1)
    Button button1;
    private AlertDialog alertDialog;
    private AlertDialog alertDialog1;
    private String [] opcoes = {"Item 1","Item 2","Item 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle(getString(R.string.alert_title));
        builder.setIcon(R.drawable.ic_stat_alert);
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


        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);

        builder2.setIcon(R.drawable.ic_action_name);
        builder2.setTitle(R.string.alert_title);
        builder2.setSingleChoiceItems(opcoes, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext()," " + opcoes[which],Toast.LENGTH_LONG).show();
            }
        });
        builder2.setPositiveButton(getString(R.string.alert_button_ok),null);
        builder2.setNegativeButton(getString(R.string.alert_button_cancel),null);
        alertDialog1 = builder2.create();


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
}
