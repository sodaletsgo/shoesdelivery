<template>

    <v-data-table
        :headers="headers"
        :items="registerOrders"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'RegisterOrdersView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            registerOrders : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/registerOrders'))

            temp.data._embedded.registerOrders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.registerOrders = temp.data._embedded.registerOrders;
        },
        methods: {
        }
    }
</script>

