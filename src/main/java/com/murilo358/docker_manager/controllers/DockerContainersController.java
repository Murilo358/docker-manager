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


    @PostMapping("/{containerId}/start")
    public void startContainer(@PathVariable(required = true) String containerId){
        dockerService.startContainer(containerId);
    }

    @GetMapping("")
    public List<Container> listAllContainers(@RequestParam Boolean listAllContainers){
        return dockerService.listAllContainers(listAllContainers);
    }

    @PostMapping("/{containerId}/stop")
    public void stopContainer(@PathVariable(required = true) String containerId){
        dockerService.stopContainer(containerId);
    }

    @PostMapping("/{imageName}/create")
    public void createContainer(@PathVariable(required = true) String imageName){
        dockerService.createNewContainer(imageName);
    }
}
