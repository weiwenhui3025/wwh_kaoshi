package com.example.lx.interfaces;
//定义一个关联v层的接口
//定义一个v层接口的泛型类
public interface IBasePersenter<V extends IBaseView> {
    void attachView(V view);
    void detachView();
}
