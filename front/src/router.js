import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "./components/Login.vue";
import Messages from "./components/MessagesManager.vue";
import PageNotFound from './components/PageNotFound.vue'
import store from './store'

Vue.use(VueRouter)
const routes = [
    {
        path: '/', component: Messages, beforeEnter: (to, from, next) => {
            if (store.state.authorized) {
                next()
            }
            else {
                next('/login')
            }
        }
    },
    { path: '/login', component: Login },
    { path: "*", component: PageNotFound }
]

const router = new VueRouter({
    routes // сокращённая запись для `routes: routes`
})

export default router;