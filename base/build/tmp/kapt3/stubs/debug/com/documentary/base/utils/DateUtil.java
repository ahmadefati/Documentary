package com.documentary.base.utils;

import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/documentary/base/utils/DateUtil;", "", "()V", "persianDate", "Lsaman/zamani/persiandate/PersianDate;", "persianDateFormat", "Lsaman/zamani/persiandate/PersianDateFormat;", "addDay", "", "value", "", "addMonth", "month", "addYear", "addYearToPersianDate", "dateDifferenceToDate", "date1", "differenceOfDates", "date2", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "getToday", "isToday", "", "date", "toDateView", "toDateViewWhitDash", "toDateViewWhitoutYear", "toTimeView", "time", "base_debug"})
@javax.inject.Singleton()
public final class DateUtil {
    private final saman.zamani.persiandate.PersianDateFormat persianDateFormat = null;
    private final saman.zamani.persiandate.PersianDate persianDate = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toDateView(@org.jetbrains.annotations.Nullable()
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toDateViewWhitoutYear(@org.jetbrains.annotations.Nullable()
    java.lang.String date) {
        return null;
    }
    
    private final java.lang.String toDateViewWhitDash(java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toTimeView(@org.jetbrains.annotations.Nullable()
    java.lang.String time) {
        return null;
    }
    
    public final boolean isToday(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final saman.zamani.persiandate.PersianDate addMonth(int month) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer differenceOfDates(@org.jetbrains.annotations.NotNull()
    java.lang.String date1, @org.jetbrains.annotations.NotNull()
    java.lang.String date2) {
        return null;
    }
    
    public final int dateDifferenceToDate(@org.jetbrains.annotations.Nullable()
    java.lang.String date1) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String addDay(int value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String addYear(int value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final saman.zamani.persiandate.PersianDate addYearToPersianDate(int value) {
        return null;
    }
    
    @javax.inject.Inject()
    public DateUtil() {
        super();
    }
}