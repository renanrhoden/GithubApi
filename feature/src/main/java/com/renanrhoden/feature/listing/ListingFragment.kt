package com.renanrhoden.feature.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.renanrhoden.feature.databinding.ListingReposFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListingFragment : Fragment() {

    private val viewModel: ListingViewModel by viewModel()
    private lateinit var binding: ListingReposFragmentBinding
    private val adapter: ListingReposAdapter by lazy {
        ListingReposAdapter(requireActivity())
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
        viewModel.repos.observe(viewLifecycleOwner, {
            adapter.list = it.toMutableList()
        })
        viewModel.setup()
    }

}