package br.com.felipeacerbi.keddit.utils

import br.com.felipeacerbi.keddit.models.RedditNews
import br.com.felipeacerbi.keddit.models.RedditNewsItem
import br.com.felipeacerbi.keddit.retrofit.RestAPI
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by felipe.acerbi on 25/05/2017.
 */

@Singleton
class NewsManager @Inject constructor(private val restApi: RestAPI) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->
            val callResponse = restApi.getNews(after, limit)
            val response = callResponse.execute()

            if(response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created,
                            item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news)
                subscriber.onNext(redditNews)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

}
