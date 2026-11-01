package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.AppSettings;

import java.util.UUID;

public interface AppSettingsRepository extends JpaRepository<AppSettings, UUID> {}
