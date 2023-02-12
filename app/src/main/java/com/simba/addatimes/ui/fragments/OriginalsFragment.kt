package com.simba.addatimes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.simba.addatimes.data.models.Data
import com.simba.addatimes.databinding.FragmentOriginalsBinding
import com.simba.addatimes.ui.adapters.WebSeriesAdapter
import com.simba.addatimes.ui.viewModels.ApiViewModel
import com.simba.addatimes.ui.viewModels.UIEvent
import com.simba.addatimes.utils.isNetworkConnected
import com.simba.addatimes.utils.showProgressBar
import com.simba.addatimes.utils.showToastMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OriginalsFragment : Fragment() {

    private val apiViewModel: ApiViewModel by viewModels()

    private var _binding: FragmentOriginalsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOriginalsBinding.inflate(inflater, container, false)
        if (requireActivity().isNetworkConnected()) {
            apiViewModel.onTriggerEvent(
                UIEvent.GetOriginalsData
            )
        } else {
            binding.tvInternetInfo.visibility = View.VISIBLE
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        apiViewModel.uiState.asLiveData().observe(viewLifecycleOwner) { uiState ->
            val bannerImageList = mutableListOf<SlideModel>()
            uiState.data?.data?.get(0)?.banners?.let {
                it.map { banner ->
                    bannerImageList.add(SlideModel(banner[0].image, ScaleTypes.CENTER_CROP))
                }
            }

            val dataList = mutableListOf<Data>()
            uiState.data?.data?.map {
                if (it.items != null && it.title != null) {
                    dataList.add(it)
                }
            }
            val webSeriesAdapter = WebSeriesAdapter(dataList)
            binding.rvMajor.adapter = webSeriesAdapter
            binding.rvMajor.layoutManager = LinearLayoutManager(requireContext())
            webSeriesAdapter.onItemClick = { itemData ->
                requireActivity().showToastMessage(itemData.title)
            }

            binding.imageSlider.setImageList(bannerImageList, ScaleTypes.CENTER_CROP)

            uiState.isDataLoading.let {
                binding.progressBar.showProgressBar(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}