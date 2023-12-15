<template>
    <div class="dzyt-home-top">
        <el-card>
            <el-carousel height="150px">
                <el-carousel-item v-for="item in 4" :key="item">
                    <h3 class="small justify-center" text="2xl">{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>
        </el-card>
    </div>
    <div class="dzyt-home-message">
        <el-card>
            <template #header>
                <div class="card-header">
                    <span>Card name</span>
                    <el-button class="button" text>Operation button</el-button>
                </div>
            </template>
        </el-card>
    </div>
</template>

<style lang="less"  scoped>
.dzyt-home-top {
    padding: 0 20px;
}
.dzyt-home-message {
    margin-top: 20px;
    padding: 0 20px;
}
</style>