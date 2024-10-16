package test;

import com.github.t1.yasson.record.issue.ProductId;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class JsonBindingTest {
    private static final Jsonb JSONB = JsonbBuilder.newBuilder().build();

    private static final ProductId ID1 = new ProductId("42");
    private static final ProductId ID2 = new ProductId("43");


    @Test
    @Order(1)
    void shouldSerializeId() {
        var json = JSONB.toJson(ID1);

        then(json).isEqualTo("\"42\"");
    }

    @Test
    @Order(2)
    void shouldSerializeList() {
        var json = JSONB.toJson(List.of(ID1, ID2));

        then(json).isEqualTo("[\"42\",\"43\"]");
    }
}
