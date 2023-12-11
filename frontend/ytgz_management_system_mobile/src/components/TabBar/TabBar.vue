<template>
    <van-tabbar @change="onChange">
        <van-tabbar-item icon="home-o">标签</van-tabbar-item>
        <van-tabbar-item icon="search">标签</van-tabbar-item>
        <van-tabbar-item icon="friends-o">标签</van-tabbar-item>
        <van-tabbar-item icon="setting-o">标签</van-tabbar-item>
    </van-tabbar>
</template>

<script setup lang="ts">
import { ref } from "vue"
import { Tabbar, TabbarItem } from "vant"

const onChange = (index: int) => {
    console.log(index)
}

</script>