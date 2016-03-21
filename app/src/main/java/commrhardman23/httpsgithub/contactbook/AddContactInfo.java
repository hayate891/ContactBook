package commrhardman23.httpsgithub.contactbook;

import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class AddContactInfo extends AppCompatActivity {

    private static Contact[] contactsArray = new Contact[10];
    private static int numContactsAdded = 0;
    private EditText edtxtName;
    private EditText edtxtPhone;
    private EditText edtxtEmail;
    private TextView txtvwError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact_info);

        edtxtName = (EditText) findViewById(R.id.edtxtName);
        edtxtPhone = (EditText) findViewById(R.id.edtxtPhone);
        edtxtEmail = (EditText) findViewById(R.id.edtxtEmail);

        txtvwError = (TextView) findViewById(R.id.txtvwError);

    }

    /**
     * addContact creates a new Contact object and adds it to the Contact array for storage
     * @param vw is the button that addContact is associated with
     */
    public void addContact(View vw){

        Contact contactToAdd;

        if(edtxtName.getText().equals("")){

            txtvwError.setText("You must enter a name to add a contact!");

        } else {

            if(numContactsAdded < contactsArray.length) {

                //creates a new Contact object to be added to the array
                contactToAdd = new Contact(edtxtName.getText().toString(),
                        edtxtPhone.getText().toString(), edtxtEmail.getText().toString());

                //adds the Contact to the array at the current index
                contactsArray[numContactsAdded] = contactToAdd;

                //increases the current index
                numContactsAdded++;

                //clears the Contact's information
                edtxtName.setText("");
                edtxtPhone.setText("");
                edtxtEmail.setText("");

                txtvwError.setText("Contact added successfully");

            } else {

                txtvwError.setText("You have maxed out the number of contacts you can store in " +
                        "your phone!");

            }

        }

        InputMethodManager inputManager = (InputMethodManager)
                this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(vw.getApplicationWindowToken(), 0);

    }

    /**
     * displaySearchActivity creates a new Intent to switch to the search activity and pass the
     * array of contacts to the search activity
     * @param vw is the button that this method is associated with
     */
    public void displaySearchActivity(View vw){

        Intent goToSearch = new Intent(this, SearchForContact.class);

        goToSearch.putExtra("CONTACTS_ARRAY", contactsArray);

        startActivity(goToSearch);

    }
}
