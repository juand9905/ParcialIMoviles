package com.jq.parcialimoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Nombre;
    EditText Salario;
    EditText Mes;
    Button btn_Calcular;
    EditText Prima;
    EditText Cesantias;
    EditText Vacaciones;
    EditText Salud;
    EditText Pension;
    EditText Caja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre = findViewById(R.id.txtNombre);
        Salario = findViewById(R.id.txtSalario);
        Mes = findViewById(R.id.txtMes);
        btn_Calcular = findViewById(R.id.btnCalcular);
        Prima = findViewById(R.id.txtResultadoPrima);
        Cesantias = findViewById(R.id.txtResultadoCesantias);
        Vacaciones = findViewById(R.id.txtResultadoVaciones);
        Salud = findViewById(R.id.txtResultadoSalud);
        Pension = findViewById(R.id.txtResultadoPension);
        Caja = findViewById(R.id.txtResultadoCaja);

        btn_Calcular.setOnClickListener(this);
        Toast.makeText(this, "Bienvenido a su calculo " + Nombre, Toast.LENGTH_SHORT).show();

    }

    public int calcularPrima(int salario, String mes){
        int prima = 0;

        if (mes.equals("Febrero")){
            if (salario<1817052){
                int auxilioTransporte = 106454;
                prima = ((salario+auxilioTransporte)*(28))/360;
            }else {
                prima = (salario * 28)/360;
            }
        }

        if (mes.equals("Abril")||mes.equals("Mayo")||mes.equals("Junio")||mes.equals("Septiembre")||mes.equals("Noviembre")){
            if (salario<1817052){
                int auxilioTrnasporte = 106454;
                prima = ((salario+auxilioTrnasporte)*(30))/360;
            }else {
                prima = (salario * 30)/360;
            }
        }

        if((mes.equals("Enero") || mes.equals("Marzo") || mes.equals("Julio") || mes.equals("Agosto") || mes.equals("Octubre") || mes.equals("Diciembre"))){

            if (salario<1817052){
                int auxilioTransporte = 106454;
                prima = ((salario+auxilioTransporte)*(31))/360;
            }else {
                prima = (salario * 31)/360;
            }
        }

        return prima;
    }

    public int calcularVacaciones(int salario, String mes) {
        int vaca = 0;
        if ((mes.equals("Enero") || mes.equals("Marzo") || mes.equals("Julio") || mes.equals("Agosto") || mes.equals("Octubre") || mes.equals("Diciembre"))) {
            vaca = (salario * 31) / 720;
        }

        if (mes.equals("Febrero")){
            vaca = (salario * 28)/720;
        }

        if (mes.equals("Abril")||mes.equals("Mayo")||mes.equals("Junio")||mes.equals("Septiembre")||mes.equals("Noviembre")){
            vaca = (salario * 30)/720;
        }

        return vaca;
    }

    public int calcularSaludPensionCaja(int salario){
        int aporte= (salario * 4)/(100);

        return  aporte;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalcular: {
                int salario = Integer.parseInt(Salario.getText().toString());
                String mes = Mes.getText().toString();
                int prima = calcularPrima(salario, mes);
                int vacaciones = calcularVacaciones(salario, mes);
                int aportes = calcularSaludPensionCaja(salario);
                Toast.makeText(this, "Total de prima es: "+ prima, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Total de cesantías son: "+ prima, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Total de aportes para salud son: "+ aportes, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Total de aportes para pensión son: "+ aportes, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Total de aportes de la empresa a caja de compensación son: "+ aportes, Toast.LENGTH_LONG).show();
                Prima.setText(" "+ prima);
                Cesantias.setText(" " + prima);
                Vacaciones.setText(""+vacaciones);
                Salud.setText(""+ aportes);
                Pension.setText("" + aportes);
                Caja.setText("" + aportes);

            }
        }
    }
}