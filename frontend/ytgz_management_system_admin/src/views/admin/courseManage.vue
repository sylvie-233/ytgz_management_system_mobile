<template>
    <div class="course-manage-box">
        <el-card body-style="height: calc(100% - 40px);display:flex;flex-direction:column;">
            <div class="box-header">
                <div class="box-header-text">
                    课表管理
                </div>
                <div class="box-header-toolbar">
                    <div class="toolbar-left">
                        <el-select v-model="classSelect" placeholder="选择班级" size="large">
                            <el-option
                            v-for="item in classOptions"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                            />
                        </el-select>
                        <el-button class="toolbar-add" type="primary" :icon="CirclePlus">添加</el-button>
                    </div>
                    <div class="toolvar-right">
                        <el-input
                            v-model="searchText"
                            placeholder="搜索"
                            :prefix-icon="Search"
                        />
                    </div>
                </div>
            </div>
            <el-divider />
            <div class="box-content">
                <CourseCalendar />
            </div>
            <div class="box-footer"></div>
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import { Search, CirclePlus } from "@element-plus/icons-vue"
import CourseCalendar from "@/components/CourseCalendar/index.vue"


interface classOption {
    label: string
    value: string
}


const searchText = ref<string>("")
const classSelect = ref<string>("")

const classOptions: classOption[] = [
    {
        label: "G2304",
        value: "G2304"
    },
    {
        label: "G2305",
        value: "G2305"
    },
]

onMounted(() => {
})

</script>

<style lang="less" scoped>
.course-manage-box {
    height: calc(100vh - 140px);
    padding: 0 20px;
    .el-card {
        height: 100%;
        padding: 20px;
        box-sizing: border-box;
        overflow: hidden;
        flex-direction: column;
        .box-header {
            .box-header-text {
                font-size: 28px;
                font-weight: bold;
            }
            .box-header-toolbar {
                margin-top: 10px;
                display: flex;
                justify-content: space-between;
                .toolbar-left {
                    display: flex;
                    align-items: center;
                    .toolbar-add {
                        margin-left: 20px;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        .el-icon {
                            font-size: 24px;
                        }
                    }
                }
                .toolvar-right {
                }
                
            }
        }
        .box-content {
            flex: 1;
            overflow-y: auto;
            &::-webkit-scrollbar {
                width: 8px;
            }
            &::-webkit-scrollbar-thumb {
                border-radius: 10px;
                background: rgba(0,0,0,0.2);
            }
            &::-webkit-scrollbar-track {
                border-radius: 0;
                background: rgba(0,0,0,0.1);
            }
            
        }
    }
}
:deep(.table-action-label) {
    text-align: center;
}
</style>