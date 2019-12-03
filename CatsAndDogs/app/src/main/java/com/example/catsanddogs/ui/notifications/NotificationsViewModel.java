package com.example.catsanddogs.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.catsanddogs.ui.Repository;

public class NotificationsViewModel extends ViewModel {

    Repository repository = new Repository();

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment"+ "\n"
                + repository.getRandom());
    }

    public LiveData<String> getText() {
        return mText;
    }
}