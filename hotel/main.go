package main

import(
	"log"
	"hotel/hotel"
	"hotel/config"
)

func main() {
	config.ConfigMode()
	options := config.Reader(config.GetMode())
	log.Printf("option : %v", options)
	hotel.HotelDBInit()
	go hotel.InitProducer(config.GetMode())
	// view 와 같이 사용시 InitConsumer 가 중복으로 호출될수 있으니, 하나는 삭제 필요
	go hotel.InitConsumer(config.GetMode())
	e := hotel.RouteInit()

	e.Logger.Fatal(e.Start(":8082"))
}
