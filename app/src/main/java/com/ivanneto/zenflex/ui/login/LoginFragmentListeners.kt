package com.ivanneto.zenflex.ui.login

import androidx.navigation.NavController
import com.ivanneto.zenflex.R
import com.ivanneto.zenflex.databinding.FragmentLoginBinding

class LoginFragmentListeners(
    private val binding: FragmentLoginBinding,
    private val navController: NavController) {

    /* Sets up all the listeners for WelcomeFragment */
    fun setup() {
        loginFragmentListener();
    }

    /* Sets up the button as a navigation button */
    private fun loginFragmentListener() {
        binding.skipSignIn.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_menuFragment)
        }
    }

}