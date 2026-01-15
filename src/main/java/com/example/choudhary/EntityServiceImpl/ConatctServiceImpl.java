package com.example.choudhary.EntityServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.Contact;
import com.example.choudhary.EntityDto.ContactDto;
import com.example.choudhary.EntityRepo.ContactRepo;
import com.example.choudhary.EntityService.ContactService;
@Service
public class ConatctServiceImpl implements ContactService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public ContactDto createContact(ContactDto contactDto) {
		// TODO Auto-generated method stub
		
		Contact contact=this.modelMapper.map(contactDto,Contact.class);
		
		Contact SaveContact=this.contactRepo.save(contact);
		return this.modelMapper.map(SaveContact, ContactDto.class);
	}

	@Override
	public List<ContactDto> gettAllConatct() {
		// TODO Auto-generated method stub
		List<Contact> list=this.contactRepo.findAll();
		return list.stream().map((l)-> this.modelMapper.map(l, ContactDto.class )).collect(Collectors.toList());
	}

	@Override
	public void deleteContact(Integer cid) {
		// TODO Auto-generated method stub
		
		this.contactRepo.deleteById(cid);

	}

	@Override
	public ContactDto getByIdConatct(Integer cid) {
		// TODO Auto-generated method stub
		
		Contact contact=this.contactRepo.findById(cid).orElseThrow();
		return this.modelMapper.map(contact,ContactDto.class);
	}

}
