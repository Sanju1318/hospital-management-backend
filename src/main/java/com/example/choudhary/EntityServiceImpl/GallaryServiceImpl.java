package com.example.choudhary.EntityServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.Gallary;
import com.example.choudhary.EntityDto.GallaryDto;
import com.example.choudhary.EntityRepo.GallaryRepo;
import com.example.choudhary.EntityService.GallaryService;

@Service
public class GallaryServiceImpl implements GallaryService {

    @Autowired
    private GallaryRepo gallaryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GallaryDto AddGallary(GallaryDto gallaryDto) {

        Gallary gallary = this.modelMapper.map(gallaryDto, Gallary.class);
        Gallary saved = this.gallaryRepo.save(gallary);

        return this.modelMapper.map(saved, GallaryDto.class);
    }

    @Override
    public List<GallaryDto> getAllGallary() {

        List<Gallary> allImages = this.gallaryRepo.findAll();

        return allImages.stream()
                .map(img -> this.modelMapper.map(img, GallaryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GallaryDto upadteGallary(GallaryDto gallaryDto, Integer gId) {
        return null;
    }

    @Override
    public void deleteGallary() {
        // future use
    }
}
