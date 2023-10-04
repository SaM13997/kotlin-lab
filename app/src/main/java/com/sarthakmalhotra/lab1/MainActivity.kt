package com.sarthakmalhotra.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private var adapter: PersonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query = FirebaseDatabase.getInstance().reference.child("people")
        val options: FirebaseRecyclerOptions<Person> = FirebaseRecyclerOptions.Builder<Person>()
            .setQuery(query, Person::class.java)
            .build()

        adapter = PersonAdapter(options)

        val rView: RecyclerView = findViewById(R.id.rView)
        rView.adapter = adapter
        rView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart(): Unit {
        super.onStart()
        adapter?.startListening()
    }


}