package com.example.kotlinlogin

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlogin.databinding.ActivityMainBinding
import com.example.kotlinlogin.databinding.RegisterBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        binding.btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val userBinding: RegisterBinding
                val dialogBuilder = AlertDialog.Builder(this@MainActivity)
                var userDialog: AlertDialog

                userBinding = RegisterBinding.inflate(layoutInflater)
                dialogBuilder.setView(userBinding.root)
                userDialog = dialogBuilder.create()
                userDialog.show()

                userBinding.btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "취소되었습니다.", Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }
                userBinding.btnRegister.setOnClickListener {
                    binding.tvName.text = userBinding.etName2.text.toString()
                    binding.tvGender.text = userBinding.etGender2.text.toString()
                    binding.tvId.text = userBinding.etId2.text.toString()
                    binding.tvPassword.text = userBinding.etPassword2.text.toString()
                    if (binding.tvName.getVisibility() == View.INVISIBLE) {
                        binding.tvName.setVisibility(View.VISIBLE);
                    }
                    if (binding.tvGender.getVisibility() == View.INVISIBLE) {
                        binding.tvGender.setVisibility(View.VISIBLE);
                    }
                    if (binding.tvId.getVisibility() == View.INVISIBLE) {
                        binding.tvId.setVisibility(View.VISIBLE);
                    }
                    if (binding.tvPassword.getVisibility() == View.INVISIBLE) {
                        binding.tvPassword.setVisibility(View.VISIBLE);
                    }
                    userDialog.dismiss()
                }
            }

        })
    }
}