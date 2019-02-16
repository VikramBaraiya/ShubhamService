package yadunandan.shubhamservice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class pending extends Fragment {
    RecyclerView rv;
    PendingRecyclerJavaClass prjv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pending,null) ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] Name={"vikram","ravi","krushit","haard","maulik","meet","kd"};
        String[] Type={"Repair","Repair","Repair","Repair","Repair","new ","cancel"};
        String[] Number={"9601019977","9601019988","9601019999","9601019900","9601019911","324324234","34324234"};
        String[] Adress={"abc","def","ghi","jkl","mno","fdsfsdfs","fdsfsdfsffsd"};
        String[] Summary={"pqr","stu","vwx","yz","thats it","dsfsdfsdf","dfsfsfdsfds"};

        rv=view.findViewById(R.id.rv);
        //view.Context c=getActivity();
        prjv=new PendingRecyclerJavaClass(getActivity(),Name,Type,Number,Adress,Summary);
        rv.setAdapter(prjv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
