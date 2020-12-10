package com.androiddevs.base.data.viewModel;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class MainActivityViewModel_AssistedFactory implements ViewModelAssistedFactory<MainActivityViewModel> {
  @Inject
  MainActivityViewModel_AssistedFactory() {
  }

  @Override
  @NonNull
  public MainActivityViewModel create(SavedStateHandle arg0) {
    return new MainActivityViewModel();
  }
}
