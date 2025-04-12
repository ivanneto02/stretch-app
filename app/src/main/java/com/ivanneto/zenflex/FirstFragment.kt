package com.ivanneto.zenflex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ivanneto.zenflex.databinding.FragmentFirstBinding
import android.media.MediaPlayer

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), MainActivityTimerListener {

    private var _binding: FragmentFirstBinding? = null;
    private var stretchingSequenceOn: Boolean = false;
    private var myTimer: Timer? = null;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binds button to the action I want
        binding.buttonStartStop.setOnClickListener {
            println("[FirstFragment] buttonStartStop clicked!")

            // Will turn on or off the stretching sequence
            stretchingSequenceOn = !stretchingSequenceOn;

            if (stretchingSequenceOn) {
                // Initialize timer and send start signal to timer
                myTimer = Timer(this, 20, 10);
                myTimer?.startTimer();
            }
            else {
                // Send the stop signal to timer
                myTimer?.stopTimer();
                myTimer = null;
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTimerSequenceStopped() {
        // change UI components
        binding.buttonStartStop.text = "START";
        binding.textViewFirst.text = "Click button to start your stretch";

        // play the sound for this action
        val audioID = resources.getIdentifier("finished1", "raw", context?.packageName);
        var mediaPlayer = MediaPlayer.create(context, audioID);
        mediaPlayer.start();
    }

    override fun onTimerSequenceStarted() {

        // change UI components
        binding.buttonStartStop.text = "STOP";
        binding.textViewFirst.text = "READY...";

        // play the sound for this action
        val audioID = resources.getIdentifier("starting1", "raw", context?.packageName);
        val mediaPlayer = MediaPlayer.create(context, audioID);
        mediaPlayer.start();

    }

    override fun onStretchTimerStarted() {
        println("[MainActivityTimerListener] stretch timer started")

        // change UI components
        binding.buttonStartStop.text = "STOP";
        binding.textViewFirst.text = "STRETCH";

        // play the sound for this action
        val audioID = resources.getIdentifier("stretch_now1", "raw", context?.packageName);
        var mediaPlayer = MediaPlayer.create(context, audioID);
        mediaPlayer.start();
    }

    override fun onStretchTimerStopped() {
        println("[MainActivityTimerListener] stretch timer stopped")

        // change UI components
        binding.textViewFirst.text = "STOP";

        // play the sound for this action
        val audioID = resources.getIdentifier("stretch_cooldown1", "raw", context?.packageName);
        var mediaPlayer = MediaPlayer.create(context, audioID);
        mediaPlayer.start();
    }

    override fun onRestTimerStarted() {
        println("[MainActivityTimerListener] rest timer started")

        // change UI components
        binding.textViewFirst.text = "REST";

        // play the sound for this action
        val audioID = resources.getIdentifier("rest_now1", "raw", context?.packageName);
        var mediaPlayer = MediaPlayer.create(context, audioID);
        mediaPlayer.start();
    }

    override fun onRestTimerStopped() {
        println("[MainActivityTimerListener] rest timer stopped")

        // change UI components
        binding.textViewFirst.text = "STOP";

        // play the sound for this action
        val audioID = resources.getIdentifier("rest_cooldown1", "raw", context?.packageName);
        var mediaPlayer = MediaPlayer.create(context, audioID);
        mediaPlayer.start();
    }

}