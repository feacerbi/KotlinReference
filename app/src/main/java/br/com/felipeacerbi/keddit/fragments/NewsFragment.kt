package br.com.felipeacerbi.keddit.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.felipeacerbi.keddit.R
import br.com.felipeacerbi.keddit.app.ReferenceApplication
import br.com.felipeacerbi.keddit.adapters.NewsAdapter
import br.com.felipeacerbi.keddit.models.RedditNews
import br.com.felipeacerbi.keddit.utils.InfiniteScrollListener
import br.com.felipeacerbi.keddit.utils.NewsManager
import br.com.felipeacerbi.keddit.utils.inflate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.news_fragment.*
import javax.inject.Inject

/**
 * Created by feaac on 5/19/2017.
 */
class NewsFragment : RxBaseFragment() {

    companion object {
        private val KEY_REDDIT_NEWS = "redditNews"
    }

    val generalLayoutManager: RecyclerView.LayoutManager by lazy {
        LinearLayoutManager(context)
    }

    @Inject lateinit var newsManager: NewsManager

    private var redditNews: RedditNews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ReferenceApplication.newsComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            setHasFixedSize(true)
            layoutManager = generalLayoutManager
            clearOnScrollListeners()
            addOnScrollListener(
                    InfiniteScrollListener({ requestNews() }, generalLayoutManager as LinearLayoutManager)
            )
        }

        initAdapter()

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_REDDIT_NEWS)) {
            redditNews = savedInstanceState.get(KEY_REDDIT_NEWS) as RedditNews
            (news_list.adapter as NewsAdapter).clearAndAddNews(redditNews?.news)
        } else {
            requestNews()
        }

    }

    private fun requestNews() {
        val subscription = newsManager.getNews(redditNews?.after ?: "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                { retrievedNews ->
                    redditNews = retrievedNews
                    (news_list.adapter as NewsAdapter).addNews(retrievedNews.news) },
                { e -> Snackbar.make(news_list, "Error retrieving news: ${e.message}", Snackbar.LENGTH_LONG).show() })

        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        val news = (news_list.adapter as NewsAdapter).getNews()
        if(redditNews != null && !news.isNotEmpty()) {
            outState?.putParcelable(KEY_REDDIT_NEWS, redditNews?.copy(news = news))
        }
    }
}