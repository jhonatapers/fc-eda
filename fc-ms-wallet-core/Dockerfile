FROM golang:1.20
WORKDIR /go-app
COPY /app .
RUN apt-get update && apt-get install -y librdkafka-dev

CMD ["go", "run", "/go-app/cmd/walletcore/main.go"]