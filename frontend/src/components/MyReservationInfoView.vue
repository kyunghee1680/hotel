<template>

    <v-data-table
        :headers="headers"
        :items="myReservationInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyReservationInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "roomNumber", value: "roomNumber" },
                { text: "reservationId", value: "reservationId" },
                { text: "reservationStatus", value: "reservationStatus" },
                { text: "startDate", value: "startDate" },
                { text: "endDate", value: "endDate" },
                { text: "price", value: "price" },
                { text: "paymentStatus", value: "paymentStatus" },
                { text: "hotelName", value: "hotelName" },
                { text: "address", value: "address" },
            ],
            myReservationInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myReservationInfos'))

            temp.data._embedded.myReservationInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myReservationInfo = temp.data._embedded.myReservationInfos;
        },
        methods: {
        }
    }
</script>

