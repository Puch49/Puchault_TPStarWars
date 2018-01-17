package com.starwars.puchault_tp_final.remote;

import com.starwars.puchault_tp_final.models.SWModelList;
import com.starwars.puchault_tp_final.models.People;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by puchault on 17/01/2018.
 * Star Wars API interface for making calls.
 */

public interface StarWarsInterface {
    //String BASE_URL = "https://swapi.co/api/";
    //String PAGE_1 = BASE_URL+"people/?page=1";
    //String ALL_PAGE = BASE_URL+"people/";

    //@GET(PAGE_1)
    //Call<SWModelList> readName();

    //@GET(ALL_PAGE)
    //Call<SWModelList> getAllPeople(@Query("page") int page);

    @GET("/people/")
    public void getAllPeople(@Query("page") int page,
                             Callback<SWModelList<People>> callback);

    @GET("/people/{id}/")
    public void getPeople(@Path("id") int peopleId,
                          Callback<People> callback);


/*
    @GET("/")
    public void getRootUrls(Callback<Root> callback);

    @GET("/people/")
    public void getAllPeople(@Query("page") int page,
                             Callback<SWModelList<People>> callback);

    @GET("/people/{id}/")
    public void getPeople(@Path("id") int peopleId,
                          Callback<People> callback);

    @GET("/films/")
    public void getAllFilms(@Query("page") int page,
                            Callback<SWModelList<Film>> callback);

    @GET("/films/{id}/")
    public void getFilm(@Path("id") int filmId,
                        Callback<Film> callback);

    @GET("/starships")
    public void getAllStarships(@Query("page") int page,
                                Callback<SWModelList<Starship>> callback);

    @GET("/starships/{id}/")
    public void getStarship(@Path("id") int starshipId,
                            Callback<Starship> callback);

    @GET("/vehicles/")
    public void getAllVehicles(@Query("page") int page,
                               Callback<SWModelList<Vehicle>> callback);

    @GET("/vehicles/{id}/")
    public void getVehicle(@Path("id") int vehicleId,
                           Callback<Vehicle> callback);

    @GET("/species/")
    public void getAllSpecies(@Query("page") int page,
                              Callback<SWModelList<Species>> callback);

    @GET("/species/{id}/")
    public void getSpecies(@Path("id") int speciesId,
                           Callback<Species> callback);

    @GET("/planets/")
    public void getAllPlanets(@Query("page") int page,
                              Callback<SWModelList<Planet>> callback);

    @GET("/planets/{id}/")
    public void getPlanet(@Path("id") int planetId,
                          Callback<Planet> callback);*/

}
