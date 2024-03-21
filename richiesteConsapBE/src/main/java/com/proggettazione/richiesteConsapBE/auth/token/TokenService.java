package com.proggettazione.richiesteConsapBE.auth.token;

import com.proggettazione.richiesteConsapBE.model.UserEntity;

public interface TokenService {

    Token addToken(Token token);


    void saveUserToken(UserEntity userEntity, String accessToken);


}
