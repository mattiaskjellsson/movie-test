package com.example.mattias.movietest.adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mattias.movietest.R;
import com.example.mattias.movietest.dal.DbAdapter;
import com.example.mattias.movietest.dal.entities.Movie;

public class MovieDetailsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Movie mMovie;
    private boolean isFavorite;
    private DbAdapter dbAdapter;
    private OnMovieDetailsListner onMovieDetailsListner;

    public MovieDetailsAdapter(Movie movie, OnMovieDetailsListner onMovieDetailsListner, boolean isFavorite) {
        mMovie = movie;
        this.isFavorite = isFavorite;
        this.onMovieDetailsListner = onMovieDetailsListner;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieDetailsAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details_item, parent, false),
                onMovieDetailsListner);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mMovie != null) {
            return 1;
        } else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        ImageView thumbnail;
        TextView title;
        TextView description;
        TextView link;
        ImageButton favorite;
        OnMovieDetailsListner onMovieDetailsListner;

        public ViewHolder(View itemView, OnMovieDetailsListner onMovieDetailsListner) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            link = itemView.findViewById(R.id.link);
            favorite = itemView.findViewById(R.id.favorites);
            dbAdapter = new DbAdapter(itemView.getContext());

            this.onMovieDetailsListner = onMovieDetailsListner;
        }

        protected void clear() {
            thumbnail.setImageDrawable(null);
            title.setText("");
            link.setText("");
            favorite.setBackgroundColor(0);
        }

        public void onBind(int position) {
            super.onBind(position);
            final Movie movie = mMovie;
            if (movie.getPosterPath() != null) {
                Glide.with(itemView.getContext())
                        .load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath())
                        .into(thumbnail);
            }

            if (movie.getTitle() != null) {
                title.setText(movie.getTitle());
            }

            if (movie.getOverview() != null) {
                description.setText(movie.getOverview());
            }

            if (movie.getImdbId() != null) {
                link.setText(movie.getImdbId());
            }

            if (isFavorite) {
                favorite.setImageResource(R.drawable.star_filled);
            } else {
                favorite.setImageResource(R.drawable.star_unfilled);
            }

            favorite.setOnClickListener(c -> {

                if(isFavorite) {
                    isFavorite = false;
                    favorite.setImageResource(R.drawable.star_unfilled);
                    dbAdapter.delete(mMovie.getId());
                }else {
                    isFavorite = true;
                    favorite.setImageResource(R.drawable.star_filled);
                    dbAdapter.insertData(mMovie.getTitle(), mMovie.getId());
                }
            });

            link.setOnClickListener(v -> {
                if (movie.getImdbId() != null) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.imdb.com/" + movie.getImdbId()));
                        itemView.getContext().startActivity(intent);
                    } catch (Exception e) {
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            onMovieDetailsListner.onFavoriteClicked();
        }

    }

    public interface OnMovieDetailsListner {
        void onFavoriteClicked();
    }
}
