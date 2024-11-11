package com.murilo358.docker_manager.services;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerService {

    private final DockerClient dockerClient;

    public DockerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Container> listAllContainers(boolean all) {

        return dockerClient.listContainersCmd().withShowAll(all).exec();

    }

    public List<Image> listAllImages(){
        return dockerClient.listImagesCmd().exec();
    }

    public List<Image> filterImages(String imageName){
        return dockerClient.listImagesCmd().withImageNameFilter(imageName).exec();
    }


    public void startContainer(String containerId){
        dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId).exec();
    }

    public void createNewContainer(String imageName) {
        dockerClient.createContainerCmd(imageName).exec();
    }

}
