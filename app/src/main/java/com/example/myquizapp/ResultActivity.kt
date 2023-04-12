package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView= findViewById(R.id.tv_name)
        val tvScore: TextView=findViewById(R.id.tv_score)
        val btnFinish:Button=findViewById(R.id.btn_finish)
        var correctAnswer: Int =0
        var totalQuestion: Int = 0

        tvName.text=intent.getStringExtra(Constants.User_Name)
        correctAnswer=intent.getIntExtra(Constants.Correct_Answer, 0)
        totalQuestion=intent.getIntExtra(Constants.Total_Question, 0)
        tvScore.text="You Scored $correctAnswer out of $totalQuestion"

        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }





    }
}
