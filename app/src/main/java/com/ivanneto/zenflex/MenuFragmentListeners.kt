package com.ivanneto.zenflex

import androidx.navigation.NavController
import com.ivanneto.zenflex.databinding.FragmentMenuBinding

class MenuFragmentListeners(
    private val binding: FragmentMenuBinding,
    private val navController: NavController) {

    /* Sets up all the listeners for WelcomeFragment */
    fun setup() {
        menuFragmentListeners();
    }

    /* Sets up the button as a navigation button */
    private fun menuFragmentListeners() {
        binding.menuFragmentExercisesButton.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_exerciseItemFragment)
        }
        binding.menuFragmentSettingsButton.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_settingsFragment)
        }
        binding.menuFragmentDonateButton.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_donateFragment)
        }
    }
}