package br.com.felipeacerbi.keddit.retrofit.models

/**
 * Created by felipe.acerbi on 26/05/2017.
 */
class RedditDataResponse (
        val children: List<RedditChildrenResponse>,
        val after: String?,
        val before: String?
)