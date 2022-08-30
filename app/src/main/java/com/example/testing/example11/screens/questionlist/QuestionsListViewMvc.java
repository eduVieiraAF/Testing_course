package com.example.testing.example11.screens.questionlist;

import com.example.testing.example11.questions.Question;
import com.example.testing.example11.screens.common.views.ObservableViewMvc;

import java.util.List;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener> {

    void bindQuestions(List<Question> questions);

    void showProgressIndication();

    void hideProgressIndication();

    interface Listener {
        void onQuestionClicked(Question question);
    }
}
