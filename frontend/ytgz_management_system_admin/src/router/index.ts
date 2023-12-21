import { RouteRecordRaw, createWebHashHistory, createRouter } from "vue-router"

const routes: RouteRecordRaw[] = [
    {
        path: "/login",
        component: () => import("@/views/login.vue"),
    },
    {
        path: "/admin",
        component: () => import("@/views/admin/index.vue"),
        children: [
            {
                path: "student_manage",
                component: () => import("@/views/admin/StudentManage/index.vue")
            },
            {
                path: "teacher_manage",
                component: () => import("@/views/admin/teacherManage.vue")
            },
            {
                path: "course_manage",
                component: () => import("@/views/admin/courseManage.vue")
            },
            {
                path: "",
                component: () => import("@/views/admin/home.vue")
            }
        ]
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router