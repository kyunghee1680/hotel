
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import HotelHotelManager from "./components/listers/HotelHotelCards"
import HotelHotelDetail from "./components/listers/HotelHotelDetail"

import ReservationHotelReservationManager from "./components/listers/ReservationHotelReservationCards"
import ReservationHotelReservationDetail from "./components/listers/ReservationHotelReservationDetail"

import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/hotels/hotels',
                name: 'HotelHotelManager',
                component: HotelHotelManager
            },
            {
                path: '/hotels/hotels/:id',
                name: 'HotelHotelDetail',
                component: HotelHotelDetail
            },

            {
                path: '/reservations/hotelReservations',
                name: 'ReservationHotelReservationManager',
                component: ReservationHotelReservationManager
            },
            {
                path: '/reservations/hotelReservations/:id',
                name: 'ReservationHotelReservationDetail',
                component: ReservationHotelReservationDetail
            },

            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },





    ]
})
