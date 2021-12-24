package com.example.tabebi.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.tabebi.R


class FragmentThird: Fragment(R.layout.fragment_third) {

    private lateinit var textView: TextView
    private lateinit var editTextNote: EditText
    private lateinit var buttonAdd: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences("amateratsu", MODE_PRIVATE)
        val text = sharedPreferences.getString("shinigami", "bijo bijuna")
        init()
        textView.text = text

        buttonAdd.setOnClickListener() {
            var note = editTextNote.text.toString()
            var text = textView.text.toString()
            var result = note + "\n" + text
            textView.text = result
            sharedPreferences.edit().putString("shinigami", result).apply()
        }
    }


    private fun init() {
        textView = requireView().findViewById(R.id. textView)
        editTextNote = requireView().findViewById(R.id.editTextNote)
        buttonAdd = requireView().findViewById(R.id.buttonAdd)

    }

}