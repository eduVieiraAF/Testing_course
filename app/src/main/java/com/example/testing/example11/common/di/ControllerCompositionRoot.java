package com.example.testing.example11.common.di;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.testing.example11.common.time.TimeProvider;
import com.example.testing.example11.networking.StackoverflowApi;
import com.example.testing.example11.networking.questions.FetchLastActiveQuestionsEndpoint;
import com.example.testing.example11.questions.FetchLastActiveQuestionsUseCase;
import com.example.testing.example11.questions.FetchQuestionDetailsUseCase;
import com.example.testing.example11.screens.common.ViewMvcFactory;
import com.example.testing.example11.screens.common.controllers.BackPressDispatcher;
import com.example.testing.example11.screens.common.fragmentframehelper.FragmentFrameHelper;
import com.example.testing.example11.screens.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.testing.example11.screens.common.navdrawer.NavDrawerHelper;
import com.example.testing.example11.screens.common.screensnavigator.ScreensNavigator;
import com.example.testing.example11.screens.common.toasthelper.ToastsHelper;
import com.example.testing.example11.screens.questiondetails.QuestionDetailsController;
import com.example.testing.example11.screens.questionlist.QuestionsListController;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private FragmentActivity getActivity() {
        return mActivity;
    }

    private Context getContext() {
        return mActivity;
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private StackoverflowApi getStackoverflowApi() {
        return mCompositionRoot.getStackOverflowApi();
    }

    private FetchLastActiveQuestionsEndpoint getFetchLastActiveQuestionsEndpoint() {
        return new FetchLastActiveQuestionsEndpoint(getStackoverflowApi());
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater(), getNavDrawerHelper());
    }

    private NavDrawerHelper getNavDrawerHelper() {
        return (NavDrawerHelper) getActivity();
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return mCompositionRoot.getFetchQuestionDetailsUseCase();
    }

    public FetchLastActiveQuestionsUseCase getFetchLastActiveQuestionsUseCase() {
        return new FetchLastActiveQuestionsUseCase(getFetchLastActiveQuestionsEndpoint());
    }

    public TimeProvider getTimeProvider() {
        return mCompositionRoot.getTimeProvider();
    }

    public QuestionsListController getQuestionsListController() {
        return new QuestionsListController(
                getFetchLastActiveQuestionsUseCase(),
                getScreensNavigator(),
                getToastsHelper(),
                getTimeProvider());
    }

    public ToastsHelper getToastsHelper() {
        return new ToastsHelper(getContext());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentFrameHelper());
    }

    private FragmentFrameHelper getFragmentFrameHelper() {
        return new FragmentFrameHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager());
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper) getActivity();
    }

    public BackPressDispatcher getBackPressDispatcher() {
        return (BackPressDispatcher) getActivity();
    }

    public QuestionDetailsController getQuestionDetailsController() {
        return new QuestionDetailsController(getFetchQuestionDetailsUseCase(), getScreensNavigator(), getToastsHelper());
    }
}
