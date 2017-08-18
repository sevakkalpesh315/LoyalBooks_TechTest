package com.example.kalpesh.loyalbooks_interviewtest.injection;

import com.example.kalpesh.loyalbooks_interviewtest.Controller;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kalpesh on 18/08/2017.
 */

@Module
public class Presenter_Module {

    @Provides
    public Controller getInteractor(){
        return new Controller();
    }
}
