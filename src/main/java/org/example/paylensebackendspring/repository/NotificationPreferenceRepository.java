package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.NotificationPreference;

import java.util.UUID;

public interface NotificationPreferenceRepository extends JpaRepository<NotificationPreference, UUID> {}
