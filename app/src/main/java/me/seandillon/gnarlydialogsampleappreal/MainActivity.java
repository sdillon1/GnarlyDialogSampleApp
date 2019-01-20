package me.seandillon.gnarlydialogsampleappreal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import me.seandillon.gnarlydialog.GnarlyDialog;






public class MainActivity extends AppCompatActivity {

    // UI vars
    TextView textview_title;
    TextView textview_content;
    TextView textview_primaryButton;
    TextView textview_secondaryButton;

    Button button_launchDialogSuccess;
    Button button_launchDialogError;
    Button button_launchDialogWarning;
    Button button_launchDialogInfo;

    Switch switch_color_wrap_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findByIds();
        assignOnClickListeners();

    }

    private void findByIds() {

        textview_title = (TextView)findViewById(R.id.textview_title);
        textview_content = (TextView)findViewById(R.id.textview_content);
        textview_primaryButton = (TextView)findViewById(R.id.textview_primaryButton);
        textview_secondaryButton = (TextView)findViewById(R.id.textview_secondaryButton);

        button_launchDialogSuccess = (Button) findViewById(R.id.button_launchDialogSuccess);
        button_launchDialogError = (Button) findViewById(R.id.button_launchDialogError);
        button_launchDialogWarning = (Button) findViewById(R.id.button_launchDialogWarning);
        button_launchDialogInfo = (Button) findViewById(R.id.button_launchDialogInfo);

        switch_color_wrap_layout = (Switch) findViewById(R.id.switch_color_wrap_layout);

    }

    private void assignOnClickListeners() {

        button_launchDialogSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_SUCCESS);
            }
        });

        button_launchDialogError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_ERROR);
            }
        });

        button_launchDialogWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_WARNING);
            }
        });

        button_launchDialogInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGnarlyAlert(GnarlyDialog.GNARLY_DIALOG_TYPE_INFO);
            }
        });

        switch_color_wrap_layout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switch_color_wrap_layout.setText(getString(R.string.checkbox_use_color_wrap_layout));
                } else {
                    switch_color_wrap_layout.setText(getString(R.string.checkbox_dont_use_color_wrap_layout));
                }
            }
        });

    }

    public void showGnarlyAlert(int whichType) {

        // initialize GnarlyDialog and get UI text to put in there
        final GnarlyDialog gnarlyDialog = new GnarlyDialog(MainActivity.this, whichType, switch_color_wrap_layout.isChecked());
//        final GnarlyDialog gnarlyDialog = new GnarlyDialog(MainActivity.this, whichType);

        if (!textview_title.getText().toString().equals("")) {
            gnarlyDialog.setGnarlyTitleText(textview_title.getText().toString());
        }

        if (!textview_content.getText().toString().equals("")) {
            gnarlyDialog.setGnarlyContentText(textview_content.getText().toString());
        }

        if (!textview_primaryButton.getText().toString().equals("")) {
            gnarlyDialog.setGnarlyPrimaryButtonText(textview_primaryButton.getText().toString());
            gnarlyDialog.setGnarlyPrimaryButtonListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Primary button clicked", Toast.LENGTH_SHORT).show();
                    gnarlyDialog.gnarlyDialogDismiss();
                }
            });
            gnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false);
        }

        if (!textview_secondaryButton.getText().toString().equals("")) {
            gnarlyDialog.setGnarlySecondaryButtonText(textview_secondaryButton.getText().toString());
            gnarlyDialog.setGnarlySecondaryButtonListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Secondary button clicked", Toast.LENGTH_SHORT).show();
                    gnarlyDialog.gnarlyDialogDismiss();
                }
            });
            gnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false);
        }

        // lastly show the dialog
        gnarlyDialog.gnarlyDialogShow();

    }

}









/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                final GnarlyDialog gnarlyDialog = new GnarlyDialog(MainActivity.this, GnarlyDialog.GNARLY_DIALOG_TYPE_SUCCESS);
                gnarlyDialog.setGnarlyContentText("content");
                gnarlyDialog.setGnarlyTitleText("Title");
                gnarlyDialog.setGnarlyPrimaryButtonText("Primary");
                gnarlyDialog.setGnarlyPrimaryButtonListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Primary Button Clicked", Toast.LENGTH_SHORT).show();
                        gnarlyDialog.gnarlyDialogDismiss();
                    }
                });
                gnarlyDialog.setGnarlySecondaryButtonText("Secondary");
                gnarlyDialog.setGnarlySecondaryButtonListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Secondary Button Clicked", Toast.LENGTH_SHORT).show();
                        gnarlyDialog.gnarlyDialogDismiss();
                    }
                });
                gnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false);
                gnarlyDialog.gnarlyDialogShow();



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

*/