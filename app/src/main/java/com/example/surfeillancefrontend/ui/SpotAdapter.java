package com.example.surfeillancefrontend.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.SpotViewHolder> {
    List<Location> spots;

    public SpotAdapter(List<Location> spots) {
        this.spots = spots;
    }
    @NonNull
    @NotNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int itemPosition) { // creates new view holders for the items
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_item_layout, viewGroup, false);
        return new SpotViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull SpotViewHolder spotViewHolder, int itemPosition) { // binds data from your dataset to the views within the ViewHolder. This method is called by the RecyclerView when an item is about to be displayed in the UI (when it's scrolled on, or if the contents of the item need to be updated) and fetches the appropriate data.
        // The SpotViewHolder parameter is an instance of the custom ViewHolder class that we just created and holds references to the views in the item layout.
        // The int is the position of the item in the dataset which needs to be bound to the views.
        Location spot = spots.get(itemPosition);
        spotViewHolder.spotName.setText(spot.getName());
        spotViewHolder.longitude.setText(spot.getLongitude());
        spotViewHolder.latitude.setText(spot.getLatitude());
        spotViewHolder.timezone.setText((spot.getTimezone()));
        spotViewHolder.waveDirection.setText(spot.getWaveDirection());
    }
    @Override
    public int getItemCount() {
        return spots.size();
    }
    public static class SpotViewHolder extends RecyclerView.ViewHolder {
        // we are creating a custom ViewHolder class here - it holds references to all the views (Button/s, TextView/s etc.) in the item layout i.e., location_item_layout.xml.
        // declare here the Views (Button/s, TextView/s etc) defined in location_item_layout.xml
        private TextView spotName;
        private TextView longitude;
        private TextView latitude;
        private TextView timezone;
        private TextView waveDirection;

        // SpotViewHolder acts as a cache, and stores references to the item views, reducing the need to keep calling findViewById() method every time the views need to be updated. This greatly reduces computational overhead and memory usage.
        public SpotViewHolder(@NonNull @NotNull View itemView) { 
            super(itemView); //  the super keyword is calling the ViewHolder super class' constructor which initialises the ViewHolder with the root view of the item layout
            // The variables we've declared need to have a particular view element attached to them. We do this via the id we gave them in the item_layout.xml file:
            spotName = itemView.findViewById(R.id.spotName);
            longitude = itemView.findViewById(R.id.longitude);
            latitude = itemView.findViewById(R.id.latitude);
            timezone = itemView.findViewById(R.id.timezone);
            waveDirection = itemView.findViewById(R.id.waveDirection);
        }
    }

}
