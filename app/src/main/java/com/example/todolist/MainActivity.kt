package com.example.todolist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val items = mutableListOf<ToDoItem>()
    private val adapter = ToDoAdapter(items)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val newItemText = binding.etNewItem.text.toString()
            if (newItemText.isNotEmpty()) {
                items.add(ToDoItem(newItemText))
                adapter.notifyDataSetChanged()
                binding.etNewItem.text.clear()
            }
        }
    }
}
