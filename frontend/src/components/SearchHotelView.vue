<template>

    <v-data-table
        :headers="headers"
        :items="searchHotel"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SearchHotelView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            searchHotel : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/searchHotels'))

            temp.data._embedded.searchHotels.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.searchHotel = temp.data._embedded.searchHotels;
        },
        methods: {
        }
    }
</script>

