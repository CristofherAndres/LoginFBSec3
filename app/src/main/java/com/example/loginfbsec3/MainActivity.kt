package com.example.loginfbsec3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginfbsec3.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding : ActivityMainBinding
    //Fireabse auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicializar firebase con auth
        auth = Firebase.auth


        //El login se activa cuando hace click al boton
        binding.btnLogin.setOnClickListener {

            //Recuperar el correo y contraseña
            val correo = binding.etEmail.text.toString()
            val contrasena = binding.etPassword.text.toString()

            if (correo.isEmpty()){
                binding.etEmail.error = "Ingrese un correo"
                return@setOnClickListener
            }
            if(contrasena.isEmpty()){
                binding.etPassword.error = "Ingrese una constraseña"
            }

            signIn(correo, contrasena)


        }

        //Reconocer si hago click sobre el tvRegistrar
        binding.tvRegistrar.setOnClickListener {
            val intent = Intent(this,registrarActivity::class.java)
            startActivity(intent)
        }

    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Inicio de sesión correcto", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, PostLoginActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this,"ERROR", Toast.LENGTH_LONG).show()
                }
            }
    }
}