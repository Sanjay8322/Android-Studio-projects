package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todo.R.id;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TaskActivity taskActivity=new TaskActivity();
        Button button = (Button) findViewById(R.id.taskButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text=(EditText) findViewById(R.id.addTask);
                String task=text.getText().toString();
                if(task.equals("")){
                    Toast.makeText(getApplicationContext(),"Type your task",Toast.LENGTH_SHORT).show();
                }
                else{
                    TaskActivity.addTask(task);
                    text.setText("");
                }
            }
        });

        Button button1=(Button) findViewById(R.id.taskPage);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TaskActivity.getSize()==0){
                    Toast.makeText(getApplicationContext(),"No tasks added!",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(MainActivity.this,TaskActivity.class);
                    startActivity(intent);
                }
            }
        });
        Button clear=(Button)findViewById(id.clearId);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskActivity.clearTasks();
            }
        });



    }
}