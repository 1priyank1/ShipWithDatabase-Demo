package priyank.patel.ownsqlitedb;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextview = (TextView) findViewById(R.id.textview);
    }


    @Override
    protected void onResume() {
        super.onResume();
        initExternalDatabase();
    }


    public void initExternalDatabase() {
        DataBaseHelper myDbHelper = new DataBaseHelper(this);
        myDbHelper = new DataBaseHelper(this);

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

            mTextview.setText("Open database successfully.");
        }catch(SQLException sqle){

            throw sqle;

        }
    }
}
