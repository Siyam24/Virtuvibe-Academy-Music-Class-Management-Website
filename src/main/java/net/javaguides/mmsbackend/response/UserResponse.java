package net.javaguides.mmsbackend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String message;
    private Boolean status;

    @Override
    public String toString() {
        return "UserResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
