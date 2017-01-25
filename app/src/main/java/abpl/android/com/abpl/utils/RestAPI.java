package abpl.android.com.abpl.utils;



import abpl.android.com.abpl.utils.response.LoginModel;
import abpl.android.com.abpl.utils.response.UploadModel;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Project : Mobikasa Retrofit Lib
 * Description :"for managing url calls like GET,POST.",
 * Creating RestAPI Interface to Send HTTP Request using Retrofit and We have to create an interface to handle our requests. So create a new RestAPI interface that will handle all HTTP Request.
 */
public interface RestAPI {

    /*
    * Guideline
    * 1. If Api takes json :-
    * @POST(URL)
      Call<MODEL> signUpNew(@Body MODEL model );
    *
    * 2. If Api takes key pair :-
    * @FormUrlEncoded
      @POST(URL)
      Call<MODEL> logIn(@Field("key") String key1, @Field("key") String key2, @Field("key") String key3);
    *
    * 3. @Multipart
        @POST(URL)
        Call<MODEL> register(@Part("key") String key1, @Part("key") String key2);

    * 4. Get Request
    *   @GET("URL")
        Call<MODEL> getUser(@Path("key") String key);
    *
    * 5. if we need to add Header in api
    * @Headers({
        "Accept: application/vnd.github.v3.full+json",
        "User-Agent: Retrofit-Sample-App"
         })
    *
    * */

    @FormUrlEncoded
    @POST(ServiceConstants.ServiceURL.REGISTER)
    Call<LoginModel> register(@Field("email_id") String email_id, @Field("device_id") String device_id, @Field("device_model") String device_model, @Field("fcm_id") String fcm_id, @Field("location") String location, @Field("timestamp") String timestamp);


    @Multipart
    @POST(ServiceConstants.ServiceURL.UPLOAD)
    Call<UploadModel> uploadFile(@Part MultipartBody.Part file, @Part("file") RequestBody name);

}

