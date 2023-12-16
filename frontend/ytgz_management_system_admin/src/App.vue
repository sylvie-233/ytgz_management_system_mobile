<script setup lang="ts">

</script>

<template>
  <transition name="router-animate">
      <router-view />
  </transition>
</template>

<style lang="less" scoped>
.router-animate-enter-active {
    animation: slideInLeft 0.5s;
}
.router-animate-leave-active {
    animation: slideOutLeft 0.5s;
}
</style>
