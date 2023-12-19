<template>
    <div class="admin-header">
        <div class="header-left">
            <el-icon><Fold /></el-icon>
        </div>
        <div class="header-right">
            <el-dropdown ref="avatar" trigger="click" style="margin-right: 30px">
                <div class="right-box">
                    <el-avatar size="default" :src="userDefault" />
                    <span class="right-box-name">Sylvie233</span>
                </div>
                <template #dropdown>
                <el-dropdown-menu>
                    <el-dropdown-item>修改个人信息</el-dropdown-item>
                    <el-dropdown-item divided @click="loginOutHandle">退出登录</el-dropdown-item>
                </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script setup lang="ts">
import userDefault from "@/assets/images/user.png"
import { useRouter } from "vue-router";
import { ElNotification } from "element-plus"

const router = useRouter()


const loginOutHandle = () => {
    setTimeout(() => {
        router.push({
            path: "/login"
        })
        ElNotification({
            title: '退出登录成功',
            message: '请重新登录账号',
            type: 'success',
        })
    }, 500)
}

</script>

<style lang="less"  scoped>
.admin-header {
    box-sizing: border-box;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    box-shadow: var(--el-box-shadow-light);
    .header-left {
        margin-left: 20px;
        font-size: 24px;
    }
    .header-right {
        margin-right: 4px;
        height: 100%;
        display: flex;
        align-items: center;
        cursor: pointer;
        .right-box {

            display: flex;
            justify-content: center;
            align-items: center;
            .right-box-name {
                margin-left: 6px;
                font-size: 16px;
            }
        }
    }
}
</style>