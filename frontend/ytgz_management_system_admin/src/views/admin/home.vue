<template>
    <div class="dzyt-home-top">
        <el-row justify="space-between">
            <el-col :span="10">
                <el-card style="height: 100%" body-style="height: 100%;box-sizing:border-box;">
                    <el-carousel height="280px">
                        <el-carousel-item v-for="item in 4" :key="item">
                            <h3 class="small justify-center" text="2xl">{{ item }}</h3>
                        </el-carousel-item>
                    </el-carousel>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card class="sum-card">
                    <div class="teacher-nums">教师总数</div>
                    <div class="teacher-text">237</div>
                </el-card>
            </el-col>
            <el-col :span="6">
                <el-card class="sum-card">
                    <div class="student-nums">学生总数</div>
                    <div class="student-text">237</div>
                </el-card>
            </el-col>
        </el-row>
    </div>
    <div class="dzyt-home-center">
        <el-row justify="start">
            <el-col :span="8">
                <el-card style="height: 540px;">
                    <template #header>
                        <div class="card-header">
                            <span>通知公告</span>
                            <el-button class="button" text style="float: right;">
                                <span>更多</span>
                                <el-icon><DArrowRight /></el-icon>
                            </el-button>
                        </div>
                    </template>
                </el-card>
            </el-col>
            <el-col :span="15" :offset="1">
                <el-card style="height: 540px;" body-style="box-sizing:border-box;width:100%;height:90%;overflow:hidden;display:flex;flex-direction:column;">
                    <template #header>
                        <div class="card-header">
                            <span class="leave-title">今日请假人数</span>
                            <el-badge class="leave-nums" :value="leaveNums" style="float: right;">
                                <el-tag type="success">{{ getToday_YYMMDD() }}</el-tag>
                            </el-badge>
                        </div>
                    </template>
                    <div ref="leaveRef" class="leaveCanvas" style="width: 100%;height: 100%;"></div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue"
import * as echarts from "echarts"
import { getToday_YYMMDD } from "@/utils/DateTimeFormat.ts"

const leaveNums = ref<number>(10)
const leaveRef = ref()
const echartsInit = () => {
    let leaveChart = echarts.init(leaveRef.value)
    let option = {
        height: "75%",
        xAxis: {
            type: 'category',
            data: ["G2304", "G2305", "G2306", "G2307", "G2308", "G2309", "G2310", "G2311", "G2312", "G2313", "G2314", "G2315"]
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                data: [6, 11, 23, 2, 5, 7, 4, 2, 12, 14, 11, 9],
                type: 'bar',
                label: {
                    show: true, // 显示数值
                    position: 'top' // 数值显示位置
                }
            }
        ]
    }
    leaveChart.setOption(option)
}

onMounted(() => {
    echartsInit()
})

</script>

<style lang="less"  scoped>
.dzyt-home-top {
    padding: 0 20px;
    min-height: 280px;
    .el-row {
        height: 100%;
        min-height: 280px;
    }
}
.dzyt-home-center {
    margin-top: 20px;
    padding: 0 20px;
    .el-card {
        min-height: 400px;
    }
    .leave-title {
        margin-right: 10px;
    }
    .leave-nums {
        margin-right: 35px;
    }
    .leaveCanvas {
        flex: 1;
        box-sizing: border-box;
        canvas {
            height: 90%;
        }
    }
}
.el-button:hover {
    span, i {
        color: rgb(64, 158, 255);
    }
}

.sum-card {
    height: 100%;
    border-radius: 68px;
    .student-nums,
    .teacher-nums {
        height: 70%;
        font-size: 28px;
        box-sizing: border-box;
        font-weight: bold;
        text-align: center;
        padding-top: 48px;
        color: #fff;
    }
    .student-text,
    .teacher-text {
        font-size: 48px;
        font-weight: bold;
        color: #fff;
        text-align: center;
        margin-top: 20px;
    }
    background-color: #75B0FF;
    &:hover {
        background-color: #fff;
        transition: all 0.3s;
        .teacher-nums, .teacher-text, .student-nums, .student-text {
            color: #75B0FF;
        }
    }
}
</style>