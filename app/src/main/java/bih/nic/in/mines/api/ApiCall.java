package bih.nic.in.mines.api;

import android.util.Log;

import bih.nic.in.mines.entity.AllotmentDetailsRequest;
import bih.nic.in.mines.entity.AllotmentDetailsResponse;
import bih.nic.in.mines.entity.AllotmentListRequest;
import bih.nic.in.mines.entity.AllotmentListResponse;
import bih.nic.in.mines.entity.ChallanUploadRequest;
import bih.nic.in.mines.entity.ChallanUploadResponse;
import bih.nic.in.mines.entity.DeclarationResponse;
import bih.nic.in.mines.entity.MiningDetailsRequest;
import bih.nic.in.mines.entity.MiningDetailsResponse;
import bih.nic.in.mines.entity.AppDetailsResponse;
import bih.nic.in.mines.entity.BlockResponse;
import bih.nic.in.mines.entity.DeclarationRequest;
import bih.nic.in.mines.entity.DistrictResponse;
import bih.nic.in.mines.entity.GeneralRequest;
import bih.nic.in.mines.entity.PurposeRequest;
import bih.nic.in.mines.entity.PurposeResponse;
import bih.nic.in.mines.entity.StateResponse;
import bih.nic.in.mines.entity.ThanaResponse;
import bih.nic.in.mines.entity.UserLogin;
import bih.nic.in.mines.entity.VeichleNoDetailsRequest;
import bih.nic.in.mines.entity.VeichelTypeRequest;
import bih.nic.in.mines.entity.VeichelTypeResponse;
import bih.nic.in.mines.entity.VeichleNoDetailsResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class ApiCall {
    //private static final String ROOT_URL = "http://10.133.20.197/Api/";
    private static final String ROOT_URL = "http://10.133.20.157:83/Api/";
    //private static final String ROOT_URL = "http://192.168.217.111/Nirikshan_API/Api/";


    public static ApiSingleCall apiSingleCall = null;

    public static ApiSingleCall getSeervice() {
        if (apiSingleCall == null) {
            try {//Create ApiSingleCall
                Retrofit retrofitBase = new Retrofit.Builder()
                        .baseUrl(ROOT_URL)
                        //.addConverterFactory(GsonConverterFactory.create(gson))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                apiSingleCall = retrofitBase.create(ApiSingleCall.class);
            } catch (Exception e) {
                Log.e("MuRavi:", "Exception: ", e.getCause());
            }
        }
        return apiSingleCall;
    }

    public interface ApiSingleCall {


        @GET("AppVersion")
        Call<AppDetailsResponse> getAppDetails();

        @POST("Login")
        Call<UserLogin> getUserLogin(@Body UserLogin userLogin);

        @POST("State")
        Call<StateResponse> getState(@Body GeneralRequest generalRequest);

        @POST("District")
        Call<DistrictResponse> getDistrict(@Body GeneralRequest generalRequest);

        @POST("Block")
        Call<BlockResponse> getBlock(@Body GeneralRequest generalRequest);

        @POST("Thana")
        Call<ThanaResponse> getThana(@Body GeneralRequest generalRequest);

        @POST("CircleByUserAutoId")
        Call<MiningDetailsResponse> getMiningDetails(@Body MiningDetailsRequest miningDetailsRequest);

        @POST("Declaration")
        Call<DeclarationResponse> getDeclaration(@Body DeclarationRequest declarationRequest);

        @POST("Purpose")
        Call<PurposeResponse> getPurpose(@Body PurposeRequest purposeRequest);

        @POST("PermitNo")
        Call<AllotmentListResponse> getAllotmentList(@Body AllotmentListRequest allotmentListRequest);

        @POST("PermitDetailsByPermitNo")
        Call<AllotmentDetailsResponse> getAllotmentDetails(@Body AllotmentDetailsRequest allotmentDetailsRequest);

        @POST("VehicleType")
        Call<VeichelTypeResponse> getVehicleType(@Body VeichelTypeRequest veichelTypeRequest);

        @POST("VehicleNo")
        Call<VeichleNoDetailsResponse> getVehicleDetails(@Body VeichleNoDetailsRequest veichleNoDetailsRequest);

        @POST("Upload")
        Call<ChallanUploadResponse> uploadChallan(@Body ChallanUploadRequest challanUploadRequest);
    }
}
