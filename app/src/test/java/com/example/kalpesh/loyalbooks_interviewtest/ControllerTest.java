package com.example.kalpesh.loyalbooks_interviewtest;

import com.example.kalpesh.loyalbooks_interviewtest.mvp.BasePresenter;
import com.example.kalpesh.loyalbooks_interviewtest.mvp.ILoyalBooks_Contract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by kalpesh on 18/08/2017.
 */

public class ControllerTest {


    @Mock
    ILoyalBooks_Contract.ILoyalBooksListOutput mockView;

    @Mock
    Controller mockPresenter;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockView = mock(ILoyalBooks_Contract.ILoyalBooksListOutput.class);
        mockPresenter = new Controller();
        mockPresenter.attachView(mockView);
    }


    @Test
    public void noInteractionsWithViewShouldTakePlaceIfUserIsNull() {
        // user object is not initialized, lets verify no interactions take place
        verifyZeroInteractions(mockView);
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException.class)
    public void search_NotAttached_ThrowsMvpException() {
        mockPresenter.detachView();
        mockPresenter.getOutput();
        verify(mockView, never()).onFetchDataStarted();
    }

   
}
