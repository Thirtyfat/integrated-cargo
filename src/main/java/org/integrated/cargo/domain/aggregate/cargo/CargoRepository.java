package org.integrated.cargo.domain.aggregate.cargo;


import org.integrated.cargo.domain.aggregate.cargo.valueobject.EnterpriseSegment;
import org.springframework.stereotype.Component;

@Component
public interface CargoRepository {

    Cargo find(String id);
    
    int sizeByCustomer(String customerPhone);
    
    int sizeByEnterpriseSegment(EnterpriseSegment enterpriseSegment);

    void save(Cargo cargo);

    void remove(String id);

}
