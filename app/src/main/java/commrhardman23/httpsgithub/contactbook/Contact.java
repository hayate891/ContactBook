package commrhardman23.httpsgithub.contactbook;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Contact is a class that includes a name, phone number, and e-mail address for a contact stored
 * in a phone.
 * Created by scott-hardman on 16-03-19.
 */
public class Contact implements Parcelable {

    private String name = "";
    private String phone = "";
    private String email = "";

    /**
     * Contact is a constructor that affects the name, phone, and e-mail information for the
     * contact
     * @param nameInput is the name passed by the user
     * @param phoneInput is the phone number passed by the user
     * @param emailInput is the e-mail address passed by the user
     */
    public Contact(String nameInput, String phoneInput, String emailInput){
        this.name = nameInput;
        this.phone = phoneInput;
        this.email = emailInput;
    }

    /**
     * This is the constructor to demarshal (unpack) information that is stored in a Parcel
     * containing all the information for the contact
     * @param in is the parcel that contains all the information for the contact from the
     *           marshaling process
     */
    public Contact(Parcel in){

        readFromParcel(in);

    }

    /**
     * getName is the getter method for the name variable
     * @return the name of the contact
     */
    public String getName(){
        return name;
    }

    /**
     * getPhone is the getter method for the phone variable
     * @return the phone number of the contact
     */
    public String getPhone(){
        return phone;
    }

    /**
     * getEmail is the getter method for the email variable
     * @return the e-mail address of the contact
     */
    public String getEmail(){
        return email;
    }

    /**
     * describeContents is a method that must be created when implementing the Parcelable
     * interface, but does not need to be altered
     * @return an integer as a code for the contents of the parcel
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * writeToParcel adds the information from the Contact object to a Parcel so that the
     * information can be transferred between Intents.
     * @param dest is the Parcel to be written to
     * @param flags describes how the informations should be written to the Parcel
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(email);
    }

    /**
     * readFromParcel allows information about Contacts to be taken from a Parcel received from
     * another part of the application and set into the variables of the Contact object
     * @param in is the Parcel that contains information about the Contact
     */
    private void readFromParcel(Parcel in){
        name = in.readString();
        phone = in.readString();
        email = in.readString();
    }

    /**
     * CREATOR helps to create new Contacts from Parcels and create newArrays of Contacts from
     * Parcelable objects
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Contact>() {
        public Contact createFromParcel(Parcel in){
            return new Contact(in);
        }

        public Contact[] newArray(int size){
            return new Contact[size];
        }

    };
}
