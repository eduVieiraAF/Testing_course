package com.example.testing.example11.screens.questionlist.questionslistitem;


import com.example.testing.example11.questions.Question;
import com.example.testing.example11.screens.common.views.ObservableViewMvc;

public interface QuestionsListItemViewMvc extends ObservableViewMvc<QuestionsListItemViewMvc.Listener> {

    interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}
