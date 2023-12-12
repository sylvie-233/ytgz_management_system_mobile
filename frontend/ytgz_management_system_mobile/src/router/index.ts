import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router"
import Main from "../views/Main.vue"
import Login from "../views/Login.vue"
import Home from "../views/Home.vue"
import Work from "../views/Work.vue"
import Mine from "../views/Mine.vue"

const routes: RouteRecordRaw[] = [
    {
        path: "/login",
        name: "login",
        component: Login
    }
    ,{
        path: "/",
        name: "main",
        component: Main,
        beforeEnter: (to, from, next) => {
            if (window.localStorage.getItem("token") == null) {
                next({
                    name: "login"
                })
            }
            next()
        },
        children: [
            {
                path: "work",
                name: "work",
                component: Work
            },
            {
                path: "mine",
                name: "mine",
                component: Mine
            },
            {
                path: "/",
                name: "home",
                component: Home
            }
        ]
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router