package ma.trellobackend.trellobackend.dtos.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.trellobackend.trellobackend.entities.ERole;
@Data
@NoArgsConstructor
@AllArgsConstructor     
public class RegisterDto {
    private String username;
    private String email;
    private String password;
    private ERole role;
}