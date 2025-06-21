package io.apijogos.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameListNotFound extends RuntimeException {
    public GameListNotFound(String message) {
        super(message);
    }
}