package com.example.abdulrahman.trakingsystem;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Abdulrahman on 29/11/17.
 */

public class Register extends DialogFragment implements View.OnClickListener {



    EditText name,idjobs,pass;
Spinner type_dep;
String [] typ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.register,container,false);
        name=(EditText) view.findViewById(R.id.editText);
        idjobs=(EditText)view.findViewById(R.id.editText2);
        pass=(EditText) view.findViewById(R.id.editText3);
        type_dep=(Spinner) view.findViewById(R.id.spinner);
        typ= new String[]{"Police", "Driver", "supervisor"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,typ);
        type_dep.setAdapter(arrayAdapter);

        Button button=(Button) view.findViewById(R.id.button3);
        button.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        MainActivity mainActivity=(MainActivity) getActivity();
        mainActivity.register(type_dep.getSelectedItem().toString(),name.getText().toString(),idjobs.getText().toString(),pass.getText().toString());
        this.dismiss();
    }
}
