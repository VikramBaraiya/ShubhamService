package yadunandan.shubhamservice;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PendingRecyclerJavaClass extends RecyclerView.Adapter<PendingRecyclerJavaClass.Holder> {
    ImageButton ib1;
    Context cx;
    //String[] LayoutValues;
    String[] Name;//={"vikram","ravi","krushit","haard","maulik"};
    String[] Type;//={"Repair","Repair","Repair","Repair","Repair"};
    String[] Number;//={"9601019977","9601019988","9601019999","9601019900","9601019911"};
    String[] Adress;//={"abc","def","ghi","jkl","mno"};
    String[] Summary;//={"pqr","stu","vwx","yz","thats it"};
    String[] StatusButton;
    //status={"pending","pending","pending","pending","pending","pending","pending"};
    PendingRecyclerJavaClass(Context ctx,String[] nm,String tp[],String[] nb,String[] ad, String[] sm,String[] status) {
        cx=ctx;
       // LayoutValues=values;
         Name=nm;//{"vikram","ravi","krushit","haard","maulik"};
         Type=tp;//{"Repair","Repair","Repair","Repair","Repair"};
         Number=nb;//{"9601019977","9601019988","9601019999","9601019900","9601019911"};
         Adress=ad;//{"abc","def","ghi","jkl","mno"};
         Summary=sm;//{"pqr","stu","vwx","yz","thats it"};
        StatusButton=status  ;

        //Status;

    }

    @NonNull
    @Override
    public PendingRecyclerJavaClass.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflate1=LayoutInflater.from(cx);
        View v1=inflate1.inflate(R.layout.layout_for_pending,viewGroup,false);

    //return null;
        return new Holder(v1);

    }

    @Override
    public void onBindViewHolder(@NonNull PendingRecyclerJavaClass.Holder mholder, int i) {
      mholder.st=StatusButton[i];
      //  if(mholder.st=="pending") {
          mholder.name.setText(Name[i]);
          mholder.type.setText(Type[i]);
          mholder.mobile.setText(Number[i]);
          mholder.address.setText(Adress[i]);
          mholder.reason.setText(Summary[i]);
          mholder.st = StatusButton[i];
      //}
       // ImageButton ib1=(ImageButton)it
    }

    @Override
    public int getItemCount() {
        return Name.length;
    }

    ImageButton ib2;

    public class Holder  extends RecyclerView.ViewHolder{
        TextView name,mobile,type,address,reason;
        String st=null;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Name);
            mobile=itemView.findViewById(R.id.Mobile);
            type=itemView.findViewById(R.id.Service);
            address=itemView.findViewById(R.id.Address);
            reason=itemView.findViewById(R.id.Reason);
            ib2=itemView.findViewById(R.id.issueResolved);
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  st="approved";
                    Toast.makeText(cx,"the status has been changed to approved",Toast.LENGTH_SHORT).show();
                    //name=itemView.findViewById(R.id.Name);
                    Name[0]="hi there name is changed ";

                }
            });
          }

    }

}
