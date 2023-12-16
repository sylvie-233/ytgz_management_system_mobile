<template>
    <div class="ytgz-admin">
        <el-container>
            <el-aside width="260px">
                <AdminAside />
            </el-aside>
            <el-container>
                <el-header height="90px">
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
    .el-header {
        padding: 0px;
        padding-bottom: 18px;
    }
    .screen {
        width: 100%;
        height: 50vh;
        background-color: #ccc;
        transition: transform 0.3s ease;
    }
    
    @media screen and (max-width: 600px) {
        /* 小于等于600像素时的样式 */
        .screen {
            transform: scale(0.7);
        }
    }
    
    @media screen and (min-width: 900px) {
        /* 大于等于900像素时的样式 */
        .screen {
            transform: scale(1.2);
        }
    }
}
</style>