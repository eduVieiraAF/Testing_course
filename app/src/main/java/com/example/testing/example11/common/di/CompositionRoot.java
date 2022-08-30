package com.example.testing.example11.common.di;

import com.example.testing.example11.common.Constants;
import com.example.testing.example11.common.time.TimeProvider;
import com.example.testing.example11.networking.StackoverflowApi;
import com.example.testing.example11.networking.questions.FetchQuestionDetailsEndpoint;
import com.example.testing.example11.questions.FetchQuestionDetailsUseCase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit mRetrofit;
    private FetchQuestionDetailsUseCase mFetchQuestionDetailsUseCase;

    private Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

    public StackoverflowApi getStackOverflowApi() {
        return getRetrofit().create(StackoverflowApi.class);
    }

    public TimeProvider getTimeProvider() {
        return new TimeProvider();
    }

    public FetchQuestionDetailsEndpoint getFetchQuestionDetailsEndpoint() {
        return new FetchQuestionDetailsEndpoint(getStackOverflowApi());
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        if (mFetchQuestionDetailsUseCase == null) {
            mFetchQuestionDetailsUseCase = new FetchQuestionDetailsUseCase(
                    getFetchQuestionDetailsEndpoint(), getTimeProvider()
            );
        }
        return mFetchQuestionDetailsUseCase;
    }
}
