package com.example.myquizapp

object Constants {

    const val User_Name: String = "User_name"
    const val Total_Question: String = "total_question"
    const val Correct_Answer: String = "correct_answer"

    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val ques1=Question(

        1,"Which Glass will fill First?",
            R.drawable.question1,"3","2","1","No Glass will be filled",
            4
        )
        questionList.add(ques1)

       val ques2=Question(
          2,"Which Balloon is Boy Holding",
          R.drawable.question2,"Yellow","Red","Green","Blue",1
      )
        questionList.add(ques2)
        val ques3=Question(
            3,"Who is the Alien?", R.drawable.question3,"Groom","Bride", "Rightmost Girl",
            "Leftmost Boy",2

        )
        questionList.add(ques3)
        val ques4=Question(
            4,"What is Odd one out?", R.drawable.question4,"1","2","3","4",4
        )
        questionList.add(ques4)
        val ques5=Question(
            5,"How many Objects are in the Image?",R.drawable.question5,"4","5","6","7",2

        )
        questionList.add(ques5)
        val ques6=Question(
            6,"Which Glass contains the most water?", R.drawable.question6,"A","B","C","D",3
        )
        questionList.add(ques6)
        val ques7=Question(
            7,"Which is Correct Birds Eye View?",R.drawable.question7,"A","B","C","D",1
        )
        questionList.add(ques7)
        val ques8=Question(
            8,"Which Teacher is Dead?",R.drawable.question8,"1","2","3","4",2
        )
        questionList.add(ques8)
        val ques9=Question(
            9,"A robbery happened on a snowy day and all 4 suspects claimed that they were at Home,Only the thief is lying , Who is the Theif?",
            R.drawable.question9,"Alex","Ben","Rick","Maria",3
        )
        questionList.add(ques9)
        val ques10=Question(
            10,"Which Line is Longest",R.drawable.question10,"A","B","C","D",3
        )
        questionList.add(ques10)

        return questionList

    }


}