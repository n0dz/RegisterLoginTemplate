package com.nodz.sqlliteprac;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nodz.sqlliteprac.databinding.ActivityAddNoteBinding;

public class AddNoteActivity extends AppCompatActivity {
    ActivityAddNoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhelper helper = new DBhelper(this);

        NotesAdapter adapter = new NotesAdapter();

        binding.saveNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insertData(binding.etAddnote.getText().toString());
                if(isInserted){
                    Toast.makeText(AddNoteActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                    startActivity(new Intent(AddNoteActivity.this, MainActivity.class));
                }
            }
        });
    }

}
