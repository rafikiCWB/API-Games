package io.apijogos.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameNotFound extends RuntimeException {
    public GameNotFound(String message) {
        super(message);
    }
}
