package com.example.recycleview.base;

import com.example.lib.base.BaseActivity;
import com.example.lib.presenter.IBasePresenter;

public class BaseMvpActivity<T extends IBasePresenter> extends BaseActivity<T> {
    @Override
    protected int attachLayoutRes() {
        return 0;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected  T createPresenter() {
        return null;
    }


    @Override
    public void loadComplete() {

    }
}
