package ca.georgiancollege.comp1011winter2023morning;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends BaseActivity {


    public String number1 = "", number2 = "";
    public String result = "";
    public String operator = "";

    public double number1Value, number2Value, resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }


    public void onButtonClick(View view){

        EditText viewResult = findViewById(R.id.result);

        Button current = findViewById(view.getId());
        String buttonText = current.getText().toString();

        switch (buttonText){


            case "+":
                operator = "+";
                number1 = viewResult.getText().toString();
                viewResult.setText("");

                break;
            case "/":
                operator = "/";
                number1 = viewResult.getText().toString();
                viewResult.setText("");
                break;
            case "*":
                operator = "*";
                number1 = viewResult.getText().toString();
                viewResult.setText("");
                break;
            case "-":
                operator = "-";
                number1 = viewResult.getText().toString();
                viewResult.setText("");
                break;

            case "=":
                if(number1.length() > 0 && number2.length() > 0){

                    number1Value = Double.parseDouble(number1);
                    number2Value = Double.parseDouble(number2);

                    switch (operator){
                        case "+":
                            resultValue = number1Value + number2Value;
                            break;
                        case "*":
                            resultValue = number1Value * number2Value;
                            break;
                        case "/":
                            resultValue = number1Value / number2Value;
                            break;
                        default:
                            resultValue = number1Value - number2Value;
                            break;

                    }
                    result = resultValue + "";
                    viewResult.setText(result);
                    result = "";
                    number1 = "";
                    number2 = "";
                    operator = "";

                }
                else{
                    result = "NaN";
                    resultValue = 0;
                    viewResult.setText(result);
                }
                break;
            case ".":
                if(number2.length() == 0){
                    number1 += ".";
                    viewResult.setText(number1);
                }
                else{
                    number2 += ".";
                    viewResult.setText(number2);
                }
            default:
                if(operator.length() == 0){
                    number1 += buttonText;
                    viewResult.setText(number1);
                }
                else{
                    number2 += buttonText;
                    viewResult.setText(number2);
                }

                break;
        }





        /*
        switch (view.getId()){


            case R.id.buttonadd:
                operator = "+";
                number1 = viewResult.getText().toString();
                viewResult.setText("");
                break;
            case R.id.buttondiv:
                operator = "/";
                number1 = viewResult.getText().toString();
                viewResult.setText("");
                break;
            case R.id.buttonmul:
                operator = "*";
                number1 = viewResult.getText().toString();
                viewResult.setText("");
                break;
            case R.id.buttonsub:
                operator = "-";
                number1 = viewResult.getText().toString();
                viewResult.setText("");
                break;

            case R.id.buttoneq:
                if(number1.length() > 0 || number2.length() > 0){

                    number1Value = Double.parseDouble(number1);
                    number2Value = Double.parseDouble(number2);

                    switch (operator){
                        case "+":
                            resultValue = number1Value + number2Value;
                            result = resultValue + "";
                            break;
                        case "*":
                            resultValue = number1Value * number2Value;
                            break;
                        case "/":
                            resultValue = number1Value / number2Value;
                            break;
                        default:
                            resultValue = number1Value - number2Value;
                            break;

                    }
                    result = resultValue + "";

                }
                else{
                    result = "NaN";
                    resultValue = 0;
                    viewResult.setText(result);
                }
                break;
            case R.id.buttondot:
                if(number2.length() == 0){
                    number1 += ".";
                    viewResult.setText(number1);
                }
                else{
                    number2 += ".";
                    viewResult.setText(number2);
                }
                case R.id.buttonno0:
                    currentButtonValue = "0";
                case R.id.buttonno1:
                    currentButtonValue = "1";
                case R.id.buttonno2:
                    currentButtonValue = "2";
                case R.id.buttonno3:
                    currentButtonValue = "3";
                case R.id.buttonno4:
                    currentButtonValue = "4";
                case R.id.buttonno5:
                    currentButtonValue = "5";
                case R.id.buttonno6:
                    currentButtonValue = "6";
                case R.id.buttonno7:
                    currentButtonValue = "7";
                case R.id.buttonno8:
                    currentButtonValue = "8";
                default:
                    currentButtonValue = "9";




        }



        if(currentButtonValue.length() > 0 && number2.length() == 0){
            number1 += currentButtonValue;
            viewResult.setText(number1);
            number1 = "";
        }
        else if(currentButtonValue.length() > 0 && number1.length() > 0){
            number2 += currentButtonValue;
            viewResult.setText(number2);
            number2 = "";
        }
    */
    }

}