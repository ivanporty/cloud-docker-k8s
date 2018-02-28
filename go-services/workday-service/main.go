package main

import (
	"fmt"
	"net/http"
	"io/ioutil"
	"log"
)

func main() {
	http.HandleFunc("/workday", serveWorkTime)
	log.Fatal(http.ListenAndServe("0.0.0.0:8080", nil))
}

func httpToString(addr string) string {
	response, err := http.Get(addr)
    if err != nil {
        fmt.Printf("Ошибка запроса %s\n", err)
        return ""
    } else {
        data, _ := ioutil.ReadAll(response.Body)
        return string(data)
    }
}

func serveWorkTime(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Вызываем time-service по имени...")
    serviceName := "time-service"
    addr := "http://" + serviceName + ":8080"
    timeStr := httpToString(addr + "/time")
    nanoTimeStr := httpToString(addr +"/nanotime")

    fmt.Fprintln(w, "/time вернул: ", timeStr, "/nanotime вернул: ", nanoTimeStr)
}