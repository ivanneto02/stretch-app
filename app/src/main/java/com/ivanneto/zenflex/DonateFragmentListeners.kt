package com.ivanneto.zenflex

import android.content.Intent
import com.ivanneto.zenflex.databinding.FragmentDonateBinding
import androidx.core.net.toUri
import androidx.fragment.app.FragmentActivity

class DonateFragmentListeners(
    private val binding: FragmentDonateBinding,
    private val activity: FragmentActivity?) {

    /* Sets up all the listeners for WelcomeFragment */
    fun setup() {
        donateFragmentListeners();
    }

    /* Sets up the button as a navigation button */
    private fun donateFragmentListeners() {
        binding.donateFragmentDonateButton.setOnClickListener {
            val uri = "https://paypal.me/ivannetodev".toUri();
            val browser = Intent(Intent.ACTION_VIEW, uri)
            activity?.startActivity(browser)
        }
    }
}