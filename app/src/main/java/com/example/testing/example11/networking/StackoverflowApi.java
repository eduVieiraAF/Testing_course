package com.example.testing.example11.networking;

import com.example.testing.example11.common.Constants;
import com.example.testing.example11.networking.questions.QuestionDetailsResponseSchema;
import com.example.testing.example11.networking.questions.QuestionsListResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackoverflowApi {

    @GET("/questions?key=" + Constants.STACKOVERFLOW_API_KEY + "&sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchLastActiveQuestions(@Query("pagesize") Integer pageSize);

    @GET("/questions/{questionId}?key=" + Constants.STACKOVERFLOW_API_KEY + "&site=stackoverflow&filter=withbody")
    Call<QuestionDetailsResponseSchema> fetchQuestionDetails(@Path("questionId") String questionId);
}
