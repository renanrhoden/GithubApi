package com.renanrhoden.feature.listing

import androidx.recyclerview.widget.DiffUtil
import com.renanrhoden.domain.model.GithubRepo

class HeroListingDiffCallback(
    private val oldItems: List<GithubRepo>,
    private val newItems: List<GithubRepo>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}