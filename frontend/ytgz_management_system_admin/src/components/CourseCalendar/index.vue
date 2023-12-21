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
                        <td class="fs-small">07:55-08:40</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-1`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-1`)"
                                        :course-subject="getCourseItem(`${it}-1`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-1`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-1`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">第二节</td>
                        <td class="fs-small">08:50-09:35</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-2`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-2`)"
                                        :course-subject="getCourseItem(`${it}-2`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-2`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-2`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div>    
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">第三节</td>
                        <td class="fs-small">10:05-10:50</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-3`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-3`)"
                                        :course-subject="getCourseItem(`${it}-3`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-3`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-3`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">第四节</td>
                        <td class="fs-small">11:00-11:45</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-4`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-4`)"
                                        :course-subject="getCourseItem(`${it}-4`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-4`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-4`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">第五节</td>
                        <td class="fs-small">11:45-12:10</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-5`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-5`)"
                                        :course-subject="getCourseItem(`${it}-5`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-5`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-5`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="10" class="td-space"></td>
                    </tr>
                    <tr>
                        <td rowspan="4" class="bold">下午</td>
                        <td class="fs-small">第六节</td>
                        <td class="fs-small">14:10-14:55</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-6`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-6`)"
                                        :course-subject="getCourseItem(`${it}-6`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-6`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-6`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">第七节</td>
                        <td class="fs-small">15:05-15:50</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-7`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-7`)"
                                        :course-subject="getCourseItem(`${it}-7`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-7`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-7`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">第八节</td>
                        <td class="fs-small">16:00-16:45</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-8`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-8`)"
                                        :course-subject="getCourseItem(`${it}-8`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-8`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-8`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">第九节</td>
                        <td class="fs-small">16:55-17:35</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-9`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-9`)"
                                        :course-subject="getCourseItem(`${it}-9`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-9`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-9`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="3" class="bold">晚上</td>
                        <td class="fs-small">晚一</td>
                        <td class="fs-small">19:10-19:55</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-10`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-10`)"
                                        :course-subject="getCourseItem(`${it}-10`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-10`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-10`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">晚二</td>
                        <td class="fs-small">20:05-20:55</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-11`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-11`)"
                                        :course-subject="getCourseItem(`${it}-11`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-11`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-11`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                    <tr>
                        <td class="fs-small">晚三</td>
                        <td class="fs-small">21:05-21:40</td>
                        <td v-for="it in [1, 2, 3, 4, 5, 6, 7]" :key="`${it}-12`" class="td-item">
                            <el-popover placement="right" :width="20" trigger="contextmenu">
                                <template #reference>
                                    <CourseItem v-if="getCourseItem(`${it}-12`)"
                                        :course-subject="getCourseItem(`${it}-12`)!.courseSubject"
                                        :course-clazz="getCourseItem(`${it}-12`)!.courseClazz"
                                        :course-teacher="getCourseItem(`${it}-12`)!.courseTeacher"
                                    />
                                    <div class="course-empty" v-else></div>
                                </template>
                                <div class="popover-content">
                                    <el-button type="primary" :icon="Edit" round>编辑</el-button>
                                    <el-button type="danger" :icon="Delete" round>删除</el-button>
                                </div> 
                            </el-popover>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import CourseItem from './CourseItem.vue'
import { Edit, Delete } from '@element-plus/icons-vue';


interface CourseInfo {
    key: string
    courseSubject: string
    courseClazz: string
    courseTeacher: string
}



const courses = ref<CourseInfo[]>([
    {
        key: "1-7",
        courseSubject: "数学",
        courseClazz: "G2304",
        courseTeacher: "汪唱",
    },
    {
        key: "4-6",
        courseSubject: "数学",
        courseClazz: "G2315",
        courseTeacher: "蒋超",
    },
    {
        key: "7-2",
        courseSubject: "英语",
        courseClazz: "G2313",
        courseTeacher: "李源庄",
    },
])

const getCourseItem = (key: string) => {
    let item: CourseInfo|null = null
    for (let it of courses.value) {
        if (it.key == key) {
            item = it
            break
        }
    }
    return item
}

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
                transition: all 0.3s;
                &.td-item:hover {
                    background-color: rgba(64, 158, 255, 0.4);
                    cursor: pointer;
                }
                &.bold {
                    font-weight: bold;
                    writing-mode: vertical-rl;
                }
                &.fs-small {
                    font-size: 13px;
                }
                .course-empty {
                    width: 100%;
                    height: 100%;
                }
            }
            .td-space {
                height: 12px;
            }
        }
    }
}

.popover-content {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
    .el-button {
        width: 100%;
        &+.el-button {
            margin: 0;
            margin-top: 6px;
        }
    }
}
</style>