package abpl.android.com.abpl.utils;

import android.content.Context;
import android.view.View;


import abpl.android.com.abpl.RefrenceWrapper;
import abpl.android.com.abpl.utils.device.Syso;
import abpl.android.com.abpl.utils.response.LoginModel;
import abpl.android.com.abpl.utils.response.UploadModel;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by cpu505 on 17/9/15.
 */
public class ServiceCallsUtils {
    private RefrenceWrapper refrenceWrapper;





    public void doRegistration(final Context mFragmentActivity,final View view, String email, String device_id, String device_model, String fcm_id, String location, String timestamp){
        refrenceWrapper = RefrenceWrapper.getRefrenceWrapper(mFragmentActivity);
        Call<LoginModel> call=refrenceWrapper.getService().register(email,device_id,device_model,fcm_id,location,timestamp);//signUp("test","lTest","testdsds2@yupmIL.COM","qwerty1","Android","32ndsfsd34y234nglgjdf746","653454hsdffdy234nglgjdf746");
        call.enqueue(new CustomCallBacks<LoginModel>(mFragmentActivity,true) {
            @Override
            public void onSucess(Call<LoginModel> call, Response<LoginModel> response) {
               refrenceWrapper.getmAlertUtils().showSnackBar(mFragmentActivity, response.body().getErrorMsg(),view);
                Syso.debug("Response----","response---success-"+response.body().getErrorMsg()+"---"+response.headers());

            }
            @Override
            public void onFailure(Throwable arg0) {
                refrenceWrapper.getmAlertUtils().showSnackBar(mFragmentActivity, arg0.getMessage(), view);
                Syso.debug("Response----","response---failure-"+arg0.getMessage());
            }
        });

    }
    public void dofileUpload(final Context mContext,final View view, MultipartBody.Part part,RequestBody name){
        refrenceWrapper = RefrenceWrapper.getRefrenceWrapper(mContext);
        Call<UploadModel> call=refrenceWrapper.getService().uploadFile(part,name);//signUp("test","lTest","testdsds2@yupmIL.COM","qwerty1","Android","32ndsfsd34y234nglgjdf746","653454hsdffdy234nglgjdf746");
        call.enqueue(new CustomCallBacks<UploadModel>(mContext,true) {
            @Override
            public void onSucess(Call<UploadModel> call, Response<UploadModel> response) {
                refrenceWrapper.getmAlertUtils().showSnackBar(mContext, response.body().getMsg(),view);
                Syso.debug("Response----","response---success-"+response.body().getMsg()+":"+response.body().getFileUrl()+"---"+response.headers());

            }
            @Override
            public void onFailure(Throwable arg0) {
                refrenceWrapper.getmAlertUtils().showSnackBar(mContext, arg0.getMessage(), view);
                Syso.debug("Response----","response---failure-"+arg0.getMessage());
            }
        });
    }



}
