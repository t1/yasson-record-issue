package com.github.t1.yasson.record.issue;

import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbTypeAdapter;

@JsonbTypeAdapter(ProductId.JsonAdapter.class)
public record ProductId(String value) {
    @Override public String toString() {return value;}

    public static class JsonAdapter implements JsonbAdapter<ProductId, String> {
        @Override public String adaptToJson(ProductId obj) {return obj.value;}

        @Override public ProductId adaptFromJson(String obj) {return new ProductId(obj);}
    }
}
