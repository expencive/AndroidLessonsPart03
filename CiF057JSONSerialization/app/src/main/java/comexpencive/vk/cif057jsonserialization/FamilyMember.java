package comexpencive.vk.cif057jsonserialization;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Настик on 19.12.2018.
 */

public class FamilyMember {
    @SerializedName("role")
    private String mRole;

    @SerializedName("age")
    private int mAge;

    public FamilyMember (String role, int age) {
        mRole = role;
        mAge = age;
    }

}
