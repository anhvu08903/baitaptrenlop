package com.example.bai2trenlop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private var studentsList: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.students_item, parent, false)
        return StudentViewHolder(view, studentsList)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentsList[position]
        holder.hoten.text = student.hoten
        holder.mssv.text = student.mssv
    }

    override fun getItemCount() = studentsList.size

    class StudentViewHolder(itemView: View, private val studentsList: List<Student>) : RecyclerView.ViewHolder(itemView) {
        val hoten: TextView = itemView.findViewById(R.id.hoten)
        val mssv: TextView = itemView.findViewById(R.id.mssv)
        val searchKeyword: EditText = itemView.findViewById(R.id.searchEditText)

        fun bind(searchKeyword: String): List<String> {
            return studentsList
                .filter { it.hoten.contains(searchKeyword, ignoreCase = true) ||
                        it.mssv.contains(searchKeyword, ignoreCase = true)  }
                .map { "${it.hoten} - ${it.mssv}" }
                .ifEmpty { listOf("Không tìm thấy sinh viên phù hợp") }
        }
    }
}