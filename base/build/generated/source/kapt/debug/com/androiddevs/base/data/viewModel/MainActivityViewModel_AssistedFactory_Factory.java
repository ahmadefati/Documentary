package com.androiddevs.base.data.viewModel;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainActivityViewModel_AssistedFactory_Factory implements Factory<MainActivityViewModel_AssistedFactory> {
  @Override
  public MainActivityViewModel_AssistedFactory get() {
    return newInstance();
  }

  public static MainActivityViewModel_AssistedFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MainActivityViewModel_AssistedFactory newInstance() {
    return new MainActivityViewModel_AssistedFactory();
  }

  private static final class InstanceHolder {
    private static final MainActivityViewModel_AssistedFactory_Factory INSTANCE = new MainActivityViewModel_AssistedFactory_Factory();
  }
}
