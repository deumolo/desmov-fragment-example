package com.deumolo.fragmentexample

import android.content.Context
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
import java.lang.RuntimeException

class FirstFragment : Fragment() {

    interface EditTextListener {
        fun onEditTextValueChanged(value: String)
    }

    interface ButtonSubmitListener {
        fun onButtonSubmit()
    }

    private var editTextListener: EditTextListener? = null
    private var submitButtonListener: ButtonSubmitListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewExample: EditText = view.findViewById(R.id.editText)
        val submitButton: Button = view.findViewById(R.id.button2)

        textViewExample?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                editTextListener?.onEditTextValueChanged(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        submitButton.setOnClickListener {
            submitButtonListener?.onButtonSubmit()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is ButtonSubmitListener) {
            submitButtonListener = context
        } else {
            throw RuntimeException("$context must implement ButtonSubmitListener")
        }

        if(context is EditTextListener) {
            editTextListener = context
        } else {
            throw RuntimeException("$context must implement EditTextListener")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FirstFragment()
                .apply {
                arguments = Bundle().apply {
                }
            }
    }
}