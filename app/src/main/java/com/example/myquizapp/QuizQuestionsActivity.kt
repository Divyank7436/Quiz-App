package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int=0

    private var progressBar:ProgressBar?=null
    private var tvprogress:TextView? = null
    private var tvquestion: TextView? = null
    private var ivimage: ImageView?=null
    private var mUserName: String?=null
    private var mCorrectAnswers: Int = 0

    private var tvoption1: TextView?=null
    private var tvoption2: TextView?=null
    private var tvoption3: TextView?=null
    private var tvoption4: TextView?=null
    private var btnSubmit: Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName=intent.getStringExtra(Constants.User_Name)


        progressBar = findViewById(R.id.progressbar)
        tvprogress = findViewById(R.id.tv_progress)
        tvquestion = findViewById(R.id.tv_question)
        ivimage = findViewById(R.id.iv_image)
        tvoption1 = findViewById(R.id.tv_option_1)
        tvoption2 = findViewById(R.id.tv_option_2)
        tvoption3 = findViewById(R.id.tv_option_3)
        tvoption4 = findViewById(R.id.tv_option_4)
        btnSubmit=findViewById(R.id.btn_submit)

        tvoption1?.setOnClickListener(this)
        tvoption2?.setOnClickListener(this)
        tvoption3?.setOnClickListener(this)
        tvoption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)




        mQuestionList = Constants.getQuestions()
        setQuestion()

        defaultOptionView()


    }

    private fun setQuestion() {


        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivimage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvprogress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvquestion?.text = question.question
        tvoption1?.text = question.optionOne
        tvoption2?.text = question.optionTwo
        tvoption3?.text = question.optionThree
        tvoption4?.text = question.optionFour


        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text="FINISH"

        }
        else{
            btnSubmit?.text="SUBMIT"

        }
    }

    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        tvoption1?.let {
            options.add(0,it)
        }

        tvoption2?.let {
            options.add(1,it)
        }
        tvoption3?.let {
            options.add(2,it)
        }
        tvoption4?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#FF0000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                //R.drawable.selected_option_border_bg
             R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
            //R.drawable.default_option_border_bg
        )

    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.tv_option_1 -> {
                tvoption1?.let{
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option_2 -> {
                tvoption2?.let{
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option_3 -> {
                tvoption3?.let{
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option_4 -> {
                tvoption4?.let{
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit -> {

                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }

                        else-> {

                            val intent = Intent( this, ResultActivity::class.java)
                            intent.putExtra(Constants.User_Name, mUserName)
                            intent.putExtra(Constants.Correct_Answer,mCorrectAnswers)
                            intent.putExtra(Constants.Total_Question, mQuestionList?.size)
                            startActivity(intent)
                            finish()

                            //Toast.makeText(this, "YOU MADE IT TO THE END", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else{
                val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!= mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }
                    else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0

                }
            }
        }


    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer) {
            1 -> {
                tvoption1?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvoption2?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvoption3?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tvoption4?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

        }

    }

}