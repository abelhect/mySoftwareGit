package org.tutorials.hectorsdesign.udemymaterialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import org.tutorials.hectorsdesign.udemymaterialdesign.R;
import org.tutorials.hectorsdesign.udemymaterialdesign.network.VolleySingleton;
import org.tutorials.hectorsdesign.udemymaterialdesign.pojo.Movie;

import java.util.ArrayList;

/**
 * Created by abelhectMACHOME on 9/18/16.
 */
public class AdapterBoxOffice extends RecyclerView.Adapter<AdapterBoxOffice.ViewHolderBoxOffice> {

    private ArrayList<Movie> listMovies = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
//    private DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//    private int previousPosition=0;
//
//
    public AdapterBoxOffice(Context context) {
//
        layoutInflater = LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
    }

    public void setMovies(ArrayList<Movie> listMovies) {
        this.listMovies = listMovies;
        notifyItemRangeChanged(0, listMovies.size());
//        notifyDataSetChanged();
    }

    @Override
    public ViewHolderBoxOffice onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_movie_box_office_layout, parent, false);
        ViewHolderBoxOffice viewHolder = new ViewHolderBoxOffice(view);
        return viewHolder;
    }
//
    @Override
    public void onBindViewHolder(ViewHolderBoxOffice holder, int position) {
        Movie currentMovie = listMovies.get(position);
        holder.movieTitle.setText(currentMovie.getTitle());
        holder.movieReleaseDate.setText(currentMovie.getReleaseDate().toString());
//        Date movieReleaseDate = currentMovie.getReleaseDateTheater();
//        if (movieReleaseDate != null) {
//            String formattedDate = dateFormatter.format(movieReleaseDate);
//            holder.movieReleaseDate.setText(formattedDate);
//        } else {
//            holder.movieReleaseDate.setText(Constants.NA);
//        }
//
//        int audienceScore = currentMovie.getAudienceScore();
//        if (audienceScore == -1) {
//            holder.movieAudienceScore.setRating(0.0F);
//            holder.movieAudienceScore.setAlpha(0.5F);
//        } else {
//            holder.movieAudienceScore.setRating(audienceScore / 20.0F);
//            holder.movieAudienceScore.setAlpha(1.0F);
//        }
//
//        if(position>previousPosition)
//        {
//            AnimationUtils.animate(holder,true);
//        }
//        else{
//            AnimationUtils.animate(holder, false);
//        }
//        previousPosition=position;
//
//
        String urlThumnail = currentMovie.getPosterPath();
        loadImages(urlThumnail, holder);

    }
//
//
    private void loadImages(String urlThumbnail, final ViewHolderBoxOffice holder) {
//        if (!urlThumbnail.equals(Constants.NA)) {
            imageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.movieThumbnail.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
//        }
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }
//
    static class ViewHolderBoxOffice extends RecyclerView.ViewHolder {

        ImageView movieThumbnail;
        TextView movieTitle;
        TextView movieReleaseDate;
        RatingBar movieAudienceScore;

        public ViewHolderBoxOffice(View itemView) {
            super(itemView);
            movieThumbnail = (ImageView) itemView.findViewById(R.id.movie_poster_id);
            movieTitle = (TextView) itemView.findViewById(R.id.movie_title_id);
            movieReleaseDate = (TextView) itemView.findViewById(R.id.movie_date_id);
            movieAudienceScore = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }
}
