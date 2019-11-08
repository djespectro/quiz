FROM alpine:latest

RUN apk add --update openjdk8-jre

ARG CONTEXT_DIR=/dir_name

WORKDIR /opt

ADD ./$CONTEXT_DIR ./app.jar

RUN echo -e "#!/usr/bin/env sh\njava -jar app.jar" > run.sh

EXPOSE 3306

CMD ["sh","run.sh"]
