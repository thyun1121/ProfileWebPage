  package com.myProfile.thyun.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.myProfile.thyun.model.Artists;
import com.myProfile.thyun.model.WorldcupNation;

@EnableJpaRepositories("com.myProfile.thyun.Repository") 
public interface WorldCupJpaRepository extends JpaRepository<WorldcupNation, String>{
	//WorldcupNation findByArtistId(String artistId);
}
