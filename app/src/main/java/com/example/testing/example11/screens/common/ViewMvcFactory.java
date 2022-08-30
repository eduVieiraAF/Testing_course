package com.example.testing.example11.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.testing.example11.screens.common.navdrawer.NavDrawerHelper;
import com.example.testing.example11.screens.common.navdrawer.NavDrawerViewMvc;
import com.example.testing.example11.screens.common.navdrawer.NavDrawerViewMvcImpl;
import com.example.testing.example11.screens.common.toolbar.ToolbarViewMvc;
import com.example.testing.example11.screens.questiondetails.QuestionDetailsViewMvc;
import com.example.testing.example11.screens.questiondetails.QuestionDetailsViewMvcImpl;
import com.example.testing.example11.screens.questionlist.QuestionsListViewMvc;
import com.example.testing.example11.screens.questionlist.QuestionsListViewMvcImpl;
import com.example.testing.example11.screens.questionlist.questionslistitem.QuestionsListItemViewMvc;
import com.example.testing.example11.screens.questionlist.questionslistitem.QuestionsListItemViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;
    private final NavDrawerHelper mNavDrawerHelper;

    public ViewMvcFactory(LayoutInflater layoutInflater, NavDrawerHelper navDrawerHelper) {
        mLayoutInflater = layoutInflater;
        mNavDrawerHelper = navDrawerHelper;
    }

    public QuestionsListViewMvc getQuestionsListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListViewMvcImpl(mLayoutInflater, parent, mNavDrawerHelper, this);
    }

    public QuestionsListItemViewMvc getQuestionsListItemViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListItemViewMvcImpl(mLayoutInflater, parent);
    }

    public QuestionDetailsViewMvc getQuestionDetailsViewMvc(@Nullable ViewGroup parent) {
        return new QuestionDetailsViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(mLayoutInflater, parent);
    }

    public NavDrawerViewMvc getNavDrawerViewMvc(@Nullable ViewGroup parent) {
        return new NavDrawerViewMvcImpl(mLayoutInflater, parent);
    }
}
