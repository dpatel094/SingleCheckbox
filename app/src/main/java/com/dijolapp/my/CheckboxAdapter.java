package com.dijolapp.my;// CheckboxAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CheckboxAdapter extends RecyclerView.Adapter<CheckboxAdapter.ViewHolder> {
    private List<Item> items;
    private int selectedItemPosition = RecyclerView.NO_POSITION;

    public CheckboxAdapter(List<Item> items) {
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkbox;

        public ViewHolder(View itemView) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.checkbox_item);
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        if (selectedItemPosition == RecyclerView.NO_POSITION) {
                            selectedItemPosition = 0; // Set it to a valid index
                        }
                        if (position != selectedItemPosition) {
                            items.get(selectedItemPosition).setChecked(false);
                            selectedItemPosition = position;
                        }
                        items.get(position).setChecked(checkbox.isChecked());
                        notifyDataSetChanged();
                    }
                }
            });
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkbox, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.checkbox.setText(item.getName());
        holder.checkbox.setChecked(item.isChecked());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
