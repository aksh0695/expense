FROM eclipse-temurin:11
RUN apt-get update && apt-get -y upgrade
RUN apt-get install -y inotify-tools dos2unix
RUN mkdir -p $HOME
WORKDIR $HOME