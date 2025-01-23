package com.iiitbinfo.iiitbinfo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record StudentRequest(
    @JsonProperty("student_id")
    @NotNull(message = "ID could not be null")
    Long student_id,

    @JsonProperty("rollNo") 
    @NotBlank(message = "First name cannot be null or blank") 
    String rollNo,

    @JsonProperty("email") 
    @NotBlank(message = "Email cannot be null or blank") 
    @Email(message = "Invalid email format")
    String email,

    @JsonProperty("firstName") 
    @NotBlank(message = "First name cannot be null or blank") 
    String firstName,

    @JsonProperty("lastName") 
    String lastName,

    @JsonProperty("password") 
    @NotBlank(message = "Password cannot be null or blank") 
    String password
) {}
