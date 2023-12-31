package com.deumolo.fragmentexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.deumolo.fragmentexample.SecondFragment.Companion.ADDRESS_BUNDLE
import com.deumolo.fragmentexample.SecondFragment.Companion.NAME_BUNDLE

class MainActivity : AppCompatActivity(), FirstFragment.EditTextListener, FirstFragment.ButtonSubmitListener {

    private var currentText = ""

    override fun onEditTextValueChanged(value: String) {
        currentText = value
    }

    override fun onButtonSubmit(){

        val bundle = bundleOf(
            NAME_BUNDLE to currentText,
            ADDRESS_BUNDLE to "Street 456"
        )

        val fragment = SecondFragment()
        fragment.arguments = bundle

        supportFragmentManager.commit {
            replace(R.id.FragmentContainer, fragment)
            addToBackStack(null)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.FragmentContainer)
            }
        }

    }

}