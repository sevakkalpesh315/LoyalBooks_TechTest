package com.example.kalpesh.loyalbooks_interviewtest.mvp;

import java.util.Map;

/**
 * Created by kalpesh on 18/08/2017.
 */

public interface ILoyalBooks_Contract {

    public interface ILoyalBooksListOutput extends MVPView{

        void onFetchDataSuccess(Map<String, Integer> s);

    }

    public interface ILoyalBooksPresenter extends MVPPresenter<ILoyalBooksListOutput>{
        void getOutput();
    }
}
