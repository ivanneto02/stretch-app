package com.ivanneto.zenflex

import androidx.navigation.NavController
import com.ivanneto.zenflex.databinding.FragmentWelcomeBinding

class WelcomeFragmentListeners(
    private val binding: FragmentWelcomeBinding,
    private val navController: NavController) {

    /* Sets up all the listeners for WelcomeFragment */
    fun setup() {
        welcomeFragmentListener();
    }

    /* Sets up the button as a navigation button */
    private fun welcomeFragmentListener() {
        binding.welcomeFragmentContinueButton.setOnClickListener {
            navController.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

}