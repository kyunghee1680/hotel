package hotel

import (
	"github.com/mitchellh/mapstructure"
)

func wheneverHotelReservationCanceled_IncreaseRoom(data map[string]interface{}){
	
	event := NewHotelReservationCanceled()
	mapstructure.Decode(data,&event)

	IncreaseRoom(event);
}

func wheneverHotelReservationCompleted_DecreaseRoom(data map[string]interface{}){
	
	event := NewHotelReservationCompleted()
	mapstructure.Decode(data,&event)

	DecreaseRoom(event);
}

