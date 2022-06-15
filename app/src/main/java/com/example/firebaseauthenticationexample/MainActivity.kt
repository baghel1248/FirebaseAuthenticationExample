package com.example.firebaseauthenticationexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var emailtext:EditText=findViewById(R.id.emailedittext)
        var passwordtext:EditText=findViewById(R.id.passwordedittext)
        var submittbuttonhere:Button=findViewById(R.id.submittbutton)
        var loginbuttonhere:Button=findViewById(R.id.loginbutton)
        auth = Firebase.auth
        loginbuttonhere.setOnClickListener {
            var intent:Intent=Intent(applicationContext,LoginActivity::class.java)   //objectmaking and moving to another activity
        startActivity(intent)
        }
        submittbuttonhere.setOnClickListener {
            var email=emailtext.text.toString()
            var password=passwordtext.text.toString()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                       Toast.makeText(applicationContext,"registeration succesful",Toast.LENGTH_LONG).show()
                    }
                    else {
                        Toast.makeText(applicationContext,task.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                }


        }

    }
}