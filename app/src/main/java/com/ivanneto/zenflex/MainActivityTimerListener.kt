package com.ivanneto.zenflex

interface MainActivityTimerListener {
    fun onTimerSequenceStopped();
    fun onTimerSequenceStarted();
    fun onStretchTimerStarted();
    fun onStretchTimerStopped();
    fun onRestTimerStarted();
    fun onRestTimerStopped();
}