package br.com.felipeacerbi.keddit.retrofit

import br.com.felipeacerbi.keddit.retrofit.models.RedditNewsResponse
import retrofit2.Call
import javax.inject.Inject

/**
 * Created by felipe.acerbi on 26/05/2017.
 */
class RestAPI @Inject constructor(private val redditService: RedditApiService) {

    fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditService.getTop(after, limit)
    }

}