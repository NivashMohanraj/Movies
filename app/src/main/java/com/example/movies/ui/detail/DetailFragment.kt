package com.example.movies.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movies.MAIN
import com.example.movies.R
import com.example.movies.SaveShared
import com.example.movies.databinding.FragmentDetailBinding
import com.example.movies.models.MovieItemModel

class DetailFragment : Fragment() {

    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    lateinit var currentMovie: MovieItemModel
    private var isFavorite = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(inflater, container, false)
        currentMovie = arguments?.getSerializable("movie") as MovieItemModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBool = SaveShared.getFavorite(MAIN, currentMovie.id.toString())
        val viewModel = ViewModelProvider(this).get(DetailViewModel:: class.java)

        if (isFavorite != valueBool) {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        Glide.with(MAIN).load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${currentMovie.poster_path}")

            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetail)

        binding.tvTitleDetail.text = currentMovie.title
        binding.tvDateDetail.text = currentMovie.release_date
        binding.tvDescription.text = currentMovie.overview

        binding.imgDetailFavorite.setOnClickListener{
            if (isFavorite == valueBool) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), true)
                viewModel.insert(currentMovie) {}
                isFavorite = true
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                viewModel.delete(currentMovie) {}
                SaveShared.setFavorite(MAIN, currentMovie.id.toString(), false)
                isFavorite = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}