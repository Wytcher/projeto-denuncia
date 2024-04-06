package com.br.projeto.dto.report;

import com.br.projeto.dto.user.ReportUserDTO;
import com.br.projeto.dto.user.UserResponseDTO;
import com.br.projeto.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponseDTO implements Serializable {

    private UUID id;
    private String protocolNumber;
    private String status;
    private String description;
    private LocalDate dateOfOccurrence;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ReportUserDTO user;
}
