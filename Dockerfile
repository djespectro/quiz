FROM alpine:latest

ARG CONTEXT_DIR=/dir_name

WORKDIR /opt

RUN apk add --update openjdk8-jre

RUN export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin

RUN addgroup -S runner -g 433 && \
    adduser -u 431 -S -g runner -h /opt -s /sbin/nologin runner

RUN echo -e "#!/usr/bin/env sh\njava -jar app.jar" > run.sh

EXPOSE 8080

ADD ./$CONTEXT_DIR ./app.jar

RUN chown -R runner:runner /opt

USER runner

CMD ["sh","run.sh"]
