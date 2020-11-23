package mx.edu.utng.recyclerviewstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabUno = (FloatingActionButton)findViewById(R.id.fab);
        fabUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intNuevo = new Intent(MainActivity.this, NuevoActivity.class);
                startActivity(intNuevo);
                finish();
            }
        });
    }
}