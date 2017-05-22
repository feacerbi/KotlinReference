package br.com.felipeacerbi.keddit.models

import br.com.felipeacerbi.keddit.adapters.utils.AdapterConstants
import br.com.felipeacerbi.keddit.adapters.models.ViewType

/**
 * Created by feaac on 5/19/2017.
 */
data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}