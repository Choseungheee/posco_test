package com.posco.web.common;

import com.posco.web.auth.TokenDTO;
import lombok.Getter;

@Getter
public class MessageWithToken extends Message{
    private final TokenDTO token;

    public MessageWithToken(String message, TokenDTO tokenDTO) {
        super(message);
        this.token = tokenDTO;
    }
}
