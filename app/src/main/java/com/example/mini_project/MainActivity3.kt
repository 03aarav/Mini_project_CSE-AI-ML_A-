package com.example.mini_project



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    // Variables to store the selected values
    private var selectedValueSpinner1: String? = null
    private var selectedValueSpinner2: String? = null
    private var selectedValueSpinner3: String? = null
    private var selectedValueSpinner4: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val items = arrayOf("itching", "skin_rash", "nodal_skin_eruptions")

        val itemsList1 = arrayOf(
            "Choose from Set A",
            "continuous_sneezing",
            "shivering",
        )
        val itemlist2 = arrayOf(
            "Choose from Set A",
            "chills",
            "continuous_sneezing",
            "watering_from_eyes"
        )

        val itemlist3 = arrayOf(
            "Choose from Set A",
            "chills",
            "shivering"


        )
        val itemlist4 = arrayOf(
            "Sweating",
            "Dizziness",
            "Weight Loss",
            "Irregular Sugar Level",
            "Watering from Eyes",
            "Swollen Legs",
            "Bloody Stool",
            "Obesity"
        )





        // Create an ArrayAdapter using the array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsList1)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemlist2)
        val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemlist3)
        val adapter4 = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemlist4)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        val spinner1: Spinner = findViewById(R.id.spinner1)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinner3: Spinner = findViewById(R.id.spinner3)
        val spinner4: Spinner = findViewById(R.id.spinner4)

        spinner1.adapter = adapter
        spinner2.adapter = adapter1
        spinner3.adapter = adapter3
        spinner4.adapter = adapter4

        // Set up OnItemSelectedListener for each spinner
        spinner1.onItemSelectedListener = createItemSelectedListener(1)
        spinner2.onItemSelectedListener = createItemSelectedListener(2)
        spinner3.onItemSelectedListener = createItemSelectedListener(3)
        spinner4.onItemSelectedListener = createItemSelectedListener(4)


        val predictbtn=findViewById<TextView>(R.id.predict_Button)

        predictbtn.setOnClickListener {

            val intent = Intent(this,MainActivity4::class.java)

            intent.putExtra("spinner1", selectedValueSpinner1)
            intent.putExtra("spinner2", selectedValueSpinner2)
            intent.putExtra("spinner3", selectedValueSpinner3)
            intent.putExtra("spinner4", selectedValueSpinner4)

            startActivity(intent)
        }
    }

    private fun createItemSelectedListener(spinnerNumber: Int): AdapterView.OnItemSelectedListener {
        return object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View?, position: Int, id: Long) {
                val selectedValue = parentView.getItemAtPosition(position) as String
                when (spinnerNumber) {
                    1 -> selectedValueSpinner1 = selectedValue
                    2 -> selectedValueSpinner2 = selectedValue
                    3 -> selectedValueSpinner3 = selectedValue
                    4 -> selectedValueSpinner4 = selectedValue
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Do nothing here if needed
            }
        }
    }
}
