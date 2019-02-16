package yadunandan.shubhamservice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.zip.Inflater;

public class service extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner s1;
    String ServiceType=null;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.service,null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        s1=(Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adaptor=ArrayAdapter.createFromResource(getActivity(),R.array.spinnervalue,android.R.layout.simple_spinner_item);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adaptor);
        s1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text;
        text=parent.getItemAtPosition(position).toString();
        ServiceType=text;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
