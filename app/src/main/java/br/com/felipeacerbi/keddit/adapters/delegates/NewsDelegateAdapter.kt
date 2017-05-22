package br.com.felipeacerbi.keddit.adapters.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.felipeacerbi.keddit.R
import br.com.felipeacerbi.keddit.adapters.models.ViewTypeDelegateAdapter
import br.com.felipeacerbi.keddit.adapters.models.ViewType
import br.com.felipeacerbi.keddit.models.RedditNewsItem
import br.com.felipeacerbi.keddit.utils.getFriendlyTime
import br.com.felipeacerbi.keddit.utils.inflate
import br.com.felipeacerbi.keddit.utils.loadImage
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by feaac on 5/19/2017.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(viewParent: android.view.ViewGroup) :
            RecyclerView.ViewHolder(viewParent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImage(item.thumbnail)
            author.text = item.author
            description.text = item.title
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}