package com.example.wwh_test.presenter;


import com.example.wwh_test.Bean;
import com.example.wwh_test.NetCallBack;
import com.example.wwh_test.model.NetModle;
import com.example.wwh_test.view.NetView;

public class NetPresenter implements NetCallBack {
    private NetModle netModle;
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
