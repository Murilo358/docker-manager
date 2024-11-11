package com.murilo358.docker_manager.controllers;

import com.github.dockerjava.api.model.Container;
import com.murilo358.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/containers")
public class DockerContainersController {

    private final DockerService dockerService;

    public DockerContainersController(DockerService dockerService) {
        this.dockerService = dockerService;
    }


    @PostMapping("/start")
    public void startContainer(@RequestParam(required = true) String containerId){
        dockerService.startContainer(containerId);
    }

    @GetMapping("")
    public List<Container> listAllContainers(@RequestParam Boolean listAllContainers){
        return dockerService.listAllContainers(listAllContainers);
    }

    @PostMapping("/stop")
    public void stopContainer(@RequestParam(required = true) String containerId){
        dockerService.stopContainer(containerId);
    }

    @PostMapping("/create")
    public void createContainer(@RequestParam(required = true) String imageName){
        dockerService.createNewContainer(imageName);
    }
}
