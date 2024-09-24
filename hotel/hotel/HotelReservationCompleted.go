package hotel

import (
	"time"
)

type HotelReservationCompleted struct{
	EventType string	`json:"eventType" type:"string"`
	TimeStamp string 	`json:"timeStamp" type:"string"`
	Id int `json:"id" type:"int"` 
	ReservationId string `json:"reservationId" type:"string"` 
	UserId string `json:"userId" type:"string"` 
	StartDate  `json:"startDate" type:""` 
	EndDate  `json:"endDate" type:""` 
	Price int `json:"price" type:"int"` 
	Status string `json:"status" type:"string"` 
	RoomCount int `json:"roomCount" type:"int"` 
	HotelName string `json:"hotelName" type:"string"` 
	Address string `json:"address" type:"string"` 
	RoomNumber int `json:"roomNumber" type:"int"` 
	
}

func NewHotelReservationCompleted() *HotelReservationCompleted{
	event := &HotelReservationCompleted{EventType:"HotelReservationCompleted", TimeStamp:time.Now().String()}

	return event
}
