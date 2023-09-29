package com.example.listofcontacts

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listofcontacts.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), ListAdapter.ListAdapterListener {

    private lateinit var bindig: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindig = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindig.root)

        val listView = bindig.lista


        listView.adapter = ListAdapter(this, listOnContacts())
        listView.layoutManager = LinearLayoutManager(this)
    }

    override fun onContactClick(content: String) {
        val clipboard: ClipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("text copied", content)
        clipboard.setPrimaryClip(clip)

        Snackbar.make(
            bindig.root,
            "Número copiado para área de transferência",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}

private fun listOnContacts(): MutableList<ContactInfo>{
    return mutableListOf(
        ContactInfo("Pedro", "61999999999"),
        ContactInfo("Lucas", "61888888888"),
        ContactInfo("Vitória", "61777777777"),
        ContactInfo("João", "61666666666"),
        ContactInfo("Marcos", "61555555555"),
        ContactInfo("Marcio", "61444444444"),
        ContactInfo("Zelandia", "61333333333"),
        ContactInfo("Gustavo", "61222222222"),
        ContactInfo("José", "61111111111"),
        ContactInfo("Ricardo", "61988776655"),
        )
}