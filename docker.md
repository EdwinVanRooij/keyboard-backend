# Learning Docker

## Commands

> List Docker CLI commands
docker

> Display docker version, amount of images on host, amount of containers, etc.
docker info

> Display docker version
docker version

> Execute a Docker image
docker run <image-name>
e.g. 'docker run hello-world'

> List docker images
docker image ls -- because listing files/images

> List active docker containers
docker container ps -- because listing processes/instances



## Dockerfile

A dockerfile defines what goes on in the environment inside the running instance of the image, a container.


## Pushing to dockerhub
Dockerhub is one of the many docker 'registries'.
A registry is a collection of repositories, like GitHub and BitBucket.
A repository is a collection of images, just like a github repository.

An account on github can contain many repositories of code.
An account on dockerhub can contain many repositories of docker images.

Dockerhub is a registry. It is the default when running 'docker run ...'. 

Using the following syntax:
'docker push username/repository:tag'
we can push images to dockerhub.

Each image's name is usually written in the following syntax, using best practices:
<username>/<name>:<tag>

After pushing it, we can just run it like this anywhere:
docker run <username>/<name>:<tag>


### Recap part 2
Using 'docker build .' we use the local Dockerfile to build a new image.

### Continue at part 3: Services
https://docs.docker.com/get-started/part3/
