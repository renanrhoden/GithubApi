package com.renanrhoden.feature.listing

import android.content.Context
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.renanrhoden.domain.model.GithubRepo
import com.renanrhoden.feature.databinding.ListItemBinding

class ListingReposAdapter(context: Context) :
    RecyclerView.Adapter<ListingReposAdapter.ViewHolder>() {

    private var list = mutableListOf<GithubRepo>()

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ListItemBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], list.lastIndex == position)
    }

    override fun getItemCount() = list.size

    fun updateItems(newItems: List<GithubRepo>) {
        val diffResult = DiffUtil.calculateDiff(
            HeroListingDiffCallback(list, newItems)
        )
        diffResult.dispatchUpdatesTo(this)
        list = newItems.toMutableList()
    }

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: GithubRepo, isLast: Boolean) {
            binding.authorName.text = repo.authorName
            binding.repoName.text = repo.repoName
            binding.stars.text = repo.stars.toString()
            binding.forks.text = repo.forks.toString()
            if (isLast && binding.separtor.visibility == VISIBLE) {
                binding.separtor.visibility = INVISIBLE
            } else {
                binding.separtor.visibility = VISIBLE
            }
            Glide.with(binding.authorPhoto)
                .load(repo.authorPhotoUrl)
                .centerCrop()
                .into(binding.authorPhoto)
        }
    }
}
