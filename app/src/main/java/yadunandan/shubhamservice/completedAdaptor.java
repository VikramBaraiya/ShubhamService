package yadunandan.shubhamservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class completedAdaptor extends RecyclerView.Adapter<completedAdaptor.Holder> {

    List<CustomerService> cust ;
    Context cx;
    public completedAdaptor(Context ct, List<CustomerService> cs){
        cx=ct;
        cust=cs;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(cx);
        View v=inflater.inflate(R.layout.layout_for_completed,viewGroup,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

        holder.n.setText(cust.get(i).getName().toString());
        holder.m.setText(cust.get(i).getMobile().toString());
        holder.a.setText(cust.get(i).getAddress().toString());
        holder.r.setText(cust.get(i).getReason().toString());
        holder.t.setText(cust.get(i).getType().toString());

    }

    @Override
    public int getItemCount() {
        return cust.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView n,m,a,r,t;

        public Holder(@NonNull View itemView) {
            super(itemView);
            n=itemView.findViewById(R.id.txtName);
            m=itemView.findViewById(R.id.txtNumber);
            a=itemView.findViewById(R.id.txtAddress);
            r=itemView.findViewById(R.id.txtReason);
            t=itemView.findViewById(R.id.txtType);

        }
    }
}
