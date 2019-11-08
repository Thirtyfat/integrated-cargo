package org.integrated.cargo.domain.aggregate.location;

public interface LocationRepository {
    Location find(String code);
}
