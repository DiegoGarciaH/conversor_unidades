package com.example.app_conversor.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app_conversor.R;
import com.example.app_conversor.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    public TextView tv_resultado;
    public Button btn_resultado;
    public Spinner spinner1, spinner2;
    public EditText txt_valor1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tv_resultado = (TextView) root.findViewById(R.id.tv_resultado);
        txt_valor1 = (EditText) root.findViewById(R.id.txt_valor1);
        spinner1 = (Spinner) root.findViewById(R.id.spinner_1);
        spinner2 = (Spinner) root.findViewById(R.id.spinner_2);

        // Cargamos los datos al spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.longitud, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        btn_resultado = (Button) root.findViewById(R.id.btn_calcular);
        btn_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                String value = spinner1.getSelectedItem().toString();
                String value2 = spinner2.getSelectedItem().toString();
                String stringValor1 = txt_valor1.getText().toString();
                if (stringValor1.isEmpty()){
                    tv_resultado.setText("Checa tus Digitos");
                } else {
                    double valor1 = Double.parseDouble(stringValor1);
                    if(valor1 <= 0){
                        tv_resultado.setText("Ingrese una Cantidad Valida");
                    } else {

                        if (value == value2) {
                            Toast.makeText(getContext(), "La conversion es la misma", Toast.LENGTH_SHORT).show();
                        }
                        if (value.equals("Metro")) {
                            if (value2.equals("Centimetro")) {

                                valor1 = valor1 * 100;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Milla")) {
                                valor1 = valor1 / 1609;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Yarda")) {
                                valor1 = valor1 * 1.09361;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie")) {
                                valor1 = valor1 * 3.281;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pulgada")) {
                                valor1 = valor1 * 39.3701;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Centimetro")) {
                            if (value2.equals("Metro")) {

                                valor1 = valor1 / 100;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Milla")) {
                                valor1 = valor1 / 160900;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Yarda")) {
                                valor1 = valor1 / 91.44;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie")) {
                                valor1 = valor1 / 30.48;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pulgada")) {
                                valor1 = valor1 / 2.54;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Milla")) {
                            if (value2.equals("Centimetro")) {

                                valor1 = valor1 * 160934;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro")) {
                                valor1 = valor1 * 1609;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Yarda")) {
                                valor1 = valor1 * 1760;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie")) {
                                valor1 = valor1 * 5280;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pulgada")) {
                                valor1 = valor1 * 63360;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Yarda")) {
                            if (value2.equals("Centimetro")) {

                                valor1 = valor1 * 91.44;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Milla")) {
                                valor1 = valor1 / 1760;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro")) {
                                valor1 = valor1 / 1.094;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie")) {
                                valor1 = valor1 * 3;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pulgada")) {
                                valor1 = valor1 * 36;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Pie")) {
                            if (value2.equals("Centimetro")) {

                                valor1 = valor1 * 30.48;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Milla")) {
                                valor1 = valor1 / 5280;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Yarda")) {
                                valor1 = valor1 / 3;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro")) {
                                valor1 = valor1 / 3.281;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pulgada")) {
                                valor1 = valor1 * 12;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Pulgada")) {
                            if (value2.equals("Centimetro")) {

                                valor1 = valor1 * 2.54;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Milla")) {
                                valor1 = valor1 / 63360;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Yarda")) {
                                valor1 = valor1 / 36;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie")) {
                                valor1 = valor1 / 12;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro")) {
                                valor1 = valor1 / 39.37;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        }
                    }
                }
            }
        } );

                            return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}