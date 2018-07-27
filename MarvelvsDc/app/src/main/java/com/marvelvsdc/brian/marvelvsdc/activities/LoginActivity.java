package com.marvelvsdc.brian.marvelvsdc.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marvelvsdc.brian.marvelvsdc.utils.CallBackDialog;
import com.marvelvsdc.brian.marvelvsdc.fragments.DialogFragmentComic;
import com.marvelvsdc.brian.marvelvsdc.R;
import com.marvelvsdc.brian.marvelvsdc.utils.UtILDialogCrate;
import com.marvelvsdc.brian.marvelvsdc.utils.UtilNavigationiActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtContraseña;
    Button btnIngresar;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = findViewById(R.id.edt_email);
        edtContraseña = findViewById(R.id.edt_passowrd);
        btnIngresar = findViewById(R.id.btn_ingresar);
        btnRegistrar = findViewById(R.id.btn_registrar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UtILDialogCrate.createAlertDialog("Inicio de sesion", "Desea iniciar sesion", new CallBackDialog() {
                    @Override
                    public void aceptar() {
                        Toast.makeText(LoginActivity.this, "aceptar", Toast.LENGTH_SHORT).show();
                        String email = edtEmail.getText().toString();
                        String contraseña = edtContraseña.getText().toString();

                        if (email.length()>5 && contraseña.length() > 5){
                            UtilNavigationiActivity.goToActivityFins(LoginActivity.this, SettigActivity.class);
                        } else {
                            Toast.makeText(getApplicationContext(), "Email= " + email + ", Constraseña= " +contraseña , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void cancelar() {
                        Toast.makeText(LoginActivity.this, "cancelar", Toast.LENGTH_SHORT).show();
                        loadDialogFragment(LoginActivity.this);
                    }
                }, LoginActivity.this);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtEmail.setText("Cambio de texto");
                edtContraseña.setText("987654321");
            }
        });

    }


    public void loadDialogFragment(Activity activity){
        FragmentManager fragmentManager = getFragmentManager();
        DialogFragmentComic dialogFragmentComic = DialogFragmentComic.newInstance();
        dialogFragmentComic.show(fragmentManager,"");
    }

}
