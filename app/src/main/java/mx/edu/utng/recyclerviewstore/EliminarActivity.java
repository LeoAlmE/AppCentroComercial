package mx.edu.utng.recyclerviewstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarActivity extends AppCompatActivity {
    private Button btnEliminarTienda;
    private StoreLab mStore;

    @Override
    public void onBackPressed() {
        Intent intNuevo = new Intent(EliminarActivity.this, MainActivity.class);
        startActivity(intNuevo);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        btnEliminarTienda = (Button) findViewById(R.id.btnEliminarTienda);
        EditText etNombre = findViewById(R.id.etNombre2);

        btnEliminarTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StoreLab mStore = StoreLab.get(getApplicationContext());
                    mStore.deleteStore(etNombre.getText().toString());
                    Toast.makeText(EliminarActivity.this, "Tienda eliminada: " + etNombre.getText().toString(), Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(EliminarActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}