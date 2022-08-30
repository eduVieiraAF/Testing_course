package com.example.testing.example11.screens.questiondetails;

import com.example.testing.example11.questions.QuestionDetails;
import com.example.testing.example11.screens.common.views.ObservableViewMvc;

public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener> {

    interface Listener {
        void onNavigateUpClicked();
    }

    void bindQuestion(QuestionDetails question);

    void showProgressIndication();

    void hideProgressIndication();
}
