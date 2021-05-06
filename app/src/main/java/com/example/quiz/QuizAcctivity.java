package com.example.quiz;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.quiz.databinding.ActivityQuizAcctivityBinding;
import com.example.quiz.model.Question;

import java.util.ArrayList;

public class QuizAcctivity extends AppCompatActivity {

    ActivityQuizAcctivityBinding activityQuizAcctivityBinding;
    ArrayList<Question> list;
    int index = 0;
    Question q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityQuizAcctivityBinding = ActivityQuizAcctivityBinding.inflate(getLayoutInflater());
        setContentView(activityQuizAcctivityBinding.getRoot());

        list = new ArrayList<>();
        list.add(new Question(1, "what are you?","Man", "animal",
                "Dog", "Bird", "Man"));

        list.add(new Question(2, "who are you?","Student", "Teacher",
                "Dog", "Bird", "Teacher"));
        list.add(new Question(3, "Dog","Man", "animal",
                "Dog", "Bird", "Man"));
        list.add(new Question(4, "what are you","Man", "animal",
                "Dog", "Bird", "Man"));
        list.add(new Question(5, "what are yousfsdf","Man", "animal",
                "Dog", "Bird", "Man"));
        setNextQuestion();

    }

    void setNextQuestion(){
        if(index < list.size()){

             q = list.get(index);
            activityQuizAcctivityBinding.question.setText(q.getQuestion());
            activityQuizAcctivityBinding.a.setText(q.getAnswerA());
            activityQuizAcctivityBinding.b.setText(q.getAnswerB());
            activityQuizAcctivityBinding.c.setText(q.getAnswerC());
            activityQuizAcctivityBinding.d.setText(q.getAnswerD());

        }
    }
    void checkAnswer(TextView textView){
        String ans = textView.getText().toString();
        if(ans.equals(q.getFinalAnswer())){
            textView.setBackground(getResources().getDrawable(R.drawable.option_right));
        }else{
            textView.setBackground(getResources().getDrawable(R.drawable.option_wrong));
        }
    }
    public void nextQuestion(View view){
        switch (view.getId()){
            case R.id.a:
            case R.id.b:
            case R.id.c:
            case R.id.d:
                TextView sele = (TextView) view;
                checkAnswer(sele);
                break;
            case R.id.nextBtn:
                reset();
                if(index < list.size()){

                    index+=1;
                    setNextQuestion();
                }else{
                    Toast.makeText(QuizAcctivity.this, "Quiz is Finished", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    void reset(){
        activityQuizAcctivityBinding.a.setBackground(getResources().getDrawable(R.drawable.option_view));
        activityQuizAcctivityBinding.b.setBackground(getResources().getDrawable(R.drawable.option_view));

        activityQuizAcctivityBinding.c.setBackground(getResources().getDrawable(R.drawable.option_view));
        activityQuizAcctivityBinding.d.setBackground(getResources().getDrawable(R.drawable.option_view));

    }
}