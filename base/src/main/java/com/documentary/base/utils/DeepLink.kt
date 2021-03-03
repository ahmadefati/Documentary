package com.documentary.base.utils

import android.net.Uri
import androidx.core.net.toUri

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
 *
 */
class DeepLink(
    val module: String,
    val fragment: String,
    private val args: Array<Any>? = null
) {
    private constructor(
        builder: Builder
    ) : this(builder.module, builder.fragment, builder.args)

    class Builder {
        var module: String = ""
            private set

        var fragment: String = ""
            private set

        var args: Array<Any>? = null
            private set

        fun module(module: String) = apply { this.module = module }

        fun fragment(fragment: String) = apply { this.fragment = fragment }

        fun args(args: Array<Any>) = apply { this.args = args }

        fun build() = DeepLink(this)
    }

    val uri: Uri
        get() {
            var result = "app.merat://$module/$fragment"

            args?.forEach {
                result += "/$it"
            }

            return result.toUri()
        }
}