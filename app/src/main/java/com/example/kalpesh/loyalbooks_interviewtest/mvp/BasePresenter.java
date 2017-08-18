package com.example.kalpesh.loyalbooks_interviewtest.mvp;

/**
 * Created by kalpesh on 18/08/2017.
 */

public class BasePresenter<T extends MVPView> implements MVPPresenter<T> {

    private T view;
    @Override
    public void attachView(T mvpView) {
        view = mvpView;

    }

    @Override
    public void detachView() {
        view = null;
    }

    public T getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
        }
    }
}
