/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.ventas.exception;

import java.util.Date;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author malopez
 */
@Data
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String detail;
    private Map<String, String> errorValidation;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public ExceptionResponse(Date timestamp, String message, String detail, Map<String, String> errorValidation) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
        this.errorValidation = errorValidation;
    }

}
