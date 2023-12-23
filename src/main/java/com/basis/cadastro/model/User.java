package com.basis.cadastro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "recovery_code")
    String recoveryCode;

    @Column(name = "is_active")
    String isActive;

    @Column(name = "access_count")
    int accessCount;

    @Column(name = "gender")
    String gender;

    @JsonFormat(
            shape=JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy")
    @Column(name = "date_of_birth")
    LocalDate  dateOfBirth;

    @LastModifiedDate
    @Column(name = "last_visit_date")
    LocalDateTime lastVisitDate;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, updatable = false)
    LocalDateTime updatedAt;
}
