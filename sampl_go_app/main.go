package main
import ( 

"fmt"
"log"
"net/http"
"os"

)

// IndexHandler returns a simple message
	func IndexHandler (w http. Responsewriter, r *http.Request) {
		fmt.Fprintf(w, "Congratulations! Welcome to AnubhavTrainings.com")
}

func main() {
	http.HandleFunc("/", IndexHandler)

	var port string
	if port = os.Getenv("PORT"); len(port) == 0 {
	   port = "8080"
	}

log.Fatal(http.ListenAndServe(":"+port, nil))

}