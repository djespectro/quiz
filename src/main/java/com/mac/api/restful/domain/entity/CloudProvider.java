package com.mac.api.restful.domain.entity;

import java.io.Serializable;

public enum CloudProvider implements Serializable {

    AWS, GOOGLE, AZURE;

    static public CloudProvider getValue(String provider){
        try {
            return CloudProvider.valueOf(provider);
        } catch (IllegalArgumentException | NullPointerException e){
            throw new IllegalArgumentException ("Provider is not supported");
        }
    }

}
