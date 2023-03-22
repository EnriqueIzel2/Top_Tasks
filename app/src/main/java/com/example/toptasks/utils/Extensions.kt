package com.example.toptasks.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.toptasks.R
import com.example.toptasks.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.initToolbar(toolbar: Toolbar) {
  (activity as AppCompatActivity).setSupportActionBar(toolbar)
  (activity as AppCompatActivity).title = ""
  (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
  toolbar.setNavigationOnClickListener { activity?.onBackPressedDispatcher?.onBackPressed() }
}

fun Fragment.showBottomSheet(
  titleDialog: Int? = null,
  titleButton: Int? = null,
  message: Int,
  onClick: () -> Unit = {}
) {
  val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
  val binding: BottomSheetBinding = BottomSheetBinding.inflate(layoutInflater, null, false)

  binding.bottomSheetTitle.text = getText(titleDialog ?: R.string.bottomSheet_title)
  binding.bottomSheetButton.text = getText(titleButton ?: R.string.bottomSheet_button_text)
  binding.bottomSheetMessage.text = getText(message)
  binding.bottomSheetButton.setOnClickListener {
    onClick()
    bottomSheetDialog.dismiss()
  }

  bottomSheetDialog.setContentView(binding.root)
  bottomSheetDialog.show()
}
