package com.bhushan.chatapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {

    private lateinit var  editEmail: EditText
    private lateinit var  editPassword: EditText
    private lateinit var  btnLogin: Button
    private lateinit var  btnSignUp: Button
    private lateinit var mAuth : FirebaseAuth

//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            val intent  = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {

            // variable for saving the user email and password
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

            // calling login function
            login(email,password);
        }


    }

    private fun login(email:String,password: String){
        // login for login user
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Code for Logging in
                    val intent = Intent(this@LogIn,MainActivity::class.java )
                    finish()
                    startActivity(intent)


                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@LogIn,"User does not exist",Toast.LENGTH_SHORT).show()

                }
            }


    }
}