package yadunandan.shubhamservice;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Completed extends Fragment {


    public Completed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_completed, container, false);
        RecyclerView rv=v.findViewById(R.id.completedrv);
        List<CustomerService> completedcs;
        completedcs=MainActivity.db.daobj().viewCompleted();
        completedAdaptor ca=new completedAdaptor(getActivity(),completedcs);

        rv.setAdapter(ca);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }

}
