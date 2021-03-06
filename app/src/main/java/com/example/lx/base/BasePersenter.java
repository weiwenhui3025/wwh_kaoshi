package com.example.lx.base;



import com.example.lx.interfaces.IBasePersenter;
import com.example.lx.interfaces.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


//p层的实现基类，实现特征：
//1 关联和解绑V 层
//2  对网络请求对象进行背压式处理
public abstract class BasePersenter<V extends IBaseView> implements IBasePersenter<V> {
    protected V mView;
    //对V层进行弱引用
    WeakReference<V> weakReference;

    protected CompositeDisposable compositeDisposable;
    @Override
    public void attachView(V view) {
         weakReference = new WeakReference<>(view);
         mView = weakReference.get();
    }
    //把当前业务下的网络请求对象添加到compositeDisposable
    protected void addSubscribe(Disposable disposable){
        if(compositeDisposable==null){
            compositeDisposable=new CompositeDisposable();
            compositeDisposable.add(disposable);
        }
    }
    protected void unSubsoribe(){
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }

    @Override
    public void detachView() {
        this.mView=null;
    }
}
