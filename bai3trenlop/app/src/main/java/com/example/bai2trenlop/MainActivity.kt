package com.example.bai2trenlop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bai2trenlop.ui.theme.Bai2trenlopTheme

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val  studentsList = listOf(
            Student("Nguyen Van A", "SV001"),
            Student("Tran Thi B", "SV002"),
            Student("Le Van C", "SV003"),
            Student("Pham Thi D", "SV004"),
            Student("Vu Van E", "SV005"),
            Student("Do Thi F", "SV006"),
            Student("Hoang Van G", "SV007"),
            Student("Bui Thi H", "SV008"),
            Student("Pham Van I", "SV009"),
            Student("Nguyen Thi J", "SV010"),
        )
        studentAdapter = StudentAdapter(studentsList)
        recyclerView.adapter = studentAdapter



    }
}