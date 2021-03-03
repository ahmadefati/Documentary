package com.documentary.base.utils;

import android.net.Uri;

/**
 * This class follows Builder pattern and is responsible for building an deep link
 * using navigation component through the project.
 *
 * @property module, The name of the module and must be the exact name. for example : ui-files
 * @property fragment, The simple name of the fragment. for example : SubmitRequestFragment
 * @property args, It's an array of any thing for including inside of uri.
 *
 * Below, is a formula of uri that should be used inside of the graph
 * for defining an deeplink.
 *
 * app.merat://module name (all lower case)/fragment name (Pascal convention)/{argument1}/{argument2}
 *
 * The order of arguments passed through the [args] should be the exact order
 * inside of deeplink's definition in navigation.xml
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u00a2\u0006\u0002\u0010\nR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/documentary/base/utils/DeepLink;", "", "builder", "Lcom/documentary/base/utils/DeepLink$Builder;", "(Lcom/documentary/base/utils/DeepLink$Builder;)V", "module", "", "fragment", "args", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getFragment", "()Ljava/lang/String;", "getModule", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Builder", "base_debug"})
public final class DeepLink {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String module = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fragment = null;
    private final java.lang.Object[] args = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFragment() {
        return null;
    }
    
    public DeepLink(@org.jetbrains.annotations.NotNull()
    java.lang.String module, @org.jetbrains.annotations.NotNull()
    java.lang.String fragment, @org.jetbrains.annotations.Nullable()
    java.lang.Object[] args) {
        super();
    }
    
    private DeepLink(com.documentary.base.utils.DeepLink.Builder builder) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\tR0\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/documentary/base/utils/DeepLink$Builder;", "", "()V", "<set-?>", "", "args", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "", "fragment", "getFragment", "()Ljava/lang/String;", "module", "getModule", "([Ljava/lang/Object;)Lcom/documentary/base/utils/DeepLink$Builder;", "build", "Lcom/documentary/base/utils/DeepLink;", "base_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull()
        private java.lang.String module = "";
        @org.jetbrains.annotations.NotNull()
        private java.lang.String fragment = "";
        @org.jetbrains.annotations.Nullable()
        private java.lang.Object[] args;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getModule() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFragment() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object[] getArgs() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.documentary.base.utils.DeepLink.Builder module(@org.jetbrains.annotations.NotNull()
        java.lang.String module) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.documentary.base.utils.DeepLink.Builder fragment(@org.jetbrains.annotations.NotNull()
        java.lang.String fragment) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.documentary.base.utils.DeepLink.Builder args(@org.jetbrains.annotations.NotNull()
        java.lang.Object[] args) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.documentary.base.utils.DeepLink build() {
            return null;
        }
        
        public Builder() {
            super();
        }
    }
}