package com.example.app_conversor.ui.notifications;

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
import com.example.app_conversor.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    public TextView tv_resultado;
    public Button btn_resultado;
    public Spinner spinner1, spinner2;
    public EditText txt_valor1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tv_resultado = (TextView) root.findViewById(R.id.tv_resultado);
        txt_valor1 = (EditText) root.findViewById(R.id.txt_valor1);
        spinner1 = (Spinner) root.findViewById(R.id.spinner_1);
        spinner2 = (Spinner) root.findViewById(R.id.spinner_2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.volumen, android.R.layout.simple_spinner_item);
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
                        if (value.equals("Litro")) {
                            if (value2.equals("Mililitro")) {

                                valor1 = valor1 * 1000;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro Cubico")) {
                                valor1 = valor1 / 1000;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Galon")) {
                                valor1 = valor1 / 3.785;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie Cubico")) {
                                valor1 = valor1 / 28.317;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Mililitro")) {
                            if (value2.equals("Litro")) {

                                valor1 = valor1 / 1000;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro Cubico")) {
                                valor1 = valor1 / 1000000;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Galon")) {
                                valor1 = valor1 / 3785;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie Cubico")) {
                                valor1 = valor1 / 28320;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Metro Cubico")) {
                            if (value2.equals("Mililitro")) {

                                valor1 = valor1 * 1000000;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Litro")) {
                                valor1 = valor1 * 1000;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Galon")) {
                                valor1 = valor1 * 264.2;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie Cubico")) {
                                valor1 = valor1 * 35.315;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Galon")) {
                            if (value2.equals("Mililitro")) {

                                valor1 = valor1 * 3785.41;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro Cubico")) {
                                valor1 = valor1 / 264.2;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Litro")) {
                                valor1 = valor1 * 3.785;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Pie Cubico")) {
                                valor1 = valor1 / 7.48;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else {
                                tv_resultado.setText("Error en la conversion revisa tus datos");
                            }
                        } else if (value.equals("Pie Cubico")) {
                            if (value2.equals("Mililitro")) {

                                valor1 = valor1 * 28320;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Metro Cubico")) {
                                valor1 = valor1 / 35.315;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Galon")) {
                                valor1 = valor1 * 7.48052;
                                String result = String.valueOf(valor1);
                                tv_resultado.setText(result);
                            } else if (value2.equals("Litro")) {
                                valor1 = valor1 * 28.317;
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}