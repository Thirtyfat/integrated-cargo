package org.integrated.cargo.infrastructure.rpc.salessystem;

import org.integrated.cargo.domain.aggregate.cargo.Cargo;
import org.integrated.cargo.domain.aggregate.cargo.valueobject.EnterpriseSegment;
import org.integrated.cargo.infrastructure.rpc.salessystem.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteServiceAdapter {

    @Autowired
    private RemoteServiceTranslator translator;

    // @Autowired
    // remoteService

    public UserDO getUser(String phone) {
        // User user = remoteService.getUser(phone);
        // return this.translator.toUserDO(user);
        return null;
    }

    public EnterpriseSegment deriveEnterpriseSegment(Cargo cargo) {
        // remote service
        // translator
        return EnterpriseSegment.FRUIT;
    }

    public boolean mayAccept(int cargoSize, Cargo cargo) {
        // remote service
        // translator
        return true;
    }

}
