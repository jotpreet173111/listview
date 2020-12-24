package com.example.listviewmidterm;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

class ReadInfo extends AsyncTask<String,Integer,String> implements AdapterView.OnItemClickListener{

        private final MainActivity activity;

    Context context;
      private ArrayList<Read> readArrayList =new ArrayList<>();
        private final ListView info;

        public ReadInfo(MainActivity mainActivity) {
            activity = mainActivity;
            info = mainActivity.findViewById(R.id.listView);
        }

        @Override
        protected void onPostExecute(String s) {


            try {
                JSONArray jsonArray = new JSONArray(s);
                for(int i =0; i<jsonArray.length();i++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String bracnh=jsonObject.getString("branches_url");
                            String tree =jsonObject.getString("trees_url");

                    JSONObject ownerObject = jsonObject.getJSONObject("owner");
                    String full_name = ownerObject.getString("login");
                    readArrayList.add(new Read(name,full_name,bracnh,tree));

                }

                ListViewAdapter adapter=new ListViewAdapter(activity,readArrayList );
                info.setAdapter(adapter);
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
       // Log.d("click", "onItemClick: ");
        Intent intent = new Intent(context,ReadDetail.class);
        intent.putExtra("readDetails",readArrayList.get(i));
        context.startActivity(intent);

    }


        @Override
        protected String doInBackground(String... args) {
            String string = args[0];
            String feedback = "";

            RepositoryURL du = new RepositoryURL();
            try {
                feedback = du.downloadurl(string);
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            return feedback;
        }


}
