package com.example.bai1trenlop

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
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
import com.example.bai1trenlop.ui.theme.Bai1trenlopTheme

class MainActivity : ComponentActivity() {
    private lateinit var editTextMSSV: EditText
    private lateinit var editTextName: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var buttonSelectBirthDate: Button
    private lateinit var calendarView: CalendarView
    private lateinit var spinnerWard: Spinner
    private lateinit var spinnerDistrict: Spinner
    private lateinit var spinnerCity: Spinner
    private lateinit var checkBoxSports: CheckBox
    private lateinit var checkBoxMovies: CheckBox
    private lateinit var checkBoxMusic: CheckBox
    private lateinit var checkBoxAgree: CheckBox
    private lateinit var buttonSubmit: Button

    private var birthDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view
        editTextMSSV = findViewById(R.id.editTextMSSV)
        editTextName = findViewById(R.id.editTextName)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        buttonSelectBirthDate = findViewById(R.id.buttonSelectBirthDate)
        calendarView = findViewById(R.id.calendarView)
        spinnerWard = findViewById(R.id.spinnerWard)
        spinnerDistrict = findViewById(R.id.spinnerDistrict)
        spinnerCity = findViewById(R.id.spinnerCity)
        checkBoxSports = findViewById(R.id.checkBoxSports)
        checkBoxMovies = findViewById(R.id.checkBoxMovies)
        checkBoxMusic = findViewById(R.id.checkBoxMusic)
        checkBoxAgree = findViewById(R.id.checkBoxAgree)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        // Sự kiện chọn ngày sinh
        buttonSelectBirthDate.setOnClickListener {
            calendarView.visibility =
                if (calendarView.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            birthDate = "$dayOfMonth/${month + 1}/$year"
            buttonSelectBirthDate.text = "Ngày sinh: $birthDate"
            calendarView.visibility = View.GONE
        }

        // Sự kiện nhấn Submit
        buttonSubmit.setOnClickListener {
            if (validateForm()) {
                // Xử lý dữ liệu ở đây
                Toast.makeText(this, "Thông tin hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm(): Boolean {
        // Kiểm tra các trường thông tin
        if (editTextMSSV.text.isBlank()) {
            editTextMSSV.error = "Vui lòng nhập MSSV"
            return false
        }

        if (editTextName.text.isBlank()) {
            editTextName.error = "Vui lòng nhập họ tên"
            return false
        }

        if (radioGroupGender.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editTextEmail.text.isBlank()) {
            editTextEmail.error = "Vui lòng nhập email"
            return false
        }

        if (editTextPhone.text.isBlank()) {
            editTextPhone.error = "Vui lòng nhập số điện thoại"
            return false
        }

        if (birthDate.isEmpty()) {
            Toast.makeText(this, "Vui lòng chọn ngày sinh", Toast.LENGTH_SHORT).show()
            return false
        }

        if (spinnerWard.selectedItem == null || spinnerDistrict.selectedItem == null || spinnerCity.selectedItem == null) {
            Toast.makeText(this, "Vui lòng chọn địa chỉ đầy đủ", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!checkBoxAgree.isChecked) {
            Toast.makeText(this, "Bạn phải đồng ý với các điều khoản", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}