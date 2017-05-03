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

    private int posterNumbers;

    private Button detailsButton;

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
