package com.gini.cattest.retrofit.DatatypeAdapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by AWAIS AHMAD on 18/12/2017.
 */

public class DoubleDefaultAdapter implements JsonSerializer<Double>, JsonDeserializer<Double> {
    @Override
    public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if (json.getAsString().equals("") || json.getAsString().equals("null")) {// Defined as double type , If the background returns "" perhaps null, Then return 0.00
                return 0.00;
            }
        } catch (Exception ignore) {
        }
        try {
            return json.getAsDouble();
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }
}
