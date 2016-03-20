package commrhardman23.httpsgithub.contactbook;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class SearchForContact extends AppCompatActivity {

    EditText edtxtSearchName;
    TextView txtvwContactInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_contact);

        edtxtSearchName = (EditText) findViewById(R.id.edtxtSearchName);
        txtvwContactInfo = (TextView) findViewById(R.id.txtvwContactInfo);
    }

    /**
     * searchContact converts the passed array from Parcelable[] to Contact[] and loops through
     * the array to search for a specific contact's information and display it for the user
     *
     * @param vw is the button that the searchContact method is connected to
     */
    public void searchContact(View vw){

        String nameToSearch = edtxtSearchName.getText().toString();

        Parcelable[] interim = getIntent().getExtras().getParcelableArray("CONTACTS_ARRAY");

        Contact[] contacts = new Contact[interim.length];

        for(int i = 0; i < contacts.length; i++){
            contacts[i] = (Contact) interim[i];
        }

        String contactInfo = "";

        if(nameToSearch.isEmpty()){
            txtvwContactInfo.setText("You must enter a name to search for a contact!");
        } else {

            for(int j = 0; j < contacts.length; j++){

                if(contacts[j] != null && nameToSearch.equals(contacts[j].getName())){
                    contactInfo += String.format("The contact information for %s is:\nPhone: " +
                            "%s\nE-mail: %s\n\n", contacts[j].getName(), contacts[j].getPhone(),
                            contacts[j].getEmail());
                }

            }

            txtvwContactInfo.setText(contactInfo);

        }

    }
}
