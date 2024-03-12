package com.example.demo.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactRecordDto(
		@NotBlank String name,
		@NotBlank String lastName,
		@NotNull int age,
		@NotBlank String nacionality,
		@NotBlank String email) {
}
