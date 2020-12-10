package com.documentary.base.extensions;

import com.documentary.base.data.entities.ErrorResult;
import com.documentary.base.data.entities.Result;
import com.documentary.base.data.entities.Success;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import java.io.IOException;

@kotlin.Suppress(names = {"NOTHING_TO_INLINE"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0086\b\u001a\u001e\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0007H\u0086\b\u00a2\u0006\u0002\u0010\b\u001aU\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00010\u0010H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001aO\u0010\u0012\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\n2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00010\u0010H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0007H\u0086\b\u001a\u0019\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0007H\u0086\b\u001a\u0019\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0007H\u0086\b\u001a\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0019\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0007H\u0086\b\u001aQ\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u00060\u00072\"\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0019\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u0007H\u0086\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"defaultShouldRetry", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "bodyOrThrow", "T", "Lretrofit2/Response;", "(Lretrofit2/Response;)Ljava/lang/Object;", "executeWithRetry", "Lretrofit2/Call;", "defaultDelay", "", "maxAttempts", "", "shouldRetry", "Lkotlin/Function1;", "(Lretrofit2/Call;JILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchBodyWithRetry", "firstDelay", "isFromCache", "isFromNetwork", "toException", "Lretrofit2/HttpException;", "toResult", "Lcom/documentary/base/data/entities/Result;", "E", "mapper", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lretrofit2/Response;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toResultUnit", "", "base_debug"})
public final class RetrofitExtensionsKt {
    
    public static final <T extends java.lang.Object>T bodyOrThrow(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$bodyOrThrow) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>retrofit2.HttpException toException(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$toException) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object executeWithRetry(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<T> $this$executeWithRetry, long defaultDelay, int maxAttempts, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Exception, java.lang.Boolean> shouldRetry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<T>> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object fetchBodyWithRetry(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<T> $this$fetchBodyWithRetry, long firstDelay, int maxAttempts, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Exception, java.lang.Boolean> shouldRetry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super T> p4) {
        return null;
    }
    
    public static final boolean defaultShouldRetry(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception) {
        return false;
    }
    
    public static final <T extends java.lang.Object>boolean isFromNetwork(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$isFromNetwork) {
        return false;
    }
    
    public static final <T extends java.lang.Object>boolean isFromCache(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$isFromCache) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>com.documentary.base.data.entities.Result<kotlin.Unit> toResultUnit(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$toResultUnit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>com.documentary.base.data.entities.Result<T> toResult(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$toResult) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.Suppress(names = {"REDUNDANT_INLINE_SUSPEND_FUNCTION_TYPE"})
    public static final <T extends java.lang.Object, E extends java.lang.Object>java.lang.Object toResult(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$toResult, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super E>, ? extends java.lang.Object> mapper, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.documentary.base.data.entities.Result<E>> p2) {
        return null;
    }
}