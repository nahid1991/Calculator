package com.example.android.calculator;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    TextView reserve, firstAndResult, operator;
    Button one, two, three, four, five, six, seven, eight, nine, zero, add, subtract, multiply, division, equal, dot, mem, spill,
    allclear, back, plusminus, root, square, cube;
    String temp = "";
    double a = 0, b;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initialize();
        settingButton();
    }


    public void initialize(){
        reserve = (TextView) findViewById(R.id.reserve);
        firstAndResult = (TextView) findViewById(R.id.firstAndResult);
        operator = (TextView) findViewById(R.id.operator);

        allclear = (Button) findViewById(R.id.allClear);
        back = (Button) findViewById(R.id.backSpace);
        dot = (Button) findViewById(R.id.dot);
        mem = (Button) findViewById(R.id.memory);
        spill = (Button) findViewById(R.id.spill);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        add = (Button) findViewById(R.id.plus);
        subtract = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        division = (Button) findViewById(R.id.division);
        equal = (Button) findViewById(R.id.equal);
        plusminus = (Button) findViewById(R.id.plusminus);
        root = (Button) findViewById(R.id.root);
        square = (Button) findViewById(R.id.square);
        cube = (Button) findViewById(R.id.cube);
    }

    public void settingButton(){
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        division.setOnClickListener(this);
        plusminus.setOnClickListener(this);

        dot.setOnClickListener(this);
        mem.setOnClickListener(this);
        spill.setOnClickListener(this);

        allclear.setOnClickListener(this);
        back.setOnClickListener(this);
        equal.setOnClickListener(this);

        root.setOnClickListener(this);
        square.setOnClickListener(this);
        cube.setOnClickListener(this);
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
            Toast.makeText(this, "Hey you just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plusminus:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("-");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()>0){
                        Toast.makeText(this, "Please put the +/- in the beginning", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else{
                        firstAndResult.setText("-");
                        break;
                    }
                }



            case R.id.dot:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText(".");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(!firstAndResult.getText().toString().contains(".")){
                        if(firstAndResult.getText().toString().length()<=7){
                            firstAndResult.setText(firstAndResult.getText()+".");
                            break;
                        }
                        else{
                            Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    else if(firstAndResult.getText().toString().contains("."))
                    {
                        Toast.makeText(this, "You already have a . in your text", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            case R.id.zero:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("0");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"0");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            case R.id.one:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("1");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"1");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            case R.id.two:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("2");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"2");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            case R.id.three:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("3");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"3");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            case R.id.four:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("4");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"4");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            case R.id.five:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("5");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"5");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            case R.id.six:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("6");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"6");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            case R.id.seven:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("7");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"7");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            case R.id.eight:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("8");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"8");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            case R.id.nine:
                if(operator.getText().toString() == "="){
                    reserve.setText("");
                    firstAndResult.setText("9");
                    operator.setText("");
                    a=0;
                    b=0;
                    break;
                }
                else{
                    if(firstAndResult.getText().toString().length()<=7){
                        firstAndResult.setText(firstAndResult.getText()+"9");
                        break;
                    }
                    else{
                        Toast.makeText(this, "No more than 8 digits", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
//                    Plus
//                    Button
//                    Work
            case R.id.plus:
                try{
                    if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                        reserve.setText(firstAndResult.getText().toString());
                        operator.setText("+");
                        a = Double.parseDouble(firstAndResult.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString() == "="){
                        operator.setText("+");
                        reserve.setText(firstAndResult.getText().toString());
                        a = Double.parseDouble(reserve.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        b = Double.parseDouble(firstAndResult.getText().toString());
                        if(operator.getText().toString() == "+"){
                            result = a+b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }


                        else if(operator.getText().toString() == "-"){
                            result = a-b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }
                        else if(operator.getText().toString() == "✖"){
                            result = a*b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }

                        }
                        else{
                            if(b == 0){
                                Toast.makeText(this, "You cannot divide anything with zero", Toast.LENGTH_SHORT).show();
                                firstAndResult.setText("");
                                reserve.setText("");
                                operator.setText("");
                                a = 0;
                                b = 0;
                                break;
                            }
                            else{
                                result = a/b;
                                if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){
                                    reserve.setText(Double.toString(result));
                                }
                                else{
                                    Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                    a = 0;
                                    b = 0;
                                    operator.setText("");
                                    firstAndResult.setText("");
                                    reserve.setText("");
                                    break;
                                }

                            }
                        }
                        a = result;
                        firstAndResult.setText("");
                        operator.setText("+");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/"
                            || operator.getText().toString() == "=")){
                        operator.setText("+");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        operator.setText("+");
                        break;
                    }

                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            && operator.getText().toString().length() == 0){
                        operator.setText("+");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString().length() == 0){
                        firstAndResult.setText("");
                        operator.setText("+");
                        break;
                    }

                    else if(firstAndResult.getText().toString().contains("-") &&operator.getText().toString() == ""){
                        firstAndResult.setText("");
                        operator.setText("+");
                        break;
                    }
                }catch (RuntimeException e){
                    e.printStackTrace();
                }




//                    Minus
//                    Button
//                    Work



            case R.id.minus:
                try{
                    if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                        reserve.setText(firstAndResult.getText().toString());
                        operator.setText("-");
                        a = Double.parseDouble(firstAndResult.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString() == "="){
                        operator.setText("-");
                        reserve.setText(firstAndResult.getText().toString());
                        a = Double.parseDouble(reserve.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }

                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        b = Double.parseDouble(firstAndResult.getText().toString());
                        if(operator.getText().toString() == "+"){
                            result = a+b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }


                        else if(operator.getText().toString() == "-"){
                            result = a-b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }
                        else if(operator.getText().toString() == "✖"){
                            result = a*b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }

                        }
                        else{
                            if(b == 0){
                                Toast.makeText(this, "You cannot divide anything with zero", Toast.LENGTH_SHORT).show();
                                firstAndResult.setText("");
                                reserve.setText("");
                                operator.setText("");
                                a = 0;
                                b = 0;
                                break;
                            }
                            else{
                                result = a/b;
                                if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){
                                    reserve.setText(Double.toString(result));
                                }
                                else{
                                    Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                    a = 0;
                                    b = 0;
                                    operator.setText("");
                                    firstAndResult.setText("");
                                    reserve.setText("");
                                    break;
                                }

                            }
                        }
                        a = result;
                        firstAndResult.setText("");
                        operator.setText("-");
                        break;
                    }

                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/"
                            || operator.getText().toString() == "=")){
                        operator.setText("-");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        operator.setText("-");
                        break;
                    }

                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            && operator.getText().toString().length() == 0){
                        operator.setText("-");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString().length() == 0){
                        firstAndResult.setText("");
                        operator.setText("-");
                        break;
                    }


                    else if(firstAndResult.getText().toString().contains("-") &&operator.getText().toString() == ""){
                        firstAndResult.setText("");
                        operator.setText("-");
                        break;
                    }
                }catch (RuntimeException e){
                    e.printStackTrace();
                }





//                    Multiply
//                    Button
//                    Work

            case R.id.multiply:
                try{
                    if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                        reserve.setText(firstAndResult.getText().toString());
                        operator.setText("✖");
                        a = Double.parseDouble(firstAndResult.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString() == "="){
                        operator.setText("✖");
                        reserve.setText(firstAndResult.getText().toString());
                        a = Double.parseDouble(reserve.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        b = Double.parseDouble(firstAndResult.getText().toString());
                        if(operator.getText().toString() == "+"){
                            result = a+b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }


                        else if(operator.getText().toString() == "-"){
                            result = a-b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }
                        else if(operator.getText().toString() == "✖"){
                            result = a*b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }

                        }
                        else{
                            if(b == 0){
                                Toast.makeText(this, "You cannot divide anything with zero", Toast.LENGTH_SHORT).show();
                                firstAndResult.setText("");
                                reserve.setText("");
                                operator.setText("");
                                a = 0;
                                b = 0;
                                break;
                            }
                            else{
                                result = a/b;
                                if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){
                                    reserve.setText(Double.toString(result));
                                }
                                else{
                                    Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                    a = 0;
                                    b = 0;
                                    operator.setText("");
                                    firstAndResult.setText("");
                                    reserve.setText("");
                                    break;
                                }

                            }
                        }
                        a = result;
                        firstAndResult.setText("");
                        operator.setText("-");
                        break;
                    }

                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/"
                            || operator.getText().toString() == "=")){
                        operator.setText("✖");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        operator.setText("✖");
                        break;
                    }

                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            && operator.getText().toString().length() == 0){
                        operator.setText("✖");
                        break;
                    }



                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString().length() == 0){
                        firstAndResult.setText("");
                        operator.setText("✖");
                        break;
                    }

                    else if(firstAndResult.getText().toString().contains("-") &&operator.getText().toString() == ""){
                        firstAndResult.setText("");
                        operator.setText("✖");
                        break;
                    }
                }catch(RuntimeException e){
                    e.printStackTrace();
                }

//                    Division
//                    Button
//                    Work


            case R.id.division:
                try{
                    if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                        reserve.setText(firstAndResult.getText().toString());
                        operator.setText("/");
                        a = Double.parseDouble(firstAndResult.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString() == "="){
                        operator.setText("/");
                        reserve.setText(firstAndResult.getText().toString());
                        a = Double.parseDouble(reserve.getText().toString());
                        firstAndResult.setText("");
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        b = Double.parseDouble(firstAndResult.getText().toString());
                        if(operator.getText().toString() == "+"){
                            result = a+b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }


                        else if(operator.getText().toString() == "-"){
                            result = a-b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }
                        else if(operator.getText().toString() == "✖"){
                            result = a*b;
                            if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){

                                reserve.setText(Double.toString(result));
                            }
                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }

                        }
                        else{
                            if(b == 0){
                                Toast.makeText(this, "You cannot divide anything with zero", Toast.LENGTH_SHORT).show();
                                firstAndResult.setText("");
                                reserve.setText("");
                                operator.setText("");
                                a = 0;
                                b = 0;
                                break;
                            }
                            else{
                                result = a/b;
                                if(result > -Float.MAX_VALUE && result < Float.MAX_VALUE){
                                    reserve.setText(Double.toString(result));
                                }
                                else{
                                    Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                    a = 0;
                                    b = 0;
                                    operator.setText("");
                                    firstAndResult.setText("");
                                    reserve.setText("");
                                    break;
                                }

                            }
                        }
                        a = result;
                        firstAndResult.setText("");
                        operator.setText("/");
                        break;
                    }

                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() > 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/"
                            || operator.getText().toString() == "=")){
                        operator.setText("/");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            && operator.getText().toString().length() == 0){
                        operator.setText("/");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() == 0 &&reserve.getText().toString().length() == 0
                            &&(operator.getText().toString() == "+" || operator.getText().toString() == "-"||
                            operator.getText().toString() == "✖" || operator.getText().toString() == "/")){
                        operator.setText("/");
                        break;
                    }


                    else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0
                            &&operator.getText().toString().length() == 0){
                        firstAndResult.setText("");
                        operator.setText("/");
                        break;
                    }

                    else if(firstAndResult.getText().toString().contains("-") &&operator.getText().toString() == ""){
                        firstAndResult.setText("");
                        operator.setText("/");
                        break;
                    }
                }catch (RuntimeException e){
                    e.printStackTrace();
                }




//                All clear




            case R.id.allClear:
                firstAndResult.setText("");
                reserve.setText("");
                operator.setText("");
                temp = "";
                a = 0;
                b = 0;
                break;




//                Backspace

            case R.id.backSpace:
                if(firstAndResult.getText().toString().length() > 0){
                    firstAndResult.setText(firstAndResult.getText().toString().substring(0,
                            firstAndResult.getText().toString().length()-1));
                    break;
                }

                else if(operator.getText().toString() == "="){
                    Toast.makeText(this, "Cannot delete answer with DEL", Toast.LENGTH_SHORT).show();
                    break;
                }

                else{
                    Toast.makeText(this, "No input yet", Toast.LENGTH_SHORT).show();
                    break;
                }




//            Memory
            case R.id.memory:
                if(firstAndResult.getText().toString().length() > 0){
                    temp = firstAndResult.getText().toString();
                    Toast.makeText(this, temp+" has been saved in memory", Toast.LENGTH_SHORT).show();
                    break;

                }

                else{
                    Toast.makeText(this, "Nothing to memorize", Toast.LENGTH_SHORT).show();
                }




//                Spill memory
            case R.id.spill:
                if(temp != ""){
                    if(operator.getText().toString() == "="){
                        operator.setText("");
                        reserve.setText("");
                        firstAndResult.setText(temp);
                        a = 0;
                        b = 0;
                        break;
                    }
                    else{
                        firstAndResult.setText("");
                        firstAndResult.setText(temp);
                        break;
                    }
                }
                else if(temp.length()==0){
                    Toast.makeText(this, "Nothing was in the memory", Toast.LENGTH_SHORT).show();
                    break;
                }









            case R.id.root:
                try{
                    if(firstAndResult.getText().toString().length() > 0) {
                        reserve.setText("√"+firstAndResult.getText().toString());
                        a = Math.sqrt(Double.parseDouble(firstAndResult.getText().toString()));
                        firstAndResult.setText(Double.toString(a));
                        operator.setText("=");
                        a = 0;
                        b = 0;
                        Toast.makeText(this, "Before pressing √ make sure you keep the previous result in memory.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }

                    else if(firstAndResult.getText().toString().contains("-")) {
                        Toast.makeText(this, "Not possible to square root a negative number. " +
                                        "Before pressing √ make sure you keep the previous result in memory.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() == 0) {
                        Toast.makeText(this, "No input entered. Before pressing √ make sure you keep the previous result in memory.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                }catch(RuntimeException e) {
                    e.printStackTrace();
                }

            case R.id.square:
                try{
                    if(firstAndResult.getText().toString().length() > 0) {
                        reserve.setText("("+firstAndResult.getText().toString()+")"+"²");
                        a = Math.pow(Double.parseDouble(firstAndResult.getText().toString()), 2);
                        firstAndResult.setText(Double.toString(a));
                        operator.setText("=");
                        a = 0;
                        b = 0;
                        Toast.makeText(this, "Before pressing x² make sure you keep the previous result in memory.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() == 0) {
                        Toast.makeText(this, "No input entered. Before pressing x² make sure you keep the previous result in memory.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                }catch(RuntimeException e) {
                    e.printStackTrace();
                }

            case R.id.cube:
                try{
                    if(firstAndResult.getText().toString().length() > 0) {
                        reserve.setText("("+firstAndResult.getText().toString()+")"+"³");
                        a = Math.pow(Double.parseDouble(firstAndResult.getText().toString()), 3);
                        firstAndResult.setText(Double.toString(a));
                        operator.setText("=");
                        a = 0;
                        b = 0;
                        Toast.makeText(this, "Before pressing x³ make sure you keep the previous result in memory.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else if(firstAndResult.getText().toString().length() == 0) {
                        Toast.makeText(this, "No input entered. Before pressing x³ make sure you keep the previous result in memory.",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                }catch(RuntimeException e) {
                    e.printStackTrace();
                }














//                equals
            case R.id.equal:
                try{
                    if(operator.getText().toString() == "+"){
                        if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0){
                            b = Double.parseDouble(firstAndResult.getText().toString());
                            result = a+b;
                            if(result > -Float.MAX_VALUE && result <Float.MAX_VALUE){
                                reserve.setText(Double.toString(a) + "+" + Double.toString(b));
                                operator.setText("=");
                                firstAndResult.setText(Double.toString(result));
                                a = result;
                                break;
                            }

                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }
                        else if(firstAndResult.getText().toString().length() == 0 && reserve.getText().toString().length() > 0){
                            b = 0;
                            result = a+b;
                            reserve.setText(Double.toString(result));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                        else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                            b = Double.parseDouble(firstAndResult.getText().toString());
                            a = 0;
                            result = a+b;
                            reserve.setText(Double.toString(result));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                        else if(firstAndResult.getText().toString().length() == 0 && reserve.getText().toString().length() == 0){
                            b = 0;
                            a = 0;
                            result = a+b;
                            reserve.setText(Double.toString(result));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;

                        }
                    }


                    else if(operator.getText().toString() == "-"){
                        if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0){
                            b = Double.parseDouble(firstAndResult.getText().toString());
                            result = a-b;
                            if(result > -Float.MAX_VALUE && result <Float.MAX_VALUE){
                                reserve.setText(Double.toString(a) + "-" +Double.toString(b));
                                firstAndResult.setText(Double.toString(result));
                                operator.setText("=");
                                a = result;
                                break;
                            }

                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }
                        else if(firstAndResult.getText().toString().length() == 0 && reserve.getText().toString().length() > 0){
                            b = 0;
                            result = a-b;
                            reserve.setText(Double.toString(result));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                        else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                            a = 0;
                            b = Double.parseDouble(firstAndResult.getText().toString());
                            result = a-b;
                            reserve.setText(Double.toString(result));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                        else if(firstAndResult.getText().toString().length() == 0 && reserve.getText().toString().length() == 0){
                            a = 0;
                            b = 0;
                            result = a-b;
                            reserve.setText(Double.toString(result));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                    }




                    else if(operator.getText().toString() == "✖"){
                        if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0){
                            b = Double.parseDouble(firstAndResult.getText().toString());
                            result = a*b;

                            if(result > -Float.MAX_VALUE && result <Float.MAX_VALUE){
                                reserve.setText(Double.toString(a) + "✖" +Double.toString(b));
                                firstAndResult.setText(Double.toString(result));
                                operator.setText("=");
                                a = result;
                                break;
                            }

                            else{
                                Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                a = 0;
                                b = 0;
                                operator.setText("");
                                firstAndResult.setText("");
                                reserve.setText("");
                                break;
                            }
                        }
                        else if(firstAndResult.getText().toString().length() == 0 && reserve.getText().toString().length() > 0){
                            b = 0;
                            result = a*b;
                            reserve.setText(Double.toString(result));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                        else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                            b = Double.parseDouble(firstAndResult.getText().toString());
                            a = 0;
                            result = a*b;
                            reserve.setText(Double.toString(a) + "✖" +Double.toString(b));
                            firstAndResult.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                        else if(firstAndResult.getText().toString().length() == 0 && reserve.getText().toString().length() == 0){
                            b = 0;
                            a = 0;
                            reserve.setText(Double.toString(a) + "✖" +Double.toString(b));
                            result = a*b;
                            reserve.setText(Double.toString(result));
                            operator.setText("=");
                            a = result;
                            break;
                        }
                    }


                    else if(operator.getText().toString() == "/"){
                        if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() > 0){
                            if(Double.parseDouble(firstAndResult.getText().toString()) == 0){
                                Toast.makeText(this, "Cannot divide by zero (When you put nothing for division we count it as zero)",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            }
                            else{
                                b = Double.parseDouble(firstAndResult.getText().toString());

                                result = a/b;

                                if(result > -Float.MAX_VALUE && result <Float.MAX_VALUE){
                                    reserve.setText(Double.toString(a) + "/" +Double.toString(b));
                                    firstAndResult.setText(Double.toString(result));
                                    operator.setText("=");
                                    a = result;
                                    break;
                                }

                                else{
                                    Toast.makeText(this, "Calculation limit exceeded", Toast.LENGTH_SHORT).show();
                                    a = 0;
                                    b = 0;
                                    operator.setText("");
                                    firstAndResult.setText("");
                                    reserve.setText("");
                                    break;
                                }
                            }
                        }
                        else if(firstAndResult.getText().toString().length() == 0 && reserve.getText().toString().length() > 0){
                            Toast.makeText(this, "Cannot divide by zero (When you put nothing for division we count it as zero)",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if(firstAndResult.getText().toString().length() > 0 && reserve.getText().toString().length() == 0){
                            if(Double.parseDouble(firstAndResult.getText().toString()) > 0)
                            {
                                a = 0;
                                b = Double.parseDouble(firstAndResult.getText().toString());
                                reserve.setText(Double.toString(a) + "/" + Double.toString(b));
                                result = a/b;
                                firstAndResult.setText(Double.toString(result));
                                operator.setText("=");
                                a = result;
                                break;
                            }
                            else{
                                Toast.makeText(this, "Cannot divide by zero (When you put nothing for division we count it as zero)",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }

                    }


                    else if(operator.getText().toString().length() == 0){
                        Toast.makeText(this, "Nothing to calculate", Toast.LENGTH_SHORT).show();
                        break;
                    }


                    else if(operator.getText().toString() == "="){
                        Toast.makeText(this, "This is your answer", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }catch (RuntimeException io){
                    io.printStackTrace();
                }







        }
    }
}
