package br.com.felipeacerbi.keddit.retrofit

import br.com.felipeacerbi.keddit.retrofit.models.RedditNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by felipe.acerbi on 26/05/2017.
 */
interface RedditApiService {
    @GET("/top.json")
    fun getTop(@Query("after") after: String, @Query("limit") limit:String) : Call<RedditNewsResponse>
}