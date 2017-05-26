package br.com.felipeacerbi.keddit.retrofit.models

/**
 * Created by felipe.acerbi on 26/05/2017.
 */
class RedditNewsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)