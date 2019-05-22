package com.example.youfeadaway.banmi.base;

import android.view.View;

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends SimplActivity {

    public P presenter;

    @Override
    public void createView(View inflate) {        presenter = createPresenter();
        presenter.bind((V) this);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter == null) {
            presenter.destoryView();
            presenter = null;
        }
    }
}
