package com.app.tupplecompany

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.app.tupplecompany.Fragment.ListFragment
import com.app.tupplecompany.Fragment.SetFragment

import com.app.tupplecompany.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolBar.title="List"

        addFragment(ListFragment(), "List")



        binding.bottamNavigation.setOnItemSelectedListener {
            return@setOnItemSelectedListener when(it.itemId){
                R.id.item_list->{
                    addFragment(ListFragment(),"List")
                    true
                }
                R.id.item_set->{
                    addFragment(SetFragment(),"Set")
                    true
                }else->{
                    false
                }
            }
        }
    }

    private fun addFragment(fragment: Fragment,tittle:String) {
        var manager=supportFragmentManager
        var transaction=manager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(tittle)
        transaction.commit()
        binding.toolBar.title="$tittle"

    }




}