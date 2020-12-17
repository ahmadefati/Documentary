package com.documentary.base.extensions;

import kotlinx.coroutines.*;
import kotlinx.coroutines.flow.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aJ\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00022)\b\u0004\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013\u00a2\u0006\u0002\b\u0016H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u001a\'\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0019\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u0002H\u0010\u00a2\u0006\u0002\u0010\u001d\u001aD\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00022)\b\u0004\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013\u00a2\u0006\u0002\b\u0016H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u001ag\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H!0\u0019\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010!*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u001927\u0010\"\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u0010\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0\u00190\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%\u001aa\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H!0\u0019\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010!*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u001921\u0010\"\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0010\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%\"!\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"deferreds", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/Deferred;", "getDeferreds", "()Ljava/util/concurrent/ConcurrentHashMap;", "deferredsCleanLaunched", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getDeferredsCleanLaunched", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "jobs", "Lkotlinx/coroutines/Job;", "getJobs", "jobsCleanLaunched", "getJobsCleanLaunched", "asyncOrAwait", "T", "key", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayFlow", "Lkotlinx/coroutines/flow/Flow;", "timeout", "", "value", "(JLjava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "launchOrJoin", "", "flatMapLatestNullable", "R", "transform", "Lkotlin/ParameterName;", "name", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "mapNullable", "base_debug"})
public final class CoroutineExtensionsKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.Object, kotlinx.coroutines.Deferred<?>> deferreds = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.atomic.AtomicBoolean deferredsCleanLaunched = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.Object, kotlinx.coroutines.Job> jobs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.atomic.AtomicBoolean jobsCleanLaunched = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, R extends java.lang.Object>kotlinx.coroutines.flow.Flow<R> flatMapLatestNullable(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends T> $this$flatMapLatestNullable, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends java.lang.Object> transform) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, R extends java.lang.Object>kotlinx.coroutines.flow.Flow<R> mapNullable(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends T> $this$mapNullable, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> transform) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.Object, kotlinx.coroutines.Deferred<?>> getDeferreds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.concurrent.atomic.AtomicBoolean getDeferredsCleanLaunched() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object asyncOrAwait(@org.jetbrains.annotations.NotNull()
    java.lang.Object key, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> action, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super T> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.Object, kotlinx.coroutines.Job> getJobs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.concurrent.atomic.AtomicBoolean getJobsCleanLaunched() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object launchOrJoin(@org.jetbrains.annotations.NotNull()
    java.lang.Object key, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> action, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>kotlinx.coroutines.flow.Flow<T> delayFlow(long timeout, T value) {
        return null;
    }
}