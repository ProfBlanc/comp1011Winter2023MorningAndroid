package ca.georgiancollege.comp1011winter2023morning;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    /*

        when creating menu
            1) Inflate menu
            2) Specify what happens when user selects a menu item
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;
        switch (item.getItemId()){


            case R.id.menu_cal:
                Toast.makeText(getApplicationContext(), "Calculator Selected", Toast.LENGTH_LONG).show();
                intent = new Intent(this, CalculatorActivity.class);
                startActivity(intent);

                break;
            case R.id.menu_fm:
                Toast.makeText(getApplicationContext(), "File Manipulation Selected", Toast.LENGTH_LONG).show();
                intent = new Intent(this, FileManipulationActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_pro:
                Toast.makeText(getApplicationContext(), "Profile Selected", Toast.LENGTH_LONG).show();
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;

            default:
                Toast.makeText(getApplicationContext(), "Unknown!", Toast.LENGTH_LONG).show();
                break;

        }

        return true;
    }




}
