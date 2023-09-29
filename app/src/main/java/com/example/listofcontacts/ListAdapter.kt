package com.example.listofcontacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listofcontacts.databinding.ContactItemBinding

class ListAdapter(
    val listener: ListAdapterListener,
    val listOfContacts: MutableList<ContactInfo>
) : RecyclerView.Adapter<ListAdapter.ListItemViewHolder>() {

    class ListItemViewHolder(binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.contactName
        val description = binding.contactDescription
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.name.text = listOfContacts[position].name
        holder.description.text = listOfContacts[position].phone

        holder.root.setOnClickListener {
            listener.onContactClick(listOfContacts[position].phone)
        }
    }

    override fun getItemCount(): Int {
        return listOfContacts.size
    }

    interface ListAdapterListener{
        fun onContactClick(content: String)
    }
}
