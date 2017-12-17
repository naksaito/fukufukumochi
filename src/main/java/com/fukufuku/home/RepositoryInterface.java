package com.fukufuku.home;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInterface extends JpaRepository<Entity, Integer> {
}
