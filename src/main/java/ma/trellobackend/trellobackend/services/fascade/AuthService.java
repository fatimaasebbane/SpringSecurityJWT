package ma.trellobackend.trellobackend.services.fascade;

import ma.trellobackend.trellobackend.dtos.req.LoginDto;
import ma.trellobackend.trellobackend.dtos.req.RegisterDto;
public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
