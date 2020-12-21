package com.renanrhoden.commons

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewEndlessScroll(private val listener: () -> Unit) :
    RecyclerView.OnScrollListener() {
    private var lastItemVisiblePositionOnList = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val lastItemVisiblePosition = layoutManager.findLastVisibleItemPosition()

        // It is at last but one.
        if (isScrollingDown(lastItemVisiblePosition) && recyclerView.shouldLoadMoreItems()) {
            listener.invoke()
        }

        lastItemVisiblePositionOnList = lastItemVisiblePosition
    }

    private fun isScrollingDown(lastItemVisiblePosition: Int) =
        lastItemVisiblePosition > lastItemVisiblePositionOnList

    private fun RecyclerView.shouldLoadMoreItems(): Boolean {
        val layoutManager = layoutManager as LinearLayoutManager

        val totalItemCount = layoutManager.itemCount
        val lastCompletelyVisibleItemPosition =
            layoutManager.findLastCompletelyVisibleItemPosition()

        return lastCompletelyVisibleItemPosition > totalItemCount - 4
    }
}