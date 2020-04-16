package com.example.mattias.movietest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.mattias.movietest.R;
import com.example.mattias.movietest.dal.entities.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "MovieAdapter";
    private List<Movie> mMovieList;
    private OnMovieListner mOnMovieListner;

    public MovieAdapter(List<Movie> movieList, OnMovieListner onMovieListner) {
        mOnMovieListner = onMovieListner;
        mMovieList = movieList;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false), this.mOnMovieListner);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mMovieList != null && mMovieList.size() > 0) {
            return mMovieList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        ImageView thumbnail;
        TextView title;
        OnMovieListner onMovieListner;

        public ViewHolder(View itemView, OnMovieListner onMovieListner) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);

            this.onMovieListner = onMovieListner;
            itemView.setOnClickListener(this);
        }

        protected void clear() {
            thumbnail.setImageDrawable(null);
            title.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);
            final Movie movie = mMovieList.get(position);
            if (movie.getPosterPath() != null) {
                Glide.with(itemView.getContext())
                        .load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath())
                        .into(thumbnail);
            }

            if (movie.getTitle() != null) {
                title.setText(movie.getTitle());
            }
        }

        @Override
        public void onClick(View v) {
            onMovieListner.onMovieClicked(getAdapterPosition());
        }
    }

    public interface OnMovieListner {
        void onMovieClicked(int position);
    }
}