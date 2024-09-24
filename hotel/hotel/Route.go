package hotel

import (
	"github.com/labstack/echo"
	"net/http"
)

func RouteInit() *echo.Echo {
	e := echo.New()
	e.GET("/healthcheck", func(c echo.Context) error {
		return c.JSON(http.StatusOK, "ok")
	})
	hotel := &Hotel{}
	e.GET("/hotels", hotel.Get)
	e.GET("/hotels/:id", hotel.FindById)
	e.POST("/hotels", hotel.Persist)
	e.PUT("/hotels/:id", hotel.Put)
	e.DELETE("/hotels/:id", hotel.Remove)
	return e
}
