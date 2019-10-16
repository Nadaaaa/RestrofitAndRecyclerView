package com.nada.restrofitandrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nada.restrofitandrecyclerview.models.Ad;

import java.util.List;

/* TODO: Step 5
* Creating the Adapter To Create the Adapter for any View you have to start with a View Holder check the one down there which called "AdsViewHolder"
* */

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.AdsViewHolder> {

    private Context context;
    private List<Ad> adList;
    private final ListItemClickListener clickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int clickedItemIndex);
    }

    public AdsAdapter(Context context, List<Ad> adList, ListItemClickListener clickListener) {
        this.context = context;
        this.adList = adList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // add the item_ad as the layout that you are gonna repeat

        int layout = R.layout.item_ad;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, viewGroup, false);
        return new AdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsViewHolder adsViewHolder, int i) {
        // call the bind function and pass the list item, of the current position to it, "i" here is the current position
        adsViewHolder.bind(adList.get(i));
    }

    @Override
    public int getItemCount() {
        // add the size of the list so the recycler view have only the size of this list you want
        return adList.size();
    }


    /* TODO Step 6
    * Creating a view Holder For the item_Ad layout
    * and assign the data of the object to it using the bind function
    * so the text that represent the name, add the ads name to it and so on
    * also i added the click listener interface in case you want to click on any view in the recycler view
    * so the view holder here is to deal with each view in the recycler View
    * */
    class AdsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView item_image;
        TextView item_name;
        TextView item_description;

        AdsViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_description);
        }

        void bind(Ad ad) {
            item_name.setText(ad.getName());
            item_description.setText(ad.getDescription());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onListItemClicked(getAdapterPosition());
        }

    }
}