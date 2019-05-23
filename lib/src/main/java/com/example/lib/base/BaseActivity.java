package com.example.lib.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.example.lib.constant.IBaseView;
import com.example.lib.presenter.IBasePresenter;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


/**
 * @author:: wangjianchi
 * @time: 2017/11/23  14:41.
 * @description:
 */

public abstract class BaseActivity<T extends IBasePresenter> extends RxAppCompatActivity implements IBaseView {
    protected String TAG = "zhangya";
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TAG = getClass().getSimpleName();
        mPresenter = createPresenter();
        initContentView();
        if (isNeedButterKnife()){
//            ButterKnife.bind(this);
        }
        initOptions();
        initViews();
        if (allowBackgroundNull()){
            getWindow().setBackgroundDrawable(null);
        }
    }

    protected void initOptions(){

    }

    protected boolean allowBackgroundNull(){
        return false;
    }

    protected boolean isNeedButterKnife(){
        return true;
    }

    protected void initContentView(){
        setContentView(attachLayoutRes());
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    @LayoutRes
    protected abstract int attachLayoutRes();

    /**
     * 初始化视图控件
     */
    protected abstract void initViews();

    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract T createPresenter();


}
