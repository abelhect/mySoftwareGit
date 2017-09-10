
package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**This is the method that increments the value to 3
     *
     */
    int quantity=1;
    public void increment(View view){
        if (quantity==100){
            Toast.makeText(this, "The maximum order is 100 cups", Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity+1;
        display(quantity);
    }
    /**This is the method that decrements the value to 1
     *
     */
    public void decrement(View view){
        if (quantity==1){
            Toast.makeText(this, "The minimum order is 1 cup", Toast.LENGTH_LONG).show();
            return;
        }
        quantity =quantity-1;
        display(quantity);
    }
    /**
     * Calculates the price of the order
     * @return total price
     * @param withCream is the input dollar for added cream
     * @param withChoco is the input dollar for added chocolate
     */
    private int calculatePrice(int withCream, int withChoco) {
        int realPrice = 5;
        return quantity * (realPrice + withCream + withChoco);
    }

    /**
     * Creates the message for order summary after submit order at check out
     * @param price is the input price needed for the summary
     * @param checked is the boolean that tells us if the whipped cream box is checked
     * @param checkedChocolate is the boolean that tells us if the chocolate box is checked
     * @return the message formulated to include details about the sale
     */
    private String createOrderSummary(String inputString, int price, boolean checked, boolean checkedChocolate){
        String priceMessage = "Name: " + inputString;
        priceMessage += "\nAdd whipped cream? " + checked;
        priceMessage += "\nAdd chocolate? " + checkedChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /*Create variable that checks if the checkbox state is enabled*/
        CheckBox whippedCreamCheck = (CheckBox)findViewById(R.id.checkBox);
        boolean checked = whippedCreamCheck.isChecked();
        CheckBox chocolateCheck = (CheckBox)findViewById(R.id.checkBoxChocolate);
        boolean checkedChocolate = chocolateCheck.isChecked();
        //if statement to test if we have cream
        int withCream;
        if(checked){
            withCream = 1;
        }else{
            withCream = 0;
        };
        int withChoco;
        //if statement to test if we have chocolate
        if(checkedChocolate){
            withChoco = 2;
        }else{
            withChoco = 0;
        };
        int price = calculatePrice(withCream, withChoco);
        EditText inputVar = (EditText) findViewById(R.id.etName);
        String inputString = inputVar.getText().toString();

        //replace the displayMessage with intent

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order Receipt Summary");
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(inputString, price, checked,
                checkedChocolate));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        // Create the text message with a string
        // displayMessage(createOrderSummary(inputString, price, checked, checkedChocolate));
    }

    /**
     * This method displays the given text on the screen.
     */
    /*private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int newNumber) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + newNumber);
    }



}