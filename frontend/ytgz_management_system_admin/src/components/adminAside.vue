<template>
    <div class="ytgz-admin-aside">
        <h1 class="aside-title">道州玉潭教务系统</h1>
        <el-menu
            active-text-color="rgb(64, 158, 255)"
            default-active="1"
            text-color="#fff"
            background-color="#304156"
            @select="handleSelect"
        >
            <el-menu-item index="1-1">
                <el-icon><HomeFilled /></el-icon>
                <span>首页</span>
            </el-menu-item>
            <el-sub-menu index="2">
                <template #title>
                    <el-icon><UserFilled /></el-icon>
                    <span>人员管理</span>
                </template>
                <el-menu-item index="2-1" >
                    <span>学生管理</span>
                </el-menu-item>
                <el-menu-item index="2-2">
                    <span>教师管理</span>
                </el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="3">
                <template #title>
                    <el-icon><Briefcase /></el-icon>
                    <span>教务管理</span>
                </template>
                <el-menu-item index="3-1">
                    <span>课表管理</span>
                </el-menu-item>
                <el-menu-item index="3-2">
                    <span>学生请假</span>
                </el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="4">
                <template #title>
                    <el-icon><DataLine /></el-icon>
                    <span>信息统计</span>
                </template>
                <el-menu-item index="3-1">
                    <span>体温测量</span>
                </el-menu-item>
            </el-sub-menu>
        </el-menu>
    </div>
</template>

<script setup lang="ts">
import { useRouter } from "vue-router"

const indexRouteMap = new Map([
    ["1-1", "/admin"],
    ["2-1", "/admin/student_manage"],
    ["2-2", "/admin/teacher_manage"],
    ["3-1", "/admin/course_manage"],
])

const router = useRouter()

const handleSelect = (index:any) => {
    router.push({
        path: indexRouteMap.get(index) || "/admin"
    })
}

</script>

<style lang="less" scoped>
@--el-menu-active-color: rgb(64, 158, 255);
.ytgz-admin-aside {
    background-color: #304156;
    height: 100%;
    .aside-title {
        display: flex;
        align-items: center;
        color: #fff;
        font-size: medium;
        justify-content: center;
        height: 45px;
    }
    .el-menu-item {
        font-size: 16px;
    }
    .el-sub-menu__title {
        span, i {
            font-size: 16px;
        }
    }
}
</style>