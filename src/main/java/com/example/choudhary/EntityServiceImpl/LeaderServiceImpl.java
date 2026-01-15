package com.example.choudhary.EntityServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.Leadership;
import com.example.choudhary.EntityDto.LeadershipDto;
import com.example.choudhary.EntityRepo.LeadersipRepo;
import com.example.choudhary.EntityService.LeadershipService;

import lombok.Setter;
@Service
public class LeaderServiceImpl implements LeadershipService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	
	private LeadersipRepo leadersipRepo;

	@Override
	public LeadershipDto addLeader(LeadershipDto leadershipDto) {
		// TODO Auto-generated method stub
		
		Leadership leadership=this.modelMapper.map(leadershipDto, Leadership.class);
		leadership.setLphoto(leadershipDto.getLphoto());
		Leadership leadershipSave=this.leadersipRepo.save(leadership);
		return this.modelMapper.map(leadershipSave, LeadershipDto.class);
	}

	@Override
	public LeadershipDto updateLeader(LeadershipDto leadershipDto, Integer lid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeadershipDto> gettAllLeader() {
		// TODO Auto-generated method stub
		
		List<Leadership> leaderships=this.leadersipRepo.findAll();
		List<LeadershipDto> AllLeders=leaderships.stream().map((leader)->this.modelMapper.map(leader, LeadershipDto.class)).collect(Collectors.toList());
		return AllLeders ;
	}

	@Override
	public LeadershipDto leaderDelete(Integer lid) {
		// TODO Auto-generated method stub
		return null;
	}

}
