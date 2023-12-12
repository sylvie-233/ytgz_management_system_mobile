<template>
    <div class="work-container">
        <van-swipe class="work-swipe" :autoplay="3000" indicator-color="white">
            <van-swipe-item v-for="it in images" :key="it.label">
                <img :src="it.imgSrc" :alt="it.label" />
            </van-swipe-item>
        </van-swipe>
        <div class="work-divider-title">
            <div class="work-divider-line" />
            <span>常用服务</span>
        </div>
        <van-grid :column-num="4">
            <van-grid-item v-for="it in serviceItems" :key="it.index" :icon="it.icon" :text="it.label" />
        </van-grid>
    </div>
</template>

<script setup lang="ts">
import { ref } from "vue"

interface WorkSwipeImage {
    imgSrc: string
    label: string
}

interface serviceItem {
    index: string
    label: string
    icon: string
}

const images = ref<WorkSwipeImage[]>([
    {
        imgSrc: 'https://fastly.jsdelivr.net/npm/@vant/assets/apple-1.jpeg',
        label: "1"
    },
    {
        imgSrc: 'https://fastly.jsdelivr.net/npm/@vant/assets/apple-2.jpeg',
        label: "2"
    }
])

const serviceItems: serviceItem[] = [
    {
        index: "1-1",
        label: "请假管理",
        icon: "photo-o"
    },
    {
        index: "1-2",
        label: "请假管理",
        icon: "photo-o"
    },
    {
        index: "1-3",
        label: "请假管理",
        icon: "photo-o"
    },
    {
        index: "1-4",
        label: "请假管理",
        icon: "photo-o"
    },
    {
        index: "1-5",
        label: "请假管理",
        icon: "photo-o"
    },
]


</script>

<style lang="less" scoped>
.work-container {
    img {
        height: 220px;
        object-fit: contain;
    };
    .work-divider-title {
        box-sizing: border-box;
        margin-top: 16px;
        margin-left: 10px;
        display: flex;
        align-items: center;
        height: 32px;
        .work-divider-line {
            margin-left: 4px;
            width: 4px;
            height: 80%;
            background-color: skyblue;
        }
        span {
            margin-left: 12px;
            box-sizing: border-box;
            font-size: 16px;
            font-weight: bold;
            color: rgb(65, 55, 55);
        }
        
    }
}
</style>