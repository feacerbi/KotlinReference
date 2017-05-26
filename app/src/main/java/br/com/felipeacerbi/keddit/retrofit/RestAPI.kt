package br.com.felipeacerbi.keddit.retrofit

import br.com.felipeacerbi.keddit.retrofit.models.RedditNewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by felipe.acerbi on 26/05/2017.
 */
class RestAPI {

    private val redditService: RedditApiService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditService = retrofit.create(RedditApiService::class.java)
    }

    fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditService.getTop(after, limit)
    }

}