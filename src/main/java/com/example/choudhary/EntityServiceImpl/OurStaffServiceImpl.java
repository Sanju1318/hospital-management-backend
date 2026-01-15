package com.example.choudhary.EntityServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.choudhary.Entity.OurStaff;
import com.example.choudhary.EntityDto.OurStaffDto;
import com.example.choudhary.EntityRepo.OurStaffRepo;
import com.example.choudhary.EntityService.OurStaffService;

@Service
public class OurStaffServiceImpl implements OurStaffService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private OurStaffRepo ourStaffRepo;
	
	

	@Override
	public OurStaffDto AddStaff(OurStaffDto ourStaffDto) {
		// TODO Auto-generated method stub
		OurStaff staff=this.modelMapper.map(ourStaffDto, OurStaff.class);
		OurStaff Staffsave=this.ourStaffRepo.save(staff);
		return this.modelMapper.map(Staffsave, OurStaffDto.class);
	}
	@Override
    public OurStaffDto AddImage(OurStaffDto ourStaffDto, Integer staffId) {
        OurStaff staff = this.ourStaffRepo.findById(staffId).orElse(null);

        if (staff == null) {
            return null;
        }

        // Set only image name
        staff.setImagename(ourStaffDto.getImagename());

        OurStaff savedStaff = this.ourStaffRepo.save(staff);
        return this.modelMapper.map(savedStaff, OurStaffDto.class);
    }
	
	

	@Override
	public List<OurStaffDto> FindData() {
		// TODO Auto-generated method stub
		
		List<OurStaff>ourStaffs =this.ourStaffRepo.findAll();
		List<OurStaffDto> ListofStaff=ourStaffs.stream().map((allstaff)->this.modelMapper.map(allstaff, OurStaffDto.class)).collect(Collectors.toList());
		return ListofStaff;
	}

	@Override
	public void DeleteStaff() {
		// TODO Auto-generated method stub

	}

	@Override
	public OurStaffDto UpdateStaff(OurStaffDto ourStaffDto, Integer staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OurStaffDto GetById(Integer staffId) {
		// TODO Auto-generated method stub
		OurStaff ourStaff=this.ourStaffRepo.findById(staffId).orElse(null);
		return this.modelMapper.map(ourStaff, OurStaffDto.class);
	}
	

}
