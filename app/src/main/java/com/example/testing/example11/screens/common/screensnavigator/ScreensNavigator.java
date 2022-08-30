package com.example.testing.example11.screens.common.screensnavigator;

import com.example.testing.example11.screens.common.fragmentframehelper.FragmentFrameHelper;
import com.example.testing.example11.screens.questiondetails.QuestionDetailsFragment;
import com.example.testing.example11.screens.questionlist.QuestionsListFragment;

public class ScreensNavigator {
    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }

    public void toQuestionDetails(String questionId) {
        mFragmentFrameHelper.replaceFragment(QuestionDetailsFragment.newInstance(questionId));
    }

    public void toQuestionsList() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(QuestionsListFragment.newInstance());
    }

    public void navigateUp() {
        mFragmentFrameHelper.navigateUp();
    }
}
