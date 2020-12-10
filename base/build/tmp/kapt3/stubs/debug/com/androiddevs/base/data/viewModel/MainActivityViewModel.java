package com.androiddevs.base.data.viewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/androiddevs/base/data/viewModel/MainActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isLoginFragment", "", "()Z", "setLoginFragment", "(Z)V", "base_debug"})
public final class MainActivityViewModel extends androidx.lifecycle.ViewModel {
    private boolean isLoginFragment = false;
    
    public final boolean isLoginFragment() {
        return false;
    }
    
    public final void setLoginFragment(boolean p0) {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public MainActivityViewModel() {
        super();
    }
}