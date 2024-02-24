package com.sales.sales.handler;

import com.sales.sales.dto.ErrorResponse;
import com.sales.sales.exception.ClientNotFoundException;
import io.micrometer.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Reem Gharib
 */
@Log4j2
@ControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ExceptionHandler({Throwable.class})
    public ResponseEntity<ErrorResponse> handleExceptions(Throwable e) {

        return new ResponseEntity<>(this.getErrorResponse("ERROR_", "An error occurred, contact the admin to check server logs", e)
                , null,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestExceptions(BadRequestException e) {

        return new ResponseEntity<>(this.getErrorResponse("ERROR_", e.getMessage(), e)
                , null,
                HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestExceptions(IllegalArgumentException e) {

        return new ResponseEntity<>(this.getErrorResponse("ERROR_", e.getMessage(), e)
                , null,
                HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler({ClientNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestExceptions(ClientNotFoundException e) {

        return new ResponseEntity<>(this.getErrorResponse("ERROR_", e.getMessage(), e)
                , null,
                HttpStatus.NOT_FOUND);
    }

    /**
     * Get error response
     *
     * @param code    the code
     * @param message the message
     * @param e       the throwable
     * @return ErrorResponse
     */
    private ErrorResponse getErrorResponse(String code, String message, Throwable e) {

        return ErrorResponse.builder()
                .code(code)
                .description(StringUtils.isBlank(message) ? e.getMessage() : message)
                .reason(e.getClass().getSimpleName())
                .build();
    }
}
