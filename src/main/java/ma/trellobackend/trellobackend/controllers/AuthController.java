package ma.trellobackend.trellobackend.controllers;

import ma.trellobackend.trellobackend.dtos.req.LoginDto;
import ma.trellobackend.trellobackend.dtos.req.RegisterDto;
import ma.trellobackend.trellobackend.dtos.res.AuthResponseDto;
import ma.trellobackend.trellobackend.sercurity.JwtTokenProvider;
import ma.trellobackend.trellobackend.services.fascade.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){

        // 01 - Receive the token from AuthService
        String token = authService.login(loginDto);

        // 02 - Set the token as a response using AuthResponseDto
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);
        
        // 03 - Generate refresh token
        String refreshToken = jwtTokenProvider.generateRefreshToken(loginDto.getUsername());
        authResponseDto.setRefreshToken(refreshToken);

        // 04 - Return the response to the user
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String responseMessage = authService.register(registerDto);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED); // HTTP 201 for created resource
    }


    // Build Refresh Token REST API
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDto> refreshToken(@RequestBody String refreshToken) {
        String newAccessToken = jwtTokenProvider.refreshAccessToken(refreshToken);
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(newAccessToken);

        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }

}
