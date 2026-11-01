
package com.tajikai.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open(R.id.openChat, "AI Chat");
        open(R.id.openTranslator, "AI Translator");
        open(R.id.openWriter, "AI Writer");
        open(R.id.openStudy, "AI Study Assistant");
        open(R.id.openQuestions, "AI Questions");
        open(R.id.openImage, "AI Image Analyzer");
        open(R.id.openPDF, "AI PDF Reader");
        open(R.id.openCode, "AI Code Assistant");
        open(R.id.openEditor, "AI Text Editor");
        open(R.id.openMath, "AI Math Solver");
        open(R.id.openHistory, "Chat History");
    }

    private void open(int viewId, String featureName) {
        View view = findViewById(viewId);

        if (view != null) {
            view.setOnClickListener(v ->
                Toast.makeText(
                    MainActivity.this,
                    featureName + " — ба наздикӣ",
                    Toast.LENGTH_SHORT
                ).show()
            );
        }
    }
}
