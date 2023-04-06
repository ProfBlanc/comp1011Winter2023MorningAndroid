package ca.georgiancollege.comp1011winter2023morning;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileManipulationActivity extends BaseActivity {

    //create file name

    private final String filename = "myfile1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manipulation);


        try{
            readFileContents();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Cannot read file", Toast.LENGTH_LONG).show();
        }

    }

    private void readFileContents() throws Exception{

        EditText output = findViewById(R.id.fileContents);

        StringBuilder sb = new StringBuilder();

        FileInputStream fis = openFileInput(filename);
        Scanner scanner = new Scanner(fis);

        while(scanner.hasNext()){
            sb.append(scanner.nextLine()).append("\n");
        }

        output.setText(sb.toString());

    }
    private void writeFileContents(String content) throws Exception{

        FileOutputStream fos = getApplicationContext().openFileOutput(filename, Context.MODE_APPEND);
        fos.write(content.getBytes());

    }

    public void onSaveClick(View view){

        EditText content = findViewById(R.id.contentToWrite);
        try {
            writeFileContents(content.getText().toString());
            content.setText("");
            Toast.makeText(getApplicationContext(), "Written successfully", Toast.LENGTH_LONG).show();

            readFileContents();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Could not write to file", Toast.LENGTH_LONG).show();
        }
    }
}