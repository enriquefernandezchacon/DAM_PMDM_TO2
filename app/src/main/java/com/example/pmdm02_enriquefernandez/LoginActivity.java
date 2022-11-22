package com.example.pmdm02_enriquefernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm02_enriquefernandez.modelo.dominio.login.Login;
import com.example.pmdm02_enriquefernandez.modelo.dominio.login.LoginStatus;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button bLogin = findViewById(R.id.bLogin);
        TextView tvRegistro = findViewById(R.id.tvRegistro);
        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etContrasena = findViewById(R.id.etPassword);

        bLogin.setOnClickListener(view -> {
            String user = etUsuario.getText().toString();
            String pass = etContrasena.getText().toString();

            LoginStatus status = Login.comprobarLogin(user, pass);
            if (status.equals(LoginStatus.USER_FAIL)) {
                Toast.makeText(this, "LOGIN: Usuario incorrecto.", Toast.LENGTH_SHORT).show();
            } else if (status.equals(LoginStatus.PASS_FAIL)) {
                Toast.makeText(this, "LOGIN: Contraseña incorrecta.", Toast.LENGTH_SHORT).show();
            } else if (status.equals(LoginStatus.OK)) {
                Intent intent = new Intent(this, PlataformasActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Error en el login.", Toast.LENGTH_SHORT).show();
            }
        });

        tvRegistro.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);
            finish();
        });
    }
}