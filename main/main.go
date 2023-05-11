package main

import (
	"encoding/json"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/health/", healthHandler)
	log.Println("Server listening on port 8000...")
	log.Fatal(http.ListenAndServe(":8000", nil))
}

type Response struct {
	Status string `json:"status"`
}

func healthHandler(w http.ResponseWriter, r *http.Request) {
	response := Response{Status: "OK"}
	jsonResponse, err := json.Marshal(response)
	if err != nil {
		log.Println("Failed to marshal JSON response:", err)
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}
	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(http.StatusOK)
	w.Write(jsonResponse)
}
