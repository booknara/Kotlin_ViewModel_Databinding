package com.booknara.githubrepo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.booknara.githubrepo.BR
import com.booknara.githubrepo.data.BaseResponse
import com.booknara.githubrepo.viewModel.MainViewModel
import com.booknara.githubrepo.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var _binding: FragmentMainBinding

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.setVariable(BR.viewModel, mainViewModel)
        binding.executePendingBindings()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            val decoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }

        initObserver()
    }

    private fun initObserver() {
        mainViewModel.githubResponseData.observe(viewLifecycleOwner, Observer {result ->
            when (result) {
                is BaseResponse.Success -> {
                    binding.progressbar.visibility = View.INVISIBLE
                    mainViewModel.setAdapterData(result.data.items)
                }
                is BaseResponse.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }                
                is BaseResponse.Error -> {
                    binding.progressbar.visibility = View.INVISIBLE
                }
            }
        })

    }

}
