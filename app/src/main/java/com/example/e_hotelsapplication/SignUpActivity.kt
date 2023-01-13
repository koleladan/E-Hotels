package com.example.e_hotelsapplication

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.e_hotelsapplication.Data.User
import com.example.e_hotelsapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private  lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth
    private lateinit var databaseref:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val actionBar: ActionBar? =supportActionBar
        actionBar?.hide()
        binding.btn.setOnClickListener {
            signup()
        }
        auth = FirebaseAuth.getInstance()


        binding.txtuser.setOnClickListener{
            val intent =Intent(this@SignUpActivity,LoginActivity::class.java)
            startActivity(intent)
        }


    }

    private fun signup() {
        val fname = binding.edtfname.text.toString().trim()
        if (fname.isEmpty()){
            binding.edtfname.error = "Enter first name"
        }
        val lname = binding.edtlname.text.toString().trim()
        if (lname.isEmpty()){
            binding.edtlname.error = "Enter last name"
        }
        val email = binding.edtemail.text.toString().trim()
        if (email.isEmpty()){
            binding.edtemail.error = "Enter email"

        }
        val pin = binding.edtpin.text.toString().trim()
        if (pin.isEmpty()){
            binding.edtpin.error = "Enter pin"
        }
        val confirm = binding.confirmpin.text.toString().trim()
        if (confirm.isEmpty()){
            binding.confirmpin.error = "Confirm pin"
        }
         val progressDialog=ProgressDialog(this@SignUpActivity)
        progressDialog.setMessage("Signing up ...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        auth.createUserWithEmailAndPassword(email, pin)
            .addOnCompleteListener(this){task->
                if (task.isSuccessful){
                    progressDialog.dismiss()
                    val currentUser = auth.currentUser
                    //storing the firstname and lastname in the database if the process is successful
                    addUserToDatabase(fname,lname,email,pin,confirm,currentUser?.uid)

                    //val currentuserdatabase = databaseref.child((currentUser?.uid!!))
                    //currentuserdatabase.child("fname").setValue(binding.edtfname.text.toString())
                    //currentuserdatabase.child("lname").setValue(binding.edtlname.text.toString())
                    Toast.makeText(applicationContext, "Registration Success.", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@SignUpActivity, RestaurentListActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, "Error occurred", Toast.LENGTH_SHORT).show()
                    Log.e(ContentValues.TAG, "signupWithCustomToken:failure", task.exception)
                }
            }

    }
    private fun addUserToDatabase(fname: String, lname: String, email: String, pin: String, confirm: String, uid: String?
    ){
        databaseref = FirebaseDatabase.getInstance().getReference()
        databaseref.child("user").child(uid!!).setValue(User(lname,fname,email,pin,confirm))

    }

}
