package com.app.tupplecompany.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.app.tupplecompany.adapter.UserDataAdapter
import com.app.tupplecompany.api.ApiService
import com.app.tupplecompany.databinding.FragmentSetBinding
import com.app.tupplecompany.model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SetFragment : Fragment() {
    lateinit var retrofit: Retrofit
    lateinit var service: ApiService
    private var namelist= mutableListOf<UserData>()
    lateinit var madapter:UserDataAdapter
    lateinit var binding: FragmentSetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSetBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrofit=Retrofit.Builder()
            .baseUrl("https://www.howtodoandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service=retrofit.create(ApiService::class.java)



        madapter=UserDataAdapter(requireActivity(),namelist)
        binding.recyclerView.layoutManager=GridLayoutManager(requireActivity(),2)
        binding.recyclerView.adapter=madapter

        loadData()

    }

    private fun loadData() {
        service.getUserList().enqueue(object :Callback<MutableList<UserData>>{
            override fun onResponse(
                call: Call<MutableList<UserData>>,
                response: Response<MutableList<UserData>>
            ) {
                if (response.isSuccessful){
                    var res=response.body()
                    namelist=res!!
                    madapter.setitem(namelist)
                }
            }

            override fun onFailure(call: Call<MutableList<UserData>>, t: Throwable) {
                Toast.makeText(requireActivity(), "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }


}