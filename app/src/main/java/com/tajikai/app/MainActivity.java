package com.tajikai.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends Activity {

    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createHomeScreen();
    }

    private void createHomeScreen() {

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setPadding(30, 30, 30, 30);
        mainLayout.setBackgroundColor(Color.rgb(5, 10, 25));

        TextView logo = new TextView(this);
        logo.setText("TAJIK AI");
        logo.setTextSize(34);
        logo.setTextColor(Color.rgb(0, 150, 255));
        logo.setGravity(Gravity.CENTER);
        logo.setTypeface(null, 1);

        TextView subtitle = new TextView(this);
        subtitle.setText("Зеҳни сунъии тоҷикӣ");
        subtitle.setTextSize(17);
        subtitle.setTextColor(Color.WHITE);
        subtitle.setGravity(Gravity.CENTER);

        TextView welcome = new TextView(this);
        welcome.setText("\nСалом! Ба TAJIK AI хуш омадӣ.");
        welcome.setTextSize(20);
        welcome.setTextColor(Color.WHITE);
        welcome.setGravity(Gravity.CENTER);

        EditText messageInput = new EditText(this);
        messageInput.setHint("Саволи худро навис...");
        messageInput.setTextColor(Color.WHITE);
        messageInput.setHintTextColor(Color.GRAY);
        messageInput.setSingleLine(false);
        messageInput.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(
                Color.rgb(0, 150, 255)
            )
        );

        Button sendButton = new Button(this);
        sendButton.setText("ИРСОЛ КАРДАН");
        sendButton.setTextColor(Color.WHITE);
        sendButton.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(
                Color.rgb(0, 110, 220)
            )
        );

        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();

            if (!message.isEmpty()) {
                showMessage("Шумо: " + message);
                messageInput.setText("");
            }
        });

        mainLayout.addView(logo);
        mainLayout.addView(subtitle);
        mainLayout.addView(welcome);

        mainLayout.addView(messageInput,
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 120
            )
        );

        mainLayout.addView(sendButton);

        setContentView(mainLayout);
    }

    private void showMessage(String message) {
        TextView text = new TextView(this);
        text.setText(message);
        text.setTextColor(Color.WHITE);
        text.setTextSize(16);
        text.setPadding(10, 15, 10, 15);

        mainLayout.addView(text);
    }
}
