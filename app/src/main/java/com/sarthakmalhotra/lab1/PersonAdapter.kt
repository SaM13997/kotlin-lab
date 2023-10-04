package com.sarthakmalhotra.lab1

import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class PersonAdapter(options: FirebaseRecyclerOptions<Person>) : FirebaseRecyclerAdapter<Person,PersonAdapter.MyViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(
        holder: PersonAdapter.MyViewHolder,
        position: Int,
        model: Person
    ) {
        holder.nameTextView.text = model.name
        holder.roleTextView.text = model.role

    }
    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.row_layout,parent,false))
    {
        val nameTextView: TextView = itemView.findViewById(R.id.txtName)
        val roleTextView: TextView = itemView.findViewById(R.id.txtRole)

    }
}