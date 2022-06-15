package com.example.firebaseauthenticationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var emailid:EditText=findViewById(R.id.loginemailedittext)
        var passswordhere:EditText=findViewById(R.id.loginpasswordedittext)
        var loginbuttonhere:Button=findViewById(R.id.loginbutton2)

        loginbuttonhere.setOnClickListener {
            var loginemail=emailid.text.toString()
            var loginpassword=passswordhere.text.toString()

            auth.signInWithEmailAndPassword(loginemail, loginpassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(applicationContext,"logging in", Toast.LENGTH_LONG).show()


                    } else {
                        Toast.makeText(applicationContext,task.exception.toString(),Toast.LENGTH_LONG).show()

                    }
                }
        }
        auth = Firebase.auth
    }
}