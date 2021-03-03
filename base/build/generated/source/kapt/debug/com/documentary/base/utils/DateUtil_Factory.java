package com.documentary.base.utils;

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
public final class DateUtil_Factory implements Factory<DateUtil> {
  @Override
  public DateUtil get() {
    return newInstance();
  }

  public static DateUtil_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DateUtil newInstance() {
    return new DateUtil();
  }

  private static final class InstanceHolder {
    private static final DateUtil_Factory INSTANCE = new DateUtil_Factory();
  }
}
