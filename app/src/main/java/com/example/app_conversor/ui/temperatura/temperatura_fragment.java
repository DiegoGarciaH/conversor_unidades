package com.example.app_conversor.ui.temperatura;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_conversor.R;
import com.example.app_conversor.databinding.FragmentNotificationsBinding;
import com.example.app_conversor.ui.notifications.NotificationsViewModel;

public class temperatura_fragment extends Fragment {

    private TemperaturaFragmentViewModel mViewModel;
    private FragmentNotificationsBinding binding;
    public TextView tv_resultado;
    public Button btn_resultado;
    public Spinner spinner1, spinner2;
    public EditText txt_valor1;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tv_resultado = (TextView) root.findViewById(R.id.tv_resultado);
        txt_valor1 = (EditText) root.findViewById(R.id.txt_valor1);
        spinner1 = (Spinner) root.findViewById(R.id.spinner_1);
        spinner2 = (Spinner) root.findViewById(R.id.spinner_2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.temperaturas, android.R.layout.simple_spinner_item);
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
                tv_resultado.setText("Y");
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
                        if (value.equals("Celsius")) {
                            if (value2.equals("Kelvin")) {

                                valor1 = valor1 + 276.15;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Fahrenheit")) {
                                valor1 = (valor1 * (9 / 5)) + 32;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Kelvin")) {
                            if (value2.equals("Celsius")) {

                                valor1 = valor1 - 273.15;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Fahrenheit")) {
                                valor1 = (valor1 - 273.15) * ((9 / 5) + 32);
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Fahrenheit")) {
                            if (value2.equals("Kelvin")) {

                                valor1 = (valor1- 32) * ((5/9) + 273.15 );
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Celsius")) {
                                valor1 = (valor1- 32) * (5/9) ;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        }
                    }
                }
            }
        });

                        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TemperaturaFragmentViewModel.class);
        // TODO: Use the ViewModel
    }

}