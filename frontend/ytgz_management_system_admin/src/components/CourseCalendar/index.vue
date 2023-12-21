<template>
    <div class="course-box">
        <div class="course-header">
            <div class="course-toolbar-left"></div>
            <div class="course-toolbar-right"></div>
        </div>
        <div class="course-content">
            <table>
                <thead>
                    <tr>
                        <th>时间</th>
                        <th>节数</th>
                        <th>时间</th>
                        <th>星期一</th>
                        <th>星期二</th>
                        <th>星期三</th>
                        <th>星期四</th>
                        <th>星期五</th>
                        <th>星期六</th>
                        <th>星期天</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td rowspan="5" class="bold">上午</td>
                        <td class="fs-small">第一节</td>
                        <td></td>
                        <td>
                            <CourseItem
                                course-subject="数学"
                                course-clazz="G2311"
                                course-teacher="汪唱"
                            />
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">第二节</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">第三节</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">第四节</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">第五节</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="10" class="td-space"></td>
                    </tr>
                    <tr>
                        <td rowspan="4" class="bold">下午</td>
                        <td class="fs-small">第六节</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">第七节</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">第八节</td>
                        <td></td>
                        <td></td>
                        <td>
                            <CourseItem
                                course-subject="数学"
                                course-clazz="G2311"
                                course-teacher="汪唱"
                            />
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">第九节</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td rowspan="3" class="bold">晚上</td>
                        <td class="fs-small">晚一</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">晚二</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="fs-small">晚三</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <CourseItem
                                course-subject="数学"
                                course-clazz="G2311"
                                course-teacher="汪唱"
                            />
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup lang="ts">
import CourseItem from './CourseItem.vue';
</script>

<style lang="less" scoped>
.course-box {
    height: 100%;
    .course-content {
        height: 100%;
        table {
            height: 100%;
            width: 100%;
            margin: 0 auto;
            border-collapse: collapse;
            th {
                border: 1px solid black;
                box-sizing: border-box;
                height: 40px;
            }
            td {
                border: 1px solid black;
                box-sizing: border-box;
                height: 40px;
                text-align: center;
                &.bold {
                    font-weight: bold;
                    writing-mode: vertical-rl;
                }
                &.fs-small {
                    font-size: 13px;
                }
            }
            .td-space {
                height: 12px;
            }
        }
    }
}
</style>