package br.com.felipeacerbi.keddit.adapters.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.felipeacerbi.keddit.R
import br.com.felipeacerbi.keddit.adapters.models.ViewType
import br.com.felipeacerbi.keddit.adapters.models.ViewTypeDelegateAdapter
import br.com.felipeacerbi.keddit.utils.inflate

/**
 * Created by feaac on 5/19/2017.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        // Nothing to do here
    }

    class TurnsViewHolder(viewParent: ViewGroup) :
            RecyclerView.ViewHolder(viewParent.inflate(R.layout.news_item_loading)) {}
}