package comexpencive.vk.cif057jsonserialization;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Настик on 18.12.2018.
 */

public class Employee {

    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("age")
    private int mAge;
    @SerializedName("mail")
    private String mMail;
    @SerializedName("adress")
    private Address mAddress;

    public Employee(String firstName, int age, String mail, Address address) {
        mFirstName = firstName;
        mAge = age;
        mMail = mail;
        mAddress = address;
    }
}
