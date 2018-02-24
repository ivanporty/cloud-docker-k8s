package main

import (
	"fmt"
	"time"
	"net/http"
	"log"
)

func main() {
	http.HandleFunc("/time", serveTime)
	http.HandleFunc("/nanotime", serveNanoTime)	
	log.Fatal(http.ListenAndServe("0.0.0.0:8080", nil))
}

func serveTime(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Текущее время: ", time.Now().String())
}

func serveNanoTime(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Время UnixNano: ", time.Now().UnixNano())
}