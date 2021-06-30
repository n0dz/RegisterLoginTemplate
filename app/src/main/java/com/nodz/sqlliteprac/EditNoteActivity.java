package com.nodz.sqlliteprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nodz.sqlliteprac.databinding.ActivityEditNoteBinding;

public class EditNoteActivity extends AppCompatActivity {

    ActivityEditNoteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityEditNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhelper helper = new DBhelper(this);
        /*binding.editNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean isUpdated = helper.updateData();
                if(isInserted){
                    Toast.makeText(AddNoteActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddNoteActivity.this,MainActivity.class));
                }
            }
        });*/

    }
}