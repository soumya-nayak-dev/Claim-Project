package com.mobisy.claimapp.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mobisy.claimapp.R;
import com.mobisy.claimapp.database.ClaimDatabase;
import com.mobisy.claimapp.database.ClaimDbModel;
import com.mobisy.claimapp.model.ClaimFieldOption;
import com.mobisy.claimapp.model.ClaimModel;
import com.mobisy.claimapp.model.ClaimTypeDetail;
import com.mobisy.claimapp.model.Claims;
import com.mobisy.claimapp.utils.Util;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private String FROM_DISTRICT = "From District";
    private String TO_DISTRICT = "To District";
    private Spinner mClaimTypeSpinner;
    private TextView mTravelDate;
    private EditText mFromDistrictName;
    private EditText to_district_name;
    private List<Claims> mClaimsList;
    private String mLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClaimTypeSpinner = findViewById(R.id.claimType);
        mTravelDate = findViewById(R.id.travel_date);
        mFromDistrictName = findViewById(R.id.from_district_name);
        to_district_name = findViewById(R.id.to_district_name);
        mClaimTypeSpinner.setOnItemSelectedListener(this);
        mFromDistrictName.setOnClickListener(this);
        to_district_name.setOnClickListener(this);
        new DatabaseAsync().execute();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        Log.i("Item clicked = ", "" + adapterView.getItemAtPosition(pos));
        if (mClaimsList != null && mClaimsList.size() > 0) {
            if (adapterView.getItemAtPosition(pos).toString().equalsIgnoreCase("Travel")) {
                mTravelDate.setText(mClaimsList.get(pos).getClaimTypeDetailList().get(pos).getClaimField().getCreated());
                mTravelDate.setVisibility(View.VISIBLE);
            } else {
                mTravelDate.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        String tag = view.getTag().toString();
        switch (view.getId()) {
            case R.id.from_district_name:
                displayDialog(mClaimsList, FROM_DISTRICT);
                break;
            case R.id.to_district_name:
                displayDialog(mClaimsList, TO_DISTRICT);
                break;
            default:
                Log.i("TAG", "No other case to handle");
        }

    }

    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String jsonFileString = Util.getJsonFromAssets(getApplicationContext(), "claims_json.json");
            Gson gson = new Gson();
            ClaimModel claimModel = gson.fromJson(jsonFileString, ClaimModel.class);
            ClaimDbModel claimDbModel = new ClaimDbModel();
            claimDbModel.setResults(claimModel.getResults());
            Log.i("List", "" + claimModel.getClaimsList().size());
            claimDbModel.setClaimsList(claimModel.getClaimsList());
            ClaimDatabase.getInstance(MainActivity.this).claimDao().insertClaim(claimDbModel);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            LiveData<List<ClaimDbModel>> claimLiveData = ClaimDatabase.getInstance(MainActivity.this).claimDao().getAllClaims();
            claimLiveData.observe(MainActivity.this, new Observer<List<ClaimDbModel>>() {
                @Override
                public void onChanged(List<ClaimDbModel> claimDbModels) {
//                    Log.i("Soumya", "" + claimDbModels.get(1).getClaimsList()
//                            .get(1).getClaimTypeDetailList()
//                            .get(1).getClaimField().getClaimFieldOptionList()
//                            .get(0).getName());
//                    Toast.makeText(MainActivity.this, "Soumya" + claimDbModels.get(1).getClaimsList()
//                            .get(1).getClaimTypeDetailList()
//                            .get(1).getClaimField().getClaimFieldOptionList()
//                            .get(0).getName(), Toast.LENGTH_SHORT).show();
                    mClaimsList = claimDbModels.get(0).getClaimsList();
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item);
                    for (int i = 0; i < mClaimsList.size(); i++) {
                        String name = mClaimsList.get(i).getClaimType().getName();
                        Log.i("Soumya", name);
                        adapter.add(name);
                        List<ClaimTypeDetail> claimTypeDetailList = mClaimsList.get(i).getClaimTypeDetailList();
                        for (int j = 0; j < claimTypeDetailList.size(); j++) {
                            String createdDate = claimTypeDetailList.get(j).getClaimField().getCreated();
                            mTravelDate.setText(createdDate);
                            //Log.i("Date", createdDate + " " + travel_date);
                        }
                    }
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    mClaimTypeSpinner.setAdapter(adapter);
                }
            });
        }
    }

    private void displayDialog(List<Claims> mClaimsList, String labelType) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
        builderSingle.setTitle("Select One Name:-");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_singlechoice);
        Log.i("ClaimType", "" + mClaimsList.size());
        for (int i = 0; i < mClaimsList.size(); i++) {
            List<ClaimTypeDetail> claimTypeDetailList1 = mClaimsList.get(i).getClaimTypeDetailList();
            for (int j = 0; j < claimTypeDetailList1.size(); j++) {
                mLabel = claimTypeDetailList1.get(j).getClaimField().getLabel();
                List<ClaimFieldOption> claimFieldOptionList = claimTypeDetailList1.get(j).getClaimField().getClaimFieldOptionList();
                for (int k = 0; k < claimFieldOptionList.size(); k++) {
                    String name = claimFieldOptionList.get(k).getName();
                    String id = claimFieldOptionList.get(k).getId();
                    Log.i("NAME", name);
                    Log.i("NAME", id);
                    arrayAdapter.add(name);
                }
            }
        }
        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                mFromDistrictName.setText(strName);
                dialog.dismiss();
            }
        });
        builderSingle.show();
    }
}