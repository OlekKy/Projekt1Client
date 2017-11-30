package com.example.aleksander.projekt1;

import java.sql.SQLException;

/**
 * Created by Aleksander on 21.11.2017.
 */

public class ApiException extends Exception {
    public ApiException(String message, SQLException e) {
        super(message,e);
    }
    public ApiException(String message) {
        super(message);
    }
}
