package projeto05.com.br.projeto05;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtComprimento, edtLargura, edtAltura;
    Button btnCalcular, btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtComprimento = (EditText) findViewById(R.id.edtComprimento);
        edtLargura = (EditText) findViewById(R.id.edtLargura);
        edtAltura = (EditText) findViewById(R.id.edtAltura);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtComprimento.getText().length() <= 0 ||
                        edtLargura.getText().length()<= 0 ||
                        edtAltura.getText().length()<= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtComprimento.requestFocus();
                } else{
                    Double comprimento = Double.parseDouble(edtComprimento.getText().toString());
                    Double largura = Double.parseDouble(edtLargura.getText().toString());
                    Double altura = Double.parseDouble(edtAltura.getText().toString());

                    Double volume = (comprimento * largura * altura);

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("VOLUME");
                    alerta.setMessage("O volume tem o valor de : "
                            + new DecimalFormat("0.00").format(volume));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtComprimento.setText("");
                edtLargura.setText("");
                edtAltura.setText("");
                edtComprimento.requestFocus();
            }
        });
    }
}
