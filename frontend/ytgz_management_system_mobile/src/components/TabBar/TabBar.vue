<template>
    <van-tabbar v-model="active" @change="onChange">
        <van-tabbar-item v-for="it in tabbarItem" :key="it.name" :icon="it.icon">{{ it.label }}</van-tabbar-item>
    </van-tabbar>
</template>

<script setup lang="ts">
import { ref } from "vue"
import { useRouter } from "vue-router"

const router = useRouter()

const active = ref<string>()

const tabbarItem = [
    {
        icon: "home-o",
        label: "首页",
        name: "home",
    },
    {
        icon: "qr",
        label: "工作台",
        name: "work",
    },
    {
        icon: "user-o",
        label: "我的",
        name: "mine"
    }
]

const onChange = (index: number) => {
    console.log(index, active)
    router.push({
        name: tabbarItem[index].name
    })
}

</script>