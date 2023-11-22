package com.example.loginfbsec3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginfbsec3.databinding.ActivityMainBinding
import com.example.loginfbsec3.databinding.ActivityPostLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class PostLoginActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding : ActivityPostLoginBinding
    //Fireabse auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicializar firebase
        auth = Firebase.auth

        //Buscar btn para cerrar sesióñ
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("¿Quieres salir?")
                .setMessage("Si precionas 'Cerrar sesión', saldras de la aplicación")
                .setNeutralButton("Cancelar") { dialog, which ->
                    // Respond to neutral button press
                }
                .setPositiveButton("Cerrar sesión") { dialog, which ->
                    // Respond to positive button press
                    auth.signOut()
                    finish()
                }
                .show()


        }

        //Realizar el cambio de contraseña

        //Crear un formulario
        //Contraseña actual
        //Contrasena nueva y confirmar la contraseña nueva

        //Relogeo (Volver a iniciar sesión)
        // Y las dos contraseñas son iguales
        //Cambio de contraseña


    }
}