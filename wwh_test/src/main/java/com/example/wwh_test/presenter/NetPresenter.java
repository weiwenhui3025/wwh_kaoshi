package com.example.cs_demo.presenter;

import com.example.cs_demo.Bean;
import com.example.cs_demo.NetCallBack;
import com.example.cs_demo.model.NetModle;
import com.example.cs_demo.view.NetView;

import java.util.List;

public class NetPresenter implements NetCallBack {
    private  NetModle netModle;
    private NetView view;

    public NetPresenter(NetView view) {
        this.view = view;
        netModle = new NetModle();
    }

    @Override
    public void Secoss(Bean bean) {
        view.setData(bean);
    }

    @Override
    public void Faid(String str) {
            view.showToast(str);
    }
    public void getData() {
        netModle.getData(this);
    }
}
