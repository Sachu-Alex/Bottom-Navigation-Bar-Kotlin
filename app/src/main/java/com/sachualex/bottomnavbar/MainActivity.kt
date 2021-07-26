package com.sachualex.bottomnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sachualex.bottomnavbar.fragments.CallFragment
import com.sachualex.bottomnavbar.fragments.CameraFragment
import com.sachualex.bottomnavbar.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val cameraFragment = CameraFragment()
    private val callFragment   =  CallFragment()
    private val settingsFragment= SettingsFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(cameraFragment)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_camera->replaceFragment(cameraFragment)
                R.id.ic_call->replaceFragment(callFragment)
                R.id.ic_settings->replaceFragment(settingsFragment)

            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}