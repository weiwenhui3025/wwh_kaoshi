package com.example.lx.common;

import android.text.TextUtils;


import com.example.lx.interfaces.IBaseView;

import io.reactivex.subscribers.ResourceSubscriber;

//失败消息的返回
public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private IBaseView mView;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(IBaseView view){
        mView = view;
    }

    protected CommonSubscriber(IBaseView view, String emsg){
        mView = view;
        errorMsg = emsg;
    }

    protected CommonSubscriber(IBaseView view, boolean isError){
        mView = view;
        isShowErrorState = isError;
    }

    protected CommonSubscriber(IBaseView view, String emsg, boolean isError){
        mView = view;
        errorMsg = emsg;
        isShowErrorState = isError;
    }

    @Override
    public void onError(Throwable t) {
        //LoadingUtil.getInstance().hideLoading();
        if(mView == null) return;
        if(errorMsg != null && TextUtils.isEmpty(errorMsg)){
            mView.showError(errorMsg);
        }
    }

    @Override
    public void onComplete() {
        //LoadingUtil.getInstance().hideLoading();
    }
}
