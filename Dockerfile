# https://hub.docker.com/r/jamesdbloom/docker-java8-maven/
FROM jamesdbloom/docker-java8-maven
# Define workspace folder
WORKDIR /local/git 
# Clone the repository
RUN git clone https://github.com/bruno1022/devops-trabalho-final
# CD to the folder we've just cloned 
WORKDIR /local/git/devops-trabalho-final