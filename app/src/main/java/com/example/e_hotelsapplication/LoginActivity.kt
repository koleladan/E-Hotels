package com.example.e_hotelsapplication

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.e_hotelsapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            login()
        }
        binding.txtuser.setOnClickListener{
            startActivity(Intent
                (this@LoginActivity,SignUpActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

        }
        auth = FirebaseAuth.getInstance()
    }

    private fun login() {
        val email = binding.edtemail.text.toString().trim()
        if (email.isEmpty()) {
            binding.edtemail.error = "Enter email"
        }
        val pin = binding.edtpin.text.toString().trim()
        if (pin.isEmpty()) {
            binding.edtpin.error = "Enter password"
        } else {
            val progressDialog = ProgressDialog(this@LoginActivity)
            progressDialog.setMessage("loading...")
            progressDialog.setCancelable(false)
            progressDialog.show()


            auth.signInWithEmailAndPassword(email, pin)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        progressDialog.dismiss()
                        startActivity(
                            Intent(
                                this@LoginActivity,
                                RestaurentListActivity::class.java
                            )
                        )
                        Toast.makeText(applicationContext, "Login Success.", Toast.LENGTH_SHORT)
                            .show()
                        finish()

                    } else {
                        progressDialog.dismiss()
                        Toast.makeText(
                            applicationContext,
                            "User does not exist",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e(ContentValues.TAG, "signupWithCustomToken:failure", task.exception)
                    }
                }

        }
    }
}