package com.murilo358.docker_manager.controllers;

import com.github.dockerjava.api.model.Image;
import com.murilo358.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class DockerImagesController {

    private final DockerService dockerService;

    public DockerImagesController(DockerService dockerService) {
        this.dockerService = dockerService;
    }


    @GetMapping("/filter")
    public List<Image> listImages(@RequestParam(required = false, defaultValue = "image-") String imageName){
        return dockerService.filterImages(imageName);
    }

    @GetMapping("")
    public List<Image> listAllImages(){
        return dockerService.listAllImages();
    }

}
