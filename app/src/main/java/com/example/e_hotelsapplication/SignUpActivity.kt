package com.example.e_hotelsapplication
import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.e_hotelsapplication.Data.User
import com.example.e_hotelsapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var  databaseref:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btn.setOnClickListener {
            signUp()
        }
        binding.txtuser.setOnClickListener {
            startActivity(
                Intent(this@SignUpActivity, LoginActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
        }

    }

    private fun signUp() {
        val fname = binding.edtfname.text.toString().trim()
        if (fname.isEmpty()){
            binding.edtfname.error = "Kindly enter first name"
        }
        val lname = binding.edtlname.text.toString().trim()
        if(lname.isEmpty()){
            binding.edtlname.error = "Kindly enter last name"
        }
        val email =binding.edtemail.text.toString().trim()
        if(email.isEmpty()){
            binding.edtemail.error = "Kindly enter email"
        }
        val password = binding.edtpin.text.toString().trim()
        if (password.isEmpty()){
            binding.edtpin.error = "Kindly enter password"
        }
        val  confirm = binding.confirmpin.text.toString().trim()
        if (confirm.isEmpty()){
            binding.confirmpin.error = "Kindly confirm password"
        } else {

            val progressDialog = ProgressDialog(this@SignUpActivity)
            progressDialog.setMessage("Loading...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        progressDialog.dismiss()

                        val currentUser = auth.currentUser

                        addUserToDatabase(fname,lname,email,password,confirm,currentUser?.uid!!
                        )
                        Toast.makeText(
                            applicationContext,
                            "Registration Successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        startActivity(
                            Intent(
                                this@SignUpActivity,
                                RestaurentListActivity::class.java
                            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        )
                    } else {
                        progressDialog.dismiss()
                        Toast.makeText(applicationContext, "Error occurred", Toast.LENGTH_SHORT)
                            .show()
                        Log.e(ContentValues.TAG, "signupWithCustomToken:failure", task.exception)
                    }
                }
        }
    }

    private fun addUserToDatabase(fname: String, lname: String, email: String, password: String, confirm: String,uid:String) {
        databaseref= FirebaseDatabase.getInstance().getReference()
        databaseref.child("user").child(uid).setValue(User(fname,lname,email,password,confirm))

    }


}
