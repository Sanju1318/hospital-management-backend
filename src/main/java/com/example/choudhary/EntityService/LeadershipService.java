package com.example.choudhary.EntityService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.choudhary.EntityDto.LeadershipDto;
@Service
public interface LeadershipService {
	
	
	LeadershipDto addLeader(LeadershipDto leadershipDto);
	
	LeadershipDto updateLeader(LeadershipDto leadershipDto,Integer lid);
	
	List<LeadershipDto> gettAllLeader();
	
	LeadershipDto leaderDelete(Integer lid);
	

}
