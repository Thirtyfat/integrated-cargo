package org.integrated.cargo.infrastructure.rpc.salessystem;

import org.integrated.cargo.infrastructure.rpc.salessystem.dataobject.UserDO;
import org.springframework.stereotype.Component;

@Component
public class RemoteServiceTranslator {

    public UserDO toUserDO(Object obj) {
        return new UserDO();
    }

}
