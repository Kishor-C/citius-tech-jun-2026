package com.examples;

import java.util.List;
import java.util.Optional;

public interface ProfileDAO {
	public Profile save(Profile profile);
	public List<Profile> findAll();
	// either returns profile or null
	public Optional<Profile> findById(int id);
	public void deleteById(int id);
	public Profile update(int id, Profile profile);
}
