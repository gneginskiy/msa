FROM golang:1.20.4-buster

RUN go version
ENV GOPATH=/
COPY go.mod ./
RUN go mod download
COPY . .

RUN go build -o endpoint-app ./main/main.go
CMD ["./endpoint-app"]
