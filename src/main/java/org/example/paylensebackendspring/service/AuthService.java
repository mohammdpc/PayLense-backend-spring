
package org.example.paylensebackendspring.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.paylensebackendspring.dto.AuthResponse;
import org.example.paylensebackendspring.dto.LoginRequest;
import org.example.paylensebackendspring.dto.RegisterRequest;
import org.example.paylensebackendspring.dto.UserResponse;
import org.example.paylensebackendspring.entity.AppSettings;
import org.example.paylensebackendspring.entity.NotificationPreference;
import org.example.paylensebackendspring.entity.User;
import org.example.paylensebackendspring.entity.UserContactMethod;
import org.example.paylensebackendspring.enums.ContactType;
import org.example.paylensebackendspring.exception.DuplicateResourceException;
import org.example.paylensebackendspring.exception.InvalidCredentialsException;
import org.example.paylensebackendspring.repository.AppSettingsRepository;
import org.example.paylensebackendspring.repository.NotificationPreferenceRepository;
import org.example.paylensebackendspring.repository.UserContactMethodRepository;
import org.example.paylensebackendspring.repository.UserRepository;
import org.example.paylensebackendspring.security.JwtService;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserContactMethodRepository contactRepository;
    private final AppSettingsRepository appSettingsRepository;
    private final NotificationPreferenceRepository notificationPreferenceRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public UserResponse register(RegisterRequest request) {

        String username = request.username().trim();
        String email = normalizeEmail(request.email());
        String phone = normalizePhone(request.phone());

        if (userRepository.existsByUsername(username)) {
            throw new DuplicateResourceException("Username is already taken");
        }

        if (contactRepository.existsByContactTypeAndContactValue(ContactType.EMAIL, email)) {
            throw new DuplicateResourceException("Email is already registered");
        }

        if (contactRepository.existsByContactTypeAndContactValue(ContactType.PHONE, phone)) {
            throw new DuplicateResourceException("Phone number is already registered");
        }

        User user = userRepository.save(User.builder()
                .username(username)
                .passwordHash(passwordEncoder.encode(request.password()))
                .build());

        contactRepository.save(UserContactMethod.builder()
                .user(user)
                .contactType(ContactType.EMAIL)
                .contactValue(email)
                .primary(true)
                .build());

        contactRepository.save(UserContactMethod.builder()
                .user(user)
                .contactType(ContactType.PHONE)
                .contactValue(phone)
                .primary(false)
                .build());

        appSettingsRepository.save(AppSettings.builder()
                .user(user)
                .build());

        notificationPreferenceRepository.save(NotificationPreference.builder()
                .user(user)
                .build());

        return UserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {

        String identifier = request.identifier().trim();

        User user;

        if (identifier.contains("@")) {

            String email = normalizeEmail(identifier);

            UserContactMethod contact = contactRepository
                    .findByContactTypeAndContactValue(ContactType.EMAIL, email)
                    .orElseThrow(InvalidCredentialsException::new);

            user = contact.getUser();

        } else if (identifier.matches("^\\+?[0-9]{8,15}$")) {

            String phone = normalizePhone(identifier);

            UserContactMethod contact = contactRepository
                    .findByContactTypeAndContactValue(ContactType.PHONE, phone)
                    .orElseThrow(InvalidCredentialsException::new);

            user = contact.getUser();

        } else {

            user = userRepository.findByUsername(identifier)
                    .orElseThrow(InvalidCredentialsException::new);
        }

        if (!user.isActive() || user.isDeleted()
                || !passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new InvalidCredentialsException();
        }

        return jwtService.generateToken(user.getId());
    }

    private String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }

    private String normalizePhone(String phone) {
        return phone.trim();
    }
}
