package com.example.mini_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_project.Adapter.MedicationAdapter
import com.example.mini_project.Adapter.PrecautionAdapter
import com.example.mini_project.Model.PredictionResponse
import com.example.mini_project.Model.SymptomRequest
import com.example.mini_project.Service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity4 : AppCompatActivity() {

    private lateinit var stringListAdapter : StringListAdapter
    private lateinit var medicationAdapter : MedicationAdapter
    private lateinit var precautionAdapter : PrecautionAdapter



    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //retriving the value

        val spinner1Value = intent.getStringExtra("spinner1")
        val spinner2Value = intent.getStringExtra("spinner2")
        val spinner3Value = intent.getStringExtra("spinner3")
        val spinner4Value = intent.getStringExtra("spinner4")

       val diseasename=findViewById<TextView>(R.id.disese_name)
        val description=findViewById<TextView>(R.id.Description)

        val medicartion_recylerview=findViewById<RecyclerView>(R.id.medication_recylerview)
        val layoutManager2= LinearLayoutManager(this)
        medicartion_recylerview.layoutManager=layoutManager2

        val diet_recylerview=findViewById<RecyclerView>(R.id.diet_recylerview)
        val layoutManager1 = LinearLayoutManager(this)
        diet_recylerview.layoutManager = layoutManager1

        val precation_recylerview=findViewById<RecyclerView>(R.id.precaution_recylerview)
        val layoutManager = LinearLayoutManager(this)
        precation_recylerview.layoutManager=layoutManager







        val retrofit = Retrofit.Builder()
            .baseUrl("https://aidoctor.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)


        val symptoms = listOf(spinner1Value,spinner2Value,spinner3Value)
        val symptomRequest = SymptomRequest(symptoms as List<String>)

        val call = apiService.predictDisease(symptomRequest)

        call.enqueue(object : Callback<PredictionResponse> {
            override fun onResponse(call: Call<PredictionResponse> , response: Response<PredictionResponse>) {
                if (response.isSuccessful) {
                    val prediction = response.body()
                    // Handle the prediction response
                    println("Disease: ${prediction?.disease}")

                    diseasename.text=prediction!!.disease

                    description.text=prediction!!.description

                    stringListAdapter= StringListAdapter(this@MainActivity4, prediction!!.diet)
                    diet_recylerview.adapter=stringListAdapter

                   medicationAdapter= MedicationAdapter(this@MainActivity4,prediction.medications)
                    medicartion_recylerview.adapter=medicationAdapter

                    precautionAdapter=PrecautionAdapter(this@MainActivity4,prediction.precaution)
                    precation_recylerview.adapter=precautionAdapter




                } else {
                    // Handle error
                    println("Error: ${response.message()}")


                }
            }

            override fun onFailure(call: Call<PredictionResponse>, t: Throwable) {
                // Handle failure
                println("Failure: ${t.message}")
            }
        })
    }
}