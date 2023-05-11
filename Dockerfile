FROM golang:1.20.4-buster

RUN go version
ENV GOPATH=/
RUN go mod download
RUN go build -o endpoint-app ./main/main.go
CMD ["./endpoint-app"]
