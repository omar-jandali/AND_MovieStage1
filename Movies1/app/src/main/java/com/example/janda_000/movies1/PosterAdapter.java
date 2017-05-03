package com.example.janda_000.movies1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by janda_000 on 4/30/2017.
 */

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder> {

    // the following stores the number of items in the grid
    private int posterNumbers;

    // the following is what will be used to store the button to be called later for the click
    private Button detailsButton;

    // This is the context that will be used for the activity in the Intent
    private Context currentContext;

    public PosterAdapter(int numberOfPosters, Context context){
        posterNumbers = numberOfPosters;
        currentContext = context;

    }

    @Override
    public PosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int posterId = R.layout.grid_item_list;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachToParentNow = false;

        View view = inflater.inflate(posterId, parent, attachToParentNow);
        PosterViewHolder posterHolder = new PosterViewHolder(view);

        return posterHolder;
    }

    @Override
    public void onBindViewHolder(PosterViewHolder holder, int position) {

        // the following is going to be the onClickListener for the button to take the user from
        // from the main activity to the details activity
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Class destination = DetailsActivity.class;
                Intent intent = new Intent(view.getContext(), destination);
                currentContext.startActivity(intent);
            }
        });

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return posterNumbers;
    }

    class PosterViewHolder extends RecyclerView.ViewHolder {

        TextView posterNumberView;
        ImageView posterImage;

        public PosterViewHolder(View itemView) {
            super(itemView);
            posterNumberView = (TextView) itemView.findViewById(R.id.movie_poster);
            posterImage = (ImageView) itemView.findViewById(R.id.poster_image);
        }

        void bind(int itemIndex){
            posterNumberView.setText(String.valueOf(itemIndex));
            posterImage.setBackgroundResource(R.drawable.mattered);

        }

    }

}
