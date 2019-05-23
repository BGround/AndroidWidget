package com.example.lib.presenter;


import com.example.lib.constant.IBaseView;
import com.example.lib.presenter.IBasePresenter;

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {
    protected  T mView;
    public BasePresenter(T t){
        mView = t;
    }


    @Override
    public void networkConnected() {

    }

    public abstract void networkConnect();

    public void destroy(){
        mView = null;
    }
}
