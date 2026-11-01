package com.tajikai.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LinearLayout messages;
    private EditText input;
    private ScrollView scrollView;

    private int blue = Color.rgb(22, 139, 255);
    private int white = Color.WHITE;
    private int background = Color.rgb(8, 15, 29);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showChat();
    }

    private void showChat() {

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(18, 18, 18, 18);
        root.setBackgroundColor(background);

        TextView title = new TextView(this);
        title.setText("TAJIK AI");
        title.setTextColor(blue);
        title.setTextSize(27);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Зеҳни сунъии тоҷикӣ");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        scrollView = new ScrollView(this);

        messages = new LinearLayout(this);
        messages.setOrientation(LinearLayout.VERTICAL);
        messages.setPadding(4, 20, 4, 20);

        scrollView.addView(messages);

        root.addView(scrollView,
            new LinearLayout.LayoutParams(
                -1, 0, 1
            )
        );

        LinearLayout bottom = new LinearLayout(this);
        bottom.setOrientation(LinearLayout.HORIZONTAL);
        bottom.setGravity(Gravity.CENTER_VERTICAL);

        input = new EditText(this);
        input.setHint("Саволи худро навис...");
        input.setTextColor(white);
        input.setHintTextColor(Color.GRAY);
        input.setTextSize(15);
        input.setPadding(15, 10, 15, 10);
        input.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(blue)
        );

        bottom.addView(input,
            new LinearLayout.LayoutParams(0, 60, 1)
        );

        Button send = new Button(this);
        send.setText("ИРСОЛ");
        send.setTextColor(white);
        send.setBackgroundTintList(
            android.content.res.ColorStateList.valueOf(blue)
        );

        bottom.addView(send);

        root.addView(bottom);

        send.setOnClickListener(v -> sendMessage());

        setContentView(root);

        addMessage("TAJIK AI",
            "Салом! Ба TAJIK AI хуш омадӣ. Чӣ кӯмак расонам?");
    }

    private void sendMessage() {

        String text = input.getText().toString().trim();

        if (text.isEmpty()) {
            return;
        }

        addMessage("Шумо", text);
        input.setText("");

        addMessage("TAJIK AI",
            "Паёми шумо қабул шуд. Барои гирифтани ҷавоби воқеии AI, сервери зеҳни сунъиро бояд пайваст кунем.");
    }

    private void addMessage(String sender, String message) {

        TextView text = new TextView(this);

        text.setText(sender + "\n" + message);
        text.setTextColor(white);
        text.setTextSize(16);
        text.setPadding(16, 14, 16, 14);
        text.setBackgroundColor(
            sender.equals("Шумо")
                ? Color.rgb(12, 65, 120)
                : Color.rgb(16, 29, 50)
        );

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                -1, -2
            );

        params.setMargins(0, 8, 0, 8);

        messages.addView(text, params);

        scrollView.post(() ->
            scrollView.fullScroll(View.FOCUS_DOWN)
        );
    }
}
