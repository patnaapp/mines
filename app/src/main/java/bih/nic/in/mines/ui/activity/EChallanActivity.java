package bih.nic.in.mines.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import bih.nic.in.mines.R;
import bih.nic.in.mines.adaptor.ListAdapter;
import bih.nic.in.mines.api.ApiCall;
import bih.nic.in.mines.databinding.ActivityEchallanBinding;
import bih.nic.in.mines.entity.AllotmentDetailsEntity;
import bih.nic.in.mines.entity.AllotmentDetailsRequest;
import bih.nic.in.mines.entity.AllotmentDetailsResponse;
import bih.nic.in.mines.entity.AllotmentListEntity;
import bih.nic.in.mines.entity.AllotmentListRequest;
import bih.nic.in.mines.entity.AllotmentListResponse;
import bih.nic.in.mines.entity.DeclarationEntity;
import bih.nic.in.mines.entity.DeclarationRequest;
import bih.nic.in.mines.entity.DeclarationResponse;
import bih.nic.in.mines.entity.MiningDetailsEntity;
import bih.nic.in.mines.entity.MiningDetailsRequest;
import bih.nic.in.mines.entity.MiningDetailsResponse;
import bih.nic.in.mines.entity.BlockEntity;
import bih.nic.in.mines.entity.BlockResponse;
import bih.nic.in.mines.entity.DistrictEntity;
import bih.nic.in.mines.entity.DistrictResponse;
import bih.nic.in.mines.entity.GeneralRequest;
import bih.nic.in.mines.entity.PurposeEntity;
import bih.nic.in.mines.entity.PurposeRequest;
import bih.nic.in.mines.entity.PurposeResponse;
import bih.nic.in.mines.entity.StateEntity;
import bih.nic.in.mines.entity.StateResponse;
import bih.nic.in.mines.entity.ThanaEntity;
import bih.nic.in.mines.entity.ThanaResponse;
import bih.nic.in.mines.entity.VehicleEntity;
import bih.nic.in.mines.entity.VeichelTypeEntity;
import bih.nic.in.mines.entity.VeichelTypeRequest;
import bih.nic.in.mines.entity.VeichelTypeResponse;
import bih.nic.in.mines.security.Encriptor;
import bih.nic.in.mines.security.RandomString;
import bih.nic.in.mines.utilities.CommonPref;
import bih.nic.in.mines.utilities.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EChallanActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private ActivityEchallanBinding binding;
    ProgressDialog dialog;
    Encriptor encriptor;
    ArrayList<StateEntity> stateArray;
    ArrayList<DistrictEntity> districtArray;
    ArrayList<BlockEntity> blockArray;
    ArrayList<ThanaEntity> thanaArray;
    ArrayList<PurposeEntity> purposeArray;
    ArrayList<AllotmentListEntity> allotmentListArray;
    ArrayList<VehicleEntity> veichelArray;

    private String allotmentNumber = "";

    MiningDetailsResponse miningDetailsResponse;
    AllotmentDetailsResponse allotmentDetailsResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_echallan);

        binding = ActivityEchallanBinding.inflate(getLayoutInflater());
        //binding = DataBindingUtil.setContentView(this,R.layout.activity_echallan);
        setContentView(binding.getRoot());
        //View root = binding.getRoot();

        dialog = new ProgressDialog(EChallanActivity.this);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage(getResources().getString(R.string.loading_data));
        showUI();
        setOnClickListner();
        callWebApi();
    }

    private void showUI() {
        binding.llMiningDetails.setVisibility(View.GONE);
        binding.showMiningDetails.setImageResource(R.drawable.left_arrow);

        binding.llAllotmentDetails.setVisibility(View.GONE);
        binding.showAllotmentDetails.setImageResource(R.drawable.left_arrow);

        binding.llTransportDetails.setVisibility(View.GONE);
        binding.showTransportDetails.setImageResource(R.drawable.left_arrow);

        binding.llConsigneeDetails.setVisibility(View.GONE);
        binding.showConsigneeDetails.setImageResource(R.drawable.left_arrow);
    }

    private void callWebApi() {
        callStateAPI();
        callMiningDetailsAPI();
        callPurposeAPI();
        callDeclarationAPI();
    }

    private void setOnClickListner() {
        binding.rlShowMiningDetails.setOnClickListener(v -> {
            if(binding.llMiningDetails.getVisibility() == View.VISIBLE){
                binding.llMiningDetails.setVisibility(View.GONE);
                binding.showMiningDetails.setImageResource(R.drawable.left_arrow);
            }else{
                binding.llMiningDetails.setVisibility(View.VISIBLE);
                binding.showMiningDetails.setImageResource(R.drawable.down_arrow_16);
            }
        });

        binding.rlShowAllotmentDetails.setOnClickListener(v -> {
            if(binding.llAllotmentDetails.getVisibility() == View.VISIBLE){
                binding.llAllotmentDetails.setVisibility(View.GONE);
                binding.showAllotmentDetails.setImageResource(R.drawable.left_arrow);
            }else{
                binding.llAllotmentDetails.setVisibility(View.VISIBLE);
                binding.showAllotmentDetails.setImageResource(R.drawable.down_arrow_16);
            }
        });

        binding.rlShowTransportDetails.setOnClickListener(v -> {
            if(binding.llTransportDetails.getVisibility() == View.VISIBLE){
                binding.llTransportDetails.setVisibility(View.GONE);
                binding.showTransportDetails.setImageResource(R.drawable.left_arrow);
            }else{
                binding.llTransportDetails.setVisibility(View.VISIBLE);
                binding.showTransportDetails.setImageResource(R.drawable.down_arrow_16);
            }
        });

        binding.rlShowConsigneeDetails.setOnClickListener(v -> {
            if(binding.llConsigneeDetails.getVisibility() == View.VISIBLE){
                binding.llConsigneeDetails.setVisibility(View.GONE);
                binding.showConsigneeDetails.setImageResource(R.drawable.left_arrow);
            }else{
                binding.llConsigneeDetails.setVisibility(View.VISIBLE);
                binding.showConsigneeDetails.setImageResource(R.drawable.down_arrow_16);
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.sp_state:
                if (position > 0) {
                    StateEntity stateEntity = stateArray.get(position-1);
                    callDistrictAPI(stateEntity.getStateId());
                }else{
                    setDistrictSpinner(null);
                }
                break;

            case R.id.sp_district:
                if (position > 0) {
                    DistrictEntity districtEntity = districtArray.get(position-1);
                    callBlockAPI(districtEntity.getDistrictId());
                    callThanaAPI(districtEntity.getDistrictId());
                }else{
                    setBlockSpinner(null);
                    setThanaSpinner(null);
                }
                break;

            case R.id.sp_block:
                if (position > 0) {
                    BlockEntity blockEntity = blockArray.get(position-1);
                }else{
                    //setThanaSpinner(null);
                }
                break;

            case R.id.sp_allotment_no:
                if (position > 0) {
                    AllotmentListEntity allotmentListEntity = allotmentListArray.get(position-1);
                    allotmentNumber = allotmentListEntity.getAllotmentId();
                    callAllotmentDetailsAPI(allotmentNumber);
                }else{
                    setAllotmentDetails(null);
                    allotmentNumber ="";
                }
                break;

            case R.id.sp_vehicle_type:
                if (position > 0) {
                    VehicleEntity vehicleEntity = veichelArray.get(position-1);
                    callVeichelTypeDetailsAPI(vehicleEntity.getVehicleTypeId());
                }else{
                    setVeichleTypeDetails(null);
                }
                break;

        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





    private void callStateAPI() {
        String _capId = "";
        String _skey = "";
        String _countryId = "";
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _countryId = encriptor.Encrypt("111", randomNo);

            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        GeneralRequest generalRequest = new GeneralRequest(_skey,_capId,_countryId);
        Call<StateResponse> call = ApiCall.getSeervice().getState(generalRequest);
        call.enqueue(new Callback<StateResponse>() {
            @Override
            public void onResponse(@NonNull Call<StateResponse> call, @NonNull Response<StateResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                StateResponse user = new StateResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            setStateSpinner(response.body().getData());
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<StateResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callDistrictAPI(String stateId) {
        String _capId = "";
        String _skey = "";
        String _stateId = "";
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _stateId = encriptor.Encrypt(stateId, randomNo);

            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        GeneralRequest generalRequest = new GeneralRequest(_skey,_capId,_stateId);
        Call<DistrictResponse> call = ApiCall.getSeervice().getDistrict(generalRequest);
        call.enqueue(new Callback<DistrictResponse>() {
            @Override
            public void onResponse(@NonNull Call<DistrictResponse> call, @NonNull Response<DistrictResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                DistrictResponse user = new DistrictResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            setDistrictSpinner(response.body().getData());
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DistrictResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callBlockAPI(String districtId) {
        String _capId = "";
        String _skey = "";
        String _districtId = "";
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _districtId = encriptor.Encrypt(districtId, randomNo);

            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        GeneralRequest generalRequest = new GeneralRequest(_skey,_capId,_districtId);
        Call<BlockResponse> call = ApiCall.getSeervice().getBlock(generalRequest);
        call.enqueue(new Callback<BlockResponse>() {
            @Override
            public void onResponse(@NonNull Call<BlockResponse> call, @NonNull Response<BlockResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                BlockResponse user = new BlockResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            setBlockSpinner(response.body().getData());
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BlockResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callThanaAPI(String districtId) {
        String _capId = "";
        String _skey = "";
        String _districtId = "";
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _districtId = encriptor.Encrypt(districtId, randomNo);

            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        GeneralRequest generalRequest = new GeneralRequest(_skey,_capId,_districtId);
        Call<ThanaResponse> call = ApiCall.getSeervice().getThana(generalRequest);
        call.enqueue(new Callback<ThanaResponse>() {
            @Override
            public void onResponse(@NonNull Call<ThanaResponse> call, @NonNull Response<ThanaResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                ThanaResponse user = new ThanaResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            setThanaSpinner(response.body().getData());
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ThanaResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callPurposeAPI() {
        String _capId = "";
        String _skey = "";
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);

        } catch (Exception e) {
            e.printStackTrace();
        }
        PurposeRequest purposeRequest = new PurposeRequest(_skey,_capId);
        Call<PurposeResponse> call = ApiCall.getSeervice().getPurpose(purposeRequest);
        call.enqueue(new Callback<PurposeResponse>() {
            @Override
            public void onResponse(@NonNull Call<PurposeResponse> call, @NonNull Response<PurposeResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                PurposeResponse user = new PurposeResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            setPurposeSpinner(response.body().getData());
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PurposeResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callDeclarationAPI() {
        String _capId = "";
        String _skey = "";
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);

        } catch (Exception e) {
            e.printStackTrace();
        }
        DeclarationRequest declarationRequest = new DeclarationRequest(_skey,_capId);
        Call<DeclarationResponse> call = ApiCall.getSeervice().getDeclaration(declarationRequest);
        call.enqueue(new Callback<DeclarationResponse>() {
            @Override
            public void onResponse(@NonNull Call<DeclarationResponse> call, @NonNull Response<DeclarationResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                DeclarationResponse user = new DeclarationResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            if(user.getData().size() > 0){
                                setDeclarationListRecycler(user.getData());
                            }else{

                            }
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DeclarationResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callMiningDetailsAPI() {
        String _capId = "";
        String _skey = "";
        String _userAutoId = "";
        String _desigId = "";
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _userAutoId = encriptor.Encrypt(CommonPref.getUserDetails(getApplicationContext()).getId(), randomNo);
            _desigId = encriptor.Encrypt(CommonPref.getUserDetails(getApplicationContext()).getDesigId(), randomNo);

            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        MiningDetailsRequest allotmentDetailsRequest = new MiningDetailsRequest(_skey,_capId,_userAutoId,_desigId);
        Call<MiningDetailsResponse> call = ApiCall.getSeervice().getMiningDetails(allotmentDetailsRequest);
        call.enqueue(new Callback<MiningDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<MiningDetailsResponse> call, @NonNull Response<MiningDetailsResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                miningDetailsResponse = new MiningDetailsResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (miningDetailsResponse.getStatus()) {
                            if(response.body().getData() !=null) {
                                setMiningDetails(response.body().getData().get(0));
                                callAllotmentListAPI(response.body().getData().get(0));

                            }else{
                                Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MiningDetailsResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callAllotmentListAPI(MiningDetailsEntity miningDetailsEntity) {
        String _capId = "";
        String _skey = "";
        String _userId = "";
        String _userType = "";
        String _dmo_Id = "";
        String _endUser_Id = "";
        String _endUserType = "";

        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            /*_userId = encriptor.Encrypt(miningDetailsEntity.getLesseeId(), randomNo);
            _userType = encriptor.Encrypt(miningDetailsEntity.getSourceTypeId(), randomNo);
            _dmo_Id = encriptor.Encrypt(miningDetailsEntity.getDmoID(), randomNo);
            _endUser_Id = encriptor.Encrypt(miningDetailsEntity.get, randomNo);
            _endUserType = encriptor.Encrypt(miningDetailsEntity., randomNo);*/
            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        AllotmentListRequest allotmentListRequest = new AllotmentListRequest(_skey,_capId,miningDetailsEntity.getLesseeId(),miningDetailsEntity.getSourceTypeId(),miningDetailsEntity.getDmoID(),miningDetailsEntity.getUserTypeId(),miningDetailsEntity.getDispatchPointUserId());
        Call<AllotmentListResponse> call = ApiCall.getSeervice().getAllotmentList(allotmentListRequest);
        call.enqueue(new Callback<AllotmentListResponse>() {
            @Override
            public void onResponse(@NonNull Call<AllotmentListResponse> call, @NonNull Response<AllotmentListResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                AllotmentListResponse user = new AllotmentListResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            setAllotmentSpinner(response.body().getData());
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AllotmentListResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callAllotmentDetailsAPI(String allotmentId) {
        String _capId = "";
        String _skey = "";
        String _userId = "";
        String _userType = "";
        String _dmo_Id = "";
        String _endUser_Id = "";
        String _endUserType = "";
        String _permitNo = "";

        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            /*_userId = encriptor.Encrypt(miningDetailsEntity.getLesseeId(), randomNo);
            _userType = encriptor.Encrypt(miningDetailsEntity.getSourceTypeId(), randomNo);
            _dmo_Id = encriptor.Encrypt(miningDetailsEntity.getDmoID(), randomNo);
            _endUser_Id = encriptor.Encrypt(miningDetailsEntity.get, randomNo);
            _endUserType = encriptor.Encrypt(miningDetailsEntity., randomNo);*/
            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        AllotmentDetailsRequest allotmentDetailsRequest = new AllotmentDetailsRequest(_skey,_capId,allotmentId,miningDetailsResponse.getData().get(0).getLesseeId(),miningDetailsResponse.getData().get(0).getSourceTypeId(),miningDetailsResponse.getData().get(0).getUserTypeId(),miningDetailsResponse.getData().get(0).getDispatchPointUserId(),miningDetailsResponse.getData().get(0).getDmoID());
        Call<AllotmentDetailsResponse> call = ApiCall.getSeervice().getAllotmentDetails(allotmentDetailsRequest);
        call.enqueue(new Callback<AllotmentDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<AllotmentDetailsResponse> call, @NonNull Response<AllotmentDetailsResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                 allotmentDetailsResponse = new AllotmentDetailsResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (allotmentDetailsResponse.getStatus()) {
                            setAllotmentDetails(response.body().getData().get(0));
                            setVeichelSpinner(response.body().getVehicle());
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AllotmentDetailsResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void callVeichelTypeDetailsAPI(String vehicleTypeId) {
        String _capId = "";
        String _skey = "";
        String _permitNo = "";
        String _miniralTypeId = "";
        String _miniralId = "";
        String _vehicleTypeId = "";

        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            /*_userId = encriptor.Encrypt(miningDetailsEntity.getLesseeId(), randomNo);
            _userType = encriptor.Encrypt(miningDetailsEntity.getSourceTypeId(), randomNo);
            _dmo_Id = encriptor.Encrypt(miningDetailsEntity.getDmoID(), randomNo);
            _endUser_Id = encriptor.Encrypt(miningDetailsEntity.get, randomNo);
            _endUserType = encriptor.Encrypt(miningDetailsEntity., randomNo);*/
            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }
        VeichelTypeRequest veichelTypeRequest = new VeichelTypeRequest(_skey,_capId,allotmentNumber,allotmentDetailsResponse.getData().get(0).getMineralTypeId(),allotmentDetailsResponse.getData().get(0).getMineral_Id(),vehicleTypeId);
        Call<VeichelTypeResponse> call = ApiCall.getSeervice().getVeichelType(veichelTypeRequest);
        call.enqueue(new Callback<VeichelTypeResponse>() {
            @Override
            public void onResponse(@NonNull Call<VeichelTypeResponse> call, @NonNull Response<VeichelTypeResponse> response) {
                Log.d("RESPONSE: ", "" + response);
                VeichelTypeResponse user = new VeichelTypeResponse(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;

                        if (user.getStatus()) {
                            setVeichleTypeDetails(response.body().getData().get(0));
                        } else {
                            Toast.makeText(EChallanActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<VeichelTypeResponse> call, @NonNull Throwable t) {

            }
        });
    }



    public void setStateSpinner(ArrayList<StateEntity> data) {
        stateArray = data;
        ArrayList<String> array = new ArrayList<>();
        array.add("-Select-");
        for (StateEntity info: stateArray)
        {
            array.add(info.getStateName());
        }
        ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spState.setAdapter(adaptor);
        binding.spState.setOnItemSelectedListener(this);
    }

    public void setDistrictSpinner(ArrayList<DistrictEntity> data) {
        ArrayList<String> array = new ArrayList<>();
        array.add("-Select-");
        if(data != null){
            districtArray = data;
            for (DistrictEntity info: districtArray)
            {
                array.add(info.getDistrictName());
            }
        }

        ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spDistrict.setAdapter(adaptor);
        binding.spDistrict.setOnItemSelectedListener(this);
    }

    private void setBlockSpinner(ArrayList<BlockEntity> data) {
        ArrayList<String> array = new ArrayList<>();
        array.add("-Select-");
        if(data != null){
            blockArray = data;
            for (BlockEntity info: blockArray)
            {
                array.add(info.getBlockName());
            }
        }

        ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spBlock.setAdapter(adaptor);
        binding.spBlock.setOnItemSelectedListener(this);
    }

    private void setThanaSpinner(ArrayList<ThanaEntity> data) {
        ArrayList<String> array = new ArrayList<>();
        array.add("-Select-");
        if(data != null){
            thanaArray = data;
            for (ThanaEntity info: thanaArray)
            {
                array.add(info.getThanaName());
            }
        }

        ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spPoliceStation.setAdapter(adaptor);
        binding.spPoliceStation.setOnItemSelectedListener(this);
    }

    private void setPurposeSpinner(ArrayList<PurposeEntity> data) {
        purposeArray = data;
        ArrayList<String> array = new ArrayList<>();
        array.add("-Select-");
        for (PurposeEntity info: purposeArray)
        {
            array.add(info.getPurposeName());
        }
        ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spPurpose.setAdapter(adaptor);
        binding.spPurpose.setOnItemSelectedListener(this);
    }

    private void setAllotmentSpinner(ArrayList<AllotmentListEntity> data) {
        allotmentListArray = data;
        ArrayList<String> array = new ArrayList<>();
        array.add("-Select-");
        for (AllotmentListEntity info: allotmentListArray)
        {
            array.add(info.getAllotmentName());
        }
        ArrayAdapter adaptor = new ArrayAdapter(this, R.layout.simple_spinner_dropdown_item_multiline, array);
        adaptor.setDropDownViewResource(R.layout.simple_spinner_dropdown_item_multiline);
        binding.spAllotmentNo.setAdapter(adaptor);
        binding.spAllotmentNo.setOnItemSelectedListener(this);
        /*if(allotmentListArray.size() > 0){
            binding.spAllotmentNo.setSelection(1);
        }*/
    }

    public void setVeichelSpinner(ArrayList<VehicleEntity> data) {
        veichelArray = data;
        ArrayList<String> array = new ArrayList<>();
        array.add("-Select-");
        for (VehicleEntity info: veichelArray)
        {
            array.add(info.getVehicleTypeName());
        }
        ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spVehicleType.setAdapter(adaptor);
        binding.spVehicleType.setOnItemSelectedListener(this);
    }




    private void setMiningDetails(MiningDetailsEntity data) {

        binding.tvDmoName.setText(data.getDmoName());
        binding.tvSourceType.setText(data.getSourceType());
        binding.tvLesseeName.setText(data.getLesseeName());
        binding.tvUserType.setText(data.getUserType());
        binding.tvDispatchPointUser.setText(data.getDispatchPointUserName());
        binding.tvMiningValidity.setText(data.getMiningValidity());
        binding.tvAnnualCap.setText(data.getAnnualCapQty());
        binding.tvSettleMobileNumber.setText(data.getMobileNoOfSettle());
        //Spanned text = Html.fromHtml("Annual E-cap of ghat for the year "+ "<b>" + data.getAnnualEcapYear() +"</b>  / घाट की वार्षिक ई-कैप");
        binding.tvAnnualCapYear.setText(Html.fromHtml(getString(R.string.annual_e_cap_of_ghat_first_part)+ " <b>" + data.getAnnualEcapYear() +getString(R.string.annual_e_cap_of_ghat_second_part)));
    }

    private void setAllotmentDetails(AllotmentDetailsEntity data) {
        binding.tvMineralName.setText(data != null ?  data.getMineralName() : "NA");
        binding.tvGeoCoordinates.setText(data != null ?  data.getGpsCordinate(): "NA");
        binding.tvPermittedQty.setText(data != null ?  data.getPermittedQty(): "NA");
        binding.tvAllowedQty.setText(data != null ?  data.getAllowedQty(): "NA");
        binding.tvAllowedBalanceQty.setText(data != null ?  data.getAvailableQty(): "NA");
        binding.tvPermitValidity.setText(data != null ?  data.getPermitValidity(): "NA");
        binding.tvChallanValidUpTo.setText(data != null ?  data.getChallanValidUpTo(): "NA");


          }

    private void setVeichleTypeDetails(VeichelTypeEntity data) {
        binding.tvVeichleCapacity.setText(data != null ?  data.getVehicleCapacity() : "NA");
        binding.etMineralWeight.setText(data != null ?  data.getMineralWeight(): "NA");
        binding.etMineralWeight.setEnabled(false);
        binding.etSalePrice.setText("0");
        binding.tvTotalSalePrice.setText("0.00");
        binding.etVehicleNo.setFocusable(true);
    }

    public void setDeclarationListRecycler(ArrayList<DeclarationEntity> data) {
        binding.rvDataList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ListAdapter adapter = new ListAdapter(getApplicationContext(), data);
        binding.rvDataList.setAdapter(adapter);
    }
}