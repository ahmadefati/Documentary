package com.androiddevs.base.data.viewModel;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = MainActivityViewModel.class
)
public interface MainActivityViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.androiddevs.base.data.viewModel.MainActivityViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(MainActivityViewModel_AssistedFactory factory);
}
