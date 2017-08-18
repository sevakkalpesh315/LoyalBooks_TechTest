package com.example.kalpesh.loyalbooks_interviewtest.injection;

import com.example.kalpesh.loyalbooks_interviewtest.MainActivity;

import dagger.Component;

/**
 * Created by kalpesh on 18/08/2017.
 */

@PerActivity
@Component(dependencies = {Presenter_Module.class})
public interface IPresenterComponent {

    void inject(MainActivity weatherList);

}
