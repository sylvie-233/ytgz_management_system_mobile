<template>
    <div class="ytgz-admin">
        <el-container>
            <el-aside width="200px">
                <AdminAside />
            </el-aside>
            <el-container>
                <el-header height="50px">
                    <AdminHeader />
                </el-header>
                <el-main>
                    <AdminMain />
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script setup lang="ts">
import AdminAside from "@/components/adminAside.vue"
import AdminHeader from "@/components/adminHeader.vue"
import AdminMain from "@/components/adminMain.vue"

</script>

<style lang="less">
.ytgz-admin {
    width: 100%;
    height: 100%;
    .el-container {
        height: 100%;
        .el-aside {
            height: 100%;
        }
        .el-main {
            padding: 0;
        }
    }
}
</style>