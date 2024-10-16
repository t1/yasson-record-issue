package test;

import com.github.t1.yasson.record.issue.ProductId;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class JsonBindingTest {
    private static final Jsonb JSONB = JsonbBuilder.newBuilder().build();

    private static final ProductId ID = new ProductId("42");

    public static class Container<T> {
        public final T element;

        public Container(T element) {this.element = element;}
    }

    @Test
    @Order(1)
    void shouldSerializeId() {
        var json = JSONB.toJson(ID);

        then(json).isEqualTo("\"42\"");
    }

    @Test
    @Order(2)
    void shouldSerializeGeneric() {
        var json = JSONB.toJson(new Container<>(ID));

        then(json).isEqualTo("{\"element\":\"42\"}");
    }
}
