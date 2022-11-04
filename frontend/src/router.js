
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import ShoppingListView from "./components/ShoppingListView"
import ShoppingListViewDetail from "./components/ShoppingListViewDetail"
import RegisterOrdersView from "./components/RegisterOrdersView"
import RegisterOrdersViewDetail from "./components/RegisterOrdersViewDetail"
import OrdermanagementManager from "./components/listers/OrdermanagementCards"
import OrdermanagementDetail from "./components/listers/OrdermanagementDetail"

import ViewOrderDetailsView from "./components/ViewOrderDetailsView"
import ViewOrderDetailsViewDetail from "./components/ViewOrderDetailsViewDetail"
import PaymentHistoryManager from "./components/listers/PaymentHistoryCards"
import PaymentHistoryDetail from "./components/listers/PaymentHistoryDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/shoppingLists',
                name: 'ShoppingListView',
                component: ShoppingListView
            },
            {
                path: '/shoppingLists/:id',
                name: 'ShoppingListViewDetail',
                component: ShoppingListViewDetail
            },
            {
                path: '/registerOrders',
                name: 'RegisterOrdersView',
                component: RegisterOrdersView
            },
            {
                path: '/registerOrders/:id',
                name: 'RegisterOrdersViewDetail',
                component: RegisterOrdersViewDetail
            },
            {
                path: '/ordermanagements',
                name: 'OrdermanagementManager',
                component: OrdermanagementManager
            },
            {
                path: '/ordermanagements/:id',
                name: 'OrdermanagementDetail',
                component: OrdermanagementDetail
            },

            {
                path: '/viewOrderDetails',
                name: 'ViewOrderDetailsView',
                component: ViewOrderDetailsView
            },
            {
                path: '/viewOrderDetails/:id',
                name: 'ViewOrderDetailsViewDetail',
                component: ViewOrderDetailsViewDetail
            },
            {
                path: '/paymentHistories',
                name: 'PaymentHistoryManager',
                component: PaymentHistoryManager
            },
            {
                path: '/paymentHistories/:id',
                name: 'PaymentHistoryDetail',
                component: PaymentHistoryDetail
            },




    ]
})
