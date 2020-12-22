package com.documentary.common_databinding.databinding

import android.content.res.Resources
import android.graphics.Outline
import android.graphics.Typeface
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.documentary.common_databinding.R
import kotlin.math.roundToInt

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {

    val options: RequestOptions = RequestOptions()
        .error(R.mipmap.ic_launcher)
    Glide.with(view.context)
        .load(imageUrl)
        .apply(options)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}

@BindingAdapter("visibleIfNotNull")
fun visibleIfNotNull(view: View, target: Any?) {
    view.isVisible = target != null
}

@BindingAdapter("visible")
fun visible(view: View, value: Boolean) {
    view.isVisible = value
}

@BindingAdapter("textOrGoneIfEmpty")
fun textOrGoneIfEmpty(view: TextView, s: CharSequence?) {
    view.text = s
    view.isGone = s.isNullOrEmpty()
}

@BindingAdapter("goneIfNull")
fun goneIfNull(view: View, value: Any?) {
    view.isGone = value == null
}

@BindingAdapter("srcRes")
fun imageViewSrcRes(view: ImageView, drawableRes: Int) {
    if (drawableRes != 0) {
        view.setImageResource(drawableRes)
    } else {
        view.setImageDrawable(null)
    }
}

@BindingAdapter("topCornerOutlineProvider")
fun topCornerOutlineProvider(view: View, oldRadius: Float, radius: Float) {
    view.clipToOutline = true
    if (oldRadius != radius) {
        view.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height + radius.roundToInt(), radius)
            }
        }
    }
}

@BindingAdapter("roundedCornerOutlineProvider")
fun roundedCornerOutlineProvider(view: View, oldRadius: Float, radius: Float) {
    view.clipToOutline = true
    if (oldRadius != radius) {
        view.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, radius)
            }
        }
    }
}

/*@BindingAdapter("textAppearanceAttr")
fun textAppearanceAttr(
    view: TextView,
    oldTextAppearanceStyleAttr: Int,
    textAppearanceStyleAttr: Int
) {
    if (oldTextAppearanceStyleAttr != textAppearanceStyleAttr) {
        view.setTextAppearance(view.context.resolveThemeReferenceResId(textAppearanceStyleAttr))
    }
}*/

@BindingAdapter("fontFamily")
fun fontFamily(view: TextView, oldFontFamily: Int, fontFamily: Int) {
    if (oldFontFamily != fontFamily) {
        view.typeface = try {
            ResourcesCompat.getFont(view.context, fontFamily)
        } catch (nfe: Resources.NotFoundException) {
            null
        } ?: Typeface.DEFAULT
    }
}
