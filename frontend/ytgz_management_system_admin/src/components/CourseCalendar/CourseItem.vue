<template>
    <div class="course-item">
        <div class="course-subject">{{ props.courseSubject }}</div>
        <div class="course-info">
            【{{ props.courseClazz }}】-【{{ props.courseTeacher }}】
        </div>
    </div>
</template>

<script setup lang="ts">
interface Props {
    courseSubject: string
    courseClazz: string
    courseTeacher: string
}

const props = defineProps<Props>()
</script>

<style lang="less" scoped>
.course-item {
    box-sizing: border-box;
    text-align: center;
    padding: 4px;
    .course-subject {
        text-align: center;
        font-weight: bold;
        font-size: 18px;
    }
    .course-info {
        text-align: center;
        font-size: 12px;
    }
}
</style>