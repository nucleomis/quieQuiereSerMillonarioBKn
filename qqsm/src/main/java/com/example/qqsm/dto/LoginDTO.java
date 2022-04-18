package com.example.qqsm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private Boolean dpoLogin;
    private Boolean usuario;
    private Boolean contraseña;
}
