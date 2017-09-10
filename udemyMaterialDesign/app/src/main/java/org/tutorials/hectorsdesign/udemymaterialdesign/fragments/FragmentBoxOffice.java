package org.tutorials.hectorsdesign.udemymaterialdesign.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tutorials.hectorsdesign.udemymaterialdesign.R;
import org.tutorials.hectorsdesign.udemymaterialdesign.adapters.AdapterBoxOffice;
import org.tutorials.hectorsdesign.udemymaterialdesign.extras.Keys;

import static org.tutorials.hectorsdesign.udemymaterialdesign.extras.UrlEndpoints.*;

import org.tutorials.hectorsdesign.udemymaterialdesign.extras.UrlEndpoints;
import org.tutorials.hectorsdesign.udemymaterialdesign.logging.L;
import org.tutorials.hectorsdesign.udemymaterialdesign.network.VolleySingleton;
import org.tutorials.hectorsdesign.udemymaterialdesign.pojo.Movie;
import org.tutorials.hectorsdesign.udemymaterialdesign.udemymaterialdesign.MyApplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.tutorials.hectorsdesign.udemymaterialdesign.extras.Keys.EndpointBoxOffice.*;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBoxOffice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBoxOffice extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //    (This was moved to the UrlEnpoints class) URL for theMOvieDB api "now playing"
//    public static final String URL_THEMOVIEDB_NOW_PLAYING =
// "https://api.themoviedb.org/3/movie/now_playing";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //    Insert variables for volley, imageloader and requestqueue for movie api
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;
    private ArrayList<Movie> listMovies = new ArrayList<>();
    private DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

//    adapter for recycler view
    private AdapterBoxOffice adapterBoxOffice;

//    this is for the UI recycler view
    private RecyclerView listMovieHits;


    public FragmentBoxOffice() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBoxOffice.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBoxOffice newInstance(String param1, String param2) {
        FragmentBoxOffice fragment = new FragmentBoxOffice();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //    Utility method to provide the string with the url + api key + other parameters
//    i used a static import in order to not have to repeat the name of the class at every key location
    public static String getRequestUrl(int limit) {
        return URL_NOW_PLAYING
                + URL_CHAR_QUESTION
                + URL_PARAM_API_KEY + MyApplication.API_KEY_THEMOVIEDB
                + URL_CHAR_AMPERSAND
                + URL_PARAM_PAGE + limit;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//      get instance for the volleysingleton and then get RequestQueue
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
//        sendJsonRequest();  //this was moved to the onCreateView when started using the recycler
    }

    private void sendJsonRequest(){
        //        Creating the JSON object request (inside curly brackets for the movie

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                getRequestUrl(1),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        toast below is just for testing that the api and network response works
//                        L.t(getActivity(), response.toString());
//                        parseJSONResponse(response);
//                        this is for the movies list
                        listMovies=parseJSONResponse(response);
                        adapterBoxOffice.setMovies(listMovies);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }

//    private void parseJSONResponse(JSONObject response)// changed this when implemented recyclerview

    private ArrayList<Movie> parseJSONResponse(JSONObject response){
            ArrayList<Movie> listMovie=new ArrayList<>();
        if(response!=null && response.length()>0){
            //        parsing the array right here
            try {
//            use a static import for the keys
                JSONArray arrayMovies = response.getJSONArray(KEY_RESULTS);
//                in here we are going to parse through the objects inside the json array
                for (int i=0;i<arrayMovies.length();i++){
                    JSONObject currentMovie=arrayMovies.getJSONObject(i);
                    //                  get the id of movie
                    long id=currentMovie.getLong(KEY_ID);
                    //                  get title of movie
                    String title=currentMovie.getString(KEY_TITLE);
//                    get overview of movie
                    String overview=currentMovie.getString(KEY_OVERVIEW);
//                    get date of movie
                    String releaseDate=currentMovie.getString(KEY_DATE);
//                    get poster of movie
//                    String posterPath=currentMovie.getString(KEY_POSTER);
                    String posterPath= UrlEndpoints.URL_POSTER_IMAGE+currentMovie.getString(KEY_POSTER);

//                    Use setter methods from the MOvie pojo
                    Movie movie=new Movie();
                    movie.setId(id);
                    movie.setTitle(title);
                    movie.setOverview(overview);
//                  reformatting the date for later manipulation during searches
                    Date formattedReleaseDate=dateFormat.parse(releaseDate);
                    movie.setReleaseDate(formattedReleaseDate);
                    movie.setPosterPath(posterPath);

                    listMovies.add(movie);
                }
//                L.T(getActivity(), listMovies.toString());  //this is for testing only
            }
            catch (JSONException e){}
            catch (ParseException e){}


        }

        return listMovies;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        layout manager for the recyclerView
        View view = inflater.inflate(R.layout.fragment_box_office, container, false);
        listMovieHits=(RecyclerView) view.findViewById(R.id.listPlayingNow_id);
        listMovieHits.setLayoutManager(new LinearLayoutManager(getActivity()));
//        initialize the adapter
        adapterBoxOffice=new AdapterBoxOffice(getActivity());
        listMovieHits.setAdapter(adapterBoxOffice);

        sendJsonRequest();
        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_box_office, container, false);
    }

}
