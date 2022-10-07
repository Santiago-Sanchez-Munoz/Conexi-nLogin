package com.example.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    private TextView t;
    //Instanciamos el boton
    private Button _submit;
    String url = "http://localhost:8080/guardar/";

 //   List<Empleado> empleadoList;
    CRUDInterface crudInterface;
    String EmailAddress;
    //Declaración de las variables
    private EditText password_= (EditText) findViewById(R.id.editTextTextPersonName);//Esta es la caja o texto que tiene el password
    private EditText email_= (EditText) findViewById(R.id.editTextTextPersonName2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     

        _submit = findViewById(R.id.submit); //encontrar el botón y como se llama

        _submit.setOnClickListener(new View.OnClickListener(){//Clase anónima, implementación de una interfaz
           @Override
            public void onClick(View view) {//Clase anónima.

               Uri uri= Uri.parse(url);
                //Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                this.readWs();
                //startActivity(intent);
           }
            private   void readWs(){
                Log.d("Test1","Hola");

                StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Test",response);

                        try {
                            JSONObject jsonObject =  new JSONObject(response);

                            String email = jsonObject.getString("email");

                            if (email != null ){
                                Log.d("Test4",email);

                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("email",email);

                                intent.putExtras(bundle);
                                startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("TestE",error.getMessage());
                    }
                })
                {
                    protected Map<String,String> getParams(){
                        Map<String, String> params = new HashMap<>();


                        params.put("password",password_.getText().toString());
                        
                        params.put("email",email_.getText().toString());

                        return params;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(postRequest);
            }
        });
    }
}