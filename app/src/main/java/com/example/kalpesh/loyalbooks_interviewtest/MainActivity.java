package com.example.kalpesh.loyalbooks_interviewtest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.kalpesh.loyalbooks_interviewtest.mvp.ILoyalBooks_Contract;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements ILoyalBooks_Contract.ILoyalBooksListOutput{
    @Inject
    Controller controllerPresenter;

    @BindView(R.id.tvOccurence)
    TextView mOccurence;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        InitializeDagger();
        InitializeProgressBar();
        mOccurence.setMovementMethod(new ScrollingMovementMethod());
      //  controllerPresenter= new Controller();
        controllerPresenter.attachView(this);
        controllerPresenter.getOutput();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        controllerPresenter.detachView();
    }

    /**
     * Injecting presenter using Dagger
     */
    public void InitializeDagger(){
        ((MyApplication)this.getApplication()).getiPresenterComponent().inject(this);
    }

    @Inject
    public void setController(Controller controllerPresenter){
        this.controllerPresenter= controllerPresenter;
    }
    public void InitializeProgressBar(){
        progressDialog= new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loadMsg));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();}


    @Override
    public void onFetchDataSuccess(Map<String, Integer> occurrences) {

        StringBuilder builder = new StringBuilder();
        for (String word : occurrences.keySet()) {
            builder.append(word+"            " + occurrences.get(word) +"      " + " Prime? : " + controllerPresenter.isPrime(occurrences.get(word))+ "\n");
        }
        mOccurence.setText(builder.toString());
        dismissProgressView();

    }
    private void dismissProgressView(){
        if(progressDialog.isShowing()|| progressDialog!=null)
            progressDialog.dismiss();
    }
}
