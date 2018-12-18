package comexpencive.vk.cif057jsonserialization;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Настик on 18.12.2018.
 */

public class Address {
    @SerializedName("country")
    private  String mCountry;
    @SerializedName("city")
    private String mCity;

    public Address(String country, String city) {
        mCountry = country;
        mCity = city;
    }
}
