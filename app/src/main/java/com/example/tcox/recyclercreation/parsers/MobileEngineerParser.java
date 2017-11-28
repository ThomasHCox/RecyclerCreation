package com.example.tcox.recyclercreation.parsers;

import com.example.tcox.recyclercreation.models.MobileEngineer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by tcox on 11/28/17.
 */


public class MobileEngineerParser {

    public ArrayList<MobileEngineer> parse(String json) throws JSONException {
        ArrayList<MobileEngineer> mobileEngineers = new ArrayList<>();
        JSONObject root = new JSONObject(json);
        JSONArray people = root.getJSONArray("People");
        for (int i = 0; i < people.length(); i++){
            JSONObject person = people.getJSONObject(i);
            MobileEngineer mobileEngineer = new MobileEngineer();
            mobileEngineer.setAvatar(person.getString("avatar"));
            mobileEngineer.setBirthdate(person.getString("birthdate"));
            mobileEngineer.setName(person.getString("name"));
            mobileEngineer.setPosition(person.getString("position"));
            mobileEngineer.setStartDate(person.getString("startdate"));

            mobileEngineers.add(mobileEngineer);
        }

        return mobileEngineers;
    }

}