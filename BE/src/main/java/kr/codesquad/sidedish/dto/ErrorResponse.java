package kr.codesquad.sidedish.dto;

public class ErrorResponse {

    private final String message;

    public String getMessage() {
        return message;
    }

    public ErrorResponse(String message) {
        this.message = message;
    }
}
