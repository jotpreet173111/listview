package com.example.listviewmidterm;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

class ReadInfo extends AsyncTask<String,Integer,String> {

        private final MainActivity activity;

        private ArrayList<String> repos;
        private ArrayList<String> owners;

        private final ListView info;

        public ReadInfo(MainActivity mainActivity) {
            activity = mainActivity;
            info = mainActivity.findViewById(R.id.listView);
        }

        @Override
        protected void onPostExecute(String s) {

            repos = new ArrayList();
            owners = new ArrayList();
            try {
                JSONArray jsonArray = new JSONArray(s);
                for(int i =0; i<jsonArray.length();i++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");

                    JSONObject ownerObject = jsonObject.getJSONObject("owner");
                    String full_name = ownerObject.getString("login");

                    repos.add(name);
                    owners.add(full_name);
                }

                ListViewAdapter adapter=new ListViewAdapter(activity, repos, owners);
                info.setAdapter(adapter);
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
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
