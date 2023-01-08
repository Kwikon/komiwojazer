package com.example.komicotam

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)

        val rezultat : TextView = findViewById(R.id.rezultatText)

        val spinnerPierwszy : Spinner = findViewById(R.id.pierwszySpinner)

        val spinnerDrugi : Spinner = findViewById(R.id.drugiSpinner)

        val drogaEditText : EditText = findViewById(R.id.drogaEditText)

        // Macierz
        val City = List<MutableList<Int>>(8){
            MutableList<Int>(8){0}
        }

        // Wypełnienie macierzy losowymi wartościami
        for(i in 0..7){
            for(j in i+1..7){
                Random().nextInt(1000).let{
                    City[i][j]=it
                    City[j][i]=it
                }
            }
        }
        // Wypełnienie spinnera miastami z pliku strings.xml
        ArrayAdapter.createFromResource(
            this,
            R.array.City,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPierwszy.adapter = adapter
            spinnerDrugi.adapter = adapter
        }

    }
}
