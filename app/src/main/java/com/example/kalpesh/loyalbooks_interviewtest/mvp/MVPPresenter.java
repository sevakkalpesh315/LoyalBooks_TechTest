package com.example.kalpesh.loyalbooks_interviewtest.mvp;

/**
 * Created by kalpesh on 18/08/2017.
 */

public interface MVPPresenter<V extends MVPView> {
    void attachView(V mvpview);
    void detachView();
}
