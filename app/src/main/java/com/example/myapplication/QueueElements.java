package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.renderscript.ScriptGroup;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.LinkedList;
import java.util.Queue;

public class QueueElements {
    Queue<String> titles = new LinkedList<>();
    Queue<String> descriptions = new LinkedList<>();
    Queue<Integer> images = new LinkedList<>();
    ActivityMainBinding binding;

    public QueueElements(ActivityMainBinding binding) {
        this.binding = binding;
        titles.add("Flexible Payment");
        titles.add("Real-Time Tracking");

        descriptions.add("Different modes of payment either before and after delivery without stress");
        descriptions.add("Track your packages/items from the comfort of your home till final destination");

        images.add(R.drawable.image2);
        images.add(R.drawable.image3);
    }

    public boolean next() {
        animate();
        if(titles.size() != 0) {
            binding.title.setText(titles.poll());
            binding.description.setText(descriptions.poll());
            binding.image.setImageResource(images.poll());
            return true;
        }

        return false;
    }

    public void animate() {
        ObjectAnimator titleAnim = ObjectAnimator.ofFloat(binding.title,"alpha", 0.5f, 1f);
        ObjectAnimator desAnim = ObjectAnimator.ofFloat(binding.description,"alpha", 0.5f, 1f);
        ObjectAnimator imAnim = ObjectAnimator.ofFloat(binding.image,"alpha", 0.5f, 1f);

        AnimatorSet set = new AnimatorSet();
        set.play(titleAnim).with(desAnim).with(imAnim);
        set.start();

    }
}
