package br.com.felipeacerbi.keddit.adapters.models

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.felipeacerbi.keddit.adapters.models.ViewType

/**
 * Created by feaac on 5/19/2017.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)

}
