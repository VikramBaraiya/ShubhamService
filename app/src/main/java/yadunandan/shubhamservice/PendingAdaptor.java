package yadunandan.shubhamservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PendingAdaptor extends RecyclerView.Adapter<PendingAdaptor.ViewHolder> {

    Context cx;
    List<CustomerService> cs;
    public PendingAdaptor(Context c, List<CustomerService> cs){
        this.cs=cs;
        cx=c;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

     // View v;
      LayoutInflater inflater=LayoutInflater.from(cx);
      View view=inflater.inflate(R.layout.layout_for_pending, viewGroup,false);
      return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int in) {
        final int i=in;
        viewHolder.name.setText(cs.get(i).getName().toString());
        viewHolder.address.setText(cs.get(i).getAddress().toString());
        viewHolder.mobile.setText(cs.get(i).getMobile().toString());
        viewHolder.reason.setText(cs.get(i).getReason().toString());
        viewHolder.type.setText(cs.get(i).getType().toString());
        viewHolder.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cx,"button Clicked",Toast.LENGTH_SHORT).show();
          //      cs.get().setStatus("Completed");
             //   cs.get(j).setStatus("Completed");
                //CustomerService c=new CustomerService();
                cs.get(i).setStatus("completed");
                MainActivity.db.daobj().updateStatus(cs.get(i));
               FragmentManager fm= ((AppCompatActivity)cx).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fm.beginTransaction();
                fragmentTransaction.replace(R.id.screen,new Pending());
                fragmentTransaction.commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return cs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView mobile,address,reason,type;
        Button done;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txtName);
            mobile=itemView.findViewById(R.id.txtNumber);
            address=itemView.findViewById(R.id.txtAddress);
            reason=itemView.findViewById(R.id.txtReason);
            type=itemView.findViewById(R.id.txtType);
            done=itemView.findViewById(R.id.btnDone);



        }
    }
}
