package com.thai27.shopfone_be_bu.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnclearSortingDirectionException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UnclearSortingDirectionException(String message) {
        super(message);
    }

}
