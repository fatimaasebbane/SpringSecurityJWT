package ma.trellobackend.trellobackend.dtos.req;

import lombok.Data;

@Data
public class LoginDto {

    private String username;
    private String password;

}