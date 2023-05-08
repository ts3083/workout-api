package exersite.workoutapi.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponse extends BasicResponse {

    private String code;
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.code = "404";
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(String errorCode, String errorMessage) {
        this.code = errorCode;
        this.errorMessage = errorMessage;
    }
}
