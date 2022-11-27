package com.example.pmdm02_enriquefernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmdm02_enriquefernandez.modelo.dominio.login.Login;

public class RegistroActivity extends AppCompatActivity {

    private Button bRegistro;
    private EditText etNombre;
    private EditText etEmail;
    private EditText etTelefono;
    private EditText etContrasena;
    private EditText etConfirmarContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //ASIGNO LOS ELEMENTOS
        bRegistro = findViewById(R.id.bRegistro);
        etNombre = findViewById(R.id.etRegistroNombre);
        etEmail = findViewById(R.id.etRegistroEmail);
        etTelefono = findViewById(R.id.etRegistroTelefono);
        etContrasena = findViewById(R.id.etRegistroContrasena);
        etConfirmarContrasena = findViewById(R.id.etRegistroConfirmarContrasena);
        //EVENTO CLIC DEL BOTON DE REGISTRO
        bRegistro.setOnClickListener(view -> {
            //CENTINELA DE VALIDACION
            Boolean centinela = true;

            if (etNombre.getText().toString().trim().isEmpty()) {
                centinela = false;
                etNombre.setError("El nombre no puede estar vacío");
            }

            String regex = "\\w+[.]?\\w+[@]\\w+[.]\\w{2,5}";
            if (etEmail.getText().toString().trim().isEmpty()) {
                centinela = false;
                etEmail.setError("El email no puede estar vacío");
            } else if (!etEmail.getText().toString().matches(regex)){
                centinela = false;
                etEmail.setError("El email no es válido");
            } else if (Login.usuarioExistente(etEmail.getText().toString())) {
                centinela = false;
                etEmail.setError("El correo ya esta registrado");
            }

            if (etTelefono.getText().toString().trim().isEmpty()) {
                centinela = false;
                etTelefono.setError("El teléfono no puede estar vacío");
            } else if (!etTelefono.getText().toString().matches("[6789]\\d{8}")) {
                centinela = false;
                etTelefono.setError("El teléfono no es válido");
            }

            if (etContrasena.getText().toString().trim().isEmpty()) {
                centinela = false;
                etContrasena.setError("La contraseña no puede estar vacía");
            } else if (etContrasena.getText().toString().matches(".*\\s+.*")){
                centinela = false;
                etContrasena.setError("La contraseña no puede contener espacios en blanco");
            } else if (etContrasena.getText().toString().trim().length() < 8) {
                centinela = false;
                etContrasena.setError("La contraseña no puede tener menos de 8 caracteres");
            }
            
            if(!etConfirmarContrasena.getText().toString().equals(etContrasena.getText().toString())) {
                centinela = false;
                etConfirmarContrasena.setError("La contraseña no coincide");
            }
            
            if(centinela) {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, PlataformasActivity.class));
                finish();
            }
        });
    }
}