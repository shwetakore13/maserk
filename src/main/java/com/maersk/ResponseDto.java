package com.maersk;

public class ResponseDto {
    private Boolean Available;

    public Boolean getAvailable() {
        return Available;
    }

    public ResponseDto(Boolean available) {
        Available = available;
    }

    public void setAvailable(Boolean available) {
        Available = available;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "Available=" + Available +
                '}';
    }


}
