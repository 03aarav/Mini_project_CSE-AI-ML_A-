package com.example.mini_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val items = arrayOf("Item 1", "Item 2", "Item 3")

        // Create an ArrayAdapter using the array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        val spinner1: Spinner = findViewById(R.id.spinner1)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinner3: Spinner = findViewById(R.id.spinner3)
        val spinner4: Spinner = findViewById(R.id.spinner4)
        spinner1.adapter = adapter
        spinner2.adapter = adapter
        spinner3.adapter = adapter
        spinner4.adapter = adapter
    }
}