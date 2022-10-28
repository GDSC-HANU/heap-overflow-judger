package hanu.gdsc.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hanu.gdsc.domain.exceptions.InvalidInputException;
import hanu.gdsc.infrastructure.json.IdSerializer;
import org.bson.types.ObjectId;

import java.util.Objects;

@JsonSerialize(using = IdSerializer.class)
public class Id {
    private String value;

    public Id(String value) throws InvalidInputException {
        if (!ObjectId.isValid(value)) {
            throw new InvalidInputException("Invalid Id: '" + value + "'.");
        }
        this.value = value;
    }

    public static Id generateRandom() {
        try {
            return new Id(new ObjectId().toString());
        } catch (Exception e) {
            // cannot reach
            return null;
        }
    }

    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(value, id.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
