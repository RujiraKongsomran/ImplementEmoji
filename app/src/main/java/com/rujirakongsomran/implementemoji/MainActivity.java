package com.rujirakongsomran.implementemoji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.rujirakongsomran.implementemoji.databinding.ActivityMainBinding;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_main);

        // Initialize emoji popup
        EmojiPopup popup = EmojiPopup.Builder.fromRootView(
                findViewById(R.id.root_view)
        ).build(binding.etEmoji);

        binding.ivEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle between text and emoji
                popup.toggle();
            }
        });

        binding.ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate emoji text view
                EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater
                        .from(view.getContext())
                        .inflate(R.layout.emoji_text_view, binding.linearLayout, false);

                // Set Text on emoji
                emojiTextView.setText(binding.etEmoji.getText().toString());
                // Add view to linear layout
                binding.linearLayout.addView(emojiTextView);
                // Clear edit text value
                binding.etEmoji.getText().clear();
            }
        });
    }
}