package web;

import org.takes.rs.RsJson;
import org.takes.rs.RsWithStatus;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.IOException;

public class ApiResponse {

    private int status;
    private String message;

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private RsWithStatus getResponse() throws IOException {
        JsonObjectBuilder json = Json.createObjectBuilder();

        json.add("message",  message);

        RsJson rsJson = new RsJson(json.build());
        RsWithStatus rsWithStatus = new RsWithStatus(rsJson,status);

        return rsWithStatus;
    }

    public static RsWithStatus success(String message) throws IOException {
        return (new ApiResponse(200, message)).getResponse();
    }

    public static RsWithStatus error(int status, String message) throws IOException {
        return (new ApiResponse(status, message)).getResponse();
    }

}
