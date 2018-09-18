package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String name = "name";
    private static final String mainName = "mainName";
    private static final String alsoKnownAs = "alsoKnownAs";
    private static final String placeOfOrigin = "placeOfOrigin";
    private static final String description = "description";
    private static final String image = "image";
    private static final String ingredients = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject sandwichName = sandwichJson.optJSONObject(name);
            sandwich.setMainName(sandwichName.optString(mainName));
            JSONArray sandwichAlsoKnownAs = sandwichName.optJSONArray(alsoKnownAs);
            List<String> sandwichAlsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < sandwichAlsoKnownAs.length(); i++) {
                sandwichAlsoKnownAsList.add(sandwichAlsoKnownAs.optString(i));
            }
            sandwich.setAlsoKnownAs(sandwichAlsoKnownAsList);
            sandwich.setPlaceOfOrigin(sandwichJson.optString(placeOfOrigin));
            sandwich.setDescription(sandwichJson.optString(description));
            sandwich.setImage(sandwichJson.optString(image));
            JSONArray sandwichIngredients = sandwichJson.optJSONArray(ingredients);
            List<String> sandwichIngredientsList = new ArrayList<>();
            for (int i = 0; i < sandwichIngredients.length(); i++) {
                sandwichIngredientsList.add(sandwichIngredients.optString(i));
            }
            sandwich.setIngredients(sandwichIngredientsList);
        } catch (JSONException e) {
            return null;
        }
        return sandwich;
    }
}
