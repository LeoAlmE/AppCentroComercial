package mx.edu.utng.recyclerviewstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class NuevoActivity extends AppCompatActivity {
    private Button btnAgregar;
    private Button btnEliminar;
    private StoreRecyclerViewAdapter adapterStores;
    private StoreLab mStore;

    @Override
    public void onBackPressed() {
        Intent intNuevo = new Intent(NuevoActivity.this, MainActivity.class);
        startActivity(intNuevo);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        EditText etNombre=findViewById(R.id.etNombre);
        EditText etImagen=findViewById(R.id.etImagen);
        EditText etDir=findViewById(R.id.etDir);
        RatingBar rbVal = findViewById(R.id.ratingBar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StoreLab mStore = StoreLab.get(getApplicationContext());
                    Store r = new Store();
                    r.setNombre(etNombre.getText().toString());
                    r.setUrlPhoto(etImagen.getText().toString());
                    r.setValoracion(rbVal.getRating());
                    r.setDireccion(etDir.getText().toString());
                    mStore.addStore(r);
                    Toast.makeText(NuevoActivity.this, "Tienda guardada: " + r.getNombre() ,Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Toast.makeText(NuevoActivity.this, "Error al guardar",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intNuevo = new Intent(NuevoActivity.this, EliminarActivity.class);
                startActivity(intNuevo);
                finish();
            }
        });

    }
}