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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        final TextView name,mob,add,rea;
        final Spinner type;
        name=(TextView)view.findViewById(R.id.Name_input);
        mob=(TextView)view.findViewById(R.id.Mobile_input);
        add=(TextView)view.findViewById(R.id.Address_input);
        rea=(TextView)view.findViewById(R.id.Summary_input);
        type= (Spinner) view.findViewById(R.id.spinner);
        final String Status="Pending";
        s1.setOnItemSelectedListener(this);
        Button b1;
        b1=view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(getContext(),"you clicked button",Toast.LENGTH_SHORT).show();
              CustomerService cs=new CustomerService();
              cs.setName(name.getText().toString());
              cs.setMobile(mob.getText().toString());
              cs.setAddress(add.getText().toString());
              cs.setReason(rea.getText().toString());
              cs.setType(type.getSelectedItem().toString());
              cs.setStatus(Status);
              MainActivity.db.daobj().insertServiceRequest(cs);
              Toast.makeText(getActivity(),"insert operation Successfull",Toast.LENGTH_SHORT).show();
            }
        });
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
