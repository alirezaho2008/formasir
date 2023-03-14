package formasir.app.Interface;

import formasir.app.models.retrofit.UserModel;
import formasir.app.models.retrofit.FollowModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Webservice {

    @GET("search/users")
    Call<UserModel> searchUser(@Query("q") String q);

    @GET("users/{id}/followers")
    Call<FollowModel> getFollowers(@Path("id") String id);

    @GET("users/{id}/following")
    Call<FollowModel> getFollowings(@Path("id") String id);

//    //get Price and Settings
//    @POST("api/v2/getAd")
//    Call<AdsModel> getAd();

}