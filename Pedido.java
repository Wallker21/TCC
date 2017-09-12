package columbia.practicafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Pedido extends AppCompatActivity implements View.OnClickListener {
    private Spinner sSabor, sTamaño;
    private EditText etCantidad;
    private Button bAceptar, bCancelar;
    private String[] sabor={"Muzzarella", "Pepperoni", "4 Quesos", "Catupiry con Pollo"};
    private String[] tamaño={"Personal", "Mediano", "Grande", "Familiar"};
    private ArrayList<Pizza> pedido;
    private LinearLayout botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        bAceptar=(Button) findViewById(R.id.bAceptar);
        bAceptar.setOnClickListener(this);

        bCancelar=(Button) findViewById(R.id.bCancelar);
        bCancelar.setOnClickListener(this);

        sSabor=(Spinner) findViewById(R.id.sSabor);
        sTamaño=(Spinner) findViewById(R.id.sTamaño);

        etCantidad=(EditText) findViewById(R.id.etCantidad);

        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sabor);
        sSabor.setAdapter(adaptador);

        ArrayAdapter<String> adaptador2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tamaño);
        sTamaño.setAdapter(adaptador2);

        pedido= new ArrayList<>();

        botones=(LinearLayout) findViewById(R.id.botones);



    }



    @Override
    public void onClick(View view) {

        if (view.getId()==bCancelar.getId()){
            finish();
        }

        if (view.getId()==bAceptar.getId()){

            /*Pizza pizza = new Pizza(sSabor.getSelectedItem().toString(), sTamaño.getSelectedItem().toString(), Integer.parseInt(etCantidad.getText().toString()));
            pedido.add(pizza);
            Toast.makeText(this, "Registro Insertado", Toast.LENGTH_LONG).show();
            System.out.println(pedido);*/

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activitu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.mAgregar){
            abrirAgregar();
        }
        if (item.getItemId()==R.id.mPedido){
            abrirPedidos();
        }
        return super.onOptionsItemSelected(item);
    }



    private void abrirAgregar() {
        Pizza pizza = new Pizza(sSabor.getSelectedItem().toString(),sTamaño.getSelectedItem().toString(),Integer.parseInt(etCantidad.getText().toString()));
        pedido.add(pizza);
        Toast.makeText(this, "Pedido Insertado",Toast.LENGTH_SHORT).show();
        /*if(pedido.size()!=0){
            botones.setVisibility(View.VISIBLE);
        }*/
        System.out.println(pedido);
    }


    private void abrirPedidos() {
        Intent intent = new Intent(this, MostrarPedido.class);
        intent.putExtra("Pedido",pedido);
        startActivity(intent);


    }
}



