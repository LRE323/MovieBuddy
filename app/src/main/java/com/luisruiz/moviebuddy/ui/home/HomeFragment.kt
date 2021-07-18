package com.luisruiz.moviebuddy.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.luisruiz.moviebuddy.databinding.FragmentHomeBinding
import com.luisruiz.moviebuddy.model.Movie
import com.luisruiz.moviebuddy.model.NowPlaying
import com.luisruiz.moviebuddy.rest.MainViewModel
import com.luisruiz.moviebuddy.viewmodelfactory.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // The ViewModel for this fragment.
    private lateinit var mainViewModel: MainViewModel

    // Sample textview
    lateinit var tvHome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ViewModel.
        initViewModel()

        // Attempt to get a Movie from the API.
        this.mainViewModel.getMovie("550")

        this.mainViewModel.getNowPlaying()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        this.tvHome = binding.tvHome

        // Observe the LiveData.
        initObservations()

        /*homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViewModel() {

        // Create a new ViewModelFactory.
        val factory = ViewModelFactory()

        // Create a new ViewModelProvider.
        val viewModelProvider = ViewModelProvider(this, factory)

        // Create a new ViewModel.
        mainViewModel = viewModelProvider.get(MainViewModel::class.java)

    }

    private fun initObservations() {

        // Create the observer.
        /*val observer: Observer<Movie> = Observer<Movie> { movie ->
            this.tvHome.text = movie.title
        }*/

        val observer2 = Observer<NowPlaying> { nowPlaying ->

            val foo = mutableListOf<Movie>(nowPlaying.results[0], nowPlaying.results[1], nowPlaying.results[2])

            this.tvHome.text = foo.toString()
        }

        // Observe the LiveData.
        //this.mainViewModel.movieLiveData.observe(viewLifecycleOwner, observer)
        this.mainViewModel.nowPlayingLiveData.observe(viewLifecycleOwner, observer2)
    }
}