package com.deumolo.fragmentexample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondFragment : Fragment() {

    interface OnDataChangeListener {
        fun onDataChanged(data: String)
    }

    private var onDataChangeListener: OnDataChangeListener? = null

    private var name:String? = null
    private var address:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            address = it.getString(ADDRESS_BUNDLE)
        }
        Log.i("test aris", name.orEmpty())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            address = it.getString(ADDRESS_BUNDLE)
        }
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)

        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewExample: TextView = view.findViewById(R.id.textView2)

        textViewExample.text = "Hello, $name, you're logged in"

    }


    companion object {

        const val NAME_BUNDLE = "name_bundle"
        const val ADDRESS_BUNDLE = "address_bundle"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment()
                .apply {
                    arguments = Bundle().apply {
                        putString(NAME_BUNDLE, param1)
                        putString(ADDRESS_BUNDLE, param2)
                    }
                }
    }
}