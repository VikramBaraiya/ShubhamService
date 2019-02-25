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
        TextView name,mob,add,rea;
        Spinner type;
        name=(TextView)view.findViewById(R.id.name);
        mob=(TextView)view.findViewById(R.id.Mobile);
        add=(TextView)view.findViewById(R.id.Address);
        rea=(TextView)view.findViewById(R.id.Summary);
        type= (Spinner) view.findViewById(R.id.spinner);


        s1.setOnItemSelectedListener(this);
        Button b1;
        final String[] ServiceData=new String[5];
        ServiceData[0]=name.getText().toString();
        ServiceData[1]=mob.getText().toString();
        ServiceData[2]=add.getText().toString();
        ServiceData[3]=rea.getText().toString();
        ServiceData[4]=type.getSelectedItem().toString();


        b1=view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"you clicked button",Toast.LENGTH_SHORT).show();
              /*  DatabaseHelper dh=new DatabaseHelper(getActivity(),ServiceData);
                boolean flag;
                flag=dh.insertData();
                if(flag)
                {
                    Toast.makeText(getContext(),"inserted",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getContext(),"Not ",Toast.LENGTH_SHORT).show();

                }*/
              CustomerService cs=new CustomerService();
             // cs.setId();
              cs.setName(ServiceData[0]);
              cs.setMobile(ServiceData[1]);
              cs.setAddress(ServiceData[2]);
              cs.setReason(ServiceData[3]);
              cs.setType(ServiceData[4]);
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
    //Button b1;

//
    public void AddData(View view) {
        Toast.makeText(getActivity(),"the status has been changed to approved",Toast.LENGTH_SHORT).show();

    }//
}
