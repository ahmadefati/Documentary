package com.androiddevs.view

import android.app.Dialog
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import com.androiddevs.ui.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelDialog(
    @StringRes private val title: Int,
    @StringRes private val desc: Int
) : DialogFragment() {

    private var yesListener: (() -> Unit)? = null

    fun setOnYesListener(listener: () -> Unit) {
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle(title)
            .setMessage(desc)
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes") { _, _ ->
                yesListener?.invoke()
            }
            .setNegativeButton("No") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()
    }

}