package com.example.todo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {
    static ArrayList<String> taskList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskactivity);
        setTitle("Tasks");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,taskList);
        LinearLayout rootView=(LinearLayout) findViewById(R.id.tasksId);
        for(int i=0;i<taskList.size();i++){
            TextView taskName=new TextView(this);
            taskName.setTextSize(30);
            taskName.setText(taskList.get(i));
            rootView.addView(taskName);
        }

    }
    public static int getSize(){
        return taskList.size();
    }

    public static void addTask(String task){
        taskList.add(task);
    }

    public static void clearTasks(){
        taskList.clear();
    }
}
