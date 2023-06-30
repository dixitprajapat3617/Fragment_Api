package com.app.tupplecompany.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.tupplecompany.R
import com.app.tupplecompany.databinding.FragmentListBinding
import com.app.tupplecompany.databinding.FragmentSetBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentListBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {

            var name=binding.etName.text.toString().trim()

            var bundle=Bundle()
            bundle.putString("NAME",name)
            var fragment=SetFragment()
            fragment.arguments=bundle

            var manager=requireActivity().supportFragmentManager
            var transation=manager.beginTransaction()
            transation.replace(R.id.fragment_container,fragment)
            transation.commit()



        }

    }


}