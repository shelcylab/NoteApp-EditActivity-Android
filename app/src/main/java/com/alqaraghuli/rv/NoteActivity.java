package com.alqaraghuli.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alqaraghuli.rv.dummy.DummyContent;

public class NoteActivity extends AppCompatActivity {

    TextView titleTV;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        titleTV = findViewById(R.id.tv_edit_title);
        Intent intent = getIntent();
        position = intent.getIntExtra("note_position",-1);
        if(intent.hasExtra("note_position")){
            titleTV.setText(DummyContent.ITEMS.get(position).title);
            ((TextView)findViewById(R.id.tv_edit_content))
                    .setText(DummyContent.ITEMS.get(position).content);
            ((TextView)findViewById(R.id.tv_edit_detail))
                    .setText(DummyContent.ITEMS.get(position).details);
        }

    }

    public void saveClicked(View view) {
        DummyContent.ITEMS.get(position).title = "New Title";
        finish();
    }
}