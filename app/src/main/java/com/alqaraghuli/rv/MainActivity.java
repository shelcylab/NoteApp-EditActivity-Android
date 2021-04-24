package com.alqaraghuli.rv;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.alqaraghuli.rv.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements NotesFragment.NotesOnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotesFragment notesFramgment = new NotesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, notesFramgment,"notesFramgment")
                .commit();
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, "Clicked note: "+DummyContent.ITEMS.get(position).title , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,NoteActivity.class);
        intent.putExtra("note_position",position);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        NotesFragment notesFragment =(NotesFragment) getSupportFragmentManager().findFragmentByTag("notesFramgment");
        if (notesFragment != null)
            notesFragment.refresh();

        Toast.makeText(this, "Data refreshed", Toast.LENGTH_SHORT).show();

    }
}