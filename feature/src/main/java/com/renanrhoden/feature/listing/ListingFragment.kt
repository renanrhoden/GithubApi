package com.renanrhoden.feature.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.renanrhoden.commons.RecyclerViewEndlessScroll
import com.renanrhoden.feature.databinding.ListingReposFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListingFragment : Fragment() {

    private val viewModel: ListingViewModel by viewModel()
    private lateinit var binding: ListingReposFragmentBinding
    private val adapter: ListingReposAdapter by lazy {
        ListingReposAdapter(requireActivity())
    }
    private val endlessScrollListener by lazy {
        RecyclerViewEndlessScroll {
            viewModel.loadNextRepos()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListingReposFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        observeViewModel()
        viewModel.setup()
        binding.recycler.addOnScrollListener(endlessScrollListener)
        binding.tryAgainButton.setOnClickListener {
            viewModel.setup()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.recycler.removeOnScrollListener(endlessScrollListener)
    }

    private fun observeViewModel() {
        viewModel.repos.observe(viewLifecycleOwner, {
            binding.errorAnimationView.visibility = GONE
            binding.tryAgainButton.visibility = GONE
            adapter.updateItems(it)
        })
        viewModel.onErrorEvent.observe(viewLifecycleOwner, {
            if (!adapter.hasItems()) {
                binding.errorAnimationView.visibility = VISIBLE
                binding.tryAgainButton.visibility = VISIBLE
            }
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        })
        viewModel.isLoading.observe(viewLifecycleOwner, {
            when (it) {
                true -> binding.loadingMoreItems.visibility = VISIBLE
                false -> binding.loadingMoreItems.visibility = GONE
            }
        })
    }

}