FROM ubuntu:latest
LABEL authors="sallich"

ENTRYPOINT ["top", "-b"]