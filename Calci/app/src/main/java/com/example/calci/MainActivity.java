package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */

    boolean hasWhippedCream=false;
    boolean hasChocolate=false;

    int quantity=0;
    public void increment(View view){
        quantity=quantity+1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if(quantity>0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    int whippedPrice=0;
    int chocoPrice=0;
    public void submitOrder(View view) {
        CheckBox checkBox=(CheckBox)findViewById(R.id.whipped) ;
        CheckBox chocoCheckbox=(CheckBox)findViewById(R.id.Choco);
        hasChocolate=chocoCheckbox.isChecked();
        hasWhippedCream=checkBox.isChecked();
        EditText name=(EditText)findViewById(R.id.plain_text_input);
        String uName=name.getText().toString();
        if(hasChocolate){
            chocoPrice=quantity*2;
        }
        else{
            chocoPrice=0;
        }
        if(hasWhippedCream){
            whippedPrice=quantity;
        }
        else {
            whippedPrice=0;
        }

        String str=createOrderSummary(uName);
//        displayMessage(str);
        String subject="Coffee Ordering";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, str);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice() {
        return (quantity * 5)+chocoPrice+whippedPrice;
    }

    public String createOrderSummary(String name){
        return  " Name: "+name+"\n Add whipped cream? "+hasWhippedCream+"\n Add chocolate? "+hasChocolate+"\n Quantity: "+quantity+"\n Total price: $"+calculatePrice();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}