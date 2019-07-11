package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)

        setHasOptionsMenu(true)

        binding.playButton.setOnClickListener {
            // To get an instance of navigation controller
//            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment)
//            it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            it.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

//        binding.playButton.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
//        )

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)   // ? marks a type as nullable
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) || super.onOptionsItemSelected(item)   // !! asserts that an expression is non-null
    }
}
