package cl.cutiko.navigationpoc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.cutiko.navigationpoc.R
import cl.cutiko.navigationpoc.databinding.FragmentFourthBinding
import cl.cutiko.navigationpoc.databinding.FragmentSecondBinding
import cl.cutiko.navigationpoc.databinding.FragmentThirdBinding

class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentFourthBinding.inflate(inflater, container, false)
        return this.binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

}