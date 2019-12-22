package appjam.hackathon.project.isaac.momentstory.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import appjam.hackathon.project.isaac.momentstory.R;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder>{

    ArrayList<Date> items = new ArrayList<Date>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.date_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Date item = items.get(position);
        holder.setItem(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 21){

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(Date item){
        items.add(item);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }

        public void setItem(Date item){
            textView.setText(item.getDate());
            textView2.setText(item.getDay());
        }
    }
}
