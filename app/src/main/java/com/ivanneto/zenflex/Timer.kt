package com.ivanneto.zenflex
import android.os.CountDownTimer

class Timer(
    private val mainActivityListener: MainActivityTimerListener,
    private val timeForStretch: Long,
    private val timeForRest: Long) {

    // keeps track of whether we should stop or continue
    private var stretchingSequenceOn: Boolean = false;

    // starting timer
    private var startingCooldownTimer: CountDownTimer? = null;

    // keep track of stretch and rest timing
    private var stretchTimer: CountDownTimer? = null;
    private var restTimer: CountDownTimer? = null;

    // keep track of cooldown timing
    private var stretchCooldownTimer: CountDownTimer? = null;
    private var restCooldownTimer: CountDownTimer? = null;

    /* Handles the timer for the gap between pressing the button and
    * starting the stretch. Iterates */
    fun startTimer() : Boolean {
        println("[Timer] starting Timer")

        // Makes sure the internal state is true
        stretchingSequenceOn = true;

        // will time the starting timer before stretching. TODO: figure out the timing. right now it's 3
        // TODO: seconds and ticking happens every 200ms
        startingCooldownTimer = object : CountDownTimer(3000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                if (stretchingSequenceOn) {
                    println("[Timer] ticking starting timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                startStretchTimer();
            }
        }

        // Starts the timer at the beginning to track wait time before stretching
        startingCooldownTimer?.start()

        // Calls UI updates as we start this timer
        mainActivityListener.onTimerSequenceStarted();

        return true;
    }

    /* Turns off the timer entirely, goes back to the beginning mode. Signals
    * to the mainActivityListener to handle UI changes */
    fun stopTimer() : Boolean {

        println("[Timer] stopping Timer entirely")

        // Makes sure the internal state is false, stops both the
        // beginning timer and the stretching timers
        stretchingSequenceOn = false;

        stretchTimer?.cancel();
        restTimer?.cancel();

        // calls UI updates when the timer stops
        mainActivityListener.onTimerSequenceStopped();

        return true;
    }

    /* Timer actually times the stretch. It runs for timeForStretch seconds and ticks every 200ms */
    fun startStretchTimer() : Boolean {

        // STUB: TODO
        println("[Timer] starting stretch timer.")

        // will time the stretching
        stretchTimer = object : CountDownTimer(timeForStretch * 1000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                if (stretchingSequenceOn) {
                    println("[Timer] ticking stretch timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                stopStretchTimer();
            }
        }
        stretchTimer?.start()

        // Notify listener
        mainActivityListener.onStretchTimerStarted();

        return true;
    }

    /* Stops the stretch timer, takes 3 seconds */
    fun stopStretchTimer() : Boolean {

        // STUB: TODO
        println("[Timer] stopping stretch timer.")

        // will time the stretch cooldown
        stretchCooldownTimer = object : CountDownTimer(3000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO("Will need to check if we have to stop")
                if (stretchingSequenceOn) {
                    println("[Timer] ticking stretchcooldown timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                startRestTimer();
            }
        }
        stretchCooldownTimer?.start()

        // Notify listener
        mainActivityListener.onStretchTimerStopped();

        return true;
    }

    /* Starts the rest timer, runs timeForRest seconds and ticks on intervals of 200ms */
    fun startRestTimer() : Boolean {

        // STUB: TODO
        println("[Timer] starting rest timer.")

        restTimer = object : CountDownTimer(timeForRest * 1000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO("Will need to check if we have to stop")
                if (stretchingSequenceOn) {
                    println("[Timer] ticking rest timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                stopRestTimer();
            }

        }
        restTimer?.start();

        // Notify listener
        mainActivityListener.onRestTimerStarted();

        return true;
    }

    /* Stops the rest timer, takes 3 seconds */
    fun stopRestTimer() : Boolean {
        // STUB: TODO
        println("[Timer] stopping rest timer.")

        // will time the stretch cooldown
        restCooldownTimer = object : CountDownTimer(3000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO("Will need to check if we have to stop")
                if (stretchingSequenceOn) {
                    println("[Timer] ticking restcooldown timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                startStretchTimer();
            }
        }
        restCooldownTimer?.start()

        // Notify listener
        mainActivityListener.onRestTimerStopped();

        return true;
    }

}