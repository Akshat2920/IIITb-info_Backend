package com.iiitbinfo.iiitbinfo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record StudentLogin(
    @JsonProperty("rollNo") 
    @NotBlank(message = "First name cannot be null or blank") 
    String rollNo,

    @JsonProperty("password") 
    @NotBlank(message = "Password cannot be null or blank") 
    String password
) {}
